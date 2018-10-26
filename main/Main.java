package main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import league.Hero;
import league.Knight;
import league.Pyromancer;
import league.Rogue;
import league.Wizard;
import league.Variable;

public final class Main {

    private Main() {

    }

    public static void main(final String[] args) throws IOException {

        Scanner scanf = new Scanner(new BufferedReader(new FileReader(args[0])));
        PrintWriter printf = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));

        int linii = scanf.nextInt(); //N linii
        int coloane = scanf.nextInt(); //M coloane
        char[][] position = new char[linii][coloane]; //harta de tipuri de teren
        scanf.nextLine();

        for (int i = 0; i < linii; i++) { //se citesc coordonatele terenurilor
            String allLands = new String();
            allLands = scanf.nextLine();
            char[] lands = allLands.toCharArray();

            for (int j = 0; j < coloane; j++) { //se introduc tipurile de teren in mapa
                position[i][j] = lands[j];
            }
        }

        int personaje = scanf.nextInt(); //P numar de personaje
        scanf.nextLine();

        Hero[] heroes = new Hero[personaje];

        for (int i = 0; i < personaje; i++) { //creeaza instante de hero in functie de tip
            int type = scanf.next().charAt(0);
            int pozitieLinie = scanf.nextInt();
            int pozitieColoana = scanf.nextInt();
            scanf.nextLine();
            if (type == 'W') {
                heroes[i] =  new Wizard(pozitieLinie, pozitieColoana);
            } else if (type == 'R') {
                heroes[i] = new Rogue(pozitieLinie, pozitieColoana);
            } else if (type == 'K') {
                heroes[i] = new Knight(pozitieLinie, pozitieColoana);
            } else {
                heroes[i] = new Pyromancer(pozitieLinie, pozitieColoana);
            }
        }

        int runde = scanf.nextInt(); //R numar de runde
        scanf.nextLine();

        for (int i = 0; i < runde; i++) { //trece prin runde

            String allMoves = new String();
            allMoves = scanf.nextLine();
            char[] moves = allMoves.toCharArray();

            for (int j = 0; j < personaje; j++) { //efectueaza toate miscarile dintr-o runda
                if (!heroes[j].isStun()) {
                    heroes[j].move(moves[j]);
                } else {
                    heroes[j].setOverTimeStun(heroes[j].getOverTimeStun() - 1);
                    if (heroes[j].getOverTimeStun() == 0) {
                        heroes[j].setStun(false);
                    }
                }

                heroes[j].setHpBasic(heroes[j].getHp() - heroes[j].getDotValue());
                if (heroes[j].getOverTimeCount() != 0) {
                    heroes[j].setOverTimeCount(heroes[j].getOverTimeCount() - 1);
                }
                if (heroes[j].getOverTimeCount() == 0) {
                    heroes[j].setDotValue(0);
                    }
                if (heroes[j].getHp() <= 0) {
                    heroes[j].setAlive(false);
                }
            }

            for (int k = 0; k < personaje; k++) { //verifica daca se intalnesc eroi
                for (int z = k + 1; z < personaje; z++) {
                    if (heroes[z].getRow() == heroes[k].getRow()
                        && heroes[z].getCol() == heroes[k].getCol()
                        && heroes[z].isAlive() && heroes[k].isAlive()) {

                        if (heroes[k] instanceof Wizard) {
                            heroes[z].abilityOne(heroes[k], position);
                            heroes[z].abilityTwo(heroes[k], position);
                            heroes[k].abilityOne(heroes[z], position);
                            heroes[k].abilityTwo(heroes[z], position);
                        } else {
                            heroes[k].abilityOne(heroes[z], position);
                            heroes[k].abilityTwo(heroes[z], position);
                            heroes[z].abilityOne(heroes[k], position);
                            heroes[z].abilityTwo(heroes[k], position);
                        }

                        heroes[z].setHpBasic(heroes[z].getHp() - heroes[k].abilitiesTotalDamage());
                        heroes[k].setHpBasic(heroes[k].getHp() - heroes[z].abilitiesTotalDamage());

                        if (heroes[z].getHp() <= 0 && heroes[k].getHp() > 0) {
                            heroes[z].setAlive(false);
                            heroes[k].setXp(heroes[k].getXp() + (int) Math.max(0, Variable.DOUA_SUTE
                            - (heroes[k].getLevel() - heroes[z].getLevel()) * Variable.PATRU_ZECI));
                            heroes[k].levelUp();
                        } else if (heroes[z].getHp() > 0 && heroes[k].getHp() <= 0) {
                            heroes[k].setAlive(false);
                            heroes[z].setXp(heroes[z].getXp() + (int) Math.max(0, Variable.DOUA_SUTE
                            - (heroes[z].getLevel() - heroes[k].getLevel()) * Variable.PATRU_ZECI));
                            heroes[z].levelUp();
                        } else if (heroes[z].getHp() <= 0 && heroes[k].getHp() <= 0) {
                            heroes[z].setAlive(false);
                            heroes[k].setAlive(false);
                        }
                    }
                }
            }
        } //aici a trecut prin toate rundele

        for (int i = 0; i < personaje; i++) { //incepe printarea de output in fisier

            if (heroes[i] instanceof Wizard) {
                printf.print("W ");
            } else if (heroes[i] instanceof Rogue) {
                printf.print("R ");
            } else if (heroes[i] instanceof Knight) {
                printf.print("K ");
            } else if (heroes[i] instanceof Pyromancer) {
                printf.print("P ");
            }

            if (!heroes[i].isAlive()) {
                printf.print("dead");
                printf.println();
                continue;
            }

            printf.print(heroes[i].getLevel() + " " + heroes[i].getXp() + " "
                        + heroes[i].getHp() + " " + heroes[i].getRow() + " "
                        + heroes[i].getCol());
            printf.println();
        }

        scanf.close();
        printf.close();

    }
}


package league;

public class Wizard extends Hero {

    public Wizard(final int row, final int col) {
        super(row, col);
        super.setHpMax((int) Variable.PATRU_SUTE);
        super.setHpInitial((int) Variable.PATRU_SUTE);
        super.setHp((int) Variable.PATRU_SUTE);
    }

    /**
     * Seteaza HP-ul pentru Wizard.
     */
    public void setHp(final int hp) {
        super.setHp(hp + (int) Variable.TREI_ZECI * getLevel());
    }
    /**
     * Mecanism pentru level, xp si hp.
     */
    public void levelUp() {
        while (true) {
            if (getXp() >= getXpPrag()) {
                setLevel(getLevel() + 1);
                setXpPrag((int) Variable.DOUA_SUTE_CINCI_ZECI
                          + (int) Variable.CINCI_ZECI * getLevel());
                setHp(getHpInitial());
                setHpMax(getHp());
                continue;
            }
        break;
        }
    }

    /**
     * Drain.
     */
    public void abilityOne(final Hero enemy, final char[][] position) {
        float procent = Variable.DOUA_ZECI + Variable.CINCI * (float) getLevel();
        if (position[getRow()][getCol()] == 'D') {
            procent = Math.round(procent * Variable.UNU_UNU);
        }
        if (enemy instanceof Wizard) {
            procent = Math.round(procent * Variable.UNU_ZERO_CINCI);
        } else if (enemy instanceof Pyromancer) {
            procent = Math.round(procent * Variable.ZERO_NOUA);
        } else if (enemy instanceof Knight) {
            procent = Math.round(procent * Variable.UNU_DOI);
        } else if (enemy instanceof Rogue) {
            procent = Math.round(procent * Variable.ZERO_OPT);
        }
        float minDamage = Math.min(Variable.ZERO_TREI * (float) enemy.getHpMax(),
                         (float) enemy.getHp());
        float damage = (float) procent * (float) Math.round((float) minDamage)
                       * Variable.ZERO_ZERO_UNU;
        setDamageAbility1(Math.round(damage));
    }

    /**
     * Deflect.
     */
    public void abilityTwo(final Hero enemy, final char[][] position) {
        if (enemy instanceof Wizard) {
            setDamageAbility2(0);
        } else {
            float procent = Variable.ZERO_TREI_ZECI_SI_CINCI
                           + Variable.ZERO_ZERO_DOI * getLevel();
            if (procent > Variable.ZERO_SAPTE) {
                procent = Variable.ZERO_SAPTE;
            }
            float damage = Math.round(procent * (float) enemy.abilitiesPureDamage());
            if (position[getRow()][getCol()] == 'D') {
                damage = damage * Variable.UNU_UNU;
            }
            if (enemy instanceof Pyromancer) {
                damage = Math.round(damage * Variable.UNU_TREI);
            } else if (enemy instanceof Knight) {
                damage = Math.round(damage * Variable.UNU_PATRU);
            } else if (enemy instanceof Rogue) {
                damage = Math.round(damage * Variable.UNU_DOI);
            }
            setDamageAbility2(Math.round(damage));
        }
    }
}

package league;

public class Hero {

    private int hp;
    private int hpMax;
    private int hpInitial;
    private boolean alive = true;

    private int xp;
    private int xpPrag = (int) Variable.DOUA_SUTE_CINCI_ZECI;
    private int level;

    private int row;
    private int col;

    private int dotValue;
    private int overTimeCount;
    private int overTimeStun;
    private boolean stun = false;

    private int damageDeflected1;
    private int damageDeflected2;
    private int damageAbility1;
    private int damageAbility2;

    public Hero() {

    }
    public Hero(final int row, final int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returneaza hp-ul curent al eroului.
     * @return
     */
    public int getHp() {
        return hp;
    }
    /**
     * Seteaza hp-ul curent al eroului in functie de parametrul primit.
     * @param hp
     */
    public void setHp(final int hp) {
        this.hp = hp;
    }
    /**
     * Returneaza hp-ul maxim curent al eroului.
     * @return
     */
    public int getHpMax() {
        return hpMax;
    }
    /**
     * Seteaza hp-ul maxim curent al eroului.
     * @param hpMax
     */
    public void setHpMax(final int hpMax) {
        this.hpMax = hpMax;
    }
    /**
     * Returneaza hp-ul initial al eroului.
     * @return
     */
    public int getHpInitial() {
        return hpInitial;
    }
    /**
     * Seteaza hp-ul initial al eroului.
     * @param hpInitial
     */
    public void setHpInitial(final int hpInitial) {
        this.hpInitial = hpInitial;
    }
    /**
     * Returneaza statusul caracterului (dead or alive).
     * @return
     */
    public boolean isAlive() {
        return alive;
    }
    /**
     * Seteaza statusul caracterului (dead or alive).
     * @param alive
     */
    public void setAlive(final boolean alive) {
        this.alive = alive;
    }
    /**
     * Returneaza XP-ul caracterului.
     * @return
     */
    public int getXp() {
        return xp;
    }
    /**
     * Seteaza XP-ul caracterului.
     * @param xp
     */
    public void setXp(final int xp) {
        this.xp = xp;
    }
    /**
     * Returneaza pragul de XP pentru level-up.
     * @return
     */
    public int getXpPrag() {
        return xpPrag;
    }
    /**
     * Seteaza pragul de XP pentru level-ul.
     * @param xpPrag
     */
    public void setXpPrag(final int xpPrag) {
        this.xpPrag = xpPrag;
    }
    /**
     * Returneaza level-ul curent.
     * @return
     */
    public int getLevel() {
        return level;
    }
    /**
     * Returneaza linia.
     * @return
     */
    public int getRow() {
        return row;
    }
    /**
     * Seteaza linia.
     * @param row
     */
    public void setRow(final int row) {
        this.row = row;
    }
    /**
     * Returneaza coloana.
     * @return
     */
    public int getCol() {
        return col;
    }
    /**
     * Seteaza coloana.
     * @param col
     */
    public void setCol(final int col) {
        this.col = col;
    }
    /**
     * Returneaza valoarea damage over time-ului.
     * @return
     */
    public int getDotValue() {
        return dotValue;
    }
    /**
     * Seteaza valoarea damage over time-ului.
     * @param dotValue
     */
    public void setDotValue(final int dotValue) {
        this.dotValue = dotValue;
    }
    /**
     * Returneaza count-ul pentru abilitatile over time.
     * @return
     */
    public int getOverTimeCount() {
        return overTimeCount;
    }
    /**
     * Seteaza count-ul pentru abilitatile over time.
     * @param overTimeCount
     */
    public void setOverTimeCount(final int overTimeCount) {
        this.overTimeCount = overTimeCount;
    }
    /**
     * Returneaza statusul de incapacitate al eroului.
     * @return
     */
    public boolean isStun() {
        return stun;
    }
    /**
     * Seteaza statusul de incapacitate al eroului.
     * @param stun
     */
    public void setStun(final boolean stun) {
        this.stun = stun;
    }
    /**
     * Returneaza count-ul de stun overtime.
     * @return
     */
    public int getOverTimeStun() {
        return overTimeStun;
    }
    /**
     * Seteaza count-ul de stun overtime.
     * @param overTimeStun
     */
    public void setOverTimeStun(final int overTimeStun) {
        this.overTimeStun = overTimeStun;
    }
    /**
     * Returneaza damage-ul deflectat pentru prima abilitate.
     * @return
     */
    public int getDamageDeflected1() {
        return damageDeflected1;
    }
    /**
     * Seteaza damage-ul deflectat pentru prima abilitate.
     * @param damageDeflected1
     */
    public void setDamageDeflected1(final int damageDeflected1) {
        this.damageDeflected1 = damageDeflected1;
    }
    /**
     * Returneaza damage-ul deflectat pentru a 2-a abilitate.
     * @return
     */
    public int getDamageDeflected2() {
        return damageDeflected2;
    }
    /**
     * Seteaza damage-ul deflectat pentru a 2-a abilitate.
     * @param damageDeflected2
     */
    public void setDamageDeflected2(final int damageDeflected2) {
        this.damageDeflected2 = damageDeflected2;
    }
    /**
     * Returneaza damage-ul dat de prima abilitate.
     * @return
     */
    public int getDamageAbility1() {
        return damageAbility1;
    }
    /**
     * Seteaza damage-ul dat de prima abilitate.
     * @param damageAbility1
     */
    public void setDamageAbility1(final int damageAbility1) {
    this.damageAbility1 = damageAbility1;
    }
    /**
     * Returneaza damage-ul dat de cea de-a doua abilitate.
     * @return
     */
    public int getDamageAbility2() {
        return damageAbility2;
    }
    /**
     * Seteaza damage-ul dat de cea de-a doua abilitate.
     * @param damageAbility2
     */
    public void setDamageAbility2(final int damageAbility2) {
        this.damageAbility2 = damageAbility2;
    }
    public void abilityOne(final Hero enemy, final char[][] position) {

    }
    public void abilityTwo(final Hero enemy, final char[][] position) {

    }
    /**
     * Returneaza damage-ul total dat intr-o runda de catre un caracter.
     * @return
     */
    public int abilitiesTotalDamage() {
        return getDamageAbility1() + getDamageAbility2();
    }
    /**
     * Returneaza damage-ul total dat de un caracter pentru Deflect-ul Wizard-ului.
     * @return
     */
    public int abilitiesPureDamage() {
        return getDamageDeflected1() + getDamageDeflected2();
    }
    /**
     * Executa miscarea unui caracter intr-o runda.
     * @param direction
     */
    public void move(final char direction) {
        if (!stun) {
            if (direction == 'U') {
                this.row--;
            } else if (direction == 'D') {
                this.row++;
            } else if (direction == 'R') {
                this.col++;
            } else if (direction == 'L') {
                this.col--;
            }
        }
    }
    /**
     * Setter pentru level.
     * @param level
     */
    public void setLevel(final int level) {
        this.level = level;
    }
    /**
     * Seteaza hp, level, si xp pentru fiecare race.
     */
    public void levelUp() {

    }
    /**
     * Set hp obisnuit, pentru a nu fi adunat la bonusul de level.
     * @param hp
     */
    public void setHpBasic(final int hitPoints) {
        this.hp = hitPoints;
    }

}

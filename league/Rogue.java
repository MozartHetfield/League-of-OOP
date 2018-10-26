package league;

public class Rogue extends Hero {

    private int critCount = 0;

    public Rogue(final int row, final int col) {
        super(row, col);
        super.setHpMax((int) Variable.SASE_SUTE);
        super.setHpInitial((int) Variable.SASE_SUTE);
        super.setHp((int) Variable.SASE_SUTE);
    }

    /**
     * Seteaza HP-ul pentru Rogue.
     */
    public void setHp(final int hp) {
        super.setHp(hp + (int) Variable.PATRU_ZECI * getLevel());
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
     * Backstab.
     */
    public void abilityOne(final Hero enemy, final char[][] position) {
        float damage = Variable.DOUA_SUTE + Variable.DOUA_ZECI * (float) getLevel();
        setDamageDeflected1(Math.round(damage));
        if (position[getRow()][getCol()] == 'W') {
            damage = Math.round(damage * Variable.UNU_UNU_CINCI);
            setDamageDeflected1(Math.round(damage));
        }
        if (enemy instanceof Wizard) {
            damage = Math.round(damage * Variable.UNU_DOI_CINCI);
        } else if (enemy instanceof Pyromancer) {
            damage = Math.round(damage * Variable.UNU_DOI_CINCI);
        } else if (enemy instanceof Knight) {
            damage = Math.round(damage * Variable.ZERO_NOUA);
        } else if (enemy instanceof Rogue) {
            damage = Math.round(damage * Variable.UNU_DOI);
        }
        if (critCount % (int) Variable.TREI == 0 && position[getRow()][getCol()] == 'W') {
            damage = Math.round(damage * Variable.UNU_CINCI);
            setDamageDeflected1(Math.round((float) getDamageDeflected1() * Variable.UNU_CINCI));
        }
        critCount++;
        setDamageAbility1(Math.round(damage));
    }

    /**
     * Paralysis.
     */
    public void abilityTwo(final Hero enemy, final char[][] position) {
        float damage = Variable.PATRU_ZECI + Variable.ZECE * (float) getLevel();
        setDamageDeflected2(Math.round(damage));
        enemy.setOverTimeCount((int) Variable.TREI);
        enemy.setOverTimeStun((int) Variable.TREI);
        if (position[getRow()][getCol()] == 'W') {
            enemy.setOverTimeCount((int) Variable.SASE);
            enemy.setOverTimeStun((int) Variable.SASE);
            damage = Math.round(damage * Variable.UNU_UNU_CINCI);
            setDamageDeflected2(Math.round(damage));
        }
        if (enemy instanceof Wizard) {
            damage = Math.round(damage * Variable.UNU_DOI_CINCI);
        } else if (enemy instanceof Pyromancer) {
            damage = Math.round(damage * Variable.UNU_DOI);
        } else if (enemy instanceof Knight) {
            damage = Math.round(damage * Variable.ZERO_OPT);
        } else if (enemy instanceof Rogue) {
            damage = Math.round(damage * Variable.ZERO_NOUA);
        }
        enemy.setDotValue(Math.round(damage));
        setDamageAbility2(Math.round(damage));
        enemy.setStun(true);
    }
}

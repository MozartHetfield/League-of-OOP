package league;

public class Pyromancer extends Hero {

    public Pyromancer(final int row, final int col) {
        super(row, col);
        super.setHpMax((int) Variable.CINCI_SUTE);
        super.setHpInitial((int) Variable.CINCI_SUTE);
        super.setHp((int) Variable.CINCI_SUTE);
    }

    /**
     * Seteaza HP-ul pentru Pyromancer.
     */
    public void setHp(final int hp) {
        super.setHp(hp + (int) Variable.CINCI_ZECI * getLevel());
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
     * Fireblast.
     */
    public void abilityOne(final Hero enemy, final char[][] position) {
        float damage = Variable.TREI_SUTE_CINCI_ZECI
                      + Variable.CINCI_ZECI * (float) getLevel();
        setDamageDeflected1(Math.round(damage));
        if (position[getRow()][getCol()] == 'V') {
            damage = Math.round(damage * Variable.UNU_DOI_CINCI);
            setDamageDeflected1(Math.round(damage));
        }
        if (enemy instanceof Wizard) {
            damage = Math.round(damage * Variable.UNU_ZERO_CINCI);
        } else if (enemy instanceof Pyromancer) {
            damage = Math.round(damage * Variable.ZERO_NOUA);
        } else if (enemy instanceof Knight) {
            damage = Math.round(damage * Variable.UNU_DOI);
        } else if (enemy instanceof Rogue) {
            damage = Math.round(damage * Variable.ZERO_OPT);
        }
        setDamageAbility1(Math.round(damage));
    }

    /**
     * Ignite.
     */
    public void abilityTwo(final Hero enemy, final char[][] position) {
        float damage = Variable.O_SUTA_CINCI_ZECI
                      + Variable.DOUA_ZECI * (float) getLevel();
        enemy.setDotValue((int) Variable.CINCI_ZECI + (int) Variable.TREI_ZECI * getLevel());
        enemy.setOverTimeCount(2);
        setDamageDeflected2(Math.round(damage));
        if (position[getRow()][getCol()] == 'V') {
            damage = Math.round(damage * Variable.UNU_DOI_CINCI);
            enemy.setDotValue(Math.round(enemy.getDotValue() * Variable.UNU_DOI_CINCI));
            setDamageDeflected2(Math.round(damage));
        }
        if (enemy instanceof Wizard) {
            damage = Math.round(damage * Variable.UNU_ZERO_CINCI);
            enemy.setDotValue(Math.round(enemy.getDotValue() * Variable.UNU_ZERO_CINCI));
        } else if (enemy instanceof Pyromancer) {
            damage = Math.round(damage * Variable.ZERO_NOUA);
            enemy.setDotValue(Math.round(enemy.getDotValue() * Variable.ZERO_NOUA));
        } else if (enemy instanceof Knight) {
            damage = Math.round(damage * Variable.UNU_DOI);
            enemy.setDotValue(Math.round(enemy.getDotValue() * Variable.UNU_DOI));
        } else if (enemy instanceof Rogue) {
            damage = Math.round(damage * Variable.ZERO_OPT);
            enemy.setDotValue(Math.round(enemy.getDotValue() * Variable.ZERO_OPT));
        }
        setDamageAbility2(Math.round(damage));
        enemy.setOverTimeCount(2);
    }
}

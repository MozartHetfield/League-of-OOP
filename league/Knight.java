package league;

public class Knight extends Hero {

    public Knight(final int row, final int col) {
        super(row, col);
        super.setHpMax((int) Variable.NOUA_SUTE);
        super.setHpInitial((int) Variable.NOUA_SUTE);
        super.setHp((int) Variable.NOUA_SUTE);
    }

    /**
     * Seteaza HP-ul pentru Knight.
     */
    public void setHp(final int hp) {
        super.setHp(hp + (int) Variable.OPT_ZECI * getLevel());
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
     * Execute.
     */
    public void abilityOne(final Hero enemy, final char[][] position) {
        int hpTroubleshot = Math.round(Variable.ZERO_DOI * (float) enemy.getHpMax()
        + Variable.ZERO_ZERO_UNU * (float) enemy.getHpMax() * (float) getLevel());
        if (hpTroubleshot > Math.round(Variable.ZERO_PATRU * (float) enemy.getHpMax())) {
            hpTroubleshot = Math.round(Variable.ZERO_PATRU * (float) enemy.getHpMax());
        }
        if (enemy.getHp() <= hpTroubleshot) {
            setDamageAbility1(enemy.getHp());
            setDamageDeflected1(enemy.getHp());
        } else {
            float damage = Variable.DOUA_SUTE + Variable.TREI_ZECI * (float) getLevel();
            setDamageDeflected1(Math.round(damage));
            if (position[getRow()][getCol()] == 'L') {
                damage = Math.round(damage * Variable.UNU_UNU_CINCI);
                setDamageDeflected1(Math.round(damage));
            }
            if (enemy instanceof Wizard) {
                damage = Math.round(damage * Variable.ZERO_OPT);
            } else if (enemy instanceof Pyromancer) {
                damage = Math.round(damage * Variable.UNU_UNU);
            } else if (enemy instanceof Rogue) {
                damage = Math.round(damage * Variable.UNU_UNU_CINCI);
            }
            setDamageAbility1(Math.round(damage));
        }
    }

    /**
     * Slam.
     */
    public void abilityTwo(final Hero enemy, final char[][] position) {
        float damage = Variable.O_SUTA + Variable.PATRU_ZECI * (float) getLevel();
        setDamageDeflected2(Math.round(damage));
        if (position[getRow()][getCol()] == 'L') {
            damage = Math.round(damage * Variable.UNU_UNU_CINCI);
            setDamageDeflected2(Math.round(damage));
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
        enemy.setStun(true);
        enemy.setOverTimeStun(1);
        enemy.setOverTimeCount(0);
        enemy.setDotValue(0);
        setDamageAbility2(Math.round(damage));
    }
}

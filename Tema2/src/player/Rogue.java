package player;

import angels.Angel;
import main.Map;

import static constants.Constants.RBONUS;
import static constants.Constants.RHEALTH;
import static constants.Constants.RKBASIC;
import static constants.Constants.RKSPECIAL;
import static constants.Constants.RLEVEL;
import static constants.Constants.RPBASIC;
import static constants.Constants.RPSPECIAL;
import static constants.Constants.RRBASIC;
import static constants.Constants.RRSPECIAL;
import static constants.Constants.RWBASIC;
import static constants.Constants.RWSPECIAL;
import static constants.Constants.R_BASIC_DAMAGE;
import static constants.Constants.R_BASIC_LEVEL;
import static constants.Constants.R_LAND_ROUNDS;
import static constants.Constants.R_LAND_ROUNDS_HURT;
import static constants.Constants.R_LUCKY_STRIKE;
import static constants.Constants.R_LUCKY_STRIKE_RESET;
import static constants.Constants.R_NO_LAND_ROUNDS;
import static constants.Constants.R_NO_LAND_ROUNDS_HURT;
import static constants.Constants.R_ROUND_DAMAGE;
import static constants.Constants.R_ROUND_LEVEL;
import static constants.Constants.XP_LIMIT;
import static constants.Constants.XP_MULTIPLIER;

public class Rogue extends Hero {

    private int chance;
    public static final int LEFT = 7;
    public static final int RIGHT = 5;
    public static final int NUM = 7;
    public static final int NR = 6;
    public static final float M1 = 0.4f;
    public static final float M2 = 0.1f;

    public Rogue(final int positionX, final int getPositionY, final HeroType type, final int id) {
        super(positionX, getPositionY, type, id);
        setInitialHealth(RHEALTH);
        setHealthPerLevel(RLEVEL);
        chance = 0;
    }

    /**
     *
     */
    public void checkStrategy() {
        if (isParalyzed() || getStandStill() > 0) {
            return;
        }
        if ((float) getInitialHealth() / LEFT < (float) getHealth()
                && getHealth() < (float) getInitialHealth() / RIGHT) {
            setHealth(Math.round((float) (getHealth() * NR) / NUM));
            setModifier(getModifier() + M1);
        }
        if (getHealth() < Math.round((float) getInitialHealth() / LEFT)) {
            setModifier(getModifier() - M2);
            addHealth(Math.round((float) getHealth() / 2));
        }
    }

    /**
     * @param pyromancer
     * @param map
     */
    public void basicAttack(final Pyromancer pyromancer, final Map map) {
        float terrainBonus = 1f;
        chance++;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        } else if (chance == 1) {
            chance = R_LUCKY_STRIKE_RESET;
        }
        float damage = R_BASIC_DAMAGE + R_BASIC_LEVEL * getLevel();
        if (chance == 1) {
            damage *= R_LUCKY_STRIKE;
        }
        damage *= terrainBonus;
        setLastDamage(Math.round(damage));
        damage *= (RPBASIC + getModifier() - 1);
        pyromancer.addHealth(-Math.round(damage));
    }

    /**
     * @param pyromancer
     * @param map
     */
    public void specialAttack(final Pyromancer pyromancer, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        }
        float damage = R_ROUND_DAMAGE + R_ROUND_LEVEL * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= (RPSPECIAL + getModifier() - 1);
        pyromancer.addHealth(-Math.round(damage));
        if (pyromancer.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - pyromancer.getLevel()) * XP_MULTIPLIER));
        }
        pyromancer.setHurt(Math.round(damage));
        pyromancer.setTimeOfHurt(R_NO_LAND_ROUNDS_HURT);
        pyromancer.setTimeOfParalyze(R_NO_LAND_ROUNDS);
        if (terrainBonus == RBONUS) {
            pyromancer.setTimeOfHurt(R_LAND_ROUNDS_HURT);
            pyromancer.setTimeOfParalyze(R_LAND_ROUNDS);
        }
        pyromancer.setParalyzed(true);
    }

    /**
     * @param knight
     * @param map
     */
    public void basicAttack(final Knight knight, final Map map) {
        float terrainBonus = 1f;
        chance++;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        } else if (chance == 1) {
            chance = R_LUCKY_STRIKE_RESET;
        }
        float damage = R_BASIC_DAMAGE + R_BASIC_LEVEL * getLevel();
        damage *= terrainBonus;
        if (chance == 1) {
            damage *= R_LUCKY_STRIKE;
        }
        setLastDamage(Math.round(damage));
        damage *= (RKBASIC + getModifier() - 1);
        knight.addHealth(-Math.round(damage));
    }

    /**
     * @param knight
     * @param map
     */
    public void specialAttack(final Knight knight, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        }
        float damage = R_ROUND_DAMAGE + R_ROUND_LEVEL * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= (RKSPECIAL + getModifier() - 1);
        knight.addHealth(-Math.round(damage));
        if (knight.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - knight.getLevel()) * XP_MULTIPLIER));
        }
        knight.setHurt(Math.round(damage));
        knight.setTimeOfHurt(R_NO_LAND_ROUNDS_HURT);
        knight.setTimeOfParalyze(R_NO_LAND_ROUNDS);
        if (terrainBonus == RBONUS) {
            knight.setTimeOfHurt(R_LAND_ROUNDS_HURT);
            knight.setTimeOfParalyze(R_LAND_ROUNDS);
        }
        knight.setParalyzed(true);
    }

    /**
     * @param wizard
     * @param map
     */
    public void basicAttack(final Wizard wizard, final Map map) {
        float terrainBonus = 1f;
        chance++;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        } else if (chance == 1) {
            chance = R_LUCKY_STRIKE_RESET;
        }
        float damage = R_BASIC_DAMAGE + R_BASIC_LEVEL * getLevel();
        if (chance == 1) {
            damage *= R_LUCKY_STRIKE;
        }
        damage *= terrainBonus;
        setLastDamage(Math.round(damage));
        damage *= (RWBASIC + getModifier() - 1);
        wizard.addHealth(-Math.round(damage));
    }

    /**
     * @param wizard
     * @param map
     */
    public void specialAttack(final Wizard wizard, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        }
        float damage = R_ROUND_DAMAGE + R_ROUND_LEVEL * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= (RWSPECIAL + getModifier() - 1);
        wizard.addHealth(-Math.round(damage));
        if (wizard.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - wizard.getLevel()) * XP_MULTIPLIER));
        }
        wizard.setHurt(Math.round(damage));
        wizard.setTimeOfHurt(R_NO_LAND_ROUNDS_HURT);
        wizard.setTimeOfParalyze(R_NO_LAND_ROUNDS);
        if (terrainBonus == RBONUS) {
            wizard.setTimeOfHurt(R_LAND_ROUNDS_HURT);
            wizard.setTimeOfParalyze(R_LAND_ROUNDS);
        }
        wizard.setParalyzed(true);
    }

    /**
     * @param rogue
     * @param map
     */
    public void basicAttack(final Rogue rogue, final Map map) {
        float terrainBonus = 1f;
        chance++;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        } else if (chance == 1) {
            chance = R_LUCKY_STRIKE_RESET;
        }
        float damage = R_BASIC_DAMAGE + R_BASIC_LEVEL * getLevel();
        if (chance == 1) {
            damage *= R_LUCKY_STRIKE;
        }
        damage *= terrainBonus;
        setLastDamage(Math.round(damage));
        damage *= (RRBASIC + getModifier() - 1);
        rogue.addHealth(-Math.round(damage));
//        }
    }

    /**
     * @param rogue
     * @param map
     */
    public void specialAttack(final Rogue rogue, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        }
        float damage = R_ROUND_DAMAGE + R_ROUND_LEVEL * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= (RRSPECIAL + getModifier() - 1);
        rogue.addHealth(-Math.round(damage));
        if (rogue.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - rogue.getLevel()) * XP_MULTIPLIER));
        }
        rogue.setHurt(Math.round(damage));
        rogue.setTimeOfHurt(R_NO_LAND_ROUNDS_HURT);
        rogue.setTimeOfParalyze(R_NO_LAND_ROUNDS);
        if (terrainBonus == RBONUS) {
            rogue.setTimeOfHurt(R_LAND_ROUNDS_HURT);
            rogue.setTimeOfParalyze(R_LAND_ROUNDS);
        }
        rogue.setParalyzed(true);
    }

    /**
     * @param hero
     * @param map
     */
    public void accept(final Hero hero, final Map map) {
        hero.basicAttack(this, map);
        hero.specialAttack(this, map);
    }

    /**
     * @param angel
     */
    public void accept(final Angel angel) {
        angel.castAngel(this);
    }
}

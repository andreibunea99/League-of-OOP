package player;

import angels.Angel;
import main.Map;

import static constants.Constants.PBONUS;
import static constants.Constants.PHEALTH;
import static constants.Constants.PKBASIC;
import static constants.Constants.PKSPECIAL;
import static constants.Constants.PLEVEL;
import static constants.Constants.PPBASIC;
import static constants.Constants.PPSPECIAL;
import static constants.Constants.PRBASIC;
import static constants.Constants.PRSPECIAL;
import static constants.Constants.PWBASIC;
import static constants.Constants.PWSPECIAL;
import static constants.Constants.P_BASIC_DAMAGE;
import static constants.Constants.P_BASIC_LEVEL;
import static constants.Constants.P_ROUND_DAMAGE;
import static constants.Constants.P_ROUND_LEVEL;
import static constants.Constants.P_SPECIAL_DAMAGE;
import static constants.Constants.P_SPECIAL_LEVEL;
import static constants.Constants.XP_LIMIT;
import static constants.Constants.XP_MULTIPLIER;

public class Pyromancer extends Hero {

    public static final int LEFT = 4;
    public static final int RIGHT = 3;
    public static final int NUM = 4;
    public static final int NR = 3;
    public static final float M1 = 0.7f;
    public static final float M2 = 0.3f;

    public Pyromancer(final int positionX, final int getPositionY, final HeroType type,
                      final int id) {
        super(positionX, getPositionY, type, id);
        setInitialHealth(PHEALTH);
        setHealthPerLevel(PLEVEL);
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
            addHealth(Math.round((float) getHealth() / NR));
        }
    }

    /**
     * @param knight
     * @param map
     */
    public void basicAttack(final Knight knight, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = P_BASIC_DAMAGE + P_BASIC_LEVEL * getLevel();
        damage *= terrainBonus;
        damage = Math.round(damage);
        setLastDamage(Math.round(damage));
        damage *= (PKBASIC + getModifier() - 1);
        knight.addHealth(-Math.round(damage));
    }

    /**
     * @param knight
     * @param map
     */
    public void specialAttack(final Knight knight, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = P_SPECIAL_DAMAGE + P_SPECIAL_LEVEL * getLevel();
        damage *= terrainBonus;
        damage = Math.round(damage);
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= (PKSPECIAL + getModifier() - 1);
        float damageRound = P_ROUND_DAMAGE + P_ROUND_LEVEL * getLevel();
        damageRound *= terrainBonus;
        damageRound = Math.round(damageRound);
        damageRound *= (PKSPECIAL + getModifier() - 1);
        knight.addHealth(-Math.round(damage));
        if (knight.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - knight.getLevel()) * XP_MULTIPLIER));
        }
        knight.setHurt(Math.round(damageRound));
        knight.setTimeOfHurt(2);
    }

    /**
     * @param rogue
     * @param map
     */
    public void basicAttack(final Rogue rogue, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = P_BASIC_DAMAGE + P_BASIC_LEVEL * getLevel();
        damage *= terrainBonus;
        damage = Math.round(damage);
        setLastDamage(Math.round(damage));
        damage *= (PRBASIC + getModifier() - 1);
        rogue.addHealth(-Math.round(damage));
    }

    /**
     * @param rogue
     * @param map
     */
    public void specialAttack(final Rogue rogue, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = P_SPECIAL_DAMAGE + P_SPECIAL_LEVEL * getLevel();
        damage *= terrainBonus;
        damage = Math.round(damage);
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= (PRSPECIAL + getModifier() - 1);
        float damageRound = P_ROUND_DAMAGE + P_ROUND_LEVEL * getLevel();
        damageRound *= terrainBonus;
        damageRound = Math.round(damageRound);
        damageRound *= (PRSPECIAL + getModifier() - 1);
        rogue.addHealth(-Math.round(damage));
        if (rogue.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - rogue.getLevel()) * XP_MULTIPLIER));
        }
        rogue.setHurt(Math.round(damageRound));
        rogue.setTimeOfHurt(2);
    }

    /**
     * @param wizard
     * @param map
     */
    public void basicAttack(final Wizard wizard, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = P_BASIC_DAMAGE + P_BASIC_LEVEL * getLevel();
        damage *= terrainBonus;
        damage = Math.round(damage);
        setLastDamage(Math.round(damage));
        damage *= (PWBASIC + getModifier() - 1);
        wizard.addHealth(-Math.round(damage));
    }

    /**
     * @param wizard
     * @param map
     */
    public void specialAttack(final Wizard wizard, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = P_SPECIAL_DAMAGE + P_SPECIAL_LEVEL * getLevel();
        damage *= terrainBonus;
        damage = Math.round(damage);
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= (PWSPECIAL + getModifier() - 1);
        float damageRound = P_ROUND_DAMAGE + P_ROUND_LEVEL * getLevel();
        damageRound *= terrainBonus;
        damageRound = Math.round(damageRound);
        damageRound *= (PWSPECIAL + getModifier() - 1);
        wizard.addHealth(-Math.round(damage));
        if (wizard.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - wizard.getLevel()) * XP_MULTIPLIER));
        }
        wizard.setHurt(Math.round(damageRound));
        wizard.setTimeOfHurt(2);
    }

    /**
     * @param pyromancer
     * @param map
     */
    public void basicAttack(final Pyromancer pyromancer, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = P_BASIC_DAMAGE + P_BASIC_LEVEL * getLevel();
        damage *= terrainBonus;
        damage = Math.round(damage);
        setLastDamage(Math.round(damage));
        damage *= (PPBASIC + getModifier() - 1);
        pyromancer.addHealth(-Math.round(damage));
    }

    /**
     * @param pyromancer
     * @param map
     */
    public void specialAttack(final Pyromancer pyromancer, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = P_SPECIAL_DAMAGE + P_SPECIAL_LEVEL * getLevel();
        damage *= terrainBonus;
        damage = Math.round(damage);
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= (PPSPECIAL + getModifier() - 1);
        float damageRound = P_ROUND_DAMAGE + P_ROUND_LEVEL * getLevel();
        damageRound *= terrainBonus;
        damageRound = Math.round(damageRound);
        damageRound *= (PPSPECIAL + getModifier() - 1);
        pyromancer.addHealth(-Math.round(damage));
        if (pyromancer.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - pyromancer.getLevel()) * XP_MULTIPLIER));
        }
        pyromancer.setHurt(Math.round(damageRound));
        pyromancer.setTimeOfHurt(2);
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

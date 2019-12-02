package player;

import main.Map;

import static constants.Constants.HUNDREAD;
import static constants.Constants.KBONUS;
import static constants.Constants.KHEALTH;
import static constants.Constants.KKSPECIAL;
import static constants.Constants.KLEVEL;
import static constants.Constants.KPBASIC;
import static constants.Constants.KPSPECIAL;
import static constants.Constants.KRBASIC;
import static constants.Constants.KRSPECIAL;
import static constants.Constants.KWBASIC;
import static constants.Constants.KWSPECIAL;
import static constants.Constants.K_BASIC_DAMAGE;
import static constants.Constants.K_BASIC_LEVEL;
import static constants.Constants.K_HEALTH_LIMIT;
import static constants.Constants.K_HEALTH_PERCENT;
import static constants.Constants.K_SPECIAL_DAMAGE;
import static constants.Constants.K_SPECIAL_LEVEL;
import static constants.Constants.XP_LIMIT;
import static constants.Constants.XP_MULTIPLIER;

public class Knight extends Hero {

    public Knight(final int positionX, final int getPositionY, final HeroType type) {
        super(positionX, getPositionY, type);
        setInitialHealth(KHEALTH);
        setHealthPerLevel(KLEVEL);
    }

    /**
     * @param pyromancer
     * @param map
     */
    public void basicAttack(final Pyromancer pyromancer, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        float hpLimit = Math.min(K_HEALTH_LIMIT, K_HEALTH_PERCENT * getInitialHealth()
                + getLevel());
        hpLimit = hpLimit / HUNDREAD;
        if (Math.round(hpLimit) >= pyromancer.getHealth()) {
            setLastDamage(Math.round(pyromancer.getHealth()));
            pyromancer.setHealth(0);
        } else {
            float damage = K_BASIC_DAMAGE + K_BASIC_LEVEL * getLevel();
            damage *= terrainBonus;
            setLastDamage(Math.round(damage));
            damage *= KPBASIC;
            pyromancer.addHealth(-Math.round(damage));
        }
    }

    /**
     * @param pyromancer
     * @param map
     */
    public void specialAttack(final Pyromancer pyromancer, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        pyromancer.setStandStill(true);
        float damage = K_SPECIAL_DAMAGE + K_SPECIAL_LEVEL * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= KPSPECIAL;
        pyromancer.addHealth(-Math.round(damage));
        if (pyromancer.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - pyromancer.getLevel()) * XP_MULTIPLIER));
        }
    }

    /**
     * @param rogue
     * @param map
     */
    public void basicAttack(final Rogue rogue, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        float hpLimit = Math.min(K_HEALTH_LIMIT, K_HEALTH_PERCENT * getInitialHealth()
                + getLevel());
        hpLimit = hpLimit / HUNDREAD;
        if (Math.round(hpLimit) >= rogue.getHealth()) {
            setLastDamage(Math.round(rogue.getHealth()));
            rogue.setHealth(0);
        } else {
            float damage = K_BASIC_DAMAGE + K_BASIC_LEVEL * getLevel();
            damage *= terrainBonus;
            setLastDamage(Math.round(damage));
            damage *= KRBASIC;
            rogue.addHealth(-Math.round(damage));
        }
    }

    /**
     * @param rogue
     * @param map
     */
    public void specialAttack(final Rogue rogue, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        rogue.setStandStill(true);
        float damage = K_SPECIAL_DAMAGE + K_SPECIAL_LEVEL * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= KRSPECIAL;
        rogue.addHealth(-Math.round(damage));
        if (rogue.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - rogue.getLevel()) * XP_MULTIPLIER));
        }
    }

    /**
     * @param knight
     * @param map
     */
    public void basicAttack(final Knight knight, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        float hpLimit = Math.min(K_HEALTH_LIMIT, K_HEALTH_PERCENT * getInitialHealth()
                + getLevel());
        hpLimit = hpLimit / HUNDREAD;
        if (Math.round(hpLimit) >= knight.getHealth()) {
            setLastDamage(Math.round(knight.getHealth()));
            knight.setHealth(0);
        } else {
            float damage = K_BASIC_DAMAGE + K_BASIC_LEVEL * getLevel();
            damage *= terrainBonus;
            setLastDamage(Math.round(damage));
            knight.addHealth(-Math.round(damage));
        }
    }

    /**
     * @param knight
     * @param map
     */
    public void specialAttack(final Knight knight, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        knight.setStandStill(true);
        float damage = K_SPECIAL_DAMAGE + K_SPECIAL_LEVEL * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= KKSPECIAL;
        knight.addHealth(-Math.round(damage));
        if (knight.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - knight.getLevel()) * XP_MULTIPLIER));
        }
    }

    /**
     * @param wizard
     * @param map
     */
    public void basicAttack(final Wizard wizard, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        float hpLimit = Math.min(K_HEALTH_LIMIT, K_HEALTH_PERCENT * getInitialHealth()
                + getLevel());
        hpLimit = hpLimit / HUNDREAD;
        if (Math.round(hpLimit) >= wizard.getHealth()) {
            setLastDamage(Math.round(wizard.getHealth()));
            wizard.setHealth(0);
        } else {
            float damage = K_BASIC_DAMAGE + K_BASIC_LEVEL * getLevel();
            damage *= terrainBonus;
            setLastDamage(Math.round(damage));
            damage *= KWBASIC;
            wizard.addHealth(-Math.round(damage));
        }
    }

    /**
     * @param wizard
     * @param map
     */
    public void specialAttack(final Wizard wizard, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        wizard.setStandStill(true);
        float damage = K_SPECIAL_DAMAGE + K_SPECIAL_LEVEL * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= KWSPECIAL;
        wizard.addHealth(-Math.round(damage));
        if (wizard.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - wizard.getLevel()) * XP_MULTIPLIER));
        }
    }

    /**
     * @param hero
     * @param map
     */
    public void accept(final Hero hero, final Map map) {
        hero.basicAttack(this, map);
        hero.specialAttack(this, map);
    }
}

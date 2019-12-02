package player;

import main.Map;

import static constants.Constants.HUNDREAD;
import static constants.Constants.WBONUS;
import static constants.Constants.WHEALTH;
import static constants.Constants.WKBASIC;
import static constants.Constants.WKSPECIAL;
import static constants.Constants.WLEVEL;
import static constants.Constants.WPBASIC;
import static constants.Constants.WPSPECIAL;
import static constants.Constants.WRBASIC;
import static constants.Constants.WRSPECIAL;
import static constants.Constants.WWBASIC;
import static constants.Constants.W_BASIC_DAMAGE;
import static constants.Constants.W_BASIC_LEVEL;
import static constants.Constants.W_BASIC_MULTIPLIER;
import static constants.Constants.W_SPECIAL_DAMAGE;
import static constants.Constants.W_SPECIAL_LEVEL;
import static constants.Constants.W_SPECIAL_MULTIPLIER;
import static constants.Constants.XP_LIMIT;
import static constants.Constants.XP_MULTIPLIER;

public class Wizard extends Hero {

    public Wizard(final int positionX, final int getPositionY, final HeroType type) {
        super(positionX, getPositionY, type);
        setInitialHealth(WHEALTH);
        setHealthPerLevel(WLEVEL);
    }

    /**
     * @param pyromancer
     * @param map
     */
    public void basicAttack(final Pyromancer pyromancer, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = WBONUS;
        }
        float perCent = W_BASIC_DAMAGE + W_BASIC_LEVEL * getLevel();
        perCent /= HUNDREAD;
        float damage = perCent * Math.min(W_BASIC_MULTIPLIER * pyromancer.getInitialHealth(),
                (float) (pyromancer.getHealth()));
        damage *= WPBASIC;
        damage *= terrainBonus;
        pyromancer.addHealth(-Math.round(damage));
    }

    /**
     * @param pyromancer
     * @param map
     */
    public void specialAttack(final Pyromancer pyromancer, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = WBONUS;
        }
        float perCent = W_SPECIAL_DAMAGE + W_SPECIAL_LEVEL * getLevel();
        perCent /= HUNDREAD;
        float damage = Math.min(W_SPECIAL_MULTIPLIER, perCent);
        damage *= pyromancer.getLastDamage();
        damage *= WPSPECIAL;
        damage *= terrainBonus;
        pyromancer.addHealth(-Math.round(damage));
        if (pyromancer.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - pyromancer.getLevel()) * XP_MULTIPLIER));
        }
    }

    /**
     * @param knight
     * @param map
     */
    public void basicAttack(final Knight knight, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = WBONUS;
        }
        float perCent = W_BASIC_DAMAGE + W_BASIC_LEVEL * getLevel();
        perCent /= HUNDREAD;
        float damage = perCent * Math.min(W_BASIC_MULTIPLIER * knight.getInitialHealth(),
                (float) (knight.getHealth()));
        damage *= WKBASIC;
        damage *= terrainBonus;
        knight.addHealth(-Math.round(damage));
    }

    /**
     * @param knight
     * @param map
     */
    public void specialAttack(final Knight knight, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = WBONUS;
        }
        float perCent = W_SPECIAL_DAMAGE + W_SPECIAL_LEVEL * getLevel();
        perCent /= HUNDREAD;
        float damage = Math.min(W_SPECIAL_MULTIPLIER, perCent);
        damage *= knight.getLastDamage();
        damage *= WKSPECIAL;
        damage *= terrainBonus;
        knight.addHealth(-Math.round(damage));
        if (knight.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - knight.getLevel()) * XP_MULTIPLIER));
        }
    }

    /**
     * @param rogue
     * @param map
     */
    public void basicAttack(final Rogue rogue, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = WBONUS;
        }
        float perCent = W_BASIC_DAMAGE + W_BASIC_LEVEL * getLevel();
        perCent /= HUNDREAD;
        float damage = perCent * Math.min(W_BASIC_MULTIPLIER * rogue.getInitialHealth(),
                (float) (rogue.getHealth()));
        damage *= WRBASIC;
        damage *= terrainBonus;
        rogue.addHealth(-Math.round(damage));
    }

    /**
     * @param rogue
     * @param map
     */
    public void specialAttack(final Rogue rogue, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = WBONUS;
        }
        float perCent = W_SPECIAL_DAMAGE + W_SPECIAL_LEVEL * getLevel();
        perCent /= HUNDREAD;
        float damage = Math.min(W_SPECIAL_MULTIPLIER, perCent);
        damage *= rogue.getLastDamage();
        damage *= WRSPECIAL;
        damage *= terrainBonus;
        rogue.addHealth(-Math.round(damage));
        if (rogue.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - rogue.getLevel()) * XP_MULTIPLIER));
        }
    }

    /**
     * @param wizard
     * @param map
     */
    public void basicAttack(final Wizard wizard, final Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = WBONUS;
        }
        float perCent = W_BASIC_DAMAGE + W_BASIC_LEVEL * getLevel();
        perCent /= HUNDREAD;
        float damage = perCent * Math.min(W_BASIC_MULTIPLIER * wizard.getInitialHealth(),
                (float) (wizard.getHealth()));
        damage *= WWBASIC;
        damage *= terrainBonus;
        wizard.addHealth(-Math.round(damage));
        if (wizard.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, XP_LIMIT - (getLevel()
                    - wizard.getLevel()) * XP_MULTIPLIER));
        }
    }

    /**
     * @param wizard
     * @param map
     */
    public void specialAttack(final Wizard wizard, final Map map) {

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

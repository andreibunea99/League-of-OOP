package player;

import main.Map;

import static constants.Constants.*;

public class Wizard extends Hero {

    public Wizard(int positionX, int getPositionY, HeroType type) {
        super(positionX, getPositionY, type);
        setInitialHealth(400);
        setHealthPerLevel(30);
    }

    public void basicAttack(Pyromancer pyromancer, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = WBONUS;
        }
        float perCent = 20 + 5 * getLevel();
        perCent /= 100;
        float damage = perCent * Math.min((float)(0.3 * pyromancer.getInitialHealth()), (float)(pyromancer.getHealth()));
        damage *= WPBASIC;
        damage *= terrainBonus;
        pyromancer.addHealth(-Math.round(damage));
    }

    public void specialAttack(Pyromancer pyromancer, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = WBONUS;
        }
        float perCent = 35 + 2 * getLevel();
        perCent /= 100;
        float damage = Math.min((float)(0.7), perCent);
        damage *= pyromancer.getLastDamage();
        damage *= WPSPECIAL;
        damage *= terrainBonus;
        pyromancer.addHealth(-Math.round(damage));
        if (pyromancer.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - pyromancer.getLevel())*40));
        }
    }

    public void basicAttack(Knight knight, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = WBONUS;
        }
        float perCent = 20 + 5 * getLevel();
        perCent /= 100;
        float damage = perCent * Math.min((float)(0.3 * knight.getInitialHealth()), (float)(knight.getHealth()));
        damage *= WKBASIC;
        damage *= terrainBonus;
        knight.addHealth(-Math.round(damage));
    }

    public void specialAttack(Knight knight, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = WBONUS;
        }
        float perCent = 35 + 2 * getLevel();
        perCent /= 100;
        float damage = Math.min((float)(0.7), perCent);
        damage *= knight.getLastDamage();
        damage *= WKSPECIAL;
        damage *= terrainBonus;
        knight.addHealth(-Math.round(damage));
        if (knight.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - knight.getLevel())*40));
        }
    }

    public void basicAttack(Rogue rogue, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = WBONUS;
        }
        float perCent = 20 + 5 * getLevel();
        perCent /= 100;
        float damage = perCent * Math.min((float)(0.3 * rogue.getInitialHealth()), (float)(rogue.getHealth()));
        damage *= WRBASIC;
        damage *= terrainBonus;
        rogue.addHealth(-Math.round(damage));
    }

    public void specialAttack(Rogue rogue, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = WBONUS;
        }
        float perCent = 35 + 2 * getLevel();
        perCent /= 100;
        float damage = Math.min((float)(0.7), perCent);
        damage *= rogue.getLastDamage();
        damage *= WRSPECIAL;
        damage *= terrainBonus;
        rogue.addHealth(-Math.round(damage));
        if (rogue.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - rogue.getLevel())*40));
        }
    }

    public void basicAttack(Wizard wizard, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = WBONUS;
        }
        float perCent = 20 + 5 * getLevel();
        perCent /= 100;
        float damage = perCent * Math.min((float)(0.3 * wizard.getInitialHealth()), (float)(wizard.getHealth()));
        damage *= WWBASIC;
        damage *= terrainBonus;
        wizard.addHealth(-Math.round(damage));
        if (wizard.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - wizard.getLevel())*40));
        }
    }

    public void specialAttack(Wizard wizard, Map map) {

    }

    public void accept(Hero hero, Map map) {
        hero.basicAttack(this, map);
        hero.specialAttack(this, map);
    }
}

package player;

import main.Map;

import static constants.Constants.*;

public class Knight extends Hero {

    public Knight(int positionX, int getPositionY, HeroType type) {
        super(positionX, getPositionY, type);
        setInitialHealth(900);
        setHealthPerLevel(80);
    }

    public void basicAttack(Pyromancer pyromancer, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        float hpLimit = Math.min(40, 20*getInitialHealth() + getLevel());
        hpLimit = hpLimit / 100;
        if (Math.round(hpLimit) >= pyromancer.getHealth()) {
            setLastDamage(Math.round(pyromancer.getHealth()));
            pyromancer.setHealth(0);
        } else {
            float damage = 200 + 30 * getLevel();
            damage *= terrainBonus;
            setLastDamage(Math.round(damage));
            damage *= KPBASIC;
            pyromancer.addHealth(-Math.round(damage));
        }
    }

    public void specialAttack(Pyromancer pyromancer, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        pyromancer.setStandStill(true);
        float damage = 100 + 40 * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= KPSPECIAL;
        pyromancer.addHealth(-Math.round(damage));
        if (pyromancer.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - pyromancer.getLevel())*40));
        }
    }

    public void basicAttack(Rogue rogue, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        float hpLimit = Math.min(40, 20*getInitialHealth() + getLevel());
        hpLimit = hpLimit / 100;
        if (Math.round(hpLimit) >= rogue.getHealth()) {
            setLastDamage(Math.round(rogue.getHealth()));
            rogue.setHealth(0);
        } else {
            float damage = 200 + 30 * getLevel();
            damage *= terrainBonus;
            setLastDamage(Math.round(damage));
            damage *= KRBASIC;
            rogue.addHealth(-Math.round(damage));
        }
    }

    public void specialAttack(Rogue rogue, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        rogue.setStandStill(true);
        float damage = 100 + 40 * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= KRSPECIAL;
        rogue.addHealth(-Math.round(damage));
        if (rogue.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - rogue.getLevel())*40));
        }
    }

    public void basicAttack(Knight knight, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        float hpLimit = Math.min(40, 20*getInitialHealth() + getLevel());
        hpLimit = hpLimit / 100;
        if (Math.round(hpLimit) >= knight.getHealth()) {
            setLastDamage(Math.round(knight.getHealth()));
            knight.setHealth(0);
        } else {
            float damage = 200 + 30 * getLevel();
            damage *= terrainBonus;
            setLastDamage(Math.round(damage));
            knight.addHealth(-Math.round(damage));
        }
    }

    public void specialAttack(Knight knight, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        knight.setStandStill(true);
        float damage = 100 + 40 * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= KKSPECIAL;
        knight.addHealth(-Math.round(damage));
        if (knight.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - knight.getLevel())*40));
        }
    }

    public void basicAttack(Wizard wizard, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        float hpLimit = Math.min(40, 20*getInitialHealth() + getLevel());
        hpLimit = hpLimit / 100;
        if (Math.round(hpLimit) >= wizard.getHealth()) {
            setLastDamage(Math.round(wizard.getHealth()));
            wizard.setHealth(0);
        } else {
            float damage = 200 + 30 * getLevel();
            damage *= terrainBonus;
            setLastDamage(Math.round(damage));
            damage *= KWBASIC;
            wizard.addHealth(-Math.round(damage));
        }
    }

    public void specialAttack(Wizard wizard, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = KBONUS;
        }
        wizard.setStandStill(true);
        float damage = 100 + 40 * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= KWSPECIAL;
        wizard.addHealth(-Math.round(damage));
        if (wizard.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - wizard.getLevel())*40));
        }
    }

    public void accept(Hero hero, Map map) {
        hero.basicAttack(this, map);
        hero.specialAttack(this, map);
    }
}

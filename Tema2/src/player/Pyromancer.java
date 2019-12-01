package player;

import main.Map;

import static constants.Constants.*;

public class Pyromancer extends Hero {

    public Pyromancer(int positionX, int getPositionY, HeroType type) {
        super(positionX, getPositionY, type);
        setInitialHealth(500);
        setHealthPerLevel(50);
    }

    public void basicAttack(Knight knight, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = 350 + 50*getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage));
        damage *= PKBASIC;
        knight.addHealth(-Math.round(damage));
    }

    public void specialAttack(Knight knight, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = 150 + 20*getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= PKSPECIAL;
        float damageRound = 50 + 30 * getLevel() * 1.2f;
        damageRound *= terrainBonus;
        damageRound *= PKSPECIAL;
        knight.addHealth(-Math.round(damage));
        if (knight.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - knight.getLevel())*40));
        }
        knight.setHurt(Math.round(damageRound));
        knight.setTimeOfHurt(2);
    }

    public void basicAttack(Rogue rogue, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = 350 + 50*getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage));
        damage *= PRBASIC;
        rogue.addHealth(-Math.round(damage));
    }

    public void specialAttack(Rogue rogue, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = 150 + 20*getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= PRSPECIAL;
        float damageRound = 50 + 30 * getLevel() * 1.2f;
        damageRound *= terrainBonus;
        damageRound *= PRSPECIAL;
        rogue.addHealth(-Math.round(damage));
        if (rogue.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - rogue.getLevel())*40));
        }
        rogue.setHurt(Math.round(damageRound));
        rogue.setTimeOfHurt(2);
    }

    public void basicAttack(Wizard wizard, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = 350 + 50*getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage));
        damage *= PWBASIC;
        wizard.addHealth(-Math.round(damage));
    }

    public void specialAttack(Wizard wizard, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = 150 + 20*getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= PWSPECIAL;
        float damageRound = 50 + 30 * getLevel() * 1.2f;
        damageRound *= terrainBonus;
        damageRound *= PWSPECIAL;
        wizard.addHealth(-Math.round(damage));
        if (wizard.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - wizard.getLevel())*40));
        }
        wizard.setHurt(Math.round(damageRound));
        wizard.setTimeOfHurt(2);
    }

    public void basicAttack(Pyromancer pyromancer, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = 350 + 50*getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage));
        damage *= PPBASIC;
        pyromancer.addHealth(-Math.round(damage));
    }

    public void specialAttack(Pyromancer pyromancer, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = PBONUS;
        }
        float damage = 150 + 20*getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= PPSPECIAL;
        float damageRound = 50 + 30 * getLevel() * 1.2f;
        damageRound *= terrainBonus;
        damageRound *= PPSPECIAL;
        pyromancer.addHealth(-Math.round(damage));
        if (pyromancer.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - pyromancer.getLevel())*40));
        }
        pyromancer.setHurt(Math.round(damageRound));
        pyromancer.setTimeOfHurt(2);
    }

    public void accept(Hero hero, Map map) {
        hero.basicAttack(this, map);
        hero.specialAttack(this, map);
    }

}

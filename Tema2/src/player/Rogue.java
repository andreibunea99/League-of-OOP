package player;

import main.Map;

import static constants.Constants.*;

public class Rogue extends Hero {

    private int chance;

    public Rogue(int positionX, int getPositionY, HeroType type) {
        super(positionX, getPositionY, type);
        setInitialHealth(600);
        setHealthPerLevel(40);
        chance = 0;
    }

    public void basicAttack(Pyromancer pyromancer, Map map) {
        float terrainBonus = 1f;
        chance++;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        } else if (chance == 1) {
            chance = -2;
        }
        float damage = 200 + 20 * getLevel();
        if (chance == 1) {
            damage *= 1.5f;
        }
        damage *= terrainBonus;
        setLastDamage(Math.round(damage));
        damage *= RPBASIC;
        pyromancer.addHealth(-Math.round(damage));
//        }
    }

    public void specialAttack(Pyromancer pyromancer, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        }
        float damage = 40 + 10 * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= RPSPECIAL;
        pyromancer.addHealth(-Math.round(damage));
        if (pyromancer.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - pyromancer.getLevel())*40));
        }
        pyromancer.setHurt(Math.round(damage));
        pyromancer.setTimeOfHurt(3);
        pyromancer.setTimeOfParalyze(4);
        if (terrainBonus == RBONUS) {
            pyromancer.setTimeOfHurt(6);
            pyromancer.setTimeOfParalyze(7);
        }
        pyromancer.setParalyzed(true);
    }

    public void basicAttack(Knight knight, Map map) {
        float terrainBonus = 1f;
        chance++;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        } else if (chance == 1) {
            chance = -2;
        }
        float damage = 200 + 20 * getLevel();
        damage *= terrainBonus;
        if (chance == 1) {
            damage *= 1.5f;
        }
        setLastDamage(Math.round(damage));
        damage *= RKBASIC;
        knight.addHealth(-Math.round(damage));
    }

    public void specialAttack(Knight knight, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        }
        float damage = 40 + 10 * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= RKSPECIAL;
        knight.addHealth(-Math.round(damage));
        if (knight.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - knight.getLevel())*40));
        }
        knight.setHurt(Math.round(damage));
        knight.setTimeOfHurt(3);
        knight.setTimeOfParalyze(4);
        if (terrainBonus == RBONUS) {
            knight.setTimeOfHurt(6);
            knight.setTimeOfParalyze(7);
        }
        knight.setParalyzed(true);
    }

    public void basicAttack(Wizard wizard, Map map) {
        float terrainBonus = 1f;
        chance++;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        } else if (chance == 1) {
            chance = -2;
        }
        float damage = 200 + 20 * getLevel();
        if (chance == 1) {
            damage *= 1.5f;
        }
        damage *= terrainBonus;
        setLastDamage(Math.round(damage));
        damage *= RWBASIC;
        wizard.addHealth(-Math.round(damage));
    }

    public void specialAttack(Wizard wizard, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        }
        float damage = 40 + 10 * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= RWSPECIAL;
        wizard.addHealth(-Math.round(damage));
        if (wizard.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - wizard.getLevel())*40));
        }
        wizard.setHurt(Math.round(damage));
        wizard.setTimeOfHurt(3);
        wizard.setTimeOfParalyze(4);
        if (terrainBonus == RBONUS) {
            wizard.setTimeOfHurt(6);
            wizard.setTimeOfParalyze(7);
        }
        wizard.setParalyzed(true);
    }

    public void basicAttack(Rogue rogue, Map map) {
        float terrainBonus = 1f;
        chance++;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        } else if (chance == 1) {
            chance = -2;
        }
        float damage = 200 + 20 * getLevel();
        if (chance == 1) {
            damage *= 1.5f;
        }
        damage *= terrainBonus;
        setLastDamage(Math.round(damage));
        damage *= RRBASIC;
        rogue.addHealth(-Math.round(damage));
//        }
    }

    public void specialAttack(Rogue rogue, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'W') {
            terrainBonus = RBONUS;
        }
        float damage = 40 + 10 * getLevel();
        damage *= terrainBonus;
        setLastDamage(Math.round(damage) + getLastDamage());
        damage *= RRSPECIAL;
        rogue.addHealth(-Math.round(damage));
        if (rogue.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - rogue.getLevel())*40));
        }
        rogue.setHurt(Math.round(damage));
        rogue.setTimeOfHurt(3);
        rogue.setTimeOfParalyze(4);
        if (terrainBonus == RBONUS) {
            rogue.setTimeOfHurt(6);
            rogue.setTimeOfParalyze(7);
        }
        rogue.setParalyzed(true);
    }

    public void accept(Hero hero, Map map) {
        hero.basicAttack(this, map);
        hero.specialAttack(this, map);
    }
}

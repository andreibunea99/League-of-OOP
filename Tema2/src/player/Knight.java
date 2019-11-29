package player;

import main.Map;
import play.Visitor;

public class Knight extends Hero {

    public Knight(int positionX, int getPositionY, HeroType type) {
        super(positionX, getPositionY, type);
        setInitialHealth(900);
        setHealthPerLevel(80);
    }

    public void visitExecute(Pyromancer pyromancer, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = 1.15f;
        }
        float hpLimit = Math.min(40, 20*getInitialHealth() + getLevel());
        hpLimit = hpLimit / 100;
        if (Math.round(hpLimit) > pyromancer.getHealth()) {
            pyromancer.setHealth(0);
        } else {
            float damage = 200 + 30 * getLevel();
            damage *= 1.1f;
            damage *= terrainBonus;
            pyromancer.addHealth(-Math.round(damage));
        }
        if (pyromancer.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - pyromancer.getLevel())*40));
        }
    }

    public void visitSlam(Pyromancer pyromancer, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = 1.15f;
        }
        pyromancer.setStandStill(true);
        float damage = 100 + 40 * getLevel();
        damage *= 0.9f;
        damage *= terrainBonus;
        pyromancer.addHealth(-Math.round(damage));
        if (pyromancer.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - pyromancer.getLevel())*40));
        }
    }

    public void visitExecute(Rogue rogue, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = 1.15f;
        }
        float hpLimit = Math.min(40, 20*getInitialHealth() + getLevel());
        hpLimit = hpLimit / 100;
        if (Math.round(hpLimit) > rogue.getHealth()) {
            rogue.setHealth(0);
        } else {
            float damage = 200 + 30 * getLevel();
            damage *= 1.15f;
            damage *= terrainBonus;
            rogue.addHealth(-Math.round(damage));
        }
        if (rogue.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - rogue.getLevel())*40));
        }
    }

    public void visitSlam(Rogue rogue, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = 1.15f;
        }
        rogue.setStandStill(true);
        float damage = 100 + 40 * getLevel();
        damage *= 0.8f;
        damage *= terrainBonus;
        rogue.addHealth(-Math.round(damage));
        if (rogue.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - rogue.getLevel())*40));
        }
    }

    public void visitExecute(Knight knight, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = 1.15f;
        }
        float hpLimit = Math.min(40, 20*getInitialHealth() + getLevel());
        hpLimit = hpLimit / 100;
        if (Math.round(hpLimit) > knight.getHealth()) {
            knight.setHealth(0);
        } else {
            float damage = 200 + 30 * getLevel();
            damage *= 1f;
            damage *= terrainBonus;
            knight.addHealth(-Math.round(damage));
        }
        if (knight.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - knight.getLevel())*40));
        }
    }

    public void visitSlam(Knight knight, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = 1.15f;
        }
        knight.setStandStill(true);
        float damage = 100 + 40 * getLevel();
        damage *= 1.2f;
        damage *= terrainBonus;
        knight.addHealth(-Math.round(damage));
        if (knight.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - knight.getLevel())*40));
        }
    }

    public void visitExecute(Wizard wizard, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = 1.15f;
        }
        float hpLimit = Math.min(40, 20*getInitialHealth() + getLevel());
        hpLimit = hpLimit / 100;
        if (Math.round(hpLimit) > wizard.getHealth()) {
            wizard.setHealth(0);
        } else {
            float damage = 200 + 30 * getLevel();
            damage *= 0.8f;
            damage *= terrainBonus;
            wizard.addHealth(-Math.round(damage));
        }
        if (wizard.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - wizard.getLevel())*40));
        }
    }

    public void visitSlam(Wizard wizard, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'L') {
            terrainBonus = 1.15f;
        }
        wizard.setStandStill(true);
        float damage = 100 + 40 * getLevel();
        damage *= 1.05f;
        damage *= terrainBonus;
        wizard.addHealth(-Math.round(damage));
        if (wizard.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - wizard.getLevel())*40));
        }
    }

    public void accept(Visitor v, Map map) {
        v.visitFireblast(this, map);
        v.visitIgnite(this, map);
        v.visitExecute(this, map);
        v.visitSlam(this, map);
    }
}

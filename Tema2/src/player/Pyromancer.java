package player;

import main.Map;
import play.Visitor;

public class Pyromancer extends Hero {

    public Pyromancer(int positionX, int getPositionY, HeroType type) {
        super(positionX, getPositionY, type);
        setInitialHealth(500);
        setHealthPerLevel(50);
    }

    public void visitFireblast(Knight knight, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = 1.25f;
        }
        float damage = 350 + 50*getLevel();
        damage *= 1.20f;
        damage *= terrainBonus;
        knight.addHealth(-Math.round(damage));
        if (knight.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - knight.getLevel())*40));
        }
    }

    public void visitIgnite(Knight knight, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = 1.25f;
        }
        float damage = 120 + 20*getLevel();
        damage *= 1.2f;
        damage *= terrainBonus;
        knight.addHealth(-Math.round(damage));
        if (knight.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - knight.getLevel())*40));
        }
        knight.setHurt(Math.round(50 + 30*getLevel()*1.2f));
        knight.setTimeOfHurt(2);
    }

    public void visitFireblast(Rogue rogue, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = 1.25f;
        }
        float damage = 350 + 50*getLevel();
        damage *= 0.8f;
        damage *= terrainBonus;
        rogue.addHealth(-Math.round(damage));
        if (rogue.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - rogue.getLevel())*40));
        }
    }

    public void visitIgnite(Rogue rogue, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = 1.25f;
        }
        float damage = 120 + 20*getLevel();
        damage *= 0.8f;
        damage *= terrainBonus;
        rogue.addHealth(-Math.round(damage));
        if (rogue.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - rogue.getLevel())*40));
        }
        rogue.setHurt(Math.round(50 + 30*getLevel()*1.2f));
        rogue.setTimeOfHurt(2);
    }

    public void visitFireblast(Wizard wizard, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = 1.25f;
        }
        float damage = 350 + 50*getLevel();
        damage *= 1.05f;
        damage *= terrainBonus;
        wizard.addHealth(-Math.round(damage));
        if (wizard.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - wizard.getLevel())*40));
        }
    }

    public void visitIgnite(Wizard wizard, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = 1.25f;
        }
        float damage = 120 + 20*getLevel();
        damage *= 1.05f;
        damage *= terrainBonus;
        wizard.addHealth(-Math.round(damage));
        if (wizard.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - wizard.getLevel())*40));
        }
        wizard.setHurt(Math.round(50 + 30*getLevel()*1.2f));
        wizard.setTimeOfHurt(2);
    }

    public void visitFireblast(Pyromancer pyromancer, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = 1.25f;
        }
        float damage = 350 + 50*getLevel();
        damage *= 0.9f;
        damage *= terrainBonus;
        pyromancer.addHealth(-Math.round(damage));
        if (pyromancer.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - pyromancer.getLevel())*40));
        }
    }

    public void visitIgnite(Pyromancer pyromancer, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'V') {
            terrainBonus = 1.25f;
        }
        float damage = 120 + 20*getLevel();
        damage *= 0.9f;
        damage *= terrainBonus;
        pyromancer.addHealth(-Math.round(damage));
        if (pyromancer.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - pyromancer.getLevel())*40));
        }
        pyromancer.setHurt(Math.round(50 + 30*getLevel()*1.2f));
        pyromancer.setTimeOfHurt(2);
    }

    public void accept(Visitor v, Map map) {
        v.visitFireblast(this, map);
        v.visitIgnite(this, map);
        v.visitExecute(this, map);
        v.visitSlam(this, map);
    }

}

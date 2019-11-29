package player;

import main.Map;
import play.Visitor;

public class Wizard extends Hero {

    public Wizard(int positionX, int getPositionY, HeroType type) {
        super(positionX, getPositionY, type);
        setInitialHealth(400);
        setHealthPerLevel(30);
    }

    public void visitDrain(Pyromancer pyromancer, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = 1.1f;
        }
        float perCent = 20 + 5 * getLevel();
        perCent /= 100;
        float damage = perCent * Math.min((float)(0.3 * pyromancer.getInitialHealth()), (float)(pyromancer.getHealth()));
        damage *= 0.9f;
        damage *= terrainBonus;
        pyromancer.addHealth(-Math.round(damage));
        if (pyromancer.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - pyromancer.getLevel())*40));
        }
    }

    public void visitDeflect(Pyromancer pyromancer, Map map) {
        float terrainBonus = 1f;
        if (map.getParcel(getPositionX(), getPositionY()) == 'D') {
            terrainBonus = 1.1f;
        }
        float perCent = 20 + 5 * getLevel();
        perCent /= 100;
        float damage = perCent * Math.min((float)(0.3 * pyromancer.getInitialHealth()), (float)(pyromancer.getHealth()));
        damage *= 0.9f;
        damage *= terrainBonus;
        pyromancer.addHealth(-Math.round(damage));
        if (pyromancer.getHealth() <= 0) {
            setExperience(getExperience() + Math.max(0, 200 - (getLevel() - pyromancer.getLevel())*40));
        }
    }

    public void accept(Visitor v, Map map) {
        v.visitFireblast(this, map);
        v.visitIgnite(this, map);
        v.visitExecute(this, map);
        v.visitSlam(this, map);
    }
}

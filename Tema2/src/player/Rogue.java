package player;

import main.Map;
import play.Visitor;

public class Rogue extends Hero {

    public Rogue(int positionX, int getPositionY, HeroType type) {
        super(positionX, getPositionY, type);
    }

    public void accept(Visitor v, Map map) {
        v.visitFireblast(this, map);
        v.visitIgnite(this, map);
        v.visitExecute(this, map);
        v.visitSlam(this, map);
    }
}

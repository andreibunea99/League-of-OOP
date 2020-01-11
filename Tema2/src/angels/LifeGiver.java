package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class LifeGiver extends Angel {

    public LifeGiver(int x, int y) {
        super(AngelType.LifeGiver, x, y);
    }

    public void castAngel(Knight knight) {
        knight.addHealth(100);
        knight.setHealth(Math.min(knight.getHealth(), knight.getInitialHealth()));
    }

    public void castAngel(Pyromancer pyromancer) {
        pyromancer.addHealth(80);
        pyromancer.setHealth(Math.min(pyromancer.getHealth(), pyromancer.getInitialHealth()));
    }

    public void castAngel(Rogue rogue) {
        rogue.addHealth(90);
        rogue.setHealth(Math.min(rogue.getHealth(), rogue.getInitialHealth()));
    }

    public void castAngel(Wizard wizard) {
        wizard.addHealth(120);
        wizard.setHealth(Math.min(wizard.getHealth(), wizard.getInitialHealth()));
    }

    public String printAngel() {
        return "LifeGiver helped";
    }
}

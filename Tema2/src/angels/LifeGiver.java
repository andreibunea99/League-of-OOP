package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class LifeGiver extends Angel {

    public LifeGiver(int x, int y) {
        super(AngelType.DamageAngel, x, y);
    }

    public void castAngel(Knight knight) {
        knight.addHealth(100);
    }

    public void castAngel(Pyromancer pyromancer) {
        pyromancer.addHealth(80);
    }

    public void castAngel(Rogue rogue) {
        rogue.addHealth(90);
    }

    public void castAngel(Wizard wizard) {
        wizard.addHealth(120);
    }
}

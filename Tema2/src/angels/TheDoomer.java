package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class TheDoomer extends Angel {

    public TheDoomer(int x, int y) {
        super(AngelType.TheDoomer, x, y);
    }

    public void castAngel(Knight knight) {
        knight.setHealth(0);
    }

    public void castAngel(Pyromancer pyromancer) {
        pyromancer.setHealth(0);
    }

    public void castAngel(Rogue rogue) {
        rogue.setHealth(0);
    }

    public void castAngel(Wizard wizard) {
        wizard.setHealth(0);
    }

    public String printAngel() {
        return "TheDoomer hit";
    }
}

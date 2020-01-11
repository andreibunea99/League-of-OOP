package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class DarkAngel extends Angel {

    public DarkAngel(int x, int y) {
        super(AngelType.DarkAngel, x, y);
    }

    public void castAngel(Knight knight) {
        knight.addHealth(-40);
    }

    public void castAngel(Pyromancer pyromancer) {
        pyromancer.addHealth(-30);
    }

    public void castAngel(Rogue rogue) {
        rogue.addHealth(-10);
    }

    public void castAngel(Wizard wizard) {
        wizard.addHealth(-20);
    }

    public String printAngel() {
        return "DarkAngel hit";
    }
}

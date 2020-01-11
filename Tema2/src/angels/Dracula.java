package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Dracula extends Angel {

    public Dracula(int x, int y) {
        super(AngelType.Dracula, x, y);
    }

    public void castAngel(Knight knight) {
        knight.setModifier((float) (knight.getModifier() - 0.2));
        knight.addHealth(-60);
    }

    public void castAngel(Pyromancer pyromancer) {
        pyromancer.setModifier((float) (pyromancer.getModifier() - 0.3));
        pyromancer.addHealth(-40);
    }

    public void castAngel(Rogue rogue) {
        rogue.setModifier((float) (rogue.getModifier() - 0.1));
        rogue.addHealth(-35);
    }

    public void castAngel(Wizard wizard) {
        wizard.setModifier((float) (wizard.getModifier() - 0.4));
        wizard.addHealth(-20);
    }

    public String printAngel() {
        return "Dracula hit";
    }
}

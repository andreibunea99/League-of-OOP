package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class GoodBoy extends Angel {

    public GoodBoy(int x, int y) {
        super(AngelType.GoodBoy, x, y);
    }

    public void castAngel(Knight knight) {
        knight.setModifier((float) (knight.getModifier() + 0.4));
        knight.addHealth(20);
        knight.setHealth(Math.min(knight.getHealth(), knight.getInitialHealth()));
    }

    public void castAngel(Pyromancer pyromancer) {
        pyromancer.setModifier((float) (pyromancer.getModifier() + 0.5));
        pyromancer.addHealth(30);
        pyromancer.setHealth(Math.min(pyromancer.getHealth(), pyromancer.getInitialHealth()));
    }

    public void castAngel(Rogue rogue) {
        rogue.setModifier((float) (rogue.getModifier() + 0.4));
        rogue.addHealth(40);
        rogue.setHealth(Math.min(rogue.getHealth(), rogue.getInitialHealth()));
    }

    public void castAngel(Wizard wizard) {
        wizard.setModifier((float) (wizard.getModifier() + 0.3));
        wizard.addHealth(50);
        wizard.setHealth(Math.min(wizard.getHealth(), wizard.getInitialHealth()));
    }

    public String printAngel() {
        return "GoodBoy helped";
    }
}

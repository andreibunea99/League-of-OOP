package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class SmallAngel extends Angel {

    public SmallAngel(int x, int y) {
        super(AngelType.SmallAngel, x, y);
    }

    public void castAngel(Knight knight) {
        knight.setModifier((float) (knight.getModifier() + 0.1));
        knight.addHealth(10);
        knight.setHealth(Math.min(knight.getHealth(), knight.getInitialHealth()));
    }

    public void castAngel(Pyromancer pyromancer) {
        pyromancer.setModifier((float) (pyromancer.getModifier() + 0.15));
        pyromancer.addHealth(15);
        pyromancer.setHealth(Math.min(pyromancer.getHealth(), pyromancer.getInitialHealth()));
    }

    public void castAngel(Rogue rogue) {
        rogue.setModifier((float) (rogue.getModifier() + 0.05));
        rogue.addHealth(20);
        rogue.setHealth(Math.min(rogue.getHealth(), rogue.getInitialHealth()));
    }

    public void castAngel(Wizard wizard) {
        wizard.setModifier((float) (wizard.getModifier() + 0.1));
        wizard.addHealth(25);
        wizard.setHealth(Math.min(wizard.getHealth(), wizard.getInitialHealth()));
    }

    public String printAngel() {
        return "SmallAngel helped";
    }
}

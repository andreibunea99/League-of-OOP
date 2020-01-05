package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class GoodBoy extends Angel {

    public GoodBoy(int x, int y) {
        super(AngelType.DamageAngel, x, y);
    }

    public void castAngel(Knight knight) {
        knight.setModifier((float) (knight.getModifier() + 0.4));
        knight.addHealth(20);
    }

    public void castAngel(Pyromancer pyromancer) {
        pyromancer.setModifier((float) (pyromancer.getModifier() + 0.5));
        pyromancer.addHealth(30);
    }

    public void castAngel(Rogue rogue) {
        rogue.setModifier((float) (rogue.getModifier() + 0.4));
        rogue.addHealth(40);
    }

    public void castAngel(Wizard wizard) {
        wizard.setModifier((float) (wizard.getModifier() + 0.3));
        wizard.addHealth(50);
    }
}

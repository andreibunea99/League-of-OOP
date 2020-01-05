package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class XPAngel extends Angel {

    public XPAngel(int x, int y) {
        super(AngelType.DamageAngel, x, y);
    }

    public void castAngel(Knight knight) {
        knight.setExperience(knight.getExperience() + 45);
    }

    public void castAngel(Pyromancer pyromancer) {
        pyromancer.setExperience(pyromancer.getExperience() + 50);
    }

    public void castAngel(Rogue rogue) {
        rogue.setExperience(rogue.getExperience() + 40);
    }

    public void castAngel(Wizard wizard) {
        wizard.setExperience(wizard.getExperience() + 60);
    }
}

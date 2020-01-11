package angels;

import player.*;

public class DamageAngel extends Angel {

    public DamageAngel(int x, int y) {
        super(AngelType.DamageAngel, x, y);
    }

    public void castAngel(Knight knight) {
        knight.setModifier((float) (knight.getModifier() + 0.15));
    }

    public void castAngel(Pyromancer pyromancer) {
        pyromancer.setModifier((float) (pyromancer.getModifier() + 0.2));
    }

    public void castAngel(Rogue rogue) {
        rogue.setModifier((float) (rogue.getModifier() + 0.3));
    }

    public void castAngel(Wizard wizard) {
        wizard.setModifier((float) (wizard.getModifier() + 0.4));
    }

    public String printAngel() {
        return "DamageAngel helped";
    }
}

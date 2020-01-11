package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class LifeGiver extends Angel {

    public static final int K = 100;
    public static final int P = 80;
    public static final int R = 90;
    public static final int W = 120;

    public LifeGiver(final int x, final int y) {
        super(AngelType.LifeGiver, x, y);
    }

    /**
     * @param knight
     */
    public void castAngel(final Knight knight) {
        knight.addHealth(K);
        knight.setHealth(Math.min(knight.getHealth(), knight.getInitialHealth()));
    }

    /**
     * @param pyromancer
     */
    public void castAngel(final Pyromancer pyromancer) {
        pyromancer.addHealth(P);
        pyromancer.setHealth(Math.min(pyromancer.getHealth(), pyromancer.getInitialHealth()));
    }

    /**
     * @param rogue
     */
    public void castAngel(final Rogue rogue) {
        rogue.addHealth(R);
        rogue.setHealth(Math.min(rogue.getHealth(), rogue.getInitialHealth()));
    }

    /**
     * @param wizard
     */
    public void castAngel(final Wizard wizard) {
        wizard.addHealth(W);
        wizard.setHealth(Math.min(wizard.getHealth(), wizard.getInitialHealth()));
    }

    /**
     * @return
     */
    public String printAngel() {
        return "LifeGiver helped";
    }
}

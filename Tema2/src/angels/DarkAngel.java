package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class DarkAngel extends Angel {
    public static final int K = -40;
    public static final int P = -30;
    public static final int R = -10;
    public static final int W = -20;

    public DarkAngel(final int x, final int y) {
        super(AngelType.DarkAngel, x, y);
    }

    /**
     * @param knight
     */
    public void castAngel(final Knight knight) {
        knight.addHealth(K);
    }

    /**
     * @param pyromancer
     */
    public void castAngel(final Pyromancer pyromancer) {
        pyromancer.addHealth(P);
    }

    /**
     * @param rogue
     */
    public void castAngel(final Rogue rogue) {
        rogue.addHealth(R);
    }

    /**
     * @param wizard
     */
    public void castAngel(final Wizard wizard) {
        wizard.addHealth(W);
    }

    /**
     * @return
     */
    public String printAngel() {
        return "DarkAngel hit";
    }
}

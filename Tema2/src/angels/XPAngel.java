package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class XPAngel extends Angel {
    public static final int K = 45;
    public static final int P = 50;
    public static final int R = 40;
    public static final int W = 60;

    public XPAngel(final int x, final int y) {
        super(AngelType.XPAngel, x, y);
    }

    /**
     * @param knight
     */
    public void castAngel(final Knight knight) {
        knight.setExperience(knight.getExperience() + K);
    }

    /**
     * @param pyromancer
     */
    public void castAngel(final Pyromancer pyromancer) {
        pyromancer.setExperience(pyromancer.getExperience() + P);
    }

    /**
     * @param rogue
     */
    public void castAngel(final Rogue rogue) {
        rogue.setExperience(rogue.getExperience() + R);
    }

    /**
     * @param wizard
     */
    public void castAngel(final Wizard wizard) {
        wizard.setExperience(wizard.getExperience() + W);
    }

    /**
     * @return
     */
    public String printAngel() {
        return "XPAngel helped";
    }
}

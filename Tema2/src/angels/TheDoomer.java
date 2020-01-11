package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class TheDoomer extends Angel {

    public TheDoomer(final int x, final int y) {
        super(AngelType.TheDoomer, x, y);
    }

    /**
     * @param knight
     */
    public void castAngel(final Knight knight) {
        knight.setHealth(0);
    }

    /**
     * @param pyromancer
     */
    public void castAngel(final Pyromancer pyromancer) {
        pyromancer.setHealth(0);
    }

    /**
     * @param rogue
     */
    public void castAngel(final Rogue rogue) {
        rogue.setHealth(0);
    }

    /**
     * @param wizard
     */
    public void castAngel(final Wizard wizard) {
        wizard.setHealth(0);
    }

    /**
     * @return
     */
    public String printAngel() {
        return "TheDoomer hit";
    }
}

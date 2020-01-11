package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Spawner extends Angel {

    public static final int K = 200;
    public static final int P = 150;
    public static final int R = 180;
    public static final int W = 120;

    public Spawner(final int x, final int y) {
        super(AngelType.Spawner, x, y);
    }

    /**
     * @param knight
     */
    public void castAngel(final Knight knight) {
        if (knight.getHealth() > 0) {
            return;
        }
        knight.setHealth(K);
    }

    /**
     * @param pyromancer
     */
    public void castAngel(final Pyromancer pyromancer) {
        if (pyromancer.getHealth() > 0) {
            return;
        }
        pyromancer.setHealth(P);
    }

    /**
     * @param rogue
     */
    public void castAngel(final Rogue rogue) {
        if (rogue.getHealth() > 0) {
            return;
        }
        rogue.setHealth(R);
    }

    /**
     * @param wizard
     */
    public void castAngel(final Wizard wizard) {
        if (wizard.getHealth() > 0) {
            return;
        }
        wizard.setHealth(W);
    }

    /**
     * @return
     */
    public String printAngel() {
        return "Spawner helped";
    }
}

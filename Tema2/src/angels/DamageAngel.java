package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class DamageAngel extends Angel {

    public static final float K = 0.15f;
    public static final float P = 0.2f;
    public static final float R = 0.3f;
    public static final float W = 0.4f;

    public DamageAngel(final int x, final int y) {
        super(AngelType.DamageAngel, x, y);
    }

    /**
     * @param knight
     */
    public void castAngel(final Knight knight) {
        knight.setModifier((float) (knight.getModifier() + K));
    }

    /**
     * @param pyromancer
     */
    public void castAngel(final Pyromancer pyromancer) {
        pyromancer.setModifier((float) (pyromancer.getModifier() + P));
    }

    /**
     * @param rogue
     */
    public void castAngel(final Rogue rogue) {
        rogue.setModifier((float) (rogue.getModifier() + R));
    }

    /**
     * @param wizard
     */
    public void castAngel(final Wizard wizard) {
        wizard.setModifier((float) (wizard.getModifier() + W));
    }

    /**
     * @return
     */
    public String printAngel() {
        return "DamageAngel helped";
    }
}

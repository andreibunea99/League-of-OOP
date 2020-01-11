package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Dracula extends Angel {

    public Dracula(final int x, final int y) {
        super(AngelType.Dracula, x, y);
    }

    public static final int KH = -60;
    public static final int PH = -40;
    public static final int RH = -35;
    public static final int WH = -20;
    public static final float KD = 0.2f;
    public static final float PD = 0.3f;
    public static final float RD = 0.1f;
    public static final float WD = 0.4f;

    /**
     * @param knight
     */
    public void castAngel(final Knight knight) {
        knight.setModifier((float) (knight.getModifier() - KD));
        knight.addHealth(KH);
    }

    /**
     * @param pyromancer
     */
    public void castAngel(final Pyromancer pyromancer) {
        pyromancer.setModifier((float) (pyromancer.getModifier() - PD));
        pyromancer.addHealth(PH);
    }

    /**
     * @param rogue
     */
    public void castAngel(final Rogue rogue) {
        rogue.setModifier((float) (rogue.getModifier() - RD));
        rogue.addHealth(RH);
    }

    /**
     * @param wizard
     */
    public void castAngel(final Wizard wizard) {
        wizard.setModifier((float) (wizard.getModifier() - WD));
        wizard.addHealth(WH);
    }

    /**
     * @return
     */
    public String printAngel() {
        return "Dracula hit";
    }
}

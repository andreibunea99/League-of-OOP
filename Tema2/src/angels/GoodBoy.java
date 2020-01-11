package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class GoodBoy extends Angel {

    public static final float KD = 0.4f;
    public static final float PD = 0.5f;
    public static final float RD = 0.4f;
    public static final float WD = 0.3f;
    public static final int KH = 20;
    public static final int PH = 30;
    public static final int RH = 40;
    public static final int WH = 50;

    public GoodBoy(final int x, final int y) {
        super(AngelType.GoodBoy, x, y);
    }

    /**
     * @param knight
     */
    public void castAngel(final Knight knight) {
        knight.setModifier((float) (knight.getModifier() + KD));
        knight.addHealth(KH);
        knight.setHealth(Math.min(knight.getHealth(), knight.getInitialHealth()));
    }

    /**
     * @param pyromancer
     */
    public void castAngel(final Pyromancer pyromancer) {
        pyromancer.setModifier((float) (pyromancer.getModifier() + PD));
        pyromancer.addHealth(PH);
        pyromancer.setHealth(Math.min(pyromancer.getHealth(), pyromancer.getInitialHealth()));
    }

    /**
     * @param rogue
     */
    public void castAngel(final Rogue rogue) {
        rogue.setModifier((float) (rogue.getModifier() + RD));
        rogue.addHealth(RH);
        rogue.setHealth(Math.min(rogue.getHealth(), rogue.getInitialHealth()));
    }

    /**
     * @param wizard
     */
    public void castAngel(final Wizard wizard) {
        wizard.setModifier((float) (wizard.getModifier() + WD));
        wizard.addHealth(WH);
        wizard.setHealth(Math.min(wizard.getHealth(), wizard.getInitialHealth()));
    }

    /**
     * @return
     */
    public String printAngel() {
        return "GoodBoy helped";
    }
}

package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class SmallAngel extends Angel {

    public static final int KH = 10;
    public static final int PH = 15;
    public static final int RH = 20;
    public static final int WH = 25;
    public static final float KD = 0.1f;
    public static final float PD = 0.15f;
    public static final float RD = 0.05f;
    public static final float WD = 0.1f;

    public SmallAngel(final int x, final int y) {
        super(AngelType.SmallAngel, x, y);
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
        return "SmallAngel helped";
    }
}

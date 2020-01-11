package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class LevelUpAngel extends Angel {

    public static final float K = 0.1f;
    public static final float P = 0.2f;
    public static final float R = 0.15f;
    public static final float W = 0.25f;

    public LevelUpAngel(final int x, final int y) {
        super(AngelType.LevelUpAngel, x, y);
    }

    /**
     * @param knight
     */
    public void castAngel(final Knight knight) {
        knight.setExperience(knight.getXPNextLevel());
        knight.setModifier((float) (knight.getModifier() + K));
    }

    /**
     * @param pyromancer
     */
    public void castAngel(final Pyromancer pyromancer) {
        pyromancer.setExperience(pyromancer.getXPNextLevel());
        pyromancer.setModifier((float) (pyromancer.getModifier() + P));
    }

    /**
     * @param rogue
     */
    public void castAngel(final Rogue rogue) {
        rogue.setExperience(rogue.getXPNextLevel());
        rogue.setModifier((float) (rogue.getModifier() + R));
    }

    /**
     * @param wizard
     */
    public void castAngel(final Wizard wizard) {
        wizard.setExperience(wizard.getXPNextLevel());
        wizard.setModifier((float) (wizard.getModifier() + W));
    }

    /**
     * @return
     */
    public String printAngel() {
        return "LevelUpAngel helped";
    }
}

package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

import static constants.Constants.LEVEL;
import static constants.Constants.LEVELZERO;

public class LevelUpAngel extends Angel {

    public LevelUpAngel(int x, int y) {
        super(AngelType.DamageAngel, x, y);
    }

    public void castAngel(Knight knight) {
        int xp_level_up = LEVELZERO + knight.getLevel() * LEVEL;
        knight.setExperience(xp_level_up);
        knight.setModifier((float) (knight.getModifier() + 0.1));
    }

    public void castAngel(Pyromancer pyromancer) {
        int xp_level_up = LEVELZERO + pyromancer.getLevel() * LEVEL;
        pyromancer.setExperience(xp_level_up);
        pyromancer.setModifier((float) (pyromancer.getModifier() + 0.2));
    }

    public void castAngel(Rogue rogue) {
        int xp_level_up = LEVELZERO + rogue.getLevel() * LEVEL;
        rogue.setExperience(xp_level_up);
        rogue.setModifier((float) (rogue.getModifier() + 0.15));
    }

    public void castAngel(Wizard wizard) {
        int xp_level_up = LEVELZERO + wizard.getLevel() * LEVEL;
        wizard.setExperience(xp_level_up);
        wizard.setModifier((float) (wizard.getModifier() + 0.25));
    }
}

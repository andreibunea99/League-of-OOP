package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Spawner extends Angel {

    public Spawner(int x, int y) {
        super(AngelType.DamageAngel, x, y);
    }

    public void castAngel(Knight knight) {
        knight.setHealth(200);
    }

    public void castAngel(Pyromancer pyromancer) {
        pyromancer.setHealth(150);
    }

    public void castAngel(Rogue rogue) {
        rogue.setHealth(180);
    }

    public void castAngel(Wizard wizard) {
        wizard.setHealth(120);
    }
}

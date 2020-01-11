package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Spawner extends Angel {

    public Spawner(int x, int y) {
        super(AngelType.Spawner, x, y);
    }

    public void castAngel(Knight knight) {
        if (knight.getHealth() > 0) {
            return;
        }
        knight.setHealth(200);
    }

    public void castAngel(Pyromancer pyromancer) {
        if (pyromancer.getHealth() > 0) {
            return;
        }
        pyromancer.setHealth(150);
    }

    public void castAngel(Rogue rogue) {
        if (rogue.getHealth() > 0) {
            return;
        }
        rogue.setHealth(180);
    }

    public void castAngel(Wizard wizard) {
        if (wizard.getHealth() > 0) {
            return;
        }
        wizard.setHealth(120);
    }

    public String printAngel() {
        return "Spawner helped";
    }
}

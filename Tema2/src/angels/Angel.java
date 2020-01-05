package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public abstract class Angel {
    private int x;
    private int y;
    private AngelType type;

    public Angel( AngelType type, int x, int y) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    /**
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return
     */
    public AngelType getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(AngelType type) {
        this.type = type;
    }

    /**
     * @param knight
     */
    public void castAngel(Knight knight) {

    }

    /**
     * @param pyromancer
     */
    public void castAngel(Pyromancer pyromancer) {

    }

    /**
     * @param rogue
     */
    public void castAngel(Rogue rogue) {

    }

    /**
     * @param wizard
     */
    public void castAngel(Wizard wizard) {

    }
}

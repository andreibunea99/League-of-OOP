package angels;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public abstract class Angel {
    private int x;
    private int y;
    private AngelType type;

    public Angel(final AngelType type, final int x, final int y) {
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
    public void setX(final int x) {
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
    public void setY(final int y) {
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
    public void setType(final AngelType type) {
        this.type = type;
    }

    /**
     * @param knight
     */
    public void castAngel(final Knight knight) {

    }

    /**
     * @param pyromancer
     */
    public void castAngel(final Pyromancer pyromancer) {

    }

    /**
     * @param rogue
     */
    public void castAngel(final Rogue rogue) {

    }

    /**
     * @param wizard
     */
    public void castAngel(final Wizard wizard) {

    }

    /**
     * @return
     */
    public String printAngel() {
        return null;
    }
}

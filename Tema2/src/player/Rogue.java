package player;

public class Rogue extends Hero {
    private int positionX;
    private int getPositionY;
    private int health;
    private int level;
    private int experience;
    private HeroType type;

    public Rogue(int positionX, int getPositionY, HeroType type) {
        super(positionX, getPositionY, type);
    }
}

package player;

public class Wizard extends Hero {
    private int positionX;
    private int getPositionY;
    private int health;
    private int level;
    private int experience;
    private HeroType type;

    public Wizard(int positionX, int getPositionY, HeroType type) {
        super(positionX, getPositionY, type);
    }
}

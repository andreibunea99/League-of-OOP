package player;

public class Knight extends Hero {
    private int positionX;
    private int getPositionY;
    private int health;
    private int level;
    private int experience;
    private HeroType type;

    public Knight(int positionX, int getPositionY, HeroType type) {
        super(positionX, getPositionY, type);
    }
}

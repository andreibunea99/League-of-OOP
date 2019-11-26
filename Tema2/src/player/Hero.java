package player;

public abstract class Hero {
    private int positionX;
    private int positionY;
    private int health;
    private int level;
    private int experience;
    private HeroType type;

    public Hero(int positionX, int getPositionY, HeroType type) {
        this.positionX = positionX;
        this.positionY = getPositionY;
        this.type = type;
        level = 0;
    }

    public void addExperience(int x) {
        experience += x;
        level = (experience - 250) % 50;
    }

    public void addHealth(int x) {
        health += x;
        if (health < 0) {
            health = 0;
        }
    }

    public void moveUp() {
        positionX++;
    }

    public void moveDown() {
        positionX--;
    }

    public void moveLeft() {
        positionY--;
    }

    public void moveRight() {
        positionY++;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int getPositionY) {
        this.positionY = getPositionY;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public HeroType getType() {
        return type;
    }

    public void setType(HeroType type) {
        this.type = type;
    }
}

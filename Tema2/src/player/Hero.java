package player;

public abstract class Hero {
    private int positionX;
    private int positionY;
    private int health;
    private int level;
    private int experience;
    private int hurt;
    private int timeOfHurt;
    private int healthPerLevel;
    private int initialHealth;
    private boolean standStill;
    private int lastDamage;
    private HeroType type;

    public Hero(int positionX, int getPositionY, HeroType type) {
        this.positionX = positionX;
        this.positionY = getPositionY;
        this.type = type;
        level = 0;
        lastDamage = 0;
    }

    public void setInitialHealth(int initialHealth) {
        this.initialHealth = initialHealth;
        health = initialHealth;
    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public boolean isStandStill() {
        return standStill;
    }

    public int getLastDamage() {
        return lastDamage;
    }

    public void setLastDamage(int lastDamage) {
        this.lastDamage = lastDamage;
    }

    public void setStandStill(boolean standStill) {
        this.standStill = standStill;
    }

    public int getHurt() {
        return hurt;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    public int getTimeOfHurt() {
        return timeOfHurt;
    }

    public void setTimeOfHurt(int timeOfHurt) {
        this.timeOfHurt = timeOfHurt;
    }

    public void setHealthPerLevel(int healthPerLevel) {
        this.healthPerLevel = healthPerLevel;
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

    public void checkWound() {
        if (hurt != 0) {
            health -= hurt;
            timeOfHurt--;
        }
        if (timeOfHurt == 0) {
            hurt = 0;
        }
        if (experience > 250 + level * 50) {
            level++;
            initialHealth += healthPerLevel;
            health = initialHealth;
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

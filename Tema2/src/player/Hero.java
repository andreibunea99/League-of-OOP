package player;

import main.Map;

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
    private boolean paralyzed;
    private int timeOfParalyze;
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
        setTimeOfHurt(0);
        setHurt(0);
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    public void setTimeOfHurt(int timeOfHurt) {
        this.timeOfHurt = timeOfHurt;
        paralyzed = false;
    }

    public void setTimeOfParalyze(int timeOfParalyze) {
        this.timeOfParalyze = timeOfParalyze;
    }

    public void setHealthPerLevel(int healthPerLevel) {
        this.healthPerLevel = healthPerLevel;
    }

    public void addHealth(int x) {
        health += x;
        if (health < 0) {
            health = 0;
        }
    }

    public void checkWound() {
        timeOfParalyze--;
        if (hurt != 0) {
            health -= hurt;
            timeOfHurt--;
        }
        if (timeOfHurt == 0) {
            hurt = 0;
        }
        if (timeOfParalyze == 0) {
            paralyzed = false;
        }
    }

    public void moveUp() {
        positionX--;
    }

    public void moveDown() {
        positionX++;
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

    public int getPositionY() {
        return positionY;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public HeroType getType() {
        return type;
    }

    public void accept(Hero hero, Map map) {

    }

    public boolean isParalyzed() {
        return paralyzed;
    }

    public void setParalyzed(boolean paralyzed) {
        this.paralyzed = paralyzed;
    }

    protected abstract void basicAttack(Pyromancer pyromancer, Map map);

    protected abstract void basicAttack(Knight knight, Map map);

    protected abstract void basicAttack(Rogue rogue, Map map);

    protected abstract void basicAttack(Wizard wizard, Map map);

    protected abstract void specialAttack(Pyromancer pyromancer, Map map);

    protected abstract void specialAttack(Knight knight, Map map);

    protected abstract void specialAttack(Rogue rogue, Map map);

    protected abstract void specialAttack(Wizard wizard, Map map);

    public void finalRound() {
        if (health <= 0) {
            return;
        }
        int levelUp = (experience - 250) / 50 + 1;
        if (levelUp > level) {
            level = levelUp;
            initialHealth += levelUp*healthPerLevel;
            health = initialHealth;
        }
    }
}

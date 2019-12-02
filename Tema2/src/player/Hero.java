package player;

import main.Map;

import static constants.Constants.LEVEL;
import static constants.Constants.LEVELZERO;

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

    public Hero(final int positionX, final int getPositionY, final HeroType type) {
        this.positionX = positionX;
        this.positionY = getPositionY;
        this.type = type;
        level = 0;
        lastDamage = 0;
    }

    /**
     * @param initialHealth
     */
    public void setInitialHealth(final int initialHealth) {
        this.initialHealth = initialHealth;
        health = initialHealth;
    }

    /**
     * @return
     */
    public int getInitialHealth() {
        return initialHealth;
    }

    /**
     * @return
     */
    public boolean isStandStill() {
        return standStill;
    }

    /**
     * @return
     */
    public int getLastDamage() {
        return lastDamage;
    }

    /**
     * @param lastDamage
     */
    public void setLastDamage(final int lastDamage) {
        this.lastDamage = lastDamage;
    }

    /**
     * @param standStill
     */
    public void setStandStill(final boolean standStill) {
        this.standStill = standStill;
        setTimeOfHurt(0);
        setHurt(0);
    }

    /**
     * @param hurt
     */
    public void setHurt(final int hurt) {
        this.hurt = hurt;
    }

    /**
     * @param timeOfHurt
     */
    public void setTimeOfHurt(final int timeOfHurt) {
        this.timeOfHurt = timeOfHurt;
        paralyzed = false;
    }

    /**
     * @param timeOfParalyze
     */
    public void setTimeOfParalyze(final int timeOfParalyze) {
        this.timeOfParalyze = timeOfParalyze;
    }

    /**
     * @param healthPerLevel
     */
    public void setHealthPerLevel(final int healthPerLevel) {
        this.healthPerLevel = healthPerLevel;
    }

    /**
     * @param x
     */
    public void addHealth(final int x) {
        health += x;
        if (health < 0) {
            health = 0;
        }
    }

    /**
     *
     */
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

    /**
     *
     */
    public void moveUp() {
        positionX--;
    }

    /**
     *
     */
    public void moveDown() {
        positionX++;
    }

    /**
     *
     */
    public void moveLeft() {
        positionY--;
    }

    /**
     *
     */
    public void moveRight() {
        positionY++;
    }

    /**
     * @return
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * @return
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * @return
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health
     */
    public void setHealth(final int health) {
        this.health = health;
    }

    /**
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return
     */
    public int getExperience() {
        return experience;
    }

    /**
     * @param experience
     */
    public void setExperience(final int experience) {
        this.experience = experience;
    }

    /**
     * @return
     */
    public HeroType getType() {
        return type;
    }

    /**
     * @param hero
     * @param map
     */
    public void accept(final Hero hero, final Map map) {

    }

    /**
     * @return
     */
    public boolean isParalyzed() {
        return paralyzed;
    }

    /**
     * @param paralyzed
     */
    public void setParalyzed(final boolean paralyzed) {
        this.paralyzed = paralyzed;
    }

    /**
     * @param pyromancer
     * @param map
     */
    protected abstract void basicAttack(Pyromancer pyromancer, Map map);

    /**
     * @param knight
     * @param map
     */
    protected abstract void basicAttack(Knight knight, Map map);

    protected abstract void basicAttack(Rogue rogue, Map map);

    /**
     * @param wizard
     * @param map
     */
    protected abstract void basicAttack(Wizard wizard, Map map);

    /**
     * @param pyromancer
     * @param map
     */
    protected abstract void specialAttack(Pyromancer pyromancer, Map map);

    /**
     * @param knight
     * @param map
     */
    protected abstract void specialAttack(Knight knight, Map map);

    /**
     * @param rogue
     * @param map
     */
    protected abstract void specialAttack(Rogue rogue, Map map);

    /**
     * @param wizard
     * @param map
     */
    protected abstract void specialAttack(Wizard wizard, Map map);

    /**
     *
     */
    public void finalRound() {
        if (health <= 0) {
            return;
        }
        int levelUp = (experience - LEVELZERO) / LEVEL + 1;
        if (levelUp > level) {
            level = levelUp;
            initialHealth += levelUp * healthPerLevel;
            health = initialHealth;
        }
    }
}

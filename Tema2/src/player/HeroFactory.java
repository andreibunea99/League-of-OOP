package player;

public final class HeroFactory {

    private static HeroFactory instance = null;

    public Hero getHero(HeroType name, int x, int y) {
        if (name == HeroType.Knight) {
            return new Knight(x, y, name);
        } else if (name == HeroType.Pyromancer) {
            return new Pyromancer(x, y, name);
        } else if (name == HeroType.Rogue) {
            return new Rogue(x, y, name);
        } else if (name == HeroType.Wizard) {
            return new Wizard(x, y, name);
        }
        return null;
    }

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }
}
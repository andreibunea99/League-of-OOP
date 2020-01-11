package player;

public final class HeroFactory {

    private static HeroFactory instance = null;

    public Hero getHero(final HeroType name, final int x, final int y, final int id) {
        if (name == HeroType.Knight) {
            return new Knight(x, y, name, id);
        } else if (name == HeroType.Pyromancer) {
            return new Pyromancer(x, y, name, id);
        } else if (name == HeroType.Rogue) {
            return new Rogue(x, y, name, id);
        } else if (name == HeroType.Wizard) {
            return new Wizard(x, y, name, id);
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

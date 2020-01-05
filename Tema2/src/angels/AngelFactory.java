package angels;

public final class AngelFactory {

    private static AngelFactory instance = null;

    public Angel getAngel(AngelType name, int x, int y) {
        if (name == AngelType.DamageAngel) {
            return new DamageAngel(x, y);
        } else if (name == AngelType.DarkAngel) {
            return new DarkAngel(x, y);
        } else if (name == AngelType.Dracula) {
            return new Dracula(x, y);
        } else if (name == AngelType.GoodBoy) {
            return new GoodBoy(x, y);
        }  else if (name == AngelType.LevelUpAngel) {
            return new LevelUpAngel(x, y);
        }  else if (name == AngelType.LifeGiver) {
            return new LifeGiver(x, y);
        }  else if (name == AngelType.SmallAngel) {
            return new SmallAngel(x, y);
        }  else if (name == AngelType.Spawner) {
            return new Spawner(x, y);
        }  else if (name == AngelType.TheDoomer) {
            return new TheDoomer(x, y);
        } else if (name == AngelType.XPAngel) {
            return new XPAngel(x, y);
        }
        return null;
    }

    public static AngelFactory getInstance() {
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }
}

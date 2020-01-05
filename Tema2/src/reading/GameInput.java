package reading;

import angels.AngelType;
import player.HeroType;

import java.util.ArrayList;
import java.util.List;

public class GameInput {
    private int n;
    private int m;
    private int p;
    private int r;
    private char[][] map;
    private List<HeroType> characters = new ArrayList<>();
    private List<Integer> ox;
    private List<Integer> oy;
    private List<List<Character>> moves;
    private List<List<AngelType>> angels = new ArrayList<>();
    private List<Integer> angelsOx = new ArrayList<>();
    private List<Integer> angelsOy = new ArrayList<>();

    public GameInput(final int nMap, final int mMap, final char[][] terrain,
                     final int numberOfPlayers, final List<Character> playerTypes,
                     final List<Integer> xCoordinates, final List<Integer> yCoordinates,
                     final int numberOfRounds, final List<List<Character>> playerMoves,
                     final List<List<String>> angelsRound) {
        n = nMap;
        m = mMap;
        p = numberOfPlayers;
        r = numberOfRounds;
        map = terrain;
        ox = xCoordinates;
        oy = yCoordinates;
        moves = playerMoves;
        for (int i = 0; i < playerTypes.size(); i++) {
            if (playerTypes.get(i) == 'K') {
                characters.add(HeroType.Knight);
            }
            if (playerTypes.get(i) == 'R') {
                characters.add(HeroType.Rogue);
            }
            if (playerTypes.get(i) == 'P') {
                characters.add(HeroType.Pyromancer);
            }
            if (playerTypes.get(i) == 'W') {
                characters.add(HeroType.Wizard);
            }
        }
        List<AngelType> angelList = new ArrayList<>();
        for (int i = 0; i < numberOfRounds; i++) {
            List<AngelType> list = new ArrayList<>();
            for (int j = 0; j < angelsRound.get(i).size(); j++) {
                String[] param = angelsRound.get(i).get(j).split(",");
                switch (param[0]) {
                    case "DamageAngel":
                        list.add(AngelType.DamageAngel);
                        break;
                    case "DarkAngel":
                        list.add(AngelType.DarkAngel);
                        break;
                    case "Dracula":
                        list.add(AngelType.Dracula);
                        break;
                    case "GoodBoy":
                        list.add(AngelType.GoodBoy);
                        break;
                    case "LevelUpAngel":
                        list.add(AngelType.LevelUpAngel);
                        break;
                    case "LifeGiver":
                        list.add(AngelType.LifeGiver);
                        break;
                    case "SmallAngel":
                        list.add(AngelType.SmallAngel);
                        break;
                    case "Spawner":
                        list.add(AngelType.Spawner);
                        break;
                    case "TheDoomer":
                        list.add(AngelType.TheDoomer);
                        break;
                    default:
                        list.add(AngelType.XPAngel);
                        break;
                }
                angelsOx.add(Integer.parseInt(param[1]));
                angelsOy.add(Integer.parseInt(param[2]));
            }
            angels.add(list);
        }
    }


    /**
     * @return
     */
    public List<HeroType> getCharacters() {
        return characters;
    }

    /**
     * @return
     */
    public List<Integer> getOx() {
        return ox;
    }

    /**
     * @return
     */
    public List<Integer> getOy() {
        return oy;
    }

    /**
     * @return
     */
    public List<List<Character>> getMoves() {
        return moves;
    }

    /**
     * @return
     */
    public char[][] getMap() {
        return map;
    }

    /**
     * @return
     */
    public int getN() {
        return n;
    }

    /**
     * @return
     */
    public int getM() {
        return m;
    }

    /**
     * @return
     */
    public int getP() {
        return p;
    }

    /**
     * @param p
     */
    public void setP(final int p) {
        this.p = p;
    }

    /**
     * @return
     */
    public int getR() {
        return r;
    }

    /**
     * @param r
     */
    public void setR(final int r) {
        this.r = r;
    }

    /**
     * @return
     */
    public List<List<AngelType>> getAngels() {
        return angels;
    }

    /**
     * @return
     */
    public List<Integer> getAngelsOx() {
        return angelsOx;
    }

    /**
     * @return
     */
    public List<Integer> getAngelsOy() {
        return angelsOy;
    }
}

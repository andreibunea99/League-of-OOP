package reading;

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


    public GameInput(final int nMap, final int mMap, final char[][] terrain,
                     final int numberOfPlayers, final List<Character> playerTypes,
                     final List<Integer> xCoordinates, final List<Integer> yCoordinates,
                     final int numberOfRounds, final List<List<Character>> playerMoves) {
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
}

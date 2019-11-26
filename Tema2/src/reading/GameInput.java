package reading;

import player.HeroType;

import java.util.ArrayList;
import java.util.List;

public class GameInput {
    // DO NOT MODIFY
    private int N;
    private int M;
    private int P;
    private int R;
    private char[][] map = new char[N][M];
    private List<HeroType> characters = new ArrayList<>();
    private List<Integer> ox = new ArrayList<>();
    private List<Integer> oy = new ArrayList<>();
    private List<List<Character>> moves = new ArrayList<>();


    public GameInput(int N_map, int M_map, char[][] terrain, int numberOfPlayers, List<Character> playerTypes, List<Integer> xCoordinates,
                     List <Integer> yCoordinates, int numberOfRounds, List<List<Character>> playerMoves) {
        N = N_map;
        M = M_map;
        P = numberOfPlayers;
        R = numberOfRounds;
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
            if (playerTypes.get(i) == 'K') {
                characters.add(HeroType.Pyromancer);
            }
            if (playerTypes.get(i) == 'W') {
                characters.add(HeroType.Wizard);
            }
        }
    }


    public List<HeroType> getCharacters() {
        return characters;
    }

    public void setCharacters(List<HeroType> characters) {
        this.characters = characters;
    }

    public List<Integer> getOx() {
        return ox;
    }

    public void setOx(List<Integer> ox) {
        this.ox = ox;
    }

    public List<Integer> getOy() {
        return oy;
    }

    public void setOy(List<Integer> oy) {
        this.oy = oy;
    }

    public List<List<Character>> getMoves() {
        return moves;
    }

    public void setMoves(List<List<Character>> moves) {
        this.moves = moves;
    }
    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

    public int getP() {
        return P;
    }

    public void setP(int p) {
        P = p;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }
}

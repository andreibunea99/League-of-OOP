package reading;

import java.util.ArrayList;
import java.util.List;

public class GameInput {
    // DO NOT MODIFY
    private int N;
    private int M;
    private int P;
    private int R;
    char[][] map = new char[N][M];
    List<Character> characters = new ArrayList<>();
    List<Integer> ox = new ArrayList<>();
    List<Integer> oy = new ArrayList<>();
    List<List<Character>> moves = new ArrayList<>();
    public GameInput(int N_map, int M_map, char[][] terrain, int numberOfPlayers, List<Character> playerTypes, List<Integer> xCoordinates,
                         List <Integer> yCoordinates, int numberOfRounds, List<List<Character>> playerMoves) {
        N = N_map;
        M = M_map;
        P = numberOfPlayers;
        R = numberOfRounds;
        map = terrain;
        characters = playerTypes;
        ox = xCoordinates;
        oy = yCoordinates;
        moves = playerMoves;
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

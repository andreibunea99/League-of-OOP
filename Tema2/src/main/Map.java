package main;

public class Map {
    private final int N;
    private final int M;
    private final char[][] map;

    public Map (int N_map, int M_map, char[][] a) {
        N = N_map;
        M = M_map;
        map = a;
    }

    public char getParcel(int i, int j) {
        return map[i][j];
    }
}

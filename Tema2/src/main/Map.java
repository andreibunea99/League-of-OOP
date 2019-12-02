package main;

public class Map {
    private final int n;
    private final int m;
    private final char[][] map;

    public Map(final int nMap, final int mMap, final char[][] a) {
        n = nMap;
        m = mMap;
        map = a;
    }

    /**
     * @param i
     * @param j
     * @return
     */
    public char getParcel(final int i, final int j) {
        return map[i][j];
    }
}

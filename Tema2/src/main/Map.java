package main;

public class Map {
    private int n;
    private int m;
    private char[][] map;
    private static Map instance = null;

    public Map() {

    }

    /**
     * @param nMap
     * @param mMap
     * @param a
     */
    public void buildMap(final int nMap, final int mMap, final char[][] a) {
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

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }
}

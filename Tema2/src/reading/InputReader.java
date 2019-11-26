package reading;

import fileio.FileSystem;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
    private final String mInputPath;
    private final String mOutputPath;

    public InputReader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        int N = 0;
        int M = 0;
        char[][] terrain = new char[1][1];
        int numberOfPlayers = 0;
        int numberOfRounds = 0;
        List<Integer> xCoordinates = new ArrayList<Integer>();
        List<Integer> yCoordinates = new ArrayList<Integer>();
        List<Character> playerTypes = new ArrayList<Character>();
        List<List<Character>> playerMoves = new ArrayList<List<Character>>();
        
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            N = fs.nextInt();
            M = fs.nextInt();

            terrain = new char[N][M];

            for (int i = 0; i < N; ++i) {
                String s = fs.nextWord();
                //System.out.println(s.length());
                for (int j = 0; j < M; j++) {
//                    System.out.println(N + " " + M);
//                    System.out.println(j + " " + s.charAt(j) + " " + terrain.length);
                    terrain[i][j] = s.charAt(j);
                }
            }

            numberOfPlayers = fs.nextInt();

            for (int i = 0; i < numberOfPlayers; ++i) {
                String s = fs.nextWord();
                playerTypes.add(s.charAt(0));
                xCoordinates.add(fs.nextInt());
                yCoordinates.add(fs.nextInt());
            }

            numberOfRounds = fs.nextInt();

            for (int i = 0 ; i < numberOfRounds; i++) {
                String s = fs.nextWord();
                List<Character> list = new ArrayList<>();
                //System.out.println(s.charAt(1));
                for (int j = 0; j < numberOfPlayers; j++) {
//                    System.out.println(playerMoves.get(0).size());
                    list.add(s.charAt(j));
                }
                playerMoves.add(list);
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(N, M, terrain, numberOfPlayers, playerTypes, xCoordinates, yCoordinates, numberOfRounds, playerMoves);
    }
}

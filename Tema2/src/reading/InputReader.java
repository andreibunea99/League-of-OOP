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
                for (int j = 0; j < M; j++) {
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
                for (int j = 0; j < numberOfPlayers; j++) {
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

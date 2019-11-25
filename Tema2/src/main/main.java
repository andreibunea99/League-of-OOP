package main;

import reading.GameInput;
import reading.InputReader;

final class Main {

    public static void main(final String[] args) {
        InputReader gameInputLoader = new InputReader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        System.out.println(gameInput.getN());
//        GameEngine turing = new GameEngine(gameInput.getRounds(), gameInput.getAssetIds(),
//                gameInput.getPlayerNames());
//        turing.solve();
    }
}

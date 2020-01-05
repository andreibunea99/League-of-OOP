package main;

import angels.AngelFactory;
import play.ThePlay;
import player.*;
import reading.GameInput;
import reading.InputReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public final class Main {

    public static void main(final String[] args) throws IOException {
        InputReader gameInputLoader = new InputReader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        HeroFactory factory = HeroFactory.getInstance();
        AngelFactory angelFactory = AngelFactory.getInstance();
        Map map = new Map(gameInput.getN(), gameInput.getM(), gameInput.getMap());
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < gameInput.getP(); i++) {
            heroes.add(factory.getHero(gameInput.getCharacters().get(i), gameInput.getOx().get(i), gameInput.getOy().get(i)));
        }
        ThePlay game = new ThePlay(gameInput.getP(), gameInput.getR(), map);
        for (int i = 0; i < gameInput.getR(); i++) {
            game.round(gameInput.getMoves(), heroes);
        }
        FileWriter fileWriter = new FileWriter(args[1]);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getHealth() <= 0) {
                if (heroes.get(i).getType() == HeroType.Pyromancer) {
                    printWriter.print("P ");
                } else if (heroes.get(i).getType() == HeroType.Knight) {
                    printWriter.print("K ");
                } else if (heroes.get(i).getType() == HeroType.Rogue) {
                    printWriter.print("R ");
                } else {
                    printWriter.print("W ");
                }
                if (i == heroes.size() - 1) {
                    printWriter.print("dead");
                    continue;
                }
                printWriter.println("dead");
                continue;
            }
            if (heroes.get(i).getType() == HeroType.Pyromancer) {
                printWriter.print("P ");
            } else if (heroes.get(i).getType() == HeroType.Knight) {
                printWriter.print("K ");
            } else if (heroes.get(i).getType() == HeroType.Rogue) {
                printWriter.print("R ");
            } else {
                printWriter.print("W ");
            }
            printWriter.println(heroes.get(i).getLevel()  + " " + heroes.get(i).getExperience()
                    + " " + heroes.get(i).getHealth() + " " + heroes.get(i).getPositionX()
                    + " " + heroes.get(i).getPositionY());
        }
        printWriter.close();
    }
}

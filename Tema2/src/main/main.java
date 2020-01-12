package main;

import angels.Angel;
import angels.AngelFactory;
import play.ThePlay;
import player.Hero;
import player.HeroFactory;
import player.HeroType;
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
        Map map = Map.getInstance();
        map.buildMap(gameInput.getN(), gameInput.getM(), gameInput.getMap());
        List<Hero> heroes = new ArrayList<>();
        List<List<Angel>> angels = new ArrayList<>();
        for (int i = 0; i < gameInput.getP(); i++) {
            heroes.add(factory.getHero(gameInput.getCharacters().get(i), gameInput.getOx().get(i),
                    gameInput.getOy().get(i), i));
        }
        int currOx = 0;
        int currOy = 0;
        for (int i = 0; i < gameInput.getR(); i++) {
            List<Angel> angelList = new ArrayList<>();
            for (int j = 0; j < gameInput.getAngels().get(i).size(); j++) {
                angelList.add(angelFactory.getAngel(gameInput.getAngels().get(i).get(j),
                        gameInput.getAngelsOx().get(currOx), gameInput.getAngelsOy().get(currOy)));
                currOx++;
                currOy++;
            }
            angels.add(angelList);
        }
        FileWriter fileWriter = new FileWriter(args[1]);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        ThePlay game = new ThePlay(gameInput.getP(), gameInput.getR(), map);
        for (int i = 0; i < gameInput.getR(); i++) {
            game.round(gameInput.getMoves(), heroes, angels, printWriter);
            printWriter.println();
        }
        printWriter.println("~~ Results ~~");
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
                    printWriter.println("dead");
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

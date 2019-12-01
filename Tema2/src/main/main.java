package main;

import fileio.FileSystem;
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
        Map map = new Map(gameInput.getN(), gameInput.getM(), gameInput.getMap());
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < gameInput.getP(); i++) {
            if (gameInput.getCharacters().get(i) == HeroType.Knight) {
                Knight hero = new Knight(gameInput.getOx().get(i), gameInput.getOy().get(i), gameInput.getCharacters().get(i));
                heroes.add(hero);
            } else if (gameInput.getCharacters().get(i) == HeroType.Rogue) {
                Rogue hero = new Rogue(gameInput.getOx().get(i), gameInput.getOy().get(i), gameInput.getCharacters().get(i));
                heroes.add(hero);
            } else if (gameInput.getCharacters().get(i) == HeroType.Pyromancer) {
                Pyromancer hero = new Pyromancer(gameInput.getOx().get(i), gameInput.getOy().get(i), gameInput.getCharacters().get(i));
                heroes.add(hero);
            } else {
                Wizard hero = new Wizard(gameInput.getOx().get(i), gameInput.getOy().get(i), gameInput.getCharacters().get(i));
                heroes.add(hero);
            }
        }
        ThePlay game = new ThePlay(gameInput.getP(), gameInput.getR(), map);
        for (int i = 0; i < gameInput.getR(); i ++) {
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

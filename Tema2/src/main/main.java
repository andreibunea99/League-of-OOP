package main;

import play.ThePlay;
import player.*;
import reading.GameInput;
import reading.InputReader;

import java.util.ArrayList;
import java.util.List;

public final class Main {

    public static void main(final String[] args) {
        InputReader gameInputLoader = new InputReader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        Map map = new Map(gameInput.getN(), gameInput.getM(), gameInput.getMap());
        List<Character> xCoord = new ArrayList<>();
        List<Character> yCoord = new ArrayList<>();
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
        ThePlay game = new ThePlay(gameInput.getP(), gameInput.getR(), heroes, map);
        for (int i = 0; i < gameInput.getR(); i ++) {
            game.round(gameInput.getMoves());
        }
        System.out.println("Heroes: ");
        for (int i = 0; i < heroes.size(); i++) {
            System.out.println(heroes.get(i).getType() + " " + heroes.get(i).getPositionX() + " " + heroes.get(i).getPositionY());
        }
    }
}

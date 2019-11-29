package play;

import main.Map;
import player.*;

import java.util.ArrayList;
import java.util.List;

public class ThePlay {
    private final List<Hero> heroes;
    private final Map map;
    private final int R;
    private final int P;
    private static int currentRound;

    public ThePlay(int P, int R, List<Hero> heroes, Map map) {
        this.P = P;
        this.R = R;
        this.heroes = heroes;
        this.map = map;
        currentRound = 0;
    }

    public void round(List<List<Character>> moves) {
        for (int i = 0; i < heroes.size(); i++) {
            heroes.get(i).checkWound();
        }
        for (int i = 0; i < moves.get(currentRound).size(); i++) {
            if (moves.get(currentRound).get(i) == 'U') {
                heroes.get(i).moveUp();
            } else if (moves.get(currentRound).get(i) == 'D') {
                heroes.get(i).moveDown();
            } else if (moves.get(currentRound).get(i) == 'L') {
                heroes.get(i).moveDown();
            } else if (moves.get(currentRound).get(i) == 'R') {
                heroes.get(i).moveDown();
            }
        }
        Pyromancer pyromancer = new Pyromancer(0, 0, HeroType.Pyromancer);
        Knight knight = new Knight(0, 0, HeroType.Knight);
        pyromancer.visitFireblast(knight, map);
        pyromancer.visitIgnite(knight, map);
        System.out.println(knight.getHealth());
    }

}

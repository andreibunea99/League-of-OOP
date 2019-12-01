package play;

import main.Map;
import player.*;

import java.util.List;

public class ThePlay {
    private final Map map;
    private final int R;
    private final int P;
    private static int currentRound;

    public ThePlay(int P, int R, Map map) {
        this.P = P;
        this.R = R;
        this.map = map;
        currentRound = 0;
    }

    public void round(List<List<Character>> moves, List<Hero> heroes) {
        for (int i = 0; i < heroes.size(); i++) {
            heroes.get(i).checkWound();
        }
        for (int j = 0; j < heroes.size(); j++) {
            if (heroes.get(j).isStandStill()) {
                heroes.get(j).setStandStill(false);
                continue;
            }
            if (heroes.get(j).isParalyzed()) {
                continue;
            }
            if (moves.get(currentRound).get(j) == 'U') {
                heroes.get(j).moveUp();
            } else if (moves.get(currentRound).get(j) == 'D') {
                heroes.get(j).moveDown();
            } else if (moves.get(currentRound).get(j) == 'L') {
                heroes.get(j).moveLeft();
            } else if (moves.get(currentRound).get(j) == 'R') {
                heroes.get(j).moveRight();
            }
        }
        for (int p1 = 0; p1 < heroes.size(); p1++) {
            for (int p2 = p1 + 1; p2 < heroes.size(); p2++) {
                if (heroes.get(p1).getPositionX() != heroes.get(p2).getPositionX()) {
                    continue;
                }
                if (heroes.get(p1).getPositionY() != heroes.get(p2).getPositionY()) {
                    continue;
                }
                if (heroes.get(p1).getHealth() <= 0 || heroes.get(p2).getHealth() <=0) {
                    continue;
                }
                if (heroes.get(p1).getType() == HeroType.Wizard) {
                    heroes.get(p1).accept(heroes.get(p2), map);
                    heroes.get(p2).accept(heroes.get(p1), map);
                } else {
                    heroes.get(p2).accept(heroes.get(p1), map);
                    heroes.get(p1).accept(heroes.get(p2), map);
                }
            }
        }
        for (int i = 0; i < heroes.size(); i++) {
            heroes.get(i).finalRound();
        }
        currentRound++;
    }

}

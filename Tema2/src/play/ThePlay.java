package play;

import angels.Angel;
import angels.AngelType;
import main.Map;
import player.Hero;
import player.HeroType;

import java.io.PrintWriter;
import java.util.List;

public class ThePlay {
    private final Map map;
    private final int r;
    private final int p;
    private static int currentRound;

    public ThePlay(final int p, final int r, final Map map) {
        this.p = p;
        this.r = r;
        this.map = map;
        currentRound = 0;
    }

    /**
     * @param moves
     * @param heroes
     */
    public void round(final List<List<Character>> moves, final List<Hero> heroes,
                      final List<List<Angel>> angels, final PrintWriter printWriter) {
        printWriter.println("~~ Round " + (currentRound + 1) + " ~~");
        for (int i = 0; i < heroes.size(); i++) {
            heroes.get(i).checkWound();
        }
        for (int j = 0; j < heroes.size(); j++) {
            if (heroes.get(j).getStandStill() == 0) {
                heroes.get(j).checkStrategy();
            }
            if (heroes.get(j).getStandStill() > 0) {
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
                if (heroes.get(p1).getHealth() <= 0 || heroes.get(p2).getHealth() <= 0) {
                    continue;
                }
                if (heroes.get(p1).getType() == HeroType.Wizard) {
                    heroes.get(p1).accept(heroes.get(p2), map);
                    heroes.get(p2).accept(heroes.get(p1), map);
                } else {
                    heroes.get(p2).accept(heroes.get(p1), map);
                    heroes.get(p1).accept(heroes.get(p2), map);
                }
                if (heroes.get(p2).getHealth() <= 0) {
                    printWriter.println("Player " + heroes.get(p2).getType() + " "
                            + heroes.get(p2).getId() + " was killed by "
                            + heroes.get(p1).getType() + " " + heroes.get(p1).getId());
                }
                if (heroes.get(p1).getHealth() <= 0) {
                    printWriter.println("Player " + heroes.get(p1).getType()
                            + " " + heroes.get(p1).getId() + " was killed by "
                            + heroes.get(p2).getType() + " " + heroes.get(p2).getId());
                }
            }
        }
        for (int i = 0; i < heroes.size(); i++) {
            int level = heroes.get(i).getLevel();
            heroes.get(i).finalRound();
            for (int j = level + 1; j <= heroes.get(i).getLevel(); j++) {
                printWriter.println(heroes.get(i).getType() + " "
                        + heroes.get(i).getId() + " reached level " + j);
            }
        }
        for (int i = 0; i < angels.get(currentRound).size(); i++) {
            printWriter.println("Angel " + angels.get(currentRound).get(i).getType()
                    + " was spawned at " + angels.get(currentRound).get(i).getX()
                    + " " + angels.get(currentRound).get(i).getY());
            for (int p1 = 0; p1 < heroes.size(); p1++) {
                if (heroes.get(p1).getHealth() <= 0
                        && angels.get(currentRound).get(i).getType() != AngelType.Spawner) {
                    continue;
                }
                if (heroes.get(p1).getPositionX() != angels.get(currentRound).get(i).getX()) {
                    continue;
                } else if (heroes.get(p1).getPositionY()
                        != angels.get(currentRound).get(i).getY()) {
                    continue;
                }
                if (angels.get(currentRound).get(i).getType() == AngelType.Spawner
                        && heroes.get(p1).getHealth() > 0) {
                    continue;
                }
                printWriter.println(angels.get(currentRound).get(i).printAngel()
                        + " " + heroes.get(p1).getType() + " " + heroes.get(p1).getId());
                int health = heroes.get(p1).getHealth();
                heroes.get(p1).accept(angels.get(currentRound).get(i));
                if (heroes.get(p1).getHealth() <= 0) {
                    printWriter.println("Player " + heroes.get(p1).getType()
                            + " " + heroes.get(p1).getId() + " was killed by an angel");
                    continue;
                }
                if (angels.get(currentRound).get(i).getType() == AngelType.Spawner && health <= 0
                        && heroes.get(p1).getHealth() > 0) {
                        printWriter.println("Player " + heroes.get(p1).getType() + " "
                                + heroes.get(p1).getId() + " was brought to life by an angel");
                        continue;
                }
                int level = heroes.get(p1).getLevel();
                heroes.get(p1).finalRound();
                for (int j = level + 1; j <= heroes.get(p1).getLevel(); j++) {
                    printWriter.println(heroes.get(p1).getType() + " "
                            + heroes.get(p1).getId() + " reached level " + j);
                }
            }
        }
        currentRound++;
    }
}

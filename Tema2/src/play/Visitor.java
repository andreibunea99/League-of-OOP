package play;

import main.Main;
import main.Map;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public interface Visitor {
    public void visitFireblast(Knight knight, Map map);
    public void visitIgnite(Knight knight, Map map);
    public void visitFireblast(Rogue rogue, Map map);
    public void visitIgnite(Rogue rogue, Map map);
    public void visitFireblast(Wizard wizard, Map map);
    public void visitIgnite(Wizard wizard, Map map);
    public void visitFireblast(Pyromancer pyromancer, Map map);
    public void visitIgnite(Pyromancer pyromancer, Map map);
    public void visitExecute(Pyromancer pyromancer, Map map);
    public void visitSlam(Pyromancer pyromancer, Map map);
    public void visitExecute(Rogue rogue, Map map);
    public void visitSlam(Rogue rogue, Map map);
    public void visitExecute(Wizard wizard, Map map);
    public void visitSlam(Wizard wizard, Map map);
    public void visitExecute(Knight knight, Map map);
    public void visitSlam(Knight knight, Map map);
    public void vizitDrain(Pyromancer pyromancer, Map map);
}

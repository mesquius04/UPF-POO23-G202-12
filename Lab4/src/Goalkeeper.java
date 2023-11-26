import java.util.LinkedList;

public class Goalkeeper extends Player {

    public Goalkeeper(boolean g, String n, int a, Country nat) {
        super(g, n, a, nat);
    }

    @Override
    public void update(Competition c, Match m) {
        GoalKeeperStats pstats = (GoalKeeperStats) super.dictionary.get(c);
        if (pstats == null) {
            pstats = new GoalKeeperStats(this);
            pstats.updateStats(m);
            dictionary.put(c, pstats);
        } else {
            pstats.updateStats(m);
        }
    }
}

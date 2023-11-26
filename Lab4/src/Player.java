import java.util.HashMap;
import java.util.LinkedList;

public class Player {
    private boolean female;
    protected String name;
    private int age;
    private Country nationality;
    protected HashMap<Competition, PlayerStats> dictionary;

    public Player(boolean g, String n, int a, Country nat) {
        female = g;
        name = n;
        age = a;
        nationality = nat;
        dictionary = new HashMap<Competition, PlayerStats>();
    }

    public boolean isFemale() {
        return female;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Country getNationality() {
        return nationality;
    }

    public void update(Competition c, Match m) {
        if (dictionary.containsKey(c)) {
            PlayerStats pstats = dictionary.get(c);
            pstats.updateStats(m);
        } else {
            PlayerStats pstats = null;
            if (this instanceof Goalkeeper) {
                pstats = new GoalKeeperStats((Goalkeeper) this);
            } else {
                pstats = new OutFielderStats((Outfielder) this);
            }
            pstats.updateStats(m);
            dictionary.put(c, pstats);
        }
    }

    public PlayerStats getStats(Competition c) {
        PlayerStats pstats = dictionary.get(c);
        if (pstats != null) {
            return pstats;
        }
        return null;
    }

    public void printStats() {
    };

    public void updateStats(Match m) {
    };

    public OutFielderStats getOutFielderStats(Competition c) {
        return null;
    };

}

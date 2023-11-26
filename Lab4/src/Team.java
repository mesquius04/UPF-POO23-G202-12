import java.util.HashMap;
import java.util.LinkedList;

public class Team {
    private String name;
    private Country country;
    private Gender gender;
    private LinkedList<Player> players;
    protected HashMap<Competition, TeamStats> dictionary;

    public Team(String n, Country c, Gender g) {
        name = n;
        country = c;
        gender = g;
        players = new LinkedList<Player>();
        dictionary = new HashMap<Competition, TeamStats>();
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public Gender getGender() {
        return gender;
    }

    public Player getPlayer(int n) {
        return players.get(n);
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public boolean addPlayer(Player p) {
        if (gender == Gender.MIXT) {
            players.add(p);
            return true;
        } else if (gender == Gender.MALE && !p.isFemale()) {
            players.add(p);
            return true;
        } else if (gender == Gender.FEMALE && p.isFemale()) {
            players.add(p);
            return true;
        }
        return false;
    }

    public void removePlayer(Player p) {
        players.remove(p);
    }

    public void playMatch(int fgoals, int agoals) {
    };

    public void updateStats(Match m) {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).updateStats(m);
        }
        if (name.equals(m.getHomeTeam().getName())) {
            playMatch(m.getHomeGoals(), m.getAwayGoals());
        } else if (name.equals(m.getAwayTeam().getName())) {
            playMatch(m.getAwayGoals(), m.getHomeGoals());
        }
    }

    public void update(Competition c, Match m) {
        if (dictionary.containsKey(c)) {
            TeamStats tstats = dictionary.get(c);
            tstats.updateStats(m);
        } else {
            TeamStats tstats = new TeamStats(this);
            tstats.updateStats(m);
            dictionary.put(c, tstats);
        }
        for (int i = 0; i < players.size(); i++) {
            players.get(i).update(c, m);
        }
    }

    public TeamStats getStats(Competition c) {
        if (dictionary.containsKey(c)) {
            return dictionary.get(c);
        } else {
            return null;
        }
    }
}
import java.util.LinkedList;

public class Team {
    private String name;
    private Country country;
    private Gender gender;
    private LinkedList<Player> players;
    private int noMatches;
    private int noWins;
    private int noTies;
    private int noLosses;
    private int goalsScored;
    private int goalsAgainst;

    public Team(String n, Country c, Gender g) {
        name = n;
        country = c;
        gender = g;
        players = new LinkedList<Player>();
        noMatches = 0;
        noTies = 0;
        noWins = 0;
        noLosses = 0;
        goalsAgainst = 0;
        goalsScored = 0;
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

    public int getWins() {
        return noWins;
    }

    public int getTies() {
        return noTies;
    }

    public int getLosses() {
        return noLosses;
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
        noMatches++;
        goalsAgainst += agoals;
        goalsScored += fgoals;
        if (fgoals > agoals) {
            noWins++;
        } else if (fgoals < agoals) {
            noLosses++;
        } else {
            noTies++;
        }
    }

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

    public void printStats() {
        System.out.println(" -Partidos: " + noMatches);
        System.out.println(" -Ganados: " + noWins);
        System.out.println(" -Empatados: " + noTies);
        System.out.println(" -Perdidos: " + noLosses);
        System.out.println(" -Goles Marcados: " + goalsScored);
        System.out.println(" -Goles Recibidos: " + goalsAgainst);
    }
}
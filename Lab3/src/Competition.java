import java.util.LinkedList;

public class Competition {
    private String name;
    private Country country;
    private boolean clubs;
    private Gender gender;
    protected LinkedList<Team> teams;
    protected LinkedList<Match> matches;

    public Competition(boolean cl, String n, Country c, Gender g) {
        name = n;
        country = c;
        clubs = cl;
        gender = g;
        teams = new LinkedList<Team>();
        matches = new LinkedList<Match>();
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

    public LinkedList<Team> getTeams() {
        return teams;
    }

    public LinkedList<Match> getMatches() {
        return matches;
    }

    public void addTeam(Team t) {
        if (clubs == true) {
            teams.addLast(t);
        } else {
            if (this.country == t.getCountry()) {
                teams.addLast(t);
            }
        }

    }

    public void generateMatches() {

    }

    public void simulateMatches() {
        for (int i = 0; i < matches.size(); i++) {
            matches.get(i).simulateMatch();
        }
    }

    public void printMatches() {
        for (int i = 0; i < matches.size(); i++) {
            matches.get(i).printMatch();
        }
    }
}

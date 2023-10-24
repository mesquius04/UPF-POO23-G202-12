import java.util.LinkedList;

public class League {
    private String name;
    private Country country;
    private Gender gender;
    private LinkedList<Team> teams;
    private LinkedList<Match> matches;

    public League(String n, Country c, Gender g) {
        name = n;
        country = c;
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
        teams.addLast(t);
    }

    public void generateMatches() {
        for (int i = 0; i < teams.size(); i++) {
            for (int j = 0; i < teams.size(); j++) {
                if (!teams.get(i).getName().equals(teams.get(j).getName())) {
                    Match partido = new Match(teams.get(i), teams.get(j));
                    matches.addLast(partido);
                }
            }
        }
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

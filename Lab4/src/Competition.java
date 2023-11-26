import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

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
            matches.get(i).simulateMatch(this);
        }
    }

    public void printMatches() {
        for (int i = 0; i < matches.size(); i++) {
            matches.get(i).printMatch();
        }
    }

    public void printGoalScorers() {
        LinkedList<OutFielderStats> listOStats = new LinkedList<OutFielderStats>();
        listOStats = getOutFielderStats();
        Collections.sort(listOStats);
        System.out.println("\n\nESTADISTICAS JUGADORES\n");
        for (int i = listOStats.size() - 1; i >= 0; i--) {
            System.out.print("Top " + (listOStats.size() - i) + ". ");
            listOStats.get(i).printStats();
            /*
             * System.out.println(
             * (listOStats.size() - i) + ". " + listOStats.get(i).getPlayer().getName() +
             * "\t GOLES -> "
             * + (int) listOStats.get(i).getPoints());
             */
        }
    }

    public LinkedList<OutFielderStats> getOutFielderStats() {
        LinkedList<OutFielderStats> listOStats = new LinkedList<OutFielderStats>();
        for (int i = 0; i < teams.size(); i++) {
            for (int j = 0; j < teams.get(i).getPlayers().size(); j++) {
                if (teams.get(i).getPlayers().get(j).getOutFielderStats(this) != null) {
                    listOStats.addLast(teams.get(i).getPlayers().get(j).getOutFielderStats(this));
                }

            }
        }
        return listOStats;
    }

    public void printTable() {
    };

    public void printTables() {
    };
}

import java.util.LinkedList;
import java.util.Random;

public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private int homeGoals;
    private int awayGoals;
    private LinkedList<Player> homeScorers;
    private LinkedList<Player> awayScorers;

    public Match(Team h, Team a) {
        homeTeam = h;
        homeGoals = 0;
        awayGoals = 0;
        awayTeam = a;
        homeScorers = new LinkedList<Player>();
        awayScorers = new LinkedList<Player>();
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public LinkedList<Player> getHomeScorers() {
        return homeScorers;
    }

    public LinkedList<Player> getAwayScorers() {
        return awayScorers;
    }

    public void simulateMatch() {
        int n = 6;
        Random random = new Random();
        homeGoals = random.nextInt(n);
        awayGoals = random.nextInt(n);
        n = 4;
        for (int i = 0; i < homeGoals; i++) {
            homeScorers.add(homeTeam.getPlayer(random.nextInt(n)));
        }
        for (int i = 0; i < awayGoals; i++) {
            awayScorers.add(awayTeam.getPlayer(random.nextInt(n)));
        }
        
        awayTeam.updateStats(this);
        homeTeam.updateStats(this);
    }

    public void printMatch() {
        System.out.println("\nPARTIDO ENTRE " + homeTeam.getName() + " Y " + awayTeam.getName() + "\nRESULTADO: "
                + homeGoals + " - " + awayGoals);
        System.out.println("\nGOLEADORES:\n   " + homeTeam.getName() + " -> ");
        for (int i = 0; i < homeGoals; i++) {
            System.out.println("\t\t" + homeScorers.get(i).getName() + " ");
        }
        System.out.println("\nGOLEADORES:\n   " + awayTeam.getName() + " -> ");
        for (int i = 0; i < awayGoals; i++) {
            System.out.println("\t\t" + awayScorers.get(i).getName() + " ");
        }
    }
}

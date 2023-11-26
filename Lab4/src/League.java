import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class League extends Competition {

    public League(boolean cl, String n, Country c, Gender g) {
        super(cl, n, c, g);
    }

    @Override
    public void generateMatches() {
        for (int i = 0; i < teams.size(); i++) {
            for (int j = 0; j < teams.size(); j++) {
                if (!teams.get(i).getName().equals(teams.get(j).getName())) {
                    Match partido = new Match(teams.get(i), teams.get(j));
                    matches.addLast(partido);
                }
            }
        }
    }

    @Override
    public void printTable() {
        LinkedList<TeamStats> stats = new LinkedList<TeamStats>();
        for (int i = 0; i < super.getTeams().size(); i++) {
            stats.add(super.getTeams().get(i).getStats(this));
        }
        Collections.sort(stats);
        System.out.println("\n\nTABLA DE LA LIGA\n");
        for (int i = stats.size() - 1; i >= 0; i--) {
            System.out.println((stats.size() - i) + ". " + stats.get(i).getTeam().getName() + "\tPUNTOS TOTALES -> "
                    + stats.get(i).getTeam().getStats(this).getPoints());
        }
    }

}

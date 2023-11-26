import java.util.Collections;
import java.util.LinkedList;

public class GroupPlay extends Competition {
    private int noGroups;
    private LinkedList<League> groups;

    public GroupPlay(boolean cl, String n, Country c, Gender g) {
        super(cl, n, c, g);
        noGroups = 0;
        groups = new LinkedList<League>();
    }

    @Override
    public void generateMatches() {
        for (int i = 0; i < groups.size(); i++) {
            for (int h = 0; h < teams.size(); h++) {
                for (int j = 0; i < teams.size(); j++) {
                    if (!teams.get(i).getName().equals(teams.get(j).getName())) {
                        Match partido = new Match(teams.get(i), teams.get(j));
                        matches.addLast(partido);
                    }
                }
            }
        }
    }

    @Override
    public void simulateMatches() {
        for (int i = 0; i < matches.size(); i++) {
            matches.get(i).simulateMatch(this);
        }
    }

    @Override
    public void printTables() {
        for (int i = 0; i < groups.size(); i++) {
            groups.get(i).printTable();
        }
    }

}

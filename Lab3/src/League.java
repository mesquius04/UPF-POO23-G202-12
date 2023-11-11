import java.util.LinkedList;

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
}

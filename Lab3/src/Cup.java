import java.util.LinkedList;
import java.util.Collections;

public class Cup extends Competition {

    private LinkedList<LinkedList<Team>> tr;
    private LinkedList<LinkedList<CupMatch>> mr;

    public Cup(boolean cl, String n, Country c, Gender g) {
        super(cl, n, c, g);
        tr = new LinkedList<LinkedList<Team>>();
        tr.addFirst(teams);
        mr = new LinkedList<LinkedList<CupMatch>>();
    }

    @Override
    public void generateMatches() {
        Collections.shuffle(tr.getLast());
        LinkedList<CupMatch> matches = new LinkedList<CupMatch>();
        for (int i = 0; i < (tr.getLast().size() / 2); i++) {
            CupMatch match = new CupMatch(tr.getLast().get(i), tr.getLast().get(tr.getLast().size() - i - 1));
            matches.addLast(match);
        }
        mr.addLast(matches);
    }

    @Override
    public void simulateMatches() {
        LinkedList<Team> teams = new LinkedList<Team>();
        for (int i = 0; i < mr.getLast().size(); i++) {

            if (mr.getLast().get(i).getHomeTeam().equals(mr.getLast().get(i).getAwayTeam())) {
                teams.addLast(mr.getLast().get(i).getHomeTeam());
                break;
            }

            int winsprev = mr.getLast().get(i).getHomeTeam().getWins();// MIRAMOS VICTORIAS ANTES DEL PARTIDO

            mr.getLast().get(i).simulateMatch();
            if (winsprev == mr.getLast().get(i).getHomeTeam().getWins()) {// MIRAMOS VICTORIAS DESPUES DEL PARTIDO
                // HAS PERDIDO
                teams.addLast(mr.getLast().get(i).getAwayTeam());
            } else {// HAS GANADO
                teams.addLast(mr.getLast().get(i).getHomeTeam());
            }
        }
        tr.addLast(teams);
        while (tr.getLast().size() > 1) {
            generateMatches();
            simulateMatches();
        }
    }

    public void printMatches() {
        for (int i = 0; i < mr.size(); i++) {
            System.out.println("\n-> EMPIEZA LA FASE " + (i + 1));
            if (mr.get(i).size() == 1) {
                mr.get(i).getLast().printMatch();
                System.out.println("\nHA TERMINADO LA COMPETICION\nEL GANADOR ES:\n################\n###"
                        + tr.getLast().getFirst().getName() + "###\n################");
                break;
            }
            for (int j = 0; j < mr.get(i).size(); j++) {
                mr.get(i).get(j).printMatch();
            }

        }
    }

}

import java.util.LinkedList;

public class Goalkeeper extends Player {
    private int noSaves;
    private int noGoalsLet;

    public Goalkeeper(boolean g, String n, int a, Country nat) {
        super(g, n, a, nat);
        noSaves = 0;
        noGoalsLet = 0;
    }

    @Override
    public void updateStats(Match m) {
        super.noMatches++;// TODOS HAN JUGADO UN PARTIDO
        for (int i = 0; i < m.getHomeTeam().getPlayers().size(); i++) {// Comprovamos si han marcado como locales
            if (m.getHomeTeam().getPlayers().get(i).name.equals(super.name)) {
                noGoalsLet += m.getAwayGoals();
                // FER SAVES
            }
        }
        for (int i = 0; i < m.getAwayTeam().getPlayers().size(); i++) {// Comprovamos si han marcado como locales
            if (m.getAwayTeam().getPlayers().get(i).name.equals(super.name)) {
                noGoalsLet += m.getHomeGoals();
                // FER SAVES
            }
        }
    }

    @Override
    public void printStats() {
        System.out.println(" -Partidos jugados -> " + super.noMatches);
        System.out.println(" -Paradas -> " + noSaves);
        System.out.println(" -Goles en contra -> " + noGoalsLet);
    }
}

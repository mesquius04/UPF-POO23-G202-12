import java.util.Random;

public class GoalKeeperStats extends PlayerStats {
    private int noSaves;
    private int noGoalsLet;

    public GoalKeeperStats(Goalkeeper g) {
        noSaves = 0;
        noGoalsLet = 0;
        super.player = g;
    }

    public double getPoints() {
        return noSaves / (noSaves + noGoalsLet);// Definimos porcentaje de exito en parada.
    }

    @Override
    public void updateStats(Match m) {
        int n = 6;
        Random random = new Random();
        this.noSaves += random.nextInt(n);
        super.noMatches++;// TODOS HAN JUGADO UN PARTIDO
        for (int i = 0; i < m.getHomeTeam().getPlayers().size(); i++) {// Comprovamos si han marcado como locales
            if (m.getHomeTeam().getPlayers().get(i).name.equals(super.player.getName())) {
                noGoalsLet += m.getAwayGoals();
                // FER SAVES
            }
        }
        for (int i = 0; i < m.getAwayTeam().getPlayers().size(); i++) {// Comprovamos si han marcado como locales
            if (m.getAwayTeam().getPlayers().get(i).name.equals(super.player.getName())) {
                noGoalsLet += m.getHomeGoals();
                // FER SAVES
            }
        }
    }

    @Override
    public void printStats() {
        System.out.println("JUGADOR " + super.player.getName());
        System.out.println(" -Partidos jugados -> " + super.noMatches);
        System.out.println(" -Paradas -> " + noSaves);
        System.out.println(" -Goles en contra -> " + noGoalsLet);
    }

    public int compareTo(Object o) {
        GoalKeeperStats estadisticas = (GoalKeeperStats) o;
        if (estadisticas.getPoints() <= this.getPoints()) {
            return 1;
        }
        return -1;
    }

}

import java.util.Random;

public class OutFielderStats extends PlayerStats implements Comparable {
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int noGoals;

    public OutFielderStats(Outfielder o) {
        noTackles = 0;
        noShots = 0;
        noAssists = 0;
        noPasses = 0;
        noGoals = 0;
        super.player = o;
    }

    public double getPoints() {
        return noGoals;// Definimos porcentaje de exito en parada.
    }

    @Override
    public void updateStats(Match m) {
        int n = 10;
        Random random = new Random();
        this.noPasses += random.nextInt(n);
        this.noTackles += random.nextInt(n);
        n = 3;
        this.noAssists += random.nextInt(n);
        this.noShots += random.nextInt(n);

        super.noMatches++;// TODOS HAN JUGADO UN PARTIDO

        for (int i = 0; i < m.getHomeScorers().size(); i++) {// Comprovamos si han marcado como locales
            if (m.getHomeScorers().get(i).name.equals(super.player.getName())) {
                noGoals += 1;
                // FER SAVES
            }
        }
        for (int i = 0; i < m.getAwayScorers().size(); i++) {// Comprovamos si han marcado como locales
            if (m.getAwayScorers().get(i).name.equals(super.player.getName())) {
                noGoals += 1;
                // FER SAVES
            }
        }
    }

    @Override
    public void printStats() {
        System.out.println("JUGADOR " + super.player.getName());
        System.out.println(" -Partidos jugados -> " + super.noMatches);
        System.out.println(" -Goles -> " + noGoals);
        System.out.println(" -Tiros a puerta -> " + noShots);
        System.out.println(" -Entradas -> " + noTackles);
        System.out.println(" -Asistencias -> " + noAssists);
        System.out.println(" -Pases -> " + noPasses);

    }

    @Override
    public int compareTo(Object o) {
        OutFielderStats estadisticas = (OutFielderStats) o;
        if (estadisticas.getPoints() < this.getPoints()) {
            return 1;
        } else if (estadisticas.getPoints() > this.getPoints()) {
            return -1;
        } else if (this.noShots >= estadisticas.noShots) {
            return 1;
        } else {
            return -1;
        }
    }
}
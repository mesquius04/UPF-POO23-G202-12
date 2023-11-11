public class Outfielder extends Player {
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    protected int noGoals;

    public Outfielder(boolean g, String n, int a, Country nat) {
        super(g, n, a, nat);
        noTackles = 0;
        noPasses = 0;
        noShots = 0;
        noAssists = 0;
        noGoals = 0;
    }

    @Override
    public void updateStats(Match m) {
        noMatches++;// TODOS HAN JUGADO UN PARTIDO
        for (int i = 0; i < m.getHomeGoals(); i++) {// Comprovamos si han marcado como locales
            if (m.getHomeScorers().get(i).name.equals(name)) {
                noGoals++;
            }
        }
        for (int i = 0; i < m.getAwayGoals(); i++) {// Comprovamos si han marcado como visitantes
            if (m.getAwayScorers().get(i).name.equals(name)) {
                noGoals++;
            }
        }
    }

    @Override
    public void printStats() {
        System.out.println(" -Partidos jugados -> " + super.noMatches);
        System.out.println(" -Goles -> " + noGoals);
        System.out.println(" -Asistencias totales -> " + noAssists);
        System.out.println(" -Pases totales -> " + noPasses);
        System.out.println(" -Disparos totales -> " + noShots);
        System.out.println(" -Entradas totales -> " + noTackles);
    }
}

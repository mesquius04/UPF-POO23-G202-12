import java.util.LinkedList;

public class Player {
    private boolean female;
    private String name;
    private int age;
    private Country nationality;
    private int noMatches;
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int noGoals;

    public Player(boolean g, String n, int a, Country nat) {
        female = g;
        name = n;
        age = a;
        nationality = nat;
        noMatches = 0;
        noAssists = 0;
        noGoals = 0;
        noPasses = 0;
        noShots = 0;
        noTackles = 0;
    }

    public boolean isFemale() {
        return female;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Country getNationality() {
        return nationality;
    }

    // Algunos metodos del Lab anterior
    public void update(int t, int p, int s, int a, int g) {
        noMatches++;
        noTackles += t;
        noGoals += g;
        noShots += s;
        noPasses += p;
        noAssists += a;
    }

    public void printStats() {
        System.out.println(" -Partidos jugados -> " + noMatches);
        System.out.println(" -Goles -> " + noGoals);
        System.out.println(" -Asistencias totales -> " + noAssists);
        System.out.println(" -Pases totales -> " + noPasses);
        System.out.println(" -Disparos totales -> " + noShots);
        System.out.println(" -Entradas totales -> " + noTackles);
    }

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

}

import java.util.LinkedList;

public class Player {
    private boolean female;
    protected String name;
    private int age;
    private Country nationality;
    protected int noMatches;

    public Player(boolean g, String n, int a, Country nat) {
        female = g;
        name = n;
        age = a;
        nationality = nat;
        noMatches = 0;

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
    }

    public void printStats() {
    }

    public void updateStats(Match m) {

    }

}

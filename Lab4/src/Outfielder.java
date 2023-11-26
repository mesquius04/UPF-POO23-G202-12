public class Outfielder extends Player {

    public Outfielder(boolean g, String n, int a, Country nat) {
        super(g, n, a, nat);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void update(Competition c, Match m) {
        OutFielderStats pstats = (OutFielderStats) super.dictionary.get(c);
        if (pstats == null) {
            pstats = new OutFielderStats(this);
            pstats.updateStats(m);
            dictionary.put(c, pstats);
        } else {
            pstats.updateStats(m);
        }
    }

    public OutFielderStats getOutFielderStats(Competition c) {
        if (super.dictionary.containsKey(c)) {
            return (OutFielderStats) super.dictionary.get(c);
        } else {
            return null;
        }
    }
}

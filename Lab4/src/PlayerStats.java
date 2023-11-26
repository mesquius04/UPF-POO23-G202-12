abstract public class PlayerStats {
    protected Player player;
    protected int noMatches;

    public void PlayerStats(Player p) {
        this.player = p;
        this.noMatches = 0;
    }

    public Player getPlayer() {
        return player;
    }

    public abstract void updateStats(Match m);

    public abstract void printStats();
}
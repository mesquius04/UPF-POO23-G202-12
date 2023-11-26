import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class TeamStats implements Comparable {
    private Team team;
    private int noMatches;
    private int noWins;
    private int noTies;
    private int noLosses;
    private int goalsScored;
    private int goalsAgainst;

    // Constructor
    public TeamStats(Team team) {
        this.team = team;
        this.noMatches = 0;
        this.noWins = 0;
        this.noTies = 0;
        this.noLosses = 0;
        this.goalsScored = 0;
        this.goalsAgainst = 0;
    }

    // Métodos getter y setter (puedes generarlos automáticamente en tu IDE)

    public int getNoMatches() {
        return noMatches;
    }

    public int getNoWins() {
        return noWins;
    }

    public int getNoTies() {
        return noTies;
    }

    public int getNoLosses() {
        return noLosses;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getPoints() {
        return (noWins * 3 + noTies);
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public Team getTeam() {
        return this.team;
    }

    // Método para actualizar las estadísticas después de un partido
    public void updateStats(Match match) {
        noMatches++;
        goalsScored += match.getHomeGoals(); // Ajustar según tus necesidades
        goalsAgainst += match.getAwayGoals(); // Ajustar según tus necesidades

        // Actualizar victorias, empates y derrotas según el resultado del partido
        if (match.getHomeGoals() > match.getAwayGoals()) {
            noWins++;
        } else if (match.getHomeGoals() < match.getAwayGoals()) {
            noLosses++;
        } else {
            noTies++;
        }
    }

    public void playMatch(int fgoals, int agoals) {
        noMatches++;
        goalsAgainst += agoals;
        goalsScored += fgoals;
        if (fgoals > agoals) {
            noWins++;
        } else if (fgoals < agoals) {
            noLosses++;
        } else {
            noTies++;
        }
    }

    public void printStats() {
        System.out.println(" -Partidos: " + noMatches);
        System.out.println(" -Ganados: " + noWins);
        System.out.println(" -Empatados: " + noTies);
        System.out.println(" -Perdidos: " + noLosses);
        System.out.println(" -Goles Marcados: " + goalsScored);
        System.out.println(" -Goles Recibidos: " + goalsAgainst);
    }

    @Override
    public int compareTo(Object o) {
        TeamStats estadisticas = (TeamStats) o;
        if (estadisticas.getPoints() < this.getPoints()) {
            return 1;
        } else if (estadisticas.getPoints() > this.getPoints()) {
            return -1;
        } else {

            if ((estadisticas.goalsScored - estadisticas.goalsAgainst) > (this.goalsScored - this.goalsAgainst)) {
                return -1;
            } else if ((estadisticas.goalsScored - estadisticas.goalsAgainst) < (this.goalsScored
                    - this.goalsAgainst)) {
                return 1;
            } else {

                if (estadisticas.goalsScored > this.goalsScored) {
                    return -1;
                } else if (estadisticas.goalsScored < this.goalsScored) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

}

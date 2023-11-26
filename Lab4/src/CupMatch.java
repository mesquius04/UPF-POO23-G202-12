import java.util.Random;

public class CupMatch extends Match {
    public CupMatch(Team h, Team a) {
        super(h, a);
    }

    @Override
    public void simulateMatch(Competition c) {
        int n = 6;
        Random random = new Random();
        super.homeGoals = random.nextInt(n);
        super.awayGoals = random.nextInt(n);

        if (homeGoals == awayGoals) {// SOLO SALIMOS DE AQUÍ CUANDO YA NO ESTEMOS EMPATADOS
            // PRORROGA
            n = 2;
            super.homeGoals += random.nextInt(n);
            super.awayGoals += random.nextInt(n);
            if (homeGoals == awayGoals) {
                // PENALTIS
                n = 5;
                super.homeGoals += random.nextInt(n);
                super.awayGoals += random.nextInt(n);
                while (homeGoals == awayGoals) {
                    n = 1;
                    super.homeGoals += random.nextInt(n);
                    super.awayGoals += random.nextInt(n);
                }

            }
        } // AL FINAL SIEMPRE ACTUALIZAMOS
        n = 4;
        for (int i = 0; i < homeGoals; i++) {
            homeScorers.add(homeTeam.getPlayer(random.nextInt(n)));
        }
        for (int i = 0; i < awayGoals; i++) {
            awayScorers.add(awayTeam.getPlayer(random.nextInt(n)));
        }
    }
}

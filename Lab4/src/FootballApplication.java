import javax.print.DocFlavor.CHAR_ARRAY;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class FootballApplication {
    public static void main(String[] args) throws Exception {

        // Declaramos e inicializamos 4 países
        Country spain = new Country("Spain");
        Country france = new Country("France");
        Country italia = new Country("Italia");
        Country portugal = new Country("Portugal");

        // Declaramos e inicializamos jugadoras
        Player player1 = new Goalkeeper(true, "Paula", 18, spain);
        Player player2 = new Outfielder(true, "Laura", 21, italia);
        Player player3 = new Outfielder(true, "Nora", 28, france);
        Player player4 = new Outfielder(true, "Sofia", 23, portugal);
        Player player5 = new Outfielder(true, "Miriam", 32, spain);
        Player player6 = new Outfielder(true, "Chloe", 30, italia);

        // Declaramos e inicializamos jugadores
        Player playerr1 = new Goalkeeper(false, "Marc", 20, spain);
        Player playerr2 = new Outfielder(false, "Martí", 21, italia);
        Player playerr3 = new Outfielder(false, "Alex", 24, france);
        Player playerr4 = new Outfielder(false, "Andrew", 33, portugal);
        Player playerr5 = new Outfielder(false, "Ibai", 26, spain);
        Player playerr6 = new Outfielder(false, "Elm", 20, italia);

        // Creamos algunos equipos
        Team team1 = new Team("Toreras", spain, Gender.FEMALE);
        Team team2 = new Team("Toreros", spain, Gender.MALE);
        Team team3 = new Team("Barça", spain, Gender.MIXT);
        Team team4 = new Team("La Pasta", italia, Gender.MIXT);
        Team team5 = new Team("BichoLovers", portugal, Gender.MALE);
        Team team6 = new Team("Las Bagettes", france, Gender.FEMALE);
        Team team7 = new Team("Bamboleo", portugal, Gender.MALE);
        Team team8 = new Team("Los Ninis", spain, Gender.MIXT);

        System.out.println("\n");
        // Probamos los metodos asociados a la clase Player
        System.out.println(player1.isFemale());
        System.out.println(player1.getName());
        System.out.println((player1.getNationality()).getName());// Como queremos imprimir el nombre del país usamos el
                                                                 // metodo de Country
        System.out.println(player1.getAge());
        System.out.println("\nSTATS JUGADORA:");
        player1.printStats();

        // Ahora vamos a assignar jugadores a los equipos creados
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        team1.addPlayer(player4);
        team1.addPlayer(player5);
        team1.addPlayer(player6);
        System.out.println("\nPRUEBA AÑADIR PLAYER");
        // Prueba equipo femenino añadir jugadora
        System.out.println(team1.addPlayer(player6));
        // Prueba equipo femenino añadir jugador
        System.out.println(team1.addPlayer(playerr6));
        // Retorna false ya que estamos intentando meter a un hombre.

        team1.removePlayer(player6);

        team2.addPlayer(playerr1);
        team2.addPlayer(playerr2);
        team2.addPlayer(playerr3);
        team2.addPlayer(playerr4);
        team2.addPlayer(playerr5);
        // Hemos creado un segundo equipo
        System.out.println("\nINFO DE EQUIPO:");
        // Comprovamos que funcionen los metodos de la clase Team
        System.out.println(team2.getName());
        System.out.println((team2.getCountry()).getName());
        System.out.println(team2.getGender());
        // Miramos stats
        System.out.println("\nSTATS PRE-PARTIDO DE " + team2.getName());
        // Jugamos partido

        System.out.println("\nSTATS POST-PARTIDO DE " + team2.getName());
        // Miramos stats actualizadas

        // Actualizamos stats de la jugadora
        System.out.println("\nSTATS JUGADORA POST-PARTIDO " + player1.getName());
        // player1.printStats();

        Competition LaLiga = new League(true, "LA LIGA", spain, Gender.MIXT);

        // Declaramos nuevos jugadores
        Player ps1 = new Goalkeeper(false, "Lola", 21, italia);
        Player ps2 = new Outfielder(true, "Koki", 28, france);
        Player ps3 = new Outfielder(false, "Nomi", 23, portugal);
        Player ps4 = new Outfielder(true, "Nami", 32, spain);
        Player ps5 = new Outfielder(true, "Lulu", 30, italia);

        Player pss1 = new Goalkeeper(false, "Reksai", 21, italia);
        Player pss2 = new Outfielder(true, "Khazix", 28, france);
        Player pss3 = new Outfielder(false, "Rengar", 23, portugal);
        Player pss4 = new Outfielder(false, "Jax", 32, spain);
        Player pss5 = new Outfielder(false, "Yi", 30, italia);

        // Los añadimos a equipo 3
        team3.addPlayer(ps1);
        team3.addPlayer(ps2);
        team3.addPlayer(ps3);
        team3.addPlayer(ps4);
        team3.addPlayer(ps5);
        // Los añadimos a equipo 4
        team4.addPlayer(pss1);
        team4.addPlayer(pss2);
        team4.addPlayer(pss3);
        team4.addPlayer(pss4);
        team4.addPlayer(pss5);

        // Ahora ponemos los teams en Liga
        LaLiga.addTeam(team1);
        LaLiga.addTeam(team2);
        LaLiga.addTeam(team3);
        LaLiga.addTeam(team4);
        // Generamos partidos
        LaLiga.generateMatches();
        // Simulamos partidos
        LaLiga.simulateMatches();
        // Imprimimos resultados de los partidos
        LaLiga.printMatches();
        // Al ser una liga todos juegan contra todos los demás.

        LaLiga.printTable();
        LaLiga.printGoalScorers();

        System.out.println("\n     EMPIEZA LA CHAMPIONS!!!\n");
        Cup Champions = new Cup(true, "LA CHAMPIONS", spain, Gender.MIXT);
        Champions.addTeam(team1);
        Champions.addTeam(team2);
        Champions.addTeam(team3);
        Champions.addTeam(team4);
        // Generamos partidos de Champions
        Champions.generateMatches();
        // Simulamos partidos de champions
        Champions.simulateMatches();
        // Imprimimos partidos jugados e indicamos ganador y goleadores
        Champions.printMatches();

        Champions.printGoalScorers();// Lo hace solo para esta competicion, como caldria esperar.

    }
}

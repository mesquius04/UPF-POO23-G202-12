public class App {
    public static void main(String[] args) throws Exception {

        // Declaramos e inicializamos 4 países
        Country spain = new Country("Spain");
        Country france = new Country("France");
        Country italia = new Country("Italia");
        Country portugal = new Country("Portugal");

        // Declaramos e inicializamos jugadoras
        Player player1 = new Player(true, "Paula", 18, spain);
        Player player2 = new Player(true, "Laura", 21, italia);
        Player player3 = new Player(true, "Nora", 28, france);
        Player player4 = new Player(true, "Sofia", 23, portugal);
        Player player5 = new Player(true, "Miriam", 32, spain);
        Player player6 = new Player(true, "Chloe", 30, italia);

        // Declaramos e inicializamos jugadores
        Player playerr1 = new Player(false, "Marc", 20, spain);
        Player playerr2 = new Player(false, "Martí", 21, italia);
        Player playerr3 = new Player(false, "Alex", 24, france);
        Player playerr4 = new Player(false, "Andrew", 33, portugal);
        Player playerr5 = new Player(false, "Ibai", 26, spain);
        Player playerr6 = new Player(false, "Elm", 20, italia);

        // Creamos algunos equipos
        Team team1 = new Team("Toreras", spain, Gender.FEMALE);
        Team team2 = new Team("Toreros", spain, Gender.MALE);
        Team team3 = new Team("Barça", spain, Gender.MIXT);
        Team team4 = new Team("La Pasta", italia, Gender.MIXT);
        Team team5 = new Team("BichoLovers", portugal, Gender.MALE);
        Team team6 = new Team("Las Bagettes", france, Gender.FEMALE);

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
        team2.printStats();
        // Jugamos partido

        Match partido1 = new Match(team1, team2);
        partido1.simulateMatch();
        partido1.printMatch();

        System.out.println("\nSTATS POST-PARTIDO DE " + team2.getName());
        // Miramos stats actualizadas
        team2.printStats();

        // Actualizamos stats de la jugadora
        System.out.println("\nSTATS JUGADORA POST-PARTIDO " + player1.getName());
        player1.printStats();
    }
}

public class NationalTeam extends Team {
    public NationalTeam(String n, Country c, Gender g) {
        super(n, c, g); // Constructor de la superclase Team
    }

    @Override
    public boolean addPlayer(Player p) {// RETORNA UN BOOLEAN al igual que addPlayer de Team
        if (p.getNationality().equals(super.getCountry())) {// Comprueva el país de origen usando un metodo sobreescrito
                                                            // de object
            super.addPlayer(p);
            return true;
        }
        return false;
    }
}

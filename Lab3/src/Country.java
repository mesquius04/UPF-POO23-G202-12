public class Country {
    private String name;

    public Country(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Country otherCountry = (Country) obj;

        return this.name.equals(otherCountry.getName());
    }

}
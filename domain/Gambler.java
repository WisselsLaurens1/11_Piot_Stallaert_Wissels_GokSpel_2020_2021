package domain;

public class Gambler {
    String voornaam;
    String achternaam;
    String spelersnaam;
    double goksaldo;

    public Gambler(String voornaam, String achternaam, String spelersnaam, double goksaldo) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.spelersnaam = spelersnaam;
        this.goksaldo = goksaldo;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getSpelersnaam() {
        return spelersnaam;
    }

    public double getGoksaldo() {
        return goksaldo;
    }
}

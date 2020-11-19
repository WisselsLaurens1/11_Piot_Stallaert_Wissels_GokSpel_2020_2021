package domain;

public class Gambler {
    String name;
    String surname;
    String playerName;
    double gamblingSaldo;

    public Gambler(String name, String surname, String playerName, double gamblingSaldo) {
        this.name = name;
        this.surname = surname;
        this.playerName = playerName;
        this.gamblingSaldo = gamblingSaldo;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPlayerName() {
        return playerName;
    }

    public double getGamblingSaldo() {
        return gamblingSaldo;
    }
}

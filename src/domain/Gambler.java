package domain;

public class Gambler {
    String name;
    String surname;
    String playerName;
    String gamblingSaldo;

    public Gambler(String name, String surname, String playerName, String gamblingSaldo) {
        this.name = name;
        this.surname = surname;
        this.playerName = playerName;
        this.gamblingSaldo = gamblingSaldo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public double getGamblingSaldo() {
        return Double.parseDouble(gamblingSaldo);
    }

    public void setGamblingSaldo(String gamblingSaldo) {
        this.gamblingSaldo = gamblingSaldo;
    }
}

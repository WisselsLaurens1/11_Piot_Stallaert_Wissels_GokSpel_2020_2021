package model.database;

import model.Gambler;

import java.util.HashMap;

public class DatabaseModel {
    public HashMap<String, Gambler> getGamblers() {
        return gamblers;
    }

    public void setGamblers(HashMap<String, Gambler> gamblers) {
        this.gamblers = gamblers;
    }

    private HashMap<String, Gambler> gamblers;

}

package model.database;

import model.Gambler;

import java.util.HashMap;

public interface GamblerDbInterface {
    HashMap<String, Gambler> getGamblerDb();
}

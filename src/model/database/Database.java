package model.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Database {

    private HashMap<String, String> database;

    public Database() {
        this.database = new HashMap<>();
    }

    public HashMap<String, String> getDatabase() {
        return database;
    }

    public void printDatabase(){
        for(String user: this.database.keySet()){
            System.out.println(this.database.get(user));
        }
    }
}

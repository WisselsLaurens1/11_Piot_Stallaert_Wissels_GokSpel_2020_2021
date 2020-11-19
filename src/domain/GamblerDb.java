package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GamblerDb {
    private HashMap<String, Gambler> gamblerDb;

    public GamblerDb() {
        gamblerDb = new HashMap<>();
        Gambler daan = new Gambler("Daan", "Stallaert", "daans", 100);
        Gambler laurens = new Gambler("Laurens", "Fons", "laurensf", 10);
        Gambler gerben = new Gambler("Gerben", "Piot", "gerbenp", 500);
        gamblerDb.put("daan", daan);
        gamblerDb.put("laurens", laurens);
        gamblerDb.put("gerben", gerben);
    }

    //comment

    public List<Gambler> getGamblerDb() {
        return new ArrayList<>(gamblerDb.values());
    }
}

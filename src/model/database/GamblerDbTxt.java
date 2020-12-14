package model.database;

import model.Gambler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class GamblerDbTxt implements GamblerDbInterface {
    private HashMap<String, Gambler> gamblerDb;

    public GamblerDbTxt() throws FileNotFoundException {
        gamblerDb = new HashMap<>();
        File gamblersFile = new File("src/bestanden/speler.txt");
        Scanner scannerFile = new Scanner(gamblersFile);
        while (scannerFile.hasNextLine()) {
            String s = scannerFile.nextLine();
            String[] delen = s.split(",");
            Gambler gambler = new Gambler(delen[0], delen[1], delen[2], delen[3]);
            gamblerDb.put(delen[2], gambler);
        }
    }


    public HashMap<String, Gambler> getGamblerDb() {
        return new HashMap<String, Gambler>(gamblerDb);
    }
}

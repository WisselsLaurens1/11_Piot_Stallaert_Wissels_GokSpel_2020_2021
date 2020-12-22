package model.database;

import jxl.write.Label;
import model.Gambler;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GamblerDbTxt implements GamblerDbInterface {
    private File spelers = new File("src/bestanden/speler.txt");
    private HashMap<String, Gambler> gamblerDb;

    public GamblerDbTxt() throws FileNotFoundException {
        gamblerDb = new HashMap<>();
        File gamblersFile = new File(String.valueOf(spelers));
        Scanner scannerFile = new Scanner(gamblersFile);
        while (scannerFile.hasNextLine()) {
            String s = scannerFile.nextLine();
            String[] delen = s.split(",");
            Gambler gambler = new Gambler(delen[0], delen[1], delen[2], delen[3]);
            gamblerDb.put(delen[2], gambler);
        }
    }

    public void write(ArrayList<Gambler> gamblers, String playerName, Double gamblingSaldo) throws IOException {
        FileWriter writer = new FileWriter(spelers);
        PrintWriter leeg = new PrintWriter(writer);
        leeg.flush();
        for(Gambler g:gamblers){
            if (g.getPlayerName().equals(playerName)) {
                writer.write(g.getName()+","+g.getSurname()+","+g.getPlayerName()+","+gamblingSaldo+System.lineSeparator());
            } else {
                writer.write(g.getName()+","+g.getSurname()+","+g.getPlayerName()+","+g.getGamblingSaldo()+System.lineSeparator());
            }
        }
        writer.close();
    }

    public HashMap<String, Gambler> getGamblerDb() {
        return new HashMap<String, Gambler>(gamblerDb);
    }
}

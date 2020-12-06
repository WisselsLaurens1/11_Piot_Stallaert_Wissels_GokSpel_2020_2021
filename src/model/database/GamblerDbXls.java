package model.database;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import model.Gambler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GamblerDbXls {
    private HashMap<String, Gambler> gamblerDb;
    private ExcelPlugin plugin;

    public GamblerDbXls() throws IOException, BiffException {
        ArrayList<ArrayList<String>> gamblers = plugin.read(new File("src/bestanden/speler.xls"));

        for(ArrayList<String> gambler:gamblers){
            Gambler gokker = new Gambler(gambler.get(0), gambler.get(1), gambler.get(2), gambler.get(3));
            gamblerDb.put(gambler.get(2), gokker);
        }
    }

    public List<Gambler> getGamblerDb() {
        return new ArrayList<>(gamblerDb.values());
    }
}
package model.database;

import excel.ExcelPlugin;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import model.Gambler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GamblerDbXls implements GamblerDbInterface{
    private File spelers = new File("src/bestanden/speler.xls");
    private HashMap<String, Gambler> gamblerDb;
    private ExcelPlugin plugin;

    public GamblerDbXls() {
    }

    public void read() throws IOException, BiffException {
        gamblerDb = new HashMap<>();
        plugin = new ExcelPlugin();
        ArrayList<ArrayList<String>> gamblers = plugin.read(new File(String.valueOf(spelers)));

        for(ArrayList<String> gambler:gamblers){
            Gambler gokker = new Gambler(gambler.get(0), gambler.get(1), gambler.get(2), gambler.get(3));
            gamblerDb.put(gambler.get(2), gokker);
        }
    }

    public void write(ArrayList<Gambler> gamblers, String newPlayerName, Double newGamblingSaldo) throws BiffException, IOException, RowsExceededException, WriteException {

        WritableWorkbook workbook = Workbook.createWorkbook(spelers);
        workbook.createSheet("sheet1", 0);
        WritableSheet sheet = workbook.getSheet(0);
        for(int i = 0; i < gamblers.size(); i++){
            Gambler g = gamblers.get(i);
            Label name = new Label(0, i, g.getName());
            sheet.addCell(name);
            Label surname = new Label(1, i, g.getSurname());
            sheet.addCell(surname);
            Label playerName = new Label(2, i, g.getPlayerName());
            sheet.addCell(playerName);
            Label gamblingSaldo;
            if (g.getPlayerName().equals(newPlayerName)) {
                gamblingSaldo = new Label(3, i, String.valueOf(newGamblingSaldo));
            } else {
                gamblingSaldo = new Label(3, i, String.valueOf(g.getGamblingSaldo()));
            }
            sheet.addCell(gamblingSaldo);

        }
        workbook.write();
        workbook.close();
    }

    public HashMap<String, Gambler> getGamblerDb() {
        return new HashMap<String, Gambler>(gamblerDb);
    }
}

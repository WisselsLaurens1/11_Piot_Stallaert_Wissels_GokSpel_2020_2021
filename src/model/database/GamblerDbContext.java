package model.database;

import jxl.read.biff.BiffException;
import model.Gambler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GamblerDbContext {
    private GamblerDbInterface gamblerInterface;

    public GamblerDbContext(){

    }

    public void setGamblerDbInterface(GamblerDbInterface gamblerDbInterface){
        this.gamblerInterface = gamblerDbInterface;
    }

    public HashMap<String, Gambler> getGamblerDb() throws IOException, BiffException, FileNotFoundException {
        gamblerInterface.read();
        return gamblerInterface.getGamblerDb();
    }

    public List<String> getBestandenLijst(){
        List <String> bestandenlijst = new ArrayList<String>();
        for (GamblerEnum bestand:GamblerEnum.values()){
            bestandenlijst.add(bestand.toString());
        }
        return bestandenlijst;
    }
}

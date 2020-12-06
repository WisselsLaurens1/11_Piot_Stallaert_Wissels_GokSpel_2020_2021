package model.database;

import model.Gambler;
import model.GamblerEnum;

import java.util.ArrayList;
import java.util.List;

public class GamblerDbContext {
    private GamblerDbInterface gamblerInterface;

    public GamblerDbContext(){

    }

    public void setGamblerDbInterface(GamblerDbInterface gamblerDbInterface){
        this.gamblerInterface = gamblerDbInterface;
    }

    public List<Gambler> getGamblerDb(){
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

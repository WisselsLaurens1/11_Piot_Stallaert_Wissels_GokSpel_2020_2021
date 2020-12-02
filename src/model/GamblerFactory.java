package model;

import model.database.GamblerDbInterface;

public class GamblerFactory {
    public static GamblerDbInterface createDb(String dbCode){
        GamblerEnum gamblerEnum = GamblerEnum.valueOf(dbCode);
        String klasseNaam = gamblerEnum.getKlasseNaam();
        GamblerDbInterface gamblerInterface = null;
        try{
            Class dbClass = Class.forName(klasseNaam);
            Object dbObject = dbClass.newInstance();
            gamblerInterface = (GamblerDbInterface) dbObject;
        }
        catch (Exception e){}
        return gamblerInterface;
    }
}

package model;

import model.database.GamblerDbInterface;

public class GamblerFactory {
    public static GamblerDbInterface createDb(String dbCode){
        GamblerEnum gamblerEnum = GamblerEnum.valueOf(dbCode);
        String klasseNaam = gamblerEnum.getKlasseNaam();
        GamblerDbInterface gamblerInterface = null;
        try{
            System.out.println(klasseNaam);
            Class dbClass = Class.forName(klasseNaam);
            System.out.println(dbClass);
            Object dbObject = dbClass.newInstance();
            System.out.println(dbObject);
            gamblerInterface = (GamblerDbInterface) dbObject;
            System.out.println(gamblerInterface);
        }
        catch (Exception e){}
        return gamblerInterface;
    }
}

package model.database;

import model.database.GamblerDbInterface;
import model.database.GamblerEnum;

import java.lang.reflect.Constructor;


public class GamblerFactory {
    public static GamblerDbInterface createDb(String dbCode){
        GamblerEnum gamblerEnum = GamblerEnum.valueOf(dbCode);
        String className = gamblerEnum.getKlasseNaam();
        GamblerDbInterface gamblerInterface = null;
        try{
            Class<?> dbClass = Class.forName(className);
            Constructor constructor = dbClass.getConstructor();
            Object db = constructor.newInstance();
            return (GamblerDbInterface) db;
        }
        catch (Exception e){}
        return null;
    }
}

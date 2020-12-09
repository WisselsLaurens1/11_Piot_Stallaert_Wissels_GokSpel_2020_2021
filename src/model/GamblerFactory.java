package model;

import model.database.GamblerDbContext;
import model.database.GamblerDbInterface;

import java.lang.reflect.Constructor;


public class GamblerFactory {
    public static GamblerDbInterface createDb(String dbCode){
        GamblerEnum gamblerEnum = GamblerEnum.valueOf(dbCode);
        String className = gamblerEnum.getKlasseNaam();
        GamblerDbInterface gamblerInterface = null;
        try{
/*            System.out.println(klasseNaam);
            Class dbClass = Class.forName(klasseNaam);
            System.out.println(dbClass);
            Object dbObject = dbClass.newInstance();
            System.out.println(dbObject);
            gamblerInterface = (GamblerDbInterface) dbObject;
            System.out.println(gamblerInterface);*/


            Class<?> dbClass = Class.forName(className);
            Constructor constructor = dbClass.getConstructor();
            Object db = constructor.newInstance();
            return (GamblerDbInterface) db;


        }
        catch (Exception e){}
        return null;
    }
}

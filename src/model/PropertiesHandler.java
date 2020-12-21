package model;

import model.GambleStrategey.GambleStrategies;
import model.database.GamblerEnum;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

public class PropertiesHandler {
    Properties properties = new Properties();

    final String databaseProperties = "src/bestanden/database.properties";
    final String gambleProperties = "src/bestanden/gamble.properties";
    final String  winstmarges = "src/bestanden/winst.properties";



    public void saveLoadSaveType(GamblerEnum loadSaveType) {
        try {
            FileOutputStream fos = new FileOutputStream(databaseProperties);
            properties.setProperty("loadSaveType",loadSaveType.toString());
            properties.store(fos, "properties");
            fos.flush();
            fos.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public GamblerEnum getLoadSaveType () {
        try {
            InputStream fis = new FileInputStream(databaseProperties);
            properties.load(fis);

            String prop = properties.getProperty("loadSaveType");
            if (prop != null) {
                return GamblerEnum.valueOf(prop);
            }

            fis.close();
        }
        catch (Exception e) {
            return null;
        }
        return null;
    }

    public void saveGambleStrategyTypes (List<GambleStrategies> types) {
        try {
            FileOutputStream fos = new FileOutputStream(gambleProperties);


            for (GambleStrategies type : types) {
                properties.setProperty(type.toString(), type.toString());
            }

            properties.store(fos, "properties");
            fos.flush();
            fos.close();

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveGambleStrategymarges (HashMap<String,Integer> types) {
        try {
            FileOutputStream fos = new FileOutputStream(winstmarges);


            for (Map.Entry<String, Integer> type : types.entrySet()) {
                properties.setProperty(type.getKey(), type.getValue().toString());
            }

            properties.store(fos, "properties");
            fos.flush();
            fos.close();

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public HashMap<String,Integer> getmarges(){
        HashMap<String,Integer> marges = new HashMap<>();
        try {
            InputStream fis = new FileInputStream(winstmarges);
            properties.load(fis);

            Set keys = properties.keySet();

            Iterator itr = keys.iterator();

            GambleStrategies type;

            while (itr.hasNext()) {
                String s = (String)itr.next();
                String value = properties.getProperty(s);

                type = GambleStrategies.valueOf(s);

                marges.put(s, Integer.valueOf(properties.getProperty(s)));

            }

            fis.close();
        }
        catch (Exception e) {
            return null;
        }
        return marges;

    }


    public ArrayList<GambleStrategies> getGambleStrategyTypes() {
        ArrayList<GambleStrategies> types = new ArrayList<>();
        try {
            InputStream fis = new FileInputStream(gambleProperties);
            properties.load(fis);

            Set keys = properties.keySet();

            Iterator itr = keys.iterator();

            GambleStrategies type;

            while (itr.hasNext()) {
                String s = (String)itr.next();
                String value = properties.getProperty(s);

                type = GambleStrategies.valueOf(s);
                types.add(type);
            }

            fis.close();
        }
        catch (Exception e) {
            return types;
        }
        return types;
    }
}

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

    public void saveLoadSaveType(GamblerEnum loadSaveType) {
        try {
            FileOutputStream fos = new FileOutputStream(databaseProperties);
            properties.setProperty("loadSaveType",loadSaveType.toString());
            properties.store(fos, "properties");
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

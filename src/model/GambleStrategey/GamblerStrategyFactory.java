package model.GambleStrategey;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GamblerStrategyFactory {

    /*use of singleton pattern */

    private static GamblerStrategyFactory instance = new GamblerStrategyFactory();

    private GamblerStrategyFactory(){};

    public static GamblerStrategyFactory getInstance() {
        return instance;
    }

    public GambleStrategy getStrategy(String gambleStrategy) {

        // TODO: 06/12/2020 catch errors verbeteren

        /* use reflection to return appropriate gamblerStrategy class*/
        try {
            Class<?> gamblerStrategyClass = Class.forName("model.GambleStrategey."+gambleStrategy);
            Constructor constructor = gamblerStrategyClass.getConstructor(String.class);
            Object gambleStrategyInstance = constructor.newInstance(gambleStrategy);
            return (GambleStrategy) gambleStrategyInstance;

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        // TODO: 06/12/2020  is returning null de beste manier?
        return null;
    }

}

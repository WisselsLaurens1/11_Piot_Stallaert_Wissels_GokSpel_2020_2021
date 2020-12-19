package model.GambleStrategey;

import java.util.ArrayList;

public class TestStrategy extends GambleStrategy {

    public static final String description = "Test Strat";

    public TestStrategy(String name) {
        super(name,description,10);
    }



    @Override
    public boolean didWin(ArrayList<Integer> diceTrhows) {
        return true;
    }
}
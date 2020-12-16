package model.GambleStrategey;

import java.util.ArrayList;

public class TestStrategy extends GambleStrategy {

    public static final String description = "Test Strat";

    public TestStrategy(String name) {
        super(name,description);
    }

    public TestStrategy(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean didWin(ArrayList<Integer> diceTrhows) {
        return true;
    }
}
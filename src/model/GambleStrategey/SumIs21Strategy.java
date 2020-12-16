package model.GambleStrategey;

import java.util.ArrayList;

public class SumIs21Strategy extends GambleStrategy {

    public static final String description = "The sum of all dice throws is equal to 21";

    public SumIs21Strategy(String name) {
        super(name,description);
    }

    @Override
    public boolean didWin(ArrayList<Integer> diceTrhows) {
        return false;
    }
}

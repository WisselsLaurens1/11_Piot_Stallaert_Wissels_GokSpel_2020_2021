package model.GambleStrategey;

import java.util.ArrayList;

public class EvenEyesStrategy extends GambleStrategy {

    public static final String description = "The amount of eyes of each dice throw is even";

    public EvenEyesStrategy(String name) {
        super(name,description,4);
    }

    @Override
    public boolean didWin(ArrayList<Integer> diceTrhows) {
        for (int i = 0; i<= diceTrhows.size(); i++){
            if(diceTrhows.get(i)%2 != 0 ) return false;
        }
        return true;
    }
}

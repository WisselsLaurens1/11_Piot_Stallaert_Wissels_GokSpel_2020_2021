package model.GambleStrategey;

public class EvenEyesStrategy extends GambleStrategy {

    public static final String description = "Each dice throw the amount of eyes is even";

    public EvenEyesStrategy(String name) {
        super(name,description);
    }

    @Override
    public boolean didWin(int diceEyes) {
        if(diceEyes % 2 == 0){
            return true;
        }else{
            return false;
        }
    }
}

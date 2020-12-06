package model.GambleStrategey;

public class EvenEyesStrategy extends GambleStrategy {
    @Override
    public boolean didWin(int diceEyes) {
        if(diceEyes % 2 == 0){
            return true;
        }else{
            return false;
        }
    }
}

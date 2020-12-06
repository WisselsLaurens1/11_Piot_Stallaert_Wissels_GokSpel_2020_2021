package model.GambleStrategey;


/*abstract class for strategy*/
 public abstract class GambleStrategy extends GamblerStrategyStatistic {

     /*returns true if the thrown dice meets the required winning conditions.
        returns false otherwise.
     *
     * */
     public abstract boolean didWin(int diceEyes);


 }

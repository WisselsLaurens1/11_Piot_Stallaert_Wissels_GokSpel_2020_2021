package model.GambleStrategey;


import java.util.ArrayList;

/*abstract class for strategy*/
 public abstract class GambleStrategy extends GamblerStrategyStatistic {

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public String getName() {
        return name;
    }

    private String name;

    public GambleStrategy(String name,String description){
        this.name = name;
        this.description = description;
    }

     /*returns true if the thrown dice meets the required winning conditions.
        returns false otherwise.
     *
     * */
     public abstract boolean didWin(ArrayList<Integer> diceTrhows);


 }

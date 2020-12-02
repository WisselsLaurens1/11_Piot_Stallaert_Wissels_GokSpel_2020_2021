package model;
import java.util.ArrayList;
import model.GambleStrategie.GambleStrategy;

public class GameModel implements Observable {

    public ArrayList<?> observers = new ArrayList<>();
    public void addObserver(Observer observer){

    };
    public void removeObserver(Observer observer){

    };

    public Gambler currentPlayer;

    public GambleStrategy gambleStrategy;

    public int trowDice(){
        return -1;
    };


}

package model;
import java.util.ArrayList;
import java.util.Random;

import model.GambleStrategey.GambleStrategies;
import model.GambleStrategey.GambleStrategy;
import model.GambleStrategey.GamblerStrategyFactory;

public class GameModel implements Observable {

    Random rand = new Random();

    public int get_random_number(int min,int max){
        return rand.nextInt((max - min) + 1) + min;
    }

    public ArrayList<?> observers = new ArrayList<>();
    public void addObserver(Observer observer){

    };
    public void removeObserver(Observer observer){

    };

    public Gambler getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Gambler currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    private Gambler currentPlayer;

    public GambleStrategy getGambleStrategy() {
        return gambleStrategy;
    }

    public void setGambleStrategy(GambleStrategy gambleStrategy) {
        this.gambleStrategy = gambleStrategy;
    }

    private GambleStrategy gambleStrategy;

    private final int maximumPlayerTruns = 4;

    public int getPlayerTurnsLeft() {
        return playerTurnsLeft;
    }

    public void setPlayerTurnsLeft(int playerTurnsLeft) {
        this.playerTurnsLeft = playerTurnsLeft;
    }

    private int playerTurnsLeft = maximumPlayerTruns;

    public boolean playerHasTurnsLeft(){
        return getPlayerTurnsLeft() > maximumPlayerTruns;
    }



    /* get gamblerStrategyFactory to create strategies*/
    private GamblerStrategyFactory gamblerStrategyFactory = GamblerStrategyFactory.getInstance();



    private ArrayList<GambleStrategy> gambleStrategies = new ArrayList<>();

    /* add all the gamblstrategies to the gamblestrategies array*/
    public void initGamblerStrategies(){
        /* for every strategy of the strategy enum create the strategy objet through the factory and add them to the array*/
        for(GambleStrategies gambleStrategy : GambleStrategies.values()){
            GambleStrategy strategy = gamblerStrategyFactory.getStrategy(gambleStrategy.toString());
            gambleStrategies.add(strategy);
        }
    }


    // TODO: 06/12/2020  test possible error: maybe past by value instead of value then object in array and currentStrategy are not in sync

    /*method to select a gambleStrategy and updtade its statistics*/
    public void selectGambleStrategy(GambleStrategy gambleStrategy){
        if (gambleStrategies.contains(gambleStrategy)){
            /*get the selected strategy out of the strategies array*/
            GambleStrategy selectedStrategy = gambleStrategies.get(gambleStrategies.indexOf(gambleStrategy));
            /* update statistic */
            selectedStrategy.setTimesSelected(selectedStrategy.getTimesSelected()+1);
            setGambleStrategy(selectedStrategy);
        }else{
            throw new IllegalArgumentException("This strategy does not exist");
        }
    }

    public void trowDice(){

        /* check if player has a turn left */
        if(playerHasTurnsLeft()){
            /*thow the dice*/
            int diceEyes =  this.get_random_number(1,6);

            setPlayerTurnsLeft(getPlayerTurnsLeft()-1);

            /*check if the player has won*/
            Boolean didWin = gambleStrategy.didWin(diceEyes);
        }else{
            /*if player does not have a turn left, end game and do something*/

            // TODO: 06/12/2020
            //  implement: udpdate gamble saldo in given format(text/excel) and show in spelverloop pain

            return;
        }

    };






}

package model;
import java.util.*;

import model.GambleStrategey.GambleStrategies;
import model.GambleStrategey.GambleStrategy;
import model.GambleStrategey.GamblerStrategyFactory;
import model.database.DatabaseModel;
import model.gambleState.*;

public class GameModel implements Observable {

    /********************** actions player can take **********************/

    public void login(String name){
        try{
            this.getCurrentstate().login(name);
        }catch(IllegalStateException e ){
            setTerminalOutput(this.getCurrentstate().errorMessage);
        }
    }

    public void logout(){
        currentstate.logout();
    }

    public void choseStrategy(GambleStrategy gambleStrategy){
        try{
            currentstate.choseStrategy(gambleStrategy);
            setGambleStrategy(gambleStrategy);
        }catch(IllegalStateException e ){
            setTerminalOutput(this.getCurrentstate().errorMessage);
        }

    }

    public void changeCurrentBettingAmount(int bettingAmount){
        try{
            currentstate.changeBettingAmount(bettingAmount);
        }catch(IllegalStateException e ){
            setTerminalOutput(this.getCurrentstate().errorMessage);
        }
    }

    public void throwDice(){
        try{
            this.currentstate.throwdice();
        }catch(IllegalStateException e ){
            setTerminalOutput(this.getCurrentstate().errorMessage);
        }
    };

    public void newGame(){
        try{
            this.currentstate.newGame();
        }catch(IllegalStateException e ){
            setTerminalOutput(this.getCurrentstate().errorMessage);
        }
    }

    public void endTurn(){
        try{
            this.currentstate.endTurn();
        }catch(IllegalStateException e ){
            setTerminalOutput(this.getCurrentstate().errorMessage);
        }
    }


    /********************** states **********************/
    private State currentstate;

    public final LoginState loginState;
    public final ThrowDiceState throwDiceState;
    public final ChoseStrategyState choseStrategyState;
    public final EndOfTurnState endOfTurnState;
    public final ChangeBettingAmountState changeBettingAmountState;

    public State getCurrentstate() {
        return currentstate;
    }
    public void setCurrentstate(State currentstate) {
        this.currentstate = currentstate;
        System.out.println("State: "+currentstate);
    }

    /********************** variables & getters & setters **********************/

    /***variables***/

    private DatabaseModel database;
    private Gambler currentPlayer;
    private GambleStrategy gambleStrategy;
    private final int maximumPlayerTruns = 4;
    private int playerTurnsLeft = maximumPlayerTruns;
    private ArrayList<GambleStrategy> gambleStrategies = new ArrayList<>();
    private HashMap<String, GambleStrategy> gambleStrategyHashMap = new HashMap<>();
    private int diceThrown = -1;
    private int currentBettingAmount;
    private ArrayList<Integer> diceThrows = new ArrayList<Integer>();
    private GamblerStrategyFactory gamblerStrategyFactory = GamblerStrategyFactory.getInstance();
    public String terminalOutput = null;
    private int gameCount;
    private PropertiesHandler handler =new PropertiesHandler();


    private int wonAmount;

    /***getters && setters***/

    public DatabaseModel getDatabase() {
        return database;
    }
    public Gambler getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(Gambler currentPlayer) {
        this.currentPlayer = currentPlayer;
        updateObservers();
    }
    public void setGambleStrategy(GambleStrategy gambleStrategy) {
        this.gambleStrategy = gambleStrategy;
        updateObservers();
    }
    public GambleStrategy getGambleStrategy() {
        return gambleStrategy;
    }
    public int getMaximumPlayerTruns() {
        return maximumPlayerTruns;
    }
    public int getPlayerTurnsLeft() {
        return playerTurnsLeft;
    }
    public void setPlayerTurnsLeft(int playerTurnsLeft) {
        this.playerTurnsLeft = playerTurnsLeft;
        updateObservers();
    }
    public ArrayList<GambleStrategy> getGambleStrategies() {
        return gambleStrategies;
    }
    public HashMap<String, GambleStrategy> getGambleStrategyHashMap() {
        return gambleStrategyHashMap;
    }
    public int getDiceThrown() {
        return diceThrown;
    }
    public void setDiceThrown(int diceThrown) {
        this.diceThrown = diceThrown;
        updateObservers();
    }
    public ArrayList<Integer> getDiceThrows() {
        return diceThrows;
    }
    public String getTerminalOutput() {
        return terminalOutput;
    }
    public void setTerminalOutput(String terminalOutput) {
        this.terminalOutput = terminalOutput;
        this.updateObservers();
    }
    public int getGameCount() {
        return gameCount;
    }
    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
        updateObservers();
    }
    public int getCurrentBettingAmount() {
        return currentBettingAmount;
    }
    public void setCurrentBettingAmount(int currentBettingAmount) {
        this.currentBettingAmount = currentBettingAmount;
        updateObservers();
    }
    public int getWonAmount() {
        return wonAmount;
    }

    public void setWonAmount(int wonAmount) {
        this.wonAmount = wonAmount;
        updateObservers();
    }


    /********************** Observers **********************/


    public ArrayList<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer){
        observers.add(observer);
    };
    public void removeObserver(Observer observer){

    };
    public void updateObservers(){
        for(Observer observer: observers){
            observer.update();
        }
    }


    /********************** constructor **********************/

    public GameModel(DatabaseModel database){
        initGamblerStrategies();
        setPlayerTurnsLeft(maximumPlayerTruns);
        this.changeBettingAmountState =new ChangeBettingAmountState(this);
        this.choseStrategyState =new ChoseStrategyState(this);
        this.currentstate = new LoginState(this);
        this.loginState =new LoginState(this);
        this.endOfTurnState = new EndOfTurnState(this);
        this.throwDiceState =new ThrowDiceState(this);
        this.database = database;
        this.setGameCount(1);
    }

    /********************** other **********************/


    /* add all the gamblstrategies to the gamblestrategies array*/
    public void initGamblerStrategies(){

        /* for every strategy of the strategy enum create the strategy objet through the factory and add them to the array*/
        for(GambleStrategies gambleStrategy : GambleStrategies.values()){

            GambleStrategy strategy = gamblerStrategyFactory.getStrategy(gambleStrategy.toString());
            if (handler.getmarges() != null){
                for (Map.Entry<String, Integer> s: handler.getmarges().entrySet()){
                    if (strategy.getClass().getSimpleName().equals(s.getKey())){
                        strategy.setWinMultiplier(s.getValue());
                    }
                }
            }
            gambleStrategyHashMap.put(gambleStrategy.toString(),strategy);
        }

    }

    public void resetDiceThrows() {
        this.diceThrows.clear();
        updateObservers();
    }

    public int get_random_number(int min,int max){
        return new Random().nextInt((max - min) + 1) + min;
    }

    public void updateMarges(HashMap<String,Integer> marges) {
        for (Map.Entry<String, Integer> entry : marges.entrySet()){
            getGambleStrategyHashMap().get(entry.getKey()).setWinMultiplier(entry.getValue());
        }
    }

    public void addDiceThrow(int diceThrow){
        diceThrows.add(diceThrow);
        updateObservers();
    }






}

package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import model.GambleStrategey.GambleStrategies;
import model.GambleStrategey.GambleStrategy;
import model.GambleStrategey.GamblerStrategyFactory;
import model.database.DatabaseModel;
import model.gambleState.*;

public class GameModel implements Observable {

    private LoginState loginState;
    private State currentstate;
    private ThrowDiceState throwDiceState;
    private ChoseStrategyState choseStrategyState;



    public ChangeBettingAmountState getChangeBettingAmountState() {
        return changeBettingAmountState;
    }

    public void setChangeBettingAmountState(ChangeBettingAmountState changeBettingAmountState) {
        this.changeBettingAmountState = changeBettingAmountState;
    }

    private ChangeBettingAmountState changeBettingAmountState;

    public ThrowDiceState getThrowDiceState() {
        return throwDiceState;
    }

    public void setThrowDiceState(ThrowDiceState throwDiceState) {
        this.throwDiceState = throwDiceState;
    }


    public ChoseStrategyState getChoseStrategyState() {
        return choseStrategyState;
    }

    public void setChoseStrategyState(ChoseStrategyState choseStrategyState) {
        this.choseStrategyState = choseStrategyState;
    }


    public LoginState getLoginState() {
        return loginState;
    }

    public void setLoginState(LoginState loginState) {
        this.loginState = loginState;
    }



    public DatabaseModel getDatabase() {
        return database;
    }

    private DatabaseModel database;




    public State getCurrentstate() {
        return currentstate;
    }

    public void setCurrentstate(State currentstate) {
        this.currentstate = currentstate;
    }

    Random rand = new Random();

    public int get_random_number(int min,int max){
        return rand.nextInt((max - min) + 1) + min;
    }

    public ArrayList<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer){
        observers.add(observer);
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

    public void updateObservers(){
        for(Observer observer: observers){
            observer.update();
        }
    }

    public void setGambleStrategy(GambleStrategy gambleStrategy) {
        this.currentstate.choseStrategy();
        this.gambleStrategy = gambleStrategy;
        System.out.println("this has been set: "+this.getGambleStrategy());

        updateObservers();
    }

    private GambleStrategy gambleStrategy;

    public int getMaximumPlayerTruns() {
        return maximumPlayerTruns;
    }

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


    public ArrayList<GambleStrategy> getGambleStrategies() {
        return gambleStrategies;
    }
    private ArrayList<GambleStrategy> gambleStrategies = new ArrayList<>();


    public HashMap<String, GambleStrategy> getGambleStrategyHashMap() {
        return gambleStrategyHashMap;
    }

    private HashMap<String, GambleStrategy> gambleStrategyHashMap = new HashMap<>();



    /* add all the gamblstrategies to the gamblestrategies array*/
    public void initGamblerStrategies(){


        /* for every strategy of the strategy enum create the strategy objet through the factory and add them to the array*/
        for(GambleStrategies gambleStrategy : GambleStrategies.values()){

            GambleStrategy strategy = gamblerStrategyFactory.getStrategy(gambleStrategy.toString());
            gambleStrategyHashMap.put(gambleStrategy.toString(),strategy);
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

            // TODO: 06/12/2020 update view with new selected strategy
            
        }else{
            throw new IllegalArgumentException("This strategy does not exist");
        }
    }

    public GameModel(DatabaseModel database){
        initGamblerStrategies();
        setPlayerTurnsLeft(maximumPlayerTruns);
        this.changeBettingAmountState =new ChangeBettingAmountState(this);
        this.choseStrategyState =new ChoseStrategyState(this);
        this.currentstate = new LoginState(this);
        this.loginState =new LoginState(this);
        this.throwDiceState =new ThrowDiceState(this);
        this.database = database;


    }

    public int getDiceThrown() {
        return diceThrown;
    }

    public void setDiceThrown(int diceThrown) {
        this.diceThrown = diceThrown;
    }

    private int diceThrown = -1;


    public void throwDice(){

        /* check if player has a turn left */
        if(getPlayerTurnsLeft() >0){
            this.currentstate.throwdice();
            /*thow the dice*/
            int diceEyes =  this.get_random_number(1,6);

            setPlayerTurnsLeft(getPlayerTurnsLeft()-1);
            if (getPlayerTurnsLeft() == 2) {
                setCurrentstate(getChangeBettingAmountState());}

           setDiceThrown(diceEyes);
           updateObservers();
        }
        else {
            this.currentstate.eind();
        }

    };

    public void login(String name){
        this.getCurrentstate().login(name);
    }

    public void logout(){
        this.getCurrentstate().logout();
        System.out.println("logging out");
    }

    public int getCurrentBettingAmount() {
        return currentBettingAmount;
    }

    public void setCurrentBettingAmount(int currentBettingAmount) {
        this.currentBettingAmount = currentBettingAmount;
    }

    private int currentBettingAmount;


    public String getTerminalOutput() {
        return terminalOutput;
    }

    public void setTerminalOutput(String terminalOutput) {
        this.terminalOutput = terminalOutput;
        System.out.println("update temrinal: "+terminalOutput);
        this.updateObservers();
    }

    public String terminalOutput = null;

}

package model.gambleState;

import model.GambleStrategey.GambleStrategy;
import model.GameModel;

public class ChangeBettingAmountState extends State{
    public ChangeBettingAmountState(GameModel model) {
        super(model);
    }

    @Override
    public void login(String name) {
        throw new IllegalStateException("You are already logged in");
    }

    @Override
    public void startGame() {
        throw new IllegalStateException("The game has already started");
    }

    @Override
    public void choseStrategy(GambleStrategy gambleStrategy) {
        gameModel.setGambleStrategy(gambleStrategy);
        gameModel.setCurrentstate(gameModel.changeBettingAmountState);
        gameModel.setTerminalOutput(" ");
    }

    @Override
    public void throwdice() {
        this.errorMessage = "Enter betting amount first";
        throw new IllegalStateException("Enter betting amount first");

    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        if(bettingAmount > getGameModel().getCurrentPlayer().getGamblingSaldo()){
            this.errorMessage =  "Entered betting amount is to big, not enough saldo";
            throw new IllegalStateException("Entered betting amount is to big, not enough saldo");
        }
        gameModel.setCurrentBettingAmount(bettingAmount);
        gameModel.setCurrentstate(gameModel.throwDiceState);
        gameModel.setTerminalOutput(" ");

    }

    @Override
    public void endTurn() {
        throw new IllegalStateException("First trhow dice");
    }




}

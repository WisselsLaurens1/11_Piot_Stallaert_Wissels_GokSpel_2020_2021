package model.gambleState;

import model.GambleStrategey.GambleStrategy;
import model.GameModel;

public class ChoseStrategyState extends State{
    public ChoseStrategyState(GameModel model) {
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
    }

    @Override
    public void throwdice() {
        this.errorMessage = "You have to chose a strategy first";
        throw new IllegalStateException("You have to chose a strategy first");
    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        this.errorMessage = "You have to chose a strategy first";
        throw new IllegalStateException("You have to chose a strategy first");    }

    @Override
    public void endTurn() {
        this.errorMessage = "You have to chose a strategy first";
        throw new IllegalStateException("You have to chose a strategy first");    }

}



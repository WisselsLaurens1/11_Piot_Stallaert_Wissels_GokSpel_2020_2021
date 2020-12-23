package model.gambleState;

import model.GambleStrategey.GambleStrategy;
import model.GameModel;

public class StartGameState extends State {
    public StartGameState(GameModel model) {
        super(model);
    }

    @Override
    public void login(String name) {
        this.errorMessage = "First start Game";
        throw new IllegalStateException("First start Game");
    }

    @Override
    public void choseStrategy(GambleStrategy gambleStrategy) {
        this.errorMessage = "First start Game";
        throw new IllegalStateException("First start Game");
    }

    @Override
    public void throwdice() {
        this.errorMessage = "First start Game";
        throw new IllegalStateException("First start Game");
    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        this.errorMessage = "First start Game";
        throw new IllegalStateException("First start Game");
    }

    @Override
    public void endTurn() {
        this.errorMessage = "First start Game";
        throw new IllegalStateException("First start Game");
    }

    @Override
    public void startGame() {
        gameModel.setCurrentstate(gameModel.throwDiceState);
        gameModel.setTerminalOutput(" ");

    }

    @Override
    public void increaseBettingAmount(int value) {
        throw new IllegalStateException("First start Game");

    }
}

package model.gambleState;

import jxl.read.biff.BiffException;
import model.GambleStrategey.GambleStrategy;
import model.GameModel;

import java.io.IOException;

public abstract class State {
public final GameModel gameModel;

    public State(GameModel model){this.gameModel =model;}

    public String errorMessage;

    public GameModel getGameModel() {
        return gameModel;
    }
    public abstract void login(String name);
    public abstract void choseStrategy(GambleStrategy gambleStrategy);
    public abstract void throwdice();
    public abstract void changeBettingAmount(int bettingAmount);
    public abstract void endTurn() throws IOException, BiffException;
    public abstract void startGame();
    public abstract void increaseBettingAmount(int value);

    public void logout(){
        gameModel.setDiceThrown(-1);
        gameModel.setCurrentPlayer(null);
        getGameModel().resetDiceThrows();
        getGameModel().setGambleStrategy(null);
        gameModel.setGameCount(1);
        gameModel.setPlayerTurnsLeft(gameModel.getMaximumPlayerTruns());
        gameModel.setCurrentstate(gameModel.loginState);
        gameModel.setTerminalOutput(" ");
    }

    public void newGame() {
        gameModel.setDiceThrown(-1);
        gameModel.setCurrentstate(gameModel.changeBettingAmountState);
        gameModel.resetDiceThrows();
        gameModel.setCurrentBettingAmount(0);
        gameModel.setPlayerTurnsLeft(gameModel.getMaximumPlayerTruns());
        gameModel.setGameCount(gameModel.getGameCount()+1);
        gameModel.setWonAmount(-1);
        gameModel.setTerminalOutput(" ");

    }

}

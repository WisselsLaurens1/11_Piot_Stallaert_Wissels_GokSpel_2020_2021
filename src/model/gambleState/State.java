package model.gambleState;

import model.GambleStrategey.GambleStrategy;
import model.GameModel;

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
    public abstract void endTurn();
    public void logout(){
        gameModel.setDiceThrown(-1);
        gameModel.setCurrentPlayer(null);
        getGameModel().resetDiceThrows();
        getGameModel().setGambleStrategy(null);
        gameModel.setGameCount(1);
        gameModel.setPlayerTurnsLeft(gameModel.getMaximumPlayerTruns());
        gameModel.setCurrentstate(gameModel.loginState);
    }

    public void newGame() {
        gameModel.setDiceThrown(-1);
        gameModel.setCurrentstate(gameModel.changeBettingAmountState);
        gameModel.resetDiceThrows();
        gameModel.setCurrentBettingAmount(0);
        gameModel.setTerminalOutput(" ");
        gameModel.setPlayerTurnsLeft(gameModel.getMaximumPlayerTruns());
        gameModel.setGameCount(gameModel.getGameCount()+1);
        gameModel.setWonAmount(-1);
    }

}

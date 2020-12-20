package model.gambleState;

import model.GameModel;

public abstract class State {
protected GameModel gameModel;

    public State(GameModel model){this.gameModel =model;}

    public GameModel getGameModel() {
        return gameModel;
    }
    public abstract void login(String name);
    public abstract void choseStrategy();
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
        gameModel.setCurrentstate(gameModel.getLoginState());


    }

    public void newGame() {
        gameModel.setDiceThrown(-1);
        this.gameModel.setCurrentstate(this.gameModel.getChangeBettingAmountState());
        this.gameModel.resetDiceThrows();
        this.gameModel.setCurrentBettingAmount(0);
        this.gameModel.setTerminalOutput(" ");
        this.gameModel.setPlayerTurnsLeft(gameModel.getMaximumPlayerTruns());
        gameModel.setGameCount(gameModel.getGameCount()+1);
    }

}

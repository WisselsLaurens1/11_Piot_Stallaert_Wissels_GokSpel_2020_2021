package model.gambleState;

import model.GameModel;

public abstract class State {
private GameModel model;

    public State(GameModel model){this.model=model;}

    public GameModel getModel() {
        return model;
    }
    public abstract void login(String name);
    public abstract void choseStrategy();
    public abstract void throwdice();
    public abstract void changeBettingAmount(int bettingAmount);
    public abstract void endTurn();
    public void logout(){
        model.setCurrentPlayer(null);
        getModel().resetDiceThrows();
        getModel().setGambleStrategy(null);
        model.setCurrentstate(model.getLoginState());
    }
}

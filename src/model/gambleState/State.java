package model.gambleState;

import model.GameModel;

public abstract class State {
private GameModel model;
public State(GameModel model){this.model=model;}

    public GameModel getModel() {
        return model;
    }
    public abstract void login(String name);
    public abstract void choosestrategy();
    public abstract void throwdice();
    public abstract void changeinzet();
    public abstract void eind();
}

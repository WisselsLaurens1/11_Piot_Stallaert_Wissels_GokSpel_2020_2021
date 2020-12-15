package model.gambleState;

import model.GameModel;

public class ChoseStrategyState extends State{
    public ChoseStrategyState(GameModel model) {
        super(model);
    }

    @Override
    public void login(String name) {
        throw new IllegalStateException("je bent al ingelogt");
    }

    @Override
    public void choseStrategy() {
        if(getModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ThrowDiceState)throw new IllegalStateException();
/*
        if(getModel().getCurrentstate() instanceof Changeinzet)throw new IllegalStateException();
*/
        if(getModel().getCurrentstate() instanceof ChoseStrategyState){
            getModel().setCurrentstate(getModel().getThrowDiceState());
        }
    }

    @Override
    public void throwdice() {
        throw new IllegalStateException("je moet eerst een strategie kiezen");
    }

    @Override
    public void changeBettingAmount() {
        throw new IllegalStateException("je moet een strategie kiezen");
    }

    @Override
    public void eind() {
        throw new IllegalStateException("je moet een strategie kiezen");
    }
}

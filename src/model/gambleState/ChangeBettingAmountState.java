package model.gambleState;

import model.GameModel;

public class ChangeBettingAmountState extends State{
    public ChangeBettingAmountState(GameModel model) {
        super(model);
    }

    @Override
    public void login(String name) {
        throw new IllegalStateException("je bent al ingelogt");
    }

    @Override
    public void choseStrategy() {
        throw new IllegalStateException("je hebt al een strategie gekozen");
    }

    @Override
    public void throwdice() {
        if(getModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ChoseStrategyState)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ThrowDiceState)throw new IllegalStateException();

    }

    @Override
    public void changeBettingAmount() {
        if(getModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ChoseStrategyState)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ThrowDiceState)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ChangeBettingAmountState){
            getModel().setCurrentstate(getModel().getThrowDiceState());
        }
    }

    @Override
    public void eind() {
        throw new IllegalStateException("je moet eerst 4 dice throws doen");
    }
}

package model.gambleState;

import model.GameModel;

public class ThrowDiceState extends State{
    public ThrowDiceState(GameModel model) {
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
        if(getModel().getCurrentstate() instanceof ChangeBettingAmountState)throw new IllegalStateException();

    }

    @Override
    public void changeBettingAmount() {
        throw new IllegalStateException("je moet eerst 2 dice throws nodig");
    }

    @Override
    public void eind() {
        if(getModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ChoseStrategyState)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ChangeBettingAmountState)throw new IllegalStateException();
        if (getModel().getCurrentstate() instanceof ThrowDiceState){
            getModel().setCurrentstate(getModel().getLoginState());
        }
    }
}

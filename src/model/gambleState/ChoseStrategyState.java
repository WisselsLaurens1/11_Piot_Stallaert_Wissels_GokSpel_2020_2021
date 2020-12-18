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
            getModel().setCurrentstate(getModel().getChangeBettingAmountState());
        }
    }

    @Override
    public void throwdice() {
        getModel().setTerminalOutput("You have to chose a strategy first");
        throw new IllegalStateException("You have to chose a strategy first");
    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        getModel().setTerminalOutput("You have to chose a strategy first");
        throw new IllegalStateException("You have to chose a strategy first");    }

    @Override
    public void endTurn() {
        getModel().setTerminalOutput("You have to chose a strategy first");
        throw new IllegalStateException("You have to chose a strategy first");    }
}

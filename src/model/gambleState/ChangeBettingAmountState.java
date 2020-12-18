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
        if(getModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ThrowDiceState)throw new IllegalStateException();
/*
        if(getModel().getCurrentstate() instanceof Changeinzet)throw new IllegalStateException();
*/
        if(getModel().getCurrentstate() instanceof ChoseStrategyState){
            getModel().setCurrentstate(getModel().getThrowDiceState());
        }    }

    @Override
    public void throwdice() {
        if(getModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ChoseStrategyState)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ThrowDiceState)throw new IllegalStateException();
        getModel().setTerminalOutput("Enter betting amount first");
        throw new IllegalStateException("Enter betting amount first");

    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        if(getModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ChoseStrategyState)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ThrowDiceState)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ChangeBettingAmountState){
            getModel().setTerminalOutput(Integer.toString((int) getModel().getCurrentPlayer().getGamblingSaldo()));

            if(bettingAmount > getModel().getCurrentPlayer().getGamblingSaldo()){
                getModel().setTerminalOutput("Entered betting amount is to big, not enough saldo");
                throw new IllegalStateException("Entered betting amount is to big, not enough saldo");
            }
            getModel().setCurrentBettingAmount(bettingAmount);
            getModel().setCurrentstate(getModel().getThrowDiceState());

        }
    }

    @Override
    public void endTurn() {
        throw new IllegalStateException("je moet eerst 4 dice throws doen");
    }
}

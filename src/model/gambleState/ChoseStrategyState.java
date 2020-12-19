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
        if(getGameModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getGameModel().getCurrentstate() instanceof ThrowDiceState)throw new IllegalStateException();
/*
        if(getModel().getCurrentstate() instanceof Changeinzet)throw new IllegalStateException();
*/
        if(getGameModel().getCurrentstate() instanceof ChoseStrategyState){
            getGameModel().setCurrentstate(getGameModel().getChangeBettingAmountState());
        }
    }

    @Override
    public void throwdice() {
        getGameModel().setTerminalOutput("You have to chose a strategy first");
        throw new IllegalStateException("You have to chose a strategy first");
    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        getGameModel().setTerminalOutput("You have to chose a strategy first");
        throw new IllegalStateException("You have to chose a strategy first");    }

    @Override
    public void endTurn() {
        getGameModel().setTerminalOutput("You have to chose a strategy first");
        throw new IllegalStateException("You have to chose a strategy first");    }

}



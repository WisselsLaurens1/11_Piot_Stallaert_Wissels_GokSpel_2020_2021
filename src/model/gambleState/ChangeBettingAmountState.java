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
        if(getGameModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getGameModel().getCurrentstate() instanceof ThrowDiceState)throw new IllegalStateException();

        if(getGameModel().getCurrentstate() instanceof ChoseStrategyState){
            getGameModel().setCurrentstate(getGameModel().getThrowDiceState());
        }    }

    @Override
    public void throwdice() {
        if(getGameModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getGameModel().getCurrentstate() instanceof ChoseStrategyState)throw new IllegalStateException();
        if(getGameModel().getCurrentstate() instanceof ThrowDiceState)throw new IllegalStateException();
        getGameModel().setTerminalOutput("Enter betting amount first");
        throw new IllegalStateException("Enter betting amount first");

    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        if(getGameModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getGameModel().getCurrentstate() instanceof ChoseStrategyState)throw new IllegalStateException();
        if(getGameModel().getCurrentstate() instanceof ThrowDiceState)throw new IllegalStateException();
        if(getGameModel().getCurrentstate() instanceof ChangeBettingAmountState){

            if(bettingAmount > getGameModel().getCurrentPlayer().getGamblingSaldo()){
                getGameModel().setTerminalOutput("Entered betting amount is to big, not enough saldo");
                throw new IllegalStateException("Entered betting amount is to big, not enough saldo");
            }
            getGameModel().setCurrentBettingAmount(bettingAmount);
            getGameModel().setCurrentstate(getGameModel().getThrowDiceState());

        }
    }

    @Override
    public void endTurn() {
        throw new IllegalStateException("je moet eerst 4 dice throws doen");
    }


}

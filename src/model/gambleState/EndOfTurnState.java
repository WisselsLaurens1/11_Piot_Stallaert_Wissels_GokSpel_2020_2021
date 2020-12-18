package model.gambleState;

import model.GameModel;

import java.util.ArrayList;

public class EndOfTurnState extends State {
    public EndOfTurnState(GameModel model) {
        super(model);
    }

    @Override
    public void login(String name) {

    }

    @Override
    public void choseStrategy() {

    }

    @Override
    public void throwdice() {

    }

    @Override
    public void changeBettingAmount(int bettingAmount) {

    }

    @Override
    public void endTurn() {
        ArrayList<Integer> diceTrhows = getModel().getDiceThrows();
        Boolean didWin = getModel().getGambleStrategy().didWin(diceTrhows);
        getModel().resetDiceThrows();
        if(didWin){
            int wonAmount = 100;
            getModel().setTerminalOutput("You won: "+wonAmount);
            getModel().getCurrentPlayer().setGamblingSaldo(Double.toString(getModel().getCurrentPlayer().getGamblingSaldo()+wonAmount));
        }else{
            getModel().setTerminalOutput("You lost!");
        }

        getModel().resetDiceThrows();
    }
}

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
        ArrayList<Integer> diceTrhows = getGameModel().getDiceThrows();
        Boolean didWin = getGameModel().getGambleStrategy().didWin(diceTrhows);

        if(didWin){
            int wonAmount = 100;
            getGameModel().setTerminalOutput("You won: "+wonAmount);
            getGameModel().getCurrentPlayer().setGamblingSaldo(Double.toString(getGameModel().getCurrentPlayer().getGamblingSaldo()+wonAmount));
        }else{
            getGameModel().setTerminalOutput("You lost!");
        }

    }

}

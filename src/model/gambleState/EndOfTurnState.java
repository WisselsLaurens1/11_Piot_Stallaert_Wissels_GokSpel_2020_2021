package model.gambleState;

import model.GameModel;

import java.util.ArrayList;

public class EndOfTurnState extends State {
    public EndOfTurnState(GameModel model) {
        super(model);
    }

    @Override
    public void login(String name) {
        getGameModel().setTerminalOutput("You are already loged in");
        throw new IllegalStateException("You are already loged in");
    }

    @Override
    public void choseStrategy() {

    }

    @Override
    public void throwdice() {
        getGameModel().setTerminalOutput("Start new game first");
        throw new IllegalStateException("Start new game first");
    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        getGameModel().setTerminalOutput("Start new game first");
        throw new IllegalStateException("Start new game first");
    }


    @Override
    public void endTurn() {
        ArrayList<Integer> diceTrhows = getGameModel().getDiceThrows();
        Boolean didWin = getGameModel().getGambleStrategy().didWin(diceTrhows);

        if(didWin){
            int wonAmount = gameModel.getCurrentBettingAmount()*gameModel.getGambleStrategy().winMultiplier;
            getGameModel().setTerminalOutput("You won: "+wonAmount);
            getGameModel().getCurrentPlayer().setGamblingSaldo(Double.toString(getGameModel().getCurrentPlayer().getGamblingSaldo()+wonAmount));
        }else{
            getGameModel().setTerminalOutput("You lost!");
        }



    }

}

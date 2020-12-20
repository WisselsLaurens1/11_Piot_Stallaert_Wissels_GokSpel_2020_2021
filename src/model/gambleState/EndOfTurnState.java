package model.gambleState;

import model.GambleStrategey.GambleStrategy;
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
            GambleStrategy strategy =  gameModel.getGambleStrategy();
            getGameModel().setTerminalOutput("You won: "+wonAmount);
            strategy.setTotalWins(strategy.getTotalWins()+1);
            strategy.setTotalProfit(strategy.getTotalProfit()+wonAmount);
            getGameModel().getCurrentPlayer().setGamblingSaldo(Double.toString(getGameModel().getCurrentPlayer().getGamblingSaldo()+wonAmount));
            gameModel.updateObservers();
        }else{
            getGameModel().setTerminalOutput("You lost!");
        }



    }

}

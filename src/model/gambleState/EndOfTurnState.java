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
        this.errorMessage = "You are already loged in";
        throw new IllegalStateException("You are already loged in");
    }

    @Override
    public void choseStrategy(GambleStrategy gambleStrategy) {

    }

    @Override
    public void throwdice() {
        this.errorMessage = "Start new game first";
        throw new IllegalStateException("Start new game first");
    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        this.errorMessage = "Start new game first";
        throw new IllegalStateException("Start new game first");
    }


    @Override
    public void endTurn() {
        ArrayList<Integer> diceThrows = getGameModel().getDiceThrows();
        Boolean didWin = getGameModel().getGambleStrategy().didWin(diceThrows);

        if(didWin){
            int wonAmount = gameModel.getCurrentBettingAmount()*gameModel.getGambleStrategy().winMultiplier;
            gameModel.setWonAmount(wonAmount);
            int newSaldo = (int) (gameModel.getCurrentPlayer().getGamblingSaldo()+wonAmount);
            GambleStrategy selectedStrategy =  gameModel.getGambleStrategy();
            gameModel.setTerminalOutput("You won: "+ wonAmount + ". Your new saldo is: " + newSaldo);
            selectedStrategy.setTotalWins(selectedStrategy.getTotalWins()+1);
            selectedStrategy.setTotalProfit(selectedStrategy.getTotalProfit()+wonAmount);
            gameModel.getCurrentPlayer().setGamblingSaldo(Double.toString(newSaldo));
            gameModel.updateObservers();
        }else{
            gameModel.setTerminalOutput("You lost! Your new saldo is: " + gameModel.getCurrentPlayer().getGamblingSaldo());
        }
    }
}

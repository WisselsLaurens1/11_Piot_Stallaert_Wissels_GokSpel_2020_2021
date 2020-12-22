package model.gambleState;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import model.GambleStrategey.GambleStrategy;
import model.Gambler;
import model.GameModel;
import model.PropertiesHandler;
import model.database.GamblerDbInterface;
import model.database.GamblerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class EndOfTurnState extends State {
    private PropertiesHandler handler =new PropertiesHandler();

    public EndOfTurnState(GameModel model) {
        super(model);
    }

    @Override
    public void login(String name) {
        this.errorMessage = "You are already loged in";
        throw new IllegalStateException("You are already loged in");
    }

    @Override
    public void startGame() {
        throw new IllegalStateException("The game has already started");
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
        GamblerDbInterface gamblerDbInterface = GamblerFactory.createDb(handler.getLoadSaveType().toString());
        HashMap<String, Gambler> gamblerDB =  gamblerDbInterface.getGamblerDb();
        ArrayList<Gambler> gamblers = new ArrayList<Gambler>(gamblerDB.values());
        try {
            gamblerDbInterface.write(gamblers, getGameModel().getCurrentPlayer().getPlayerName(), getGameModel().getCurrentPlayer().getGamblingSaldo());
        } catch (BiffException biffException) {
            biffException.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

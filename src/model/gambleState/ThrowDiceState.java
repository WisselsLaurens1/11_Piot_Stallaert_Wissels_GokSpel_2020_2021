package model.gambleState;

import model.GambleStrategey.GambleStrategy;
import model.GameModel;

public class ThrowDiceState extends State{
    public ThrowDiceState(GameModel model) {
        super(model);
    }

    @Override
    public void login(String name) {

        throw new IllegalStateException("You are already logged in");
    }

    @Override
    public void startGame() {
        throw new IllegalStateException("The game has already started");
    }

    @Override
    public void increaseBettingAmount(int value) {
        if(gameModel.getPlayerTurnsLeft() == 2 && gameModel.getGambleStrategy().didWin(gameModel.getDiceThrows())){

            int temp = gameModel.getDiceThrows().get(1);
            gameModel.getDiceThrows().remove(1);
            /*remove one dice throw temporarily so UI get updated correctly */
            if(value<=10){
                gameModel.setCurrentBettingAmount(gameModel.getCurrentBettingAmount()+value);

            }else{
                gameModel.setTerminalOutput("You can't increase your betting amount with more then €10");
            }

            /*add throw back to dice throws*/
            gameModel.getDiceThrows().add(temp);

        }else{
            throw new IllegalStateException("You can't increase your betting amount");
        }
    }

    @Override
    public void choseStrategy(GambleStrategy gambleStrategy) {
        this.errorMessage = "You can't change your strategy while playing";
        throw new IllegalStateException("You can't change your strategy while playing");
    }

    @Override
    public void throwdice() {

        /* subtract betted amount from player saldo*/
        if(gameModel.getPlayerTurnsLeft() == gameModel.getMaximumPlayerTruns()){

            GambleStrategy selectedStrategy = gameModel.getGambleStrategy();
            gameModel.getCurrentPlayer().setGamblingSaldo(Double.toString(gameModel.getCurrentPlayer().getGamblingSaldo()-gameModel.getCurrentBettingAmount()));

            /*update times selected for slected strategy*/
            selectedStrategy.setTimesSelected(gameModel.getGambleStrategy().getTimesSelected()+1);
            selectedStrategy.setTotalAmoutBeted(gameModel.getCurrentBettingAmount());
            gameModel.updateObservers();
        }

        /* check if player has a turn left */
        if(getGameModel().getPlayerTurnsLeft() > 0){
            /*thow the dice*/
            gameModel.setPlayerTurnsLeft(gameModel.getPlayerTurnsLeft()-1);

            int diceEyes =  getGameModel().get_random_number(1,6);
            gameModel.setDiceThrown(diceEyes);
/*
            gameModel.addDiceThrow(diceEyes);
*/
            gameModel.getDiceThrows().add(diceEyes);
        }
        if(getGameModel().getPlayerTurnsLeft() == 0) {
            /*if all dice are thrown, end game*/
            gameModel.setCurrentstate(getGameModel().endOfTurnState);
            gameModel.setTerminalOutput(" ");

            gameModel.endTurn();
        }

    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        this.errorMessage = "You can't chang your betting amount while playing";
        throw new IllegalStateException("You can't chang your betting amount while playing");
    }

    @Override
    public void endTurn() {
        throw new IllegalStateException("Throw dice first");
    }



}

package model.gambleState;

import model.GameModel;

public class ThrowDiceState extends State{
    public ThrowDiceState(GameModel model) {
        super(model);
    }

    @Override
    public void login(String name) {
        throw new IllegalStateException("je bent al ingelogt");
    }

    @Override
    public void choseStrategy() {
        throw new IllegalStateException("je hebt al een strategie gekozen");
    }

    @Override
    public void throwdice() {
        if(getGameModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getGameModel().getCurrentstate() instanceof ChoseStrategyState)throw new IllegalStateException();
        if(getGameModel().getCurrentstate() instanceof ChangeBettingAmountState)throw new IllegalStateException();

        System.out.println(getGameModel().getPlayerTurnsLeft());

        /* check if player has a turn left */
        if(getGameModel().getPlayerTurnsLeft() > 0){
            /*thow the dice*/
            int diceEyes =  getGameModel().get_random_number(1,6);
            getGameModel().setPlayerTurnsLeft(getGameModel().getPlayerTurnsLeft()-1);
            getGameModel().getDiceThrows().add(getGameModel().getDiceThrown());
            getGameModel().setDiceThrown(diceEyes);
        }
        if(getGameModel().getPlayerTurnsLeft() == 0) {
            System.out.println("end tuuuurn");
            /*if all dice are thrown, end game*/
            getGameModel().setCurrentstate(getGameModel().getEndOfTurnState());
            getGameModel().getCurrentstate().endTurn();
        }

    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        throw new IllegalStateException("je moet eerst 2 dice throws nodig");
    }

    @Override
    public void endTurn() {
        if(getGameModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getGameModel().getCurrentstate() instanceof ChoseStrategyState)throw new IllegalStateException();
        if(getGameModel().getCurrentstate() instanceof ChangeBettingAmountState)throw new IllegalStateException();
        if (getGameModel().getCurrentstate() instanceof ThrowDiceState){
            getGameModel().setCurrentstate(getGameModel().getLoginState());
        }
    }

}

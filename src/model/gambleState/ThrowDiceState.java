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
        if(getModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ChoseStrategyState)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ChangeBettingAmountState)throw new IllegalStateException();

        System.out.println(getModel().getPlayerTurnsLeft());

        /* check if player has a turn left */
        if(getModel().getPlayerTurnsLeft() >= 0){
            /*getModel().getCurrentstate().throwdice();*/
            /*thow the dice*/
            int diceEyes =  getModel().get_random_number(1,6);
            getModel().setPlayerTurnsLeft(getModel().getPlayerTurnsLeft()-1);
/*            if (getModel().getPlayerTurnsLeft() == 2) {
                getModel().setCurrentstate(getModel().getChangeBettingAmountState());
            }*/

            getModel().setDiceThrown(diceEyes);
            getModel().getDiceThrows().add(getModel().getDiceThrown());
        }
        if(getModel().getPlayerTurnsLeft() == 0) {
            System.out.println("end tuuuurn");
            /*if all dice are thrown, end game*/
            getModel().setCurrentstate(getModel().getEndOfTurnState());
            getModel().getCurrentstate().endTurn();
        }

    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        throw new IllegalStateException("je moet eerst 2 dice throws nodig");
    }

    @Override
    public void endTurn() {
        if(getModel().getCurrentstate() instanceof LoginState) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ChoseStrategyState)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof ChangeBettingAmountState)throw new IllegalStateException();
        if (getModel().getCurrentstate() instanceof ThrowDiceState){
            getModel().setCurrentstate(getModel().getLoginState());
        }
    }
}

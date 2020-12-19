package model.gambleState;

import model.GameModel;

public class LoginState extends State{
    public LoginState(GameModel model) {
        super(model);
    }

    @Override
    public void login(String name) {
/*        if(getModel().getCurrentstate() instanceof Choose) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof Trowdice)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof Changeinzet)throw new IllegalStateException();*/
        if(getGameModel().getCurrentstate() instanceof LoginState){
            if(getGameModel().getDatabase().getGamblers().keySet().contains(name)){
                System.out.println("whooop");
                getGameModel().setCurrentPlayer(getGameModel().getDatabase().getGamblers().get(name));
                getGameModel().setCurrentstate(getGameModel().getChoseStrategyState());

            }
        }
    }

    @Override
    public void choseStrategy() {
        getGameModel().setTerminalOutput("You have to login first");
        throw new IllegalStateException("You have to login");

    }

    @Override
    public void throwdice() {
        getGameModel().setTerminalOutput("You have to login first");
        throw new IllegalStateException("You have to login");
    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        getGameModel().setTerminalOutput("You have to login first");
        throw new IllegalStateException("You have to login");

    }

    @Override
    public void endTurn() {
        getGameModel().setTerminalOutput("You have to login first");
        throw new IllegalStateException("You have to login");

    }

    @Override
    public void newGame() {
        getGameModel().setTerminalOutput("You have to login first");
        throw new IllegalStateException("You have to login");

    }
}

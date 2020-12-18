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
        if(getModel().getCurrentstate() instanceof LoginState){
            if(getModel().getDatabase().getGamblers().keySet().contains(name)){
                System.out.println("whooop");
                getModel().setCurrentPlayer(getModel().getDatabase().getGamblers().get(name));
                getModel().setCurrentstate(getModel().getChoseStrategyState());

            }
        }
    }

    @Override
    public void choseStrategy() {
        getModel().setTerminalOutput("You have to login first");
        throw new IllegalStateException("You have to login");

    }

    @Override
    public void throwdice() {
        getModel().setTerminalOutput("You have to login first");
        throw new IllegalStateException("You have to login");
    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        getModel().setTerminalOutput("You have to login first");
        throw new IllegalStateException("You have to login");

    }

    @Override
    public void endTurn() {
        getModel().setTerminalOutput("You have to login first");
        throw new IllegalStateException("You have to login");

    }
}

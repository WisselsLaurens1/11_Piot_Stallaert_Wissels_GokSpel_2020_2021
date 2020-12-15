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
                getModel().setCurrentstate(getModel().getChoseStrategyState());
                getModel().setCurrentPlayer(null);
            }
        }
    }

    @Override
    public void choseStrategy() {
        getModel().setTerminalOutput("You have to login");
        throw new IllegalStateException("You have to login");

    }

    @Override
    public void throwdice() {
        getModel().setTerminalOutput("You have to login");
        throw new IllegalStateException("You have to login");
    }

    @Override
    public void changeBettingAmount() {
        getModel().setTerminalOutput("You have to login");
        throw new IllegalStateException("You have to login");

    }

    @Override
    public void eind() {
        getModel().setTerminalOutput("You have to login");
        throw new IllegalStateException("You have to login");

    }
}

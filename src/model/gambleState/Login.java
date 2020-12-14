package model.gambleState;

import model.GameModel;

public class Login extends State{
    public Login(GameModel model) {
        super(model);
    }

    @Override
    public void login(String name) {
        if(getModel().getCurrentstate() instanceof Choose) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof Trowdice)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof Changeinzet)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof Login){
            if(getModel().getDatabase().getGamblers().keySet().contains(name)){
                System.out.println("whooop");
                getModel().setCurrentstate(getModel().getChoose());
            }
        }

    }

    @Override
    public void choosestrategy() {
        throw new IllegalStateException("je moet eerst inloggen");
    }

    @Override
    public void throwdice() {
        throw new IllegalStateException("je moet eerst inloggen");
    }

    @Override
    public void changeinzet() {
        throw new IllegalStateException("je moet eerst inloggen");
    }

    @Override
    public void eind() {
        throw new IllegalStateException("je moet eerst inloggen");
    }
}

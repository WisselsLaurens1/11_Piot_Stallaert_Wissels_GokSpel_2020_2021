package model.gambleState;

import model.GameModel;

public class Choose extends State{
    public Choose(GameModel model) {
        super(model);
    }

    @Override
    public void login(String name) {
        throw new IllegalStateException("je bent al ingelogt");
    }

    @Override
    public void choosestrategy() {
        if(getModel().getCurrentstate() instanceof Login) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof Trowdice)throw new IllegalStateException();
/*
        if(getModel().getCurrentstate() instanceof Changeinzet)throw new IllegalStateException();
*/
        if(getModel().getCurrentstate() instanceof Choose){
            getModel().setCurrentstate(getModel().getTrowdice());
        }
    }

    @Override
    public void throwdice() {
        throw new IllegalStateException("je moet eerst een strategie kiezen");
    }

    @Override
    public void changeinzet() {
        throw new IllegalStateException("je moet een strategie kiezen");
    }

    @Override
    public void eind() {
        throw new IllegalStateException("je moet een strategie kiezen");
    }
}

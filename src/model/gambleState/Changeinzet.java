package model.gambleState;

import model.GameModel;

public class Changeinzet extends State{
    public Changeinzet(GameModel model) {
        super(model);
    }

    @Override
    public void login(String name) {
        throw new IllegalStateException("je bent al ingelogt");
    }

    @Override
    public void choosestrategy() {
        throw new IllegalStateException("je hebt al een strategie gekozen");
    }

    @Override
    public void throwdice() {
        if(getModel().getCurrentstate() instanceof Login) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof Choose)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof Trowdice)throw new IllegalStateException();

    }

    @Override
    public void changeinzet() {
        if(getModel().getCurrentstate() instanceof Login) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof Choose)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof Trowdice)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof Changeinzet){
            getModel().setCurrentstate(getModel().getTrowdice());
        }
    }

    @Override
    public void eind() {
        throw new IllegalStateException("je moet eerst 4 dice throws doen");
    }
}

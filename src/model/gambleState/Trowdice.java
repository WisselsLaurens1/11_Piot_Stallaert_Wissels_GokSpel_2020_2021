package model.gambleState;

import model.GameModel;

public class Trowdice extends State{
    public Trowdice(GameModel model) {
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
        if(getModel().getCurrentstate() instanceof Changeinzet)throw new IllegalStateException();

    }

    @Override
    public void changeinzet() {
        throw new IllegalStateException("je moet eerst 2 dice throws nodig");
    }

    @Override
    public void eind() {
        if(getModel().getCurrentstate() instanceof Login) throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof Choose)throw new IllegalStateException();
        if(getModel().getCurrentstate() instanceof Changeinzet)throw new IllegalStateException();
        if (getModel().getCurrentstate() instanceof  Trowdice){
            getModel().setCurrentstate(getModel().getWait());
        }
    }
}

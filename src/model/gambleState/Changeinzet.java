package model.gambleState;

import model.GameModel;

public class Changeinzet extends State{
    public Changeinzet(GameModel model) {
        super(model);
    }

    @Override
    public void login() {
        throw new IllegalStateException("je bent al ingelogt");
    }

    @Override
    public void choosestrategy() {
        throw new IllegalStateException("je hebt al een strategie gekozen");
    }

    @Override
    public void throwdice() {
        if(getModel().getCurrentstat() instanceof Wait) throw new IllegalStateException();
        if(getModel().getCurrentstat() instanceof Choose)throw new IllegalStateException();
        if(getModel().getCurrentstat() instanceof Trowdice)throw new IllegalStateException();

    }

    @Override
    public void changeinzet() {
        if(getModel().getCurrentstat() instanceof Wait) throw new IllegalStateException();
        if(getModel().getCurrentstat() instanceof Choose)throw new IllegalStateException();
        if(getModel().getCurrentstat() instanceof Trowdice)throw new IllegalStateException();
        if(getModel().getCurrentstat() instanceof Changeinzet){
            getModel().setCurrentstat(getModel().getTrowdice());
        }
    }

    @Override
    public void eind() {
        throw new IllegalStateException("je moet eerst 4 dice throws doen");
    }
}

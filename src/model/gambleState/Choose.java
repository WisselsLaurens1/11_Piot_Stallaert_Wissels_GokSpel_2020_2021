package model.gambleState;

import model.GameModel;

public class Choose extends State{
    public Choose(GameModel model) {
        super(model);
    }

    @Override
    public void login() {
        throw new IllegalStateException("je bent al ingelogt");
    }

    @Override
    public void choosestrategy() {
        if(getModel().getCurrentstat() instanceof Wait) throw new IllegalStateException();
        if(getModel().getCurrentstat() instanceof Trowdice)throw new IllegalStateException();
        if(getModel().getCurrentstat() instanceof Changeinzet)throw new IllegalStateException();
        if(getModel().getCurrentstat() instanceof Choose){
            getModel().setCurrentstat(getModel().getTrowdice());
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

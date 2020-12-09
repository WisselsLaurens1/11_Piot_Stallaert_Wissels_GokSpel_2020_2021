package model.gambleState;

import model.GameModel;

public class Wait extends State{
    public Wait(GameModel model) {
        super(model);
    }

    @Override
    public void login() {
        if(getModel().getCurrentstat() instanceof Choose) throw new IllegalStateException();
        if(getModel().getCurrentstat() instanceof Trowdice)throw new IllegalStateException();
        if(getModel().getCurrentstat() instanceof Changeinzet)throw new IllegalStateException();
        if(getModel().getCurrentstat() instanceof Wait){
            getModel().setCurrentstat(getModel().getChoose());
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

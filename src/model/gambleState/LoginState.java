package model.gambleState;

import model.GambleStrategey.GambleStrategy;
import model.GameModel;

public class LoginState extends State{
    public LoginState(GameModel model) {
        super(model);
    }


    @Override
    public void login(String name) {
        if(gameModel.getCurrentstate() instanceof LoginState){
            if(gameModel.getDatabase().getGamblers().keySet().contains(name)){
                gameModel.setCurrentPlayer(getGameModel().getDatabase().getGamblers().get(name));
                gameModel.setCurrentstate(gameModel.changeBettingAmountState);
            }
        }
    }

    @Override
    public void startGame() {
        this.errorMessage = "You have to login first";
        throw new IllegalStateException("You have to login");    }

    @Override
    public void increaseBettingAmount(int value) {
        throw new IllegalStateException("You have to login");

}

    @Override
    public void choseStrategy(GambleStrategy gambleStrategy) {
        this.errorMessage = "You have to login first";
        throw new IllegalStateException("You have to login");
    }

    @Override
    public void throwdice() throws IllegalStateException {
        this.errorMessage = "You have to login first";
        throw new IllegalStateException("You have to login");
    }

    @Override
    public void changeBettingAmount(int bettingAmount) {
        this.errorMessage = "You have to login first";
        throw new IllegalStateException("You have to login");
    }

    @Override
    public void endTurn() {
        this.errorMessage = "You have to login first";
        throw new IllegalStateException("You have to login");
    }

    @Override
    public void newGame() {
        this.errorMessage = "You have to login first";
        throw new IllegalStateException("You have to login");
    }
}

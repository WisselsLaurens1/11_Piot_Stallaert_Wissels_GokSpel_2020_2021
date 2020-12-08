package Controller;
import model.GameModel;
import view.View;

public class GamblerViewController implements Controller {

    private View view;
    private GameModel gameModel;

    public GamblerViewController(GameModel gameModel){
        this.gameModel = gameModel;
    }


    public void selectStrategey(String strategey){
        this.gameModel.setGambleStrategy(this.gameModel.getGambleStrategyHashMap().get(strategey));
    }


    // TODO: 08/12/2020 update
    public void throwDice(){
        this.gameModel.throwDice();
    }


    public void update(){};


    @Override
    public void setView(view.View view) {
        this.view = view;
    }
}



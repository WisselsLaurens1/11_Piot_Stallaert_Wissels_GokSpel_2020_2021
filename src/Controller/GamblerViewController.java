package Controller;
import model.GambleStrategey.GambleStrategies;
import model.Gambler;
import model.GameModel;
import view.View;
import view.panes.GamblerViewPanes.GamblerViewSelectStrategyPane;

import java.util.List;

public class GamblerViewController extends Controller {
    private GamblerViewSelectStrategyPane pane;


    public GamblerViewController(GameModel gameModel){
        super(gameModel);

    }

    public void setPane(GamblerViewSelectStrategyPane pane) {
        this.pane = pane;
    }

    public void updatestrategies(List<GambleStrategies> list){
        this.pane.updatestrategies(list);
    }

    public void selectStrategey(String strategey){
        gameModel.choseStrategy(gameModel.getGambleStrategyHashMap().get(strategey));
    }


    // TODO: 08/12/2020 update
    public void throwDice(){

        this.gameModel.throwDice();
    }


    public void update(){};

    public void login(String name){
        gameModel.login(name);
    }

    public void logout(){
        gameModel.logout();
    }

    public void setBettingAmount(int amount){
        gameModel.changeCurrentBettingAmount(amount);
    }

    public void startGame(){
        gameModel.startGame();
    }


    @Override
    public void setView(view.View view) {
        this.view = view;
    }
}



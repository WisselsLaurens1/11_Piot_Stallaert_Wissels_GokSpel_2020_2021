package Controller;

import model.GameModel;
import view.View;

public class GameProgressTabController extends Controller {
    public GameProgressTabController(GameModel gameModel) {
        super(gameModel);
    }

    @Override
    public void setView(View view) {

    }

    @Override
    public void update() {

    }

    public void newGame(){
        this.gameModel.newGame();
    }
}

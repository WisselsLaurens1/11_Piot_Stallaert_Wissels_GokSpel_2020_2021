package Controller;

import view.View;

public class GameProgressTabController implements Controller {
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

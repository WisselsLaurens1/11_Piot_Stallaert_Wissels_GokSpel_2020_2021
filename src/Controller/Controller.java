package Controller;

import model.GameModel;
import model.Observer;
import view.View;

public abstract class Controller implements Observer {
     public GameModel gameModel;
     public View view;

     public Controller(GameModel gameModel){
          this.gameModel = gameModel;
     }

     public void setView(View view){
          this.view = view;
     };

}

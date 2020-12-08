package Controller;

import model.GameModel;
import model.Observer;
import view.View;

public interface Controller extends Observer {
     public GameModel gameModel = null;
     public View view = null;

     public void setView(View view);

}

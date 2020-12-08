package view;

import Controller.Controller;
import model.GameModel;
import model.Observer;

public interface View extends Observer {
    public GameModel gameModel =null;
    public Controller controller =null;

}

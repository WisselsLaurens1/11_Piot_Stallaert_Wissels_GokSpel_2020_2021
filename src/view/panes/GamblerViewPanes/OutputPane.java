package view.panes.GamblerViewPanes;

import Controller.Controller;
import model.GameModel;

public class OutputPane extends CustomGridPane {
    public OutputPane(GameModel gameModel, Controller viewController, int rows, int columns) {
        super(gameModel, viewController, rows, columns);
    }

    @Override
    public void update() {

    }
}

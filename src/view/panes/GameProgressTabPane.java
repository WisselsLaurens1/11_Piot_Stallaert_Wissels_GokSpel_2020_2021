package view.panes;

import Controller.Controller;
import javafx.scene.control.Label;
import model.GameModel;
import view.panes.GamblerViewPanes.customGridPane;

public class GameProgressTabPane extends customGridPane {
    public GameProgressTabPane(GameModel gameModel, Controller controller){
        super(gameModel,controller,2,2);

/*
        this.setStyle("-fx-font-size: 2em");
*/
        Label gameCount = new Label("Game: ");
        this.containerPane.add(gameCount,0,0);
        Label currentPlayer = new Label("Current player: ");
        this.containerPane.add(currentPlayer,0,1);
        Label bettingAmount = new Label("Amount betted: ");
        this.containerPane.add(bettingAmount,0,2);
    }


}

package view.panes;

import Controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.GameModel;
import view.panes.GamblerViewPanes.customGridPane;
import Controller.GameProgressTabController;
import Controller.GamblerViewController;

public class GameProgressTabPane extends customGridPane {
    public GameProgressTabPane(GameModel gameModel, Controller controller){
        super(gameModel,controller,2,2);
        this.containerPane.setStyle("-fx-font-size: 2em");

       GameProgressTabController myController = (GameProgressTabController) this.getViewController();

        GridPane contentContainer = new GridPane();
        contentContainer.setGridLinesVisible(true);
        Label gameCount = new Label("Game: ");
        contentContainer.add(gameCount,0,0);
        Label currentPlayer = new Label("Current player: ");
        contentContainer.add(currentPlayer,0,1);
        Label bettingAmount = new Label("Amount beted: ");
        contentContainer.add(bettingAmount,0,2);
        Label selectedStrategy = new Label("Selected strategy: ");
        contentContainer.add(selectedStrategy,0,3);
        Label diceThrows = new Label("Dice throws: ");
        contentContainer.add(diceThrows,0,4);
        Label result = new Label("Result: ");
        contentContainer.add(result,0,5);
        contentContainer.setId("contentContainer");

        Button newGame = new Button("New game");
        contentContainer.add(newGame,0,7);

        newGame.setOnAction((e)->{
            myController.newGame();
        });

        this.containerPane.add(contentContainer,0,0);



    }


}

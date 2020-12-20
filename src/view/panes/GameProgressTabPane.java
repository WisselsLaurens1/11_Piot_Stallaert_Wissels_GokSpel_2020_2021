package view.panes;

import Controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import model.GameModel;
import view.panes.GamblerViewPanes.CustomLabel;
import view.panes.GamblerViewPanes.CustomGridPane;
import Controller.GameProgressTabController;

public class GameProgressTabPane extends CustomGridPane {

    CustomLabel gameCount;
    CustomLabel currentPlayer;
    CustomLabel selectedStrategy;
    CustomLabel diceThrows;
    CustomLabel bettedAmount;
    CustomLabel result;

    public GameProgressTabPane(GameModel gameModel, Controller controller){


        super(gameModel,controller,2,1);
        this.containerPane.setStyle("-fx-font-size: 2em");

        gameCount = new CustomLabel("Game: ",gameModel,"getGameCount()",gameModel);
        currentPlayer = new CustomLabel("Current player: ",gameModel,"getCurrentPlayer().getName()",gameModel);
        selectedStrategy = new CustomLabel("Selected strategy: ",gameModel,"getGambleStrategy().getName()",gameModel);
        diceThrows = new CustomLabel("Dice throws: ",gameModel,"getDiceThrows()",gameModel);
        bettedAmount = new CustomLabel("Amount betted: ",gameModel,"getCurrentBettingAmount()",gameModel);
        result = new CustomLabel("Result: ",gameModel,"getCurrentBettingAmount()",gameModel);

        GameProgressTabController myController = (GameProgressTabController) this.getViewController();

        GridPane contentContainer = new GridPane();

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);

        contentContainer.getColumnConstraints().addAll(column1);

        contentContainer.add(gameCount.label,0,0);
        contentContainer.add(currentPlayer.label,0,1);
        contentContainer.add(bettedAmount.label,0,2);
        contentContainer.add(selectedStrategy.label,0,3);
        contentContainer.add(diceThrows.label,0,4);
        contentContainer.add(result.label,0,5);
        contentContainer.setId("contentContainer");

        Button newGame = new Button("New game");
        contentContainer.add(newGame,0,7);

        newGame.setOnAction((e)->{
            myController.newGame();
        });

        this.containerPane.add(contentContainer,0,0);



    }


    @Override
    public void update(){
        gameCount.update();
        currentPlayer.update();
        selectedStrategy.update();
        diceThrows.update();
        bettedAmount.update();
        result.update();

    }
}

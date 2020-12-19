package view.panes;

import Controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.GambleStrategey.GambleStrategy;
import model.Gambler;
import model.GameModel;
import view.panes.GamblerViewPanes.CustomLabel;
import view.panes.GamblerViewPanes.customGridPane;
import Controller.GameProgressTabController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class GameProgressTabPane extends customGridPane {


    private Label CurrentPlayer = new Label("Current player: ");
    private  Label GameCount = new Label("Game: ");
/*
    private Label CurrentBettingAmount = new Label("Amount beted: ");
*/
/*
    private Label GambleStrategy = new Label("Selected strategy: ");
*/
/*
    private Label DiceThrows = new Label("Dice throws: ");
*/
    private Label result = new Label("Result: ");
    private ArrayList<Label> labels = new ArrayList<Label>();
    CustomLabel test = new CustomLabel("Current player: ","getCurrentPlayer().getName()",null);
    CustomLabel GambleStrategy = new CustomLabel("Selected strategy: ","getGambleStrategy().getName()",null);
    CustomLabel DiceThrows = new CustomLabel("Dice throws: ","getDiceThrows()",null);
    CustomLabel CurrentBettingAmount = new CustomLabel("Amount beted: ","getCurrentBettingAmount()",null);


    public GameProgressTabPane(GameModel gameModel, Controller controller){


        super(gameModel,controller,2,2);
        this.containerPane.setStyle("-fx-font-size: 2em");

        test.setGameModel(gameModel);
        GambleStrategy.setGameModel(gameModel);
        DiceThrows.setGameModel(gameModel);
        CurrentBettingAmount.setGameModel(gameModel);
/*
        labels.add(CurrentPlayer);
*/
/*        labels.add(GambleStrategy);
        labels.add(DiceThrows);*/

/*
        this.getGameModel().getCurrentPlayer().get
*/

        GameProgressTabController myController = (GameProgressTabController) this.getViewController();

        System.out.println(gameModel.getDiceThrows());

        GridPane contentContainer = new GridPane();
        contentContainer.setGridLinesVisible(true);
        contentContainer.add(GameCount,0,0);
        contentContainer.add(test.label,0,1);
        contentContainer.add(CurrentBettingAmount.label,0,2);
        contentContainer.add(GambleStrategy.label
                ,0,3);
        contentContainer.add(DiceThrows.label,0,4);
        contentContainer.add(result,0,5);
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
        test.update();
        GambleStrategy.update();
        DiceThrows.update();
        CurrentBettingAmount.update();

    }
}

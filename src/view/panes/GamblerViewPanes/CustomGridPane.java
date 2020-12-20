package view.panes.GamblerViewPanes;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import model.GameModel;
import model.Observer;

public abstract class CustomGridPane extends GridPane implements Observer {

    public GameModel getGameModel() {
        return gameModel;
    }

    public Controller getViewController() {
        return viewController;
    }

    private GameModel gameModel;
    private Controller viewController;
    public GridPane containerPane;


    public CustomGridPane(GameModel gameModel, Controller viewController, int rows, int columns){
        this.gameModel = gameModel;
        this.viewController = viewController;
        GridPane containerPane = new GridPane();
        this.containerPane = containerPane;
        this.getStylesheets().add("stylesheets/GamblerViewStylesheet.css");

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        this.getColumnConstraints().addAll(column1);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100);
        this.getRowConstraints().addAll(row1);

        this.add(containerPane,0,0);
        containerPane.setId("containerPane");
/*
        containerPane.setGridLinesVisible(true);
*/
        this.containerPane.setStyle("-fx-font-size: 1.2em");

        this.setStyle("-fx-background-color: #136399");

        /*adding collumns*/
        for(int i=0; i<columns; i++){
            ColumnConstraints column = new ColumnConstraints();
            column.setPrefWidth(500/columns);
            containerPane.getColumnConstraints().add(column);
        }
        /*adding rows*/
        for(int i=0; i<rows; i++){
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100/rows);
            containerPane.getRowConstraints().add(row);
        }

        this.setMargin(containerPane, new Insets(0, 10, 0, 10));

        containerPane.setHgap(10);


    }






}

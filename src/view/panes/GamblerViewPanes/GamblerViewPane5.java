package view.panes.GamblerViewPanes;

import Controller.Controller;
import Controller.GamblerViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import model.GameModel;

public class GamblerViewPane5 extends GridPane {


    private GameModel gameModel;
    private GamblerViewController controller;
    public GamblerViewPane5(GameModel gameModel, Controller gameblerViewController){

        // TODO: 06/12/2020  set minmium size


        this.setId("Pane5");
        this.gameModel = gameModel;
        this.controller = (GamblerViewController) gameblerViewController;

/*
        this.setGridLinesVisible(true);
*/

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPrefWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPrefWidth(510);

        this.getColumnConstraints().addAll(column1, column2); // each get 50% of width

        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(30);
        RowConstraints row2 = new RowConstraints();
        row2.setPrefHeight(130);
        this.getRowConstraints().addAll(row1,row2);

        Pane terminal = new Pane();


        Label output = new Label("Output");
        terminal.setStyle("-fx-background-color: white;");

        this.add(output, 0,0);
        this.add(terminal, 0,1,2
                ,1);
        this.setHgap(20); //horizontal gap in pixels => that's what you are asking for
        this.setPadding(new Insets(20, 10, 10, 10)); //margins around the whole grid





        this.getStylesheets().add("stylesheets/GamblerViewStylesheet.css");


    }

    public void update() {
        System.out.println("update");
    }
}

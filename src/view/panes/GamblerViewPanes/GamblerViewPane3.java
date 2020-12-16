package view.panes.GamblerViewPanes;

import Controller.Controller;
import Controller.GamblerViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import model.GameModel;

public class GamblerViewPane3 extends GridPane {


    private GameModel gameModel;
    private GamblerViewController controller;
    public GamblerViewPane3(GameModel gameModel, Controller gameblerViewController){

        // TODO: 06/12/2020  set minmium size


        this.setId("Pane3");
        this.gameModel = gameModel;
        this.controller = (GamblerViewController) gameblerViewController;

/*
        this.setGridLinesVisible(true);
*/

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column2 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column3 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column4 = new ColumnConstraints();
        column1.setPercentWidth(25);


        this.getColumnConstraints().addAll(column1, column2,column3,column4); // each get 50% of width
        this.setGridLinesVisible(true);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100/3);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(100/3);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(100/3);
        this.getRowConstraints().addAll(row1,row2,row3);

        Label label1 = new Label("Enter bet amount");
        Button confirmButton = new Button("Confirm");
        TextField bettingAmount = new TextField ();
        this.add(label1, 0,1);
        this.add(bettingAmount, 1,1);
        this.add(confirmButton, 2,1);
        this.setHgap(10); //horizontal gap in pixels => that's what you are asking for
        this.setHgap(10); //horizontal gap in pixels => that's what you are asking for

        this.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid


        confirmButton.setOnAction((e)->{
            controller.setBettingAmount(Integer.parseInt(bettingAmount.getText()));
        });




        this.getStylesheets().add("stylesheets/GamblerViewStylesheet.css");


    }

    public void update() {
        System.out.println("update");
    }
}

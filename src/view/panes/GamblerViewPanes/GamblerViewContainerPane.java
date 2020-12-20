package view.panes.GamblerViewPanes;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import model.GameModel;


public class GamblerViewContainerPane extends GridPane {

    private GameModel model;
    private Controller controller;
    private GamblerViewSelectStrategyPane gamblerViewSelectStrategyPane;
    private GamblerViewLoginPane gamblerViewLoginPane;
    private GamblerViewThrowDicePane gamblerViewThrowDicePane;
    private GamblerViewEnterBettingAmountPane gamblerViewEnterBettingAmountPane;
    private GamblerViewOutputPane gamblerViewOutputPane;

    public GamblerViewContainerPane(GameModel model, Controller gamblerViewController){

        this.model = model;
        this.controller = gamblerViewController;


        // TODO: 06/12/2020  set minmium size

        this.setId("containerView");


        // TODO: 06/12/2020 implemnt 3 row better cause of little bit of screen left on bottom
        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(120);
        RowConstraints row2 = new RowConstraints();
        row2.setPrefHeight(120);
        RowConstraints row3 = new RowConstraints();
        row3.setPrefHeight(60);
        RowConstraints row4 = new RowConstraints();
        row4.setPrefHeight(190);
        RowConstraints row5 = new RowConstraints();
        row5.setPrefHeight(110);
        this.getRowConstraints().addAll(row1,row2,row3,row4,row5);



        GamblerViewLoginPane gamblerViewLoginPane = new GamblerViewLoginPane(model,this.controller);
        GamblerViewSelectStrategyPane gamblerViewSelectStrategyPane = new GamblerViewSelectStrategyPane(model,this.controller);
        GamblerViewThrowDicePane gamblerViewThrowDicePane = new GamblerViewThrowDicePane(model,this.controller);
        GamblerViewEnterBettingAmountPane gamblerPane3 = new GamblerViewEnterBettingAmountPane(model,this.controller);
        GamblerViewOutputPane gamblerPane5 = new GamblerViewOutputPane(model,this.controller);

        this.gamblerViewSelectStrategyPane = gamblerViewSelectStrategyPane;
        this.gamblerViewLoginPane = gamblerViewLoginPane;
        this.gamblerViewThrowDicePane = gamblerViewThrowDicePane;
        this.gamblerViewEnterBettingAmountPane = gamblerPane3;
        this.gamblerViewOutputPane = gamblerPane5;

        gamblerViewSelectStrategyPane.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid
        gamblerViewLoginPane.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid
        gamblerViewThrowDicePane.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid
        gamblerViewEnterBettingAmountPane.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid
        gamblerPane5.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid

/*
        OutputPane test = new OutputPane(model, controller,4,4);
*/


        this.add(gamblerViewLoginPane, 0, 0,1,1);
        this.add(gamblerViewSelectStrategyPane,0,1,1,1);
        this.add(gamblerPane3,0,2,1,1);
        this.add(gamblerViewThrowDicePane,0,3,1,1);
        this.add(gamblerPane5,0,4);

        this.getStylesheets().add("stylesheets/GamblerViewStylesheet.css");


    }

    public void update() {
        gamblerViewLoginPane.update();
        gamblerViewSelectStrategyPane.update();
        gamblerViewThrowDicePane.update();
        gamblerViewEnterBettingAmountPane.update();
        gamblerViewOutputPane.update();

    }
}

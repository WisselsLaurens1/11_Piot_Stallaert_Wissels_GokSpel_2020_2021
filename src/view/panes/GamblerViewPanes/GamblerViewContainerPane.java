package view.panes.GamblerViewPanes;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import model.GameModel;


public class GamblerViewContainerPane extends GridPane {

    private GameModel model;
    private Controller controller;
    private GamblerViewMiddlePane gamblerViewMiddlePane;
    private GamblerViewTopPane gamblerViewTopPane;
    private GamblerViewBottomPane gamblerViewBottomPane;
    private GamblerViewPane3 gamblerViewPane3;
    private GamblerViewPane5 gamblerViewPane5;

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



        GamblerViewTopPane gamblerViewTopPane = new GamblerViewTopPane(model,this.controller);
        GamblerViewMiddlePane gamblerViewMiddlePane = new GamblerViewMiddlePane(model,this.controller);
        GamblerViewBottomPane gamblerViewBottomPane = new GamblerViewBottomPane(model,this.controller);
        GamblerViewPane3 gamblerPane3 = new GamblerViewPane3(model,this.controller);
        GamblerViewPane5 gamblerPane5 = new GamblerViewPane5(model,this.controller);

        this.gamblerViewMiddlePane = gamblerViewMiddlePane;
        this.gamblerViewTopPane = gamblerViewTopPane;
        this.gamblerViewBottomPane = gamblerViewBottomPane;
        this.gamblerViewPane3 = gamblerPane3;
        this.gamblerViewPane5  = gamblerPane5;

        gamblerViewMiddlePane.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid
        gamblerViewTopPane.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid
        gamblerViewBottomPane.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid
        gamblerViewPane3.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid
        gamblerPane5.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid



        this.add(gamblerViewTopPane, 0, 0,1,1);
        this.add(gamblerViewMiddlePane,0,1,1,1);
        this.add(gamblerPane3,0,2,1,1);
        this.add(gamblerViewBottomPane,0,3,1,1);
        this.add(gamblerPane5,0,4,1,1);

        this.getStylesheets().add("stylesheets/GamblerViewStylesheet.css");


    }

    public void update() {
        System.out.println("updating");
        gamblerViewTopPane.update();
        gamblerViewMiddlePane.update();
        gamblerViewBottomPane.update();
        gamblerViewPane3.update();
        gamblerViewPane5.update();

    }
}

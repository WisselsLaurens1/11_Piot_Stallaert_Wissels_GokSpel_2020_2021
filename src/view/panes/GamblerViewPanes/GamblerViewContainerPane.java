package view.panes.GamblerViewPanes;

import Controller.Controller;
import javafx.scene.layout.*;
import model.GameModel;

import java.util.ArrayList;


public class GamblerViewContainerPane extends GridPane {

    private GameModel model;
    private Controller controller;
    private GamblerViewMiddlePane gamblerViewMiddlePane;
    private GamblerViewTopPane gamblerViewTopPane;
    private GamblerViewBottomPane gamblerViewBottomPane;

    public GamblerViewContainerPane(GameModel model, Controller gamblerViewController){

        this.model = model;
        this.controller = gamblerViewController;


        // TODO: 06/12/2020  set minmium size

        this.setId("containerView");


        // TODO: 06/12/2020 implemnt 3 row better cause of little bit of screen left on bottom
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100/3);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(100/3);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(100/3);
        this.getRowConstraints().addAll(row1,row2,row3);

        GamblerViewTopPane gamblerViewTopPane = new GamblerViewTopPane();
        GamblerViewMiddlePane gamblerViewMiddlePane = new GamblerViewMiddlePane(model,this.controller);
        GamblerViewBottomPane gamblerViewBottomPane = new GamblerViewBottomPane(model,this.controller
        );

        this.gamblerViewMiddlePane = gamblerViewMiddlePane;
        this.gamblerViewTopPane = gamblerViewTopPane;
        this.gamblerViewBottomPane = gamblerViewBottomPane;


        this.add(gamblerViewTopPane, 0, 0,1,1);
        this.add(gamblerViewMiddlePane,0,1,1,1);
        this.add(gamblerViewBottomPane,0,2,1,1);
        this.getStylesheets().add("stylesheets/GamblerViewStylesheet.css");


    }

    public void update() {
        gamblerViewTopPane.update();
        gamblerViewMiddlePane.update();
        gamblerViewBottomPane.update();
    }
}
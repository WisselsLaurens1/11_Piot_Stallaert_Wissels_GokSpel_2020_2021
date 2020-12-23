package view.panes.GamblerViewPanes;

import Controller.Controller;
import javafx.scene.layout.*;
import model.GameModel;


public class GamblerViewContainerPane extends GridPane {

    private GameModel gameModel;
    private Controller controller;
    private GamblerViewSelectStrategyPane gamblerViewSelectStrategyPane;
    private GamblerViewLoginPane gamblerViewLoginPane;
    private GamblerViewThrowDicePane gamblerViewThrowDicePane;
    private GamblerViewEnterBettingAmountPane gamblerViewEnterBettingAmountPane;
    private GamblerViewOutputPane gamblerViewOutputPane;

    public GamblerViewContainerPane(GameModel gameModel, Controller gamblerViewController){

        this.gameModel = gameModel;
        this.controller = gamblerViewController;

        this.setId("containerView");

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

        GamblerViewLoginPane gamblerViewLoginPane = new GamblerViewLoginPane(this.gameModel,this.controller);
        GamblerViewSelectStrategyPane gamblerViewSelectStrategyPane = new GamblerViewSelectStrategyPane(this.gameModel,this.controller);
        GamblerViewThrowDicePane gamblerViewThrowDicePane = new GamblerViewThrowDicePane(this.gameModel,this.controller);
        GamblerViewEnterBettingAmountPane bettingAmountPane = new GamblerViewEnterBettingAmountPane(this.gameModel,this.controller);
        GamblerViewOutputPane outputPane = new GamblerViewOutputPane(this.gameModel,this.controller);

        this.gamblerViewSelectStrategyPane = gamblerViewSelectStrategyPane;
        this.gamblerViewLoginPane = gamblerViewLoginPane;
        this.gamblerViewThrowDicePane = gamblerViewThrowDicePane;
        this.gamblerViewEnterBettingAmountPane = bettingAmountPane;
        this.gamblerViewOutputPane = outputPane;

        this.add(gamblerViewLoginPane, 0, 0,1,1);
        this.add(gamblerViewSelectStrategyPane,0,1,1,1);
        this.add(bettingAmountPane,0,2,1,1);
        this.add(gamblerViewThrowDicePane,0,3,1,1);
        this.add(outputPane,0,4);

    }

    public void update() {
        gamblerViewLoginPane.update();
        gamblerViewSelectStrategyPane.update();
        gamblerViewThrowDicePane.update();
        gamblerViewEnterBettingAmountPane.update();
        gamblerViewOutputPane.update();

    }
}

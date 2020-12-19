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

public class GamblerViewEnterBettingAmountPane3 extends CustomGridPane {


    private GameModel gameModel;
    private GamblerViewController controller;
    public GamblerViewEnterBettingAmountPane3(GameModel gameModel, Controller gameblerViewController){
        super(gameModel, gameblerViewController,1,8);

        GamblerViewController myController = (GamblerViewController) gameblerViewController;

        Label label1 = new Label("Enter bet amount");
        this.containerPane.add(label1,0,0,3,1);
        TextField bettingAmount = new TextField ();
        this.containerPane.add(bettingAmount,2,0,2,1);
        Button confirmButton = new Button("Confirm");
        this.containerPane.add(confirmButton,4,0,2,1);

        confirmButton.setOnAction((e)->{
            myController.setBettingAmount(Integer.parseInt(bettingAmount.getText()));
        });
    }

    public void update() {
    }
}

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

public class GamblerViewEnterBettingAmountPane extends CustomGridPane {

    CustomLabel enteredAmount;
    public GamblerViewEnterBettingAmountPane(GameModel gameModel, Controller gameblerViewController){
        super(gameModel, gameblerViewController,2,8);

        GamblerViewController myController = (GamblerViewController) gameblerViewController;

        Label label1 = new Label("Enter bet amount");
        this.containerPane.add(label1,0,0,3,1);
        TextField bettingAmount = new TextField ();
        this.containerPane.add(bettingAmount,2,0,2,1);
        Button confirmButton = new Button("Confirm");
        this.containerPane.add(confirmButton,4,0,2,1);
        this.enteredAmount = new CustomLabel ("Entered amount: ", gameModel,"getCurrentBettingAmount()");
        this.containerPane.add(enteredAmount.label,0,1,4,1);

        Button startButton = new Button("Start game");
        this.containerPane.add(startButton, 6,0,2,1);

        confirmButton.setOnAction((e)->{
            try{
                myController.setBettingAmount(Integer.parseInt(bettingAmount.getText()));
                bettingAmount.clear();
            }catch(NumberFormatException err){

            }

        });

        startButton.setOnAction((e) ->{
            myController.startGame();
        });
    }

    public void update() {
        enteredAmount.update();
    }

}

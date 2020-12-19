package view.panes.GamblerViewPanes;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import model.GameModel;
import Controller.GamblerViewController;
import view.View;

import java.util.ArrayList;


public class GamblerViewThrowDicePane extends CustomGridPane {

    private GameModel gameModel;
    private GamblerViewController controller;
    private ArrayList<Label> diceThrows;
    private Label playerTurnsLeft;

    public GamblerViewThrowDicePane(GameModel gameModel, Controller gameblerViewController){
        super(gameModel,gameblerViewController,6,8);
        GamblerViewController myController = (GamblerViewController) gameblerViewController;

/*        this.gameModel = gameModel;
        this.controller = (GamblerViewController) gameblerViewController;


        this.setId("bottomView");
        this.getStylesheets().add("stylesheets/GamblerViewStylesheet.css");


        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        this.setGridLinesVisible(true);

        this.getColumnConstraints().addAll(column1, column2); // each get 50% of width
*//*
        this.setGridLinesVisible(true);
*//*
        this.setHgap(20); //horizontal gap in pixels => that's what you are asking for
        this.setPadding(new Insets(20, 10, 10, 10)); //margins around the whole grid

        for(int i = 0; i<6;i++){
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100/6);
            this.getRowConstraints().addAll(row);
        }

        Button throwDice = new Button("Throw Dice");
        this.add(throwDice,0,1);
        Label playerTurnsLeft = new Label("Turns left: "+this.gameModel.getPlayerTurnsLeft());
        this.playerTurnsLeft = playerTurnsLeft;
        this.add(playerTurnsLeft,0,3);


        ArrayList<Label> diceThrows = new ArrayList<>();
        for (int i = 1; i<this.gameModel.getMaximumPlayerTruns()+1; i++){
            diceThrows.add(new Label("Dice throw: "));
            System.out.println(i);
            this.add(diceThrows.get(i-1),1,i+1);
        }
        this.diceThrows = diceThrows;




                *//*action for throwing button*//*
        throwDice.setOnAction((e) -> {
            this.controller.throwDice();
        });*/


    }


    public void update() {
        if(gameModel.getDiceThrows().size() == 0){
            for(int i = 0; i<gameModel.getMaximumPlayerTruns();i++){
                this.diceThrows.get(i).setText("Dice throw: ");
            }
        }else{
            int diceEyes = this.gameModel.getDiceThrown();
            if(diceEyes != -1){
                int throwIndex = this.gameModel.getMaximumPlayerTruns()-this.gameModel.getPlayerTurnsLeft()-1;
                this.diceThrows.get(throwIndex).setText("Dice throw: "+Integer.toString(diceEyes));
                this.playerTurnsLeft.setText("Turns left: "+gameModel.getPlayerTurnsLeft());
            }
        }

/*        int diceEyes = this.gameModel.getDiceThrown();
        if(diceEyes != -1){
            int throwIndex = this.gameModel.getMaximumPlayerTruns()-this.gameModel.getPlayerTurnsLeft()-1;
            this.diceThrows.get(throwIndex).setText("Dice throw: "+Integer.toString(diceEyes));
            this.playerTurnsLeft.setText("Turns left: "+gameModel.getPlayerTurnsLeft());
        }*/

    }

}
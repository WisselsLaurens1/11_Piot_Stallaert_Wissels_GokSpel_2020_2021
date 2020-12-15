package view.panes.GamblerViewPanes;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import model.GameModel;
import Controller.GamblerViewController;

import java.util.ArrayList;


public class GamblerViewBottomPane extends GridPane {

    private GameModel gameModel;
    private GamblerViewController controller;
    private ArrayList<Label> diceThrows;

    public GamblerViewBottomPane(GameModel gameModel, Controller gameblerViewController){

        this.gameModel = gameModel;
        this.controller = (GamblerViewController) gameblerViewController;



        // TODO: 06/12/2020  set minmium size

        this.setId("bottomView");
        this.getStylesheets().add("stylesheets/GamblerViewStylesheet.css");


        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);

        this.getColumnConstraints().addAll(column1, column2); // each get 50% of width
/*
        this.setGridLinesVisible(true);
*/
        this.setHgap(20); //horizontal gap in pixels => that's what you are asking for
        this.setPadding(new Insets(20, 10, 10, 10)); //margins around the whole grid

        for(int i = 0; i<6;i++){
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100/6);
            this.getRowConstraints().addAll(row);
        }

        Button throwDice = new Button("Throw Dice");
        this.add(throwDice,0,0);

        ArrayList<Label> diceThrows = new ArrayList<>();
        for (int i = 1; i<this.gameModel.getMaximumPlayerTruns()+1; i++){
            diceThrows.add(new Label("Dice throw: "));
            System.out.println(i);
            this.add(diceThrows.get(i-1),0,i+1);
        }
        this.diceThrows = diceThrows;




                /*action for throwing button*/
        throwDice.setOnAction((e) -> {
            this.controller.throwDice();
        });


    }


    // TODO: 08/12/2020 should this logic be in controller?
    public void update() {
        int diceEyes = this.gameModel.getDiceThrown();
        if(diceEyes != -1){
            int throwIndex = this.gameModel.getMaximumPlayerTruns()-this.gameModel.getPlayerTurnsLeft()-1;
            this.diceThrows.get(throwIndex).setText("Dice throw: "+Integer.toString(diceEyes));
        }

    }

}

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

    private CustomLabel playerTurnsLeft;
    private ArrayList<CustomLabel> diceThrows = new ArrayList<>();


    public GamblerViewThrowDicePane(GameModel gameModel, Controller gameblerViewController){
        super(gameModel,gameblerViewController,5,8);
        GamblerViewController myController = (GamblerViewController) gameblerViewController;

        this.playerTurnsLeft = new CustomLabel("Turns left: ","getPlayerTurnsLeft()",gameModel);
        this.containerPane.add(playerTurnsLeft.label,0,1,2,1);
        Button throwDice = new Button("Throw Dice");
        this.containerPane.add(throwDice,2,1,2,1);

        for (int i = 1; i<this.getGameModel().getMaximumPlayerTruns()+1; i++){
            diceThrows.add(new CustomLabel("Dice throw: ","getDiceThrown()",gameModel));
            System.out.println(i);
            this.containerPane.add(diceThrows.get(i-1).label,4,i,2,1);
        }

        throwDice.setOnAction((e) -> {
            myController.throwDice();
        });

    }

    public void update() {
            playerTurnsLeft.update();

            if(this.getGameModel().getDiceThrown() == -1){
                for(CustomLabel label: diceThrows){
                    label.update();
                }
            }

            if(this.getGameModel().getPlayerTurnsLeft() >= 1){
                diceThrows.get(this.getGameModel().getDiceThrows().size()).update();
            }else{
                diceThrows.get(this.getGameModel().getMaximumPlayerTruns()-this.getGameModel().getPlayerTurnsLeft()-1).update();
            }


    }

}

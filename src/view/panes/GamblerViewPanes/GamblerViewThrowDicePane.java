package view.panes.GamblerViewPanes;

import Controller.Controller;
import javafx.scene.control.Button;
import model.GameModel;
import Controller.GamblerViewController;
import java.util.ArrayList;


public class GamblerViewThrowDicePane extends CustomGridPane {

    private CustomLabel playerTurnsLeft;
    private ArrayList<CustomLabel> diceThrows = new ArrayList<>();

    public GamblerViewThrowDicePane(GameModel gameModel, Controller gameblerViewController){
        super(gameModel,gameblerViewController,4,8);
        GamblerViewController myController = (GamblerViewController) gameblerViewController;

        this.playerTurnsLeft = new CustomLabel("Turns left: ",gameModel,"getPlayerTurnsLeft()");
        this.containerPane.add(playerTurnsLeft.label,0,0,2,1);
        Button throwDice = new Button("Throw Dice");
        this.containerPane.add(throwDice,2,0,2,1);

        for (int i = 0; i<this.getGameModel().getMaximumPlayerTruns()+1; i++){
            diceThrows.add(new CustomLabel("Dice throw: ",gameModel,"getDiceThrown()"));
            this.containerPane.add(diceThrows.get(i).label,4,i,2,1);
        }

        throwDice.setOnAction((e) -> {
            myController.throwDice();
        });

    }

    public void update() {
            playerTurnsLeft.update();
            /*reset all dice*/
            if(this.getGameModel().getDiceThrown() == -1){
                for(CustomLabel label: diceThrows){
                    label.update();
                }
            }else{
                /*update dice throws*/
                if(this.getGameModel().getPlayerTurnsLeft() >= 1){
                    diceThrows.get(this.getGameModel().getDiceThrows().size()).update();

                }else{
                    diceThrows.get(this.getGameModel().getDiceThrows().size()).update();
                }
            }



    }

}

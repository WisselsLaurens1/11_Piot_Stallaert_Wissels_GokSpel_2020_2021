package view.panes;

import Controller.Controller;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.shape.LineBuilder;
import model.GambleStrategey.GambleStrategy;
import model.GameModel;
import view.panes.GamblerViewPanes.CustomGridPane;
import Controller.StrategiesInfoController;
import view.panes.GamblerViewPanes.CustomLabel;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.HashMap;

public class StrategiesInfoPane extends CustomGridPane {
    private ArrayList<ArrayList<CustomLabel>> labels = new ArrayList<>();

    public StrategiesInfoPane(GameModel gameModel, Controller viewController) {
        super(gameModel, viewController, 10, 10);

        HashMap<String,GambleStrategy> gambleStrategies = gameModel.getGambleStrategyHashMap();

        ArrayList<GambleStrategy> strategies = gameModel.getGambleStrategies();
        System.out.println(strategies);


/*
        this.containerPane.setGridLinesVisible(true);
*/
        int i = 0;
        for(GambleStrategy gs: gambleStrategies.values()){
            Label label = new Label(gs.getName());
            this.containerPane.add(label,0,i,4,1);

            ArrayList<CustomLabel> gsLabels = new ArrayList<>();
            CustomLabel timesSelected = new CustomLabel("Times selected: ",gs,"getTimesSelected()",gameModel);
            this.containerPane.add(timesSelected.label,3,i,4,1);
            CustomLabel timesWon = new CustomLabel("Times won: ",gs,"getTotalWins()",gameModel);
            this.containerPane.add(timesWon.label,5,i,4,1);
            CustomLabel totalProfit = new CustomLabel("Total profit: ",gs,"getTotalProfit()",gameModel);
            this.containerPane.add(totalProfit.label,7,i,4,1);

            gsLabels.add(timesSelected);
            gsLabels.add(timesWon);
            gsLabels.add(totalProfit);

            labels.add(gsLabels);

            i++;
        }
    }


    @Override
    public void update() {
        for(ArrayList<CustomLabel> list: labels){
            for(CustomLabel label : list){
                label.update();
            }
        }
    }
}

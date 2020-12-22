package view.panes.AdminViewPanes;

import Controller.Controller;
import javafx.scene.control.Label;
import model.GambleStrategey.GambleStrategy;
import model.GameModel;
import view.panes.GamblerViewPanes.CustomGridPane;
import view.panes.GamblerViewPanes.CustomLabel;
import java.util.ArrayList;
import java.util.HashMap;

public class StrategiesInfoPane extends CustomGridPane {
    private ArrayList<ArrayList<CustomLabel>> labels = new ArrayList<>();

    public StrategiesInfoPane(GameModel gameModel, Controller viewController) {
        super(gameModel, viewController, 10, 10);

        HashMap<String,GambleStrategy> gambleStrategies = gameModel.getGambleStrategyHashMap();

        int i = 0;
        for(GambleStrategy gs: gambleStrategies.values()){
            Label label = new Label(gs.getName());
            int j = (i*2);
            this.containerPane.add(label,0,j,4,1);
            ArrayList<CustomLabel> gsLabels = new ArrayList<>();
            CustomLabel timesSelected = new CustomLabel("Times selected: ",gs,"getTimesSelected()");
            this.containerPane.add(timesSelected.label,3,j,4,1);
            CustomLabel timesWon = new CustomLabel("Times won: ",gs,"getTotalWins()");
            this.containerPane.add(timesWon.label,6,j,4,1);
            CustomLabel totalBettedAmount = new CustomLabel("Total amount betted: ",gs,"getTotalAmoutBeted()");
            this.containerPane.add(totalBettedAmount.label,3,j+1,3,1);
            CustomLabel totalProfit = new CustomLabel("Total profit: ",gs,"getTotalProfit()");
            this.containerPane.add(totalProfit.label,6,j+1,4,1);

            gsLabels.add(timesSelected);
            gsLabels.add(timesWon);
            gsLabels.add(totalProfit);
            gsLabels.add(totalBettedAmount);

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

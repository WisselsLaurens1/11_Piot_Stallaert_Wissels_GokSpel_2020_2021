package view.panes.GamblerViewPanes;

import Controller.Controller;
import Controller.GamblerViewController;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import model.GambleStrategey.GambleStrategies;
import model.GambleStrategey.GambleStrategy;
import model.GameModel;
import model.PropertiesHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;


public class GamblerViewSelectStrategyPane extends CustomGridPane{
    private ComboBox<String> comboBoxGambleStrategies;
    private PropertiesHandler handler =new PropertiesHandler();
    private CustomLabel description;
    private GamblerViewController myController;

    public GamblerViewSelectStrategyPane(GameModel gameModel, Controller gameblerViewController){
        super(gameModel,gameblerViewController,2,8);

        myController = (GamblerViewController) gameblerViewController;
        myController.setPane(this);

        HashMap<String,GambleStrategy> gambleStrategies = gameModel.getGambleStrategyHashMap();
        ArrayList<String> strategyNames = new ArrayList<>();
        ArrayList<GambleStrategies> strats = handler.getGambleStrategyTypes();

        for(String gs: gambleStrategies.keySet()){
            String[] strategyString = gs.getClass().toString().split(Pattern.quote("."));
            String strategyName = strategyString[strategyString.length-1];

            if(handler.getGambleStrategyTypes().size() != 0){
                if(strats.contains(GambleStrategies.valueOf(gs))){
                    strategyNames.add(gs);
                }
            }else{
                strategyNames.add(gs);
            }

        }

        comboBoxGambleStrategies = new ComboBox();

        comboBoxGambleStrategies.getItems().addAll(strategyNames);

        Label selectLabel = new Label();
        selectLabel.setText("Select a strategy: ");
        this.containerPane.add(selectLabel,0,0,2,1);
        this.containerPane.add(comboBoxGambleStrategies,2,0,3,1);
        comboBoxGambleStrategies.setOnAction((e) -> {
            String selectedItem = comboBoxGambleStrategies.getSelectionModel().getSelectedItem();
            myController.selectStrategey(selectedItem);
        });

        description = new CustomLabel("Description: ",gameModel,"getGambleStrategy().getDescription()");
        this.containerPane.add(description.label,0,1,8,1);

    }

    public void update() {
        description.update();

    }
    public void updatestrategies(List<GambleStrategies> stategies){
        HashMap<String,GambleStrategy> gambleStrategies = this.getGameModel().getGambleStrategyHashMap();
        ArrayList<String> strategyNames = new ArrayList<>();


        for(String gs: gambleStrategies.keySet()){
            String[] strategyString = gs.getClass().toString().split(Pattern.quote("."));
            String strategyName = strategyString[strategyString.length-1];

            if(stategies.contains(GambleStrategies.valueOf(gs))){
                    strategyNames.add(gs);
            }

        }

        comboBoxGambleStrategies.getItems().setAll(strategyNames);


    }

}

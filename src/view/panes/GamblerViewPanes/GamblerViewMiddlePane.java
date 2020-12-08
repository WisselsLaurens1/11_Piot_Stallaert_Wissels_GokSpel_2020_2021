package view.panes.GamblerViewPanes;

import Controller.Controller;
import Controller.GamblerViewController;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import model.GambleStrategey.GambleStrategy;
import model.GameModel;

import java.util.ArrayList;
import java.util.HashMap;


public class GamblerViewMiddlePane extends GridPane{

    // TODO: 06/12/2020 change to interface????
    private GameModel gameModel;
    private GamblerViewController controller;
    private Label description;

    public GamblerViewMiddlePane(GameModel gameModel, Controller gameblerViewController){

        // TODO: 06/12/2020  set minmium size

        this.gameModel = gameModel;
        this.controller = (GamblerViewController) gameblerViewController;


        this.setId("middleView");
        this.getStylesheets().add("stylesheets/GamblerViewStylesheet.css");

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column2 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column3 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column4 = new ColumnConstraints();
        column1.setPercentWidth(25);

        this.getColumnConstraints().addAll(column1, column2,column3,column4); // each get 50% of width

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100/3);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(100/3);
        RowConstraints row3 = new RowConstraints();
        row2.setPercentHeight(100/3);
        this.getRowConstraints().addAll(row1,row2,row3);


        HashMap<String,GambleStrategy> gambleStrategies = this.gameModel.getGambleStrategyHashMap();
        ArrayList<String> strategyNames = new ArrayList<>();

        for(String gs: gambleStrategies.keySet()){
/*            String[] strategyString = gs.getClass().toString().split(Pattern.quote("."));
            String strategyName = strategyString[strategyString.length-1];*/
            strategyNames.add(gs);
        }

        ComboBox<String> comboBoxGambleStrategies = new ComboBox();

        comboBoxGambleStrategies.getItems().addAll(strategyNames);

        /*get description of strategy*/
        Label description = new Label();
        GambleStrategy selectedStrategy= this.gameModel.getGambleStrategy();
        
        if(selectedStrategy != null){
            description.setText(selectedStrategy.getDescription());
        }else{
            description.setText("Select a strategy");
        }
        this.description = description;

        this.add(description,0,1);
        

        this.add(comboBoxGambleStrategies,1,0);


        comboBoxGambleStrategies.setOnAction((e) -> {
            String selectedItem = comboBoxGambleStrategies.getSelectionModel().getSelectedItem();
            this.controller.selectStrategey(selectedItem);

        });

    }

    public void update() {
        this.description.setText(this.gameModel.getGambleStrategy().getDescription());
    }

}

package view.panes.GamblerViewPanes;

import Controller.Controller;
import Controller.GamblerViewController;
import javafx.geometry.Insets;
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
/*
        column1.setPercentWidth(25);
*/
        column1.setPrefWidth(150);
        ColumnConstraints column2 = new ColumnConstraints();
        column1.setPrefWidth(150);
        ColumnConstraints column3 = new ColumnConstraints();
        column1.setPrefWidth(150);
        ColumnConstraints column4 = new ColumnConstraints();
        column1.setPrefWidth(150);

/*
        this.setGridLinesVisible(true);
*/

        this.getColumnConstraints().addAll(column1,column2,column3,column4); // each get 50% of width

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100/2);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(100/2);
        RowConstraints row3 = new RowConstraints();
        row2.setPercentHeight(100/2);
        this.getRowConstraints().addAll(row1,row2,row3);
        this.setHgap(10); //horizontal gap in pixels => that's what you are asking for
        this.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid


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
            description.setText("Description: "+ selectedStrategy.getDescription());
        }else{
            description.setText("Description: ");
        }
        this.description = description;


        this.add(description,0,1,3,1);
        
        Label selectLabel = new Label();
        selectLabel.setText("Selected: ");
        this.add(selectLabel,1,0,1,1);

        this.add(comboBoxGambleStrategies,2,0);


        comboBoxGambleStrategies.setOnAction((e) -> {
            String selectedItem = comboBoxGambleStrategies.getSelectionModel().getSelectedItem();
            this.controller.selectStrategey(selectedItem);

        });

    }

    public void update() {
        if(this.gameModel.getGambleStrategy() != null){
            this.description.setText("Description: "+this.gameModel.getGambleStrategy().getDescription());
        }



    }

}

package view.panes.AdminViewPanes;

import Controller.SettingsController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.GambleStrategey.*;
import model.database.GamblerEnum;


import java.util.HashMap;
import java.util.HashSet;

public class SettingsViewPane extends GridPane {
    ComboBox playerOverviewSettings;

    SettingsController controller;

    public void setController(SettingsController controller) {
        this.controller = controller;
    }

    public SettingsViewPane () {
        playerOverviewSettings = new ComboBox();

        this.add(new Label("Load & Save to: "), 0,0);
        this.add(playerOverviewSettings,0,1);

        Button saveBtn = new Button("Save");
        saveBtn.setOnAction(event -> {
            controller.save();
        });

        this.add(saveBtn, 0,200);
        this.add(new Label("Available strategies: "), 2,0);
    }

    public void setAvailableGambleStrategiesSettings (HashSet<GambleStrategies> selectTypes ) {
        int i = 1;
        for (GambleStrategies type : GambleStrategies.values()) {
            CheckBox checkBox = new CheckBox(type.toString());

            if (selectTypes.contains(type)) {
                controller.addAvailableType(type);
                checkBox.setSelected(true);
            }
            else {
                checkBox.setSelected(false);
            }

            checkBox.setOnAction(event -> {
                GambleStrategies index = type;

                if (checkBox.isSelected()) {
                    controller.addAvailableType(index);
                }
                else {
                    controller.removeAvailableType(index);
                }

            });
            this.add(checkBox,3, i++);
        }
    }

    public void setPlayerOverviewSettings(ObservableList playerOverviewSettings, int selectIndex) {
        this.playerOverviewSettings.setItems(playerOverviewSettings);

        this.playerOverviewSettings.getSelectionModel().select(selectIndex);

        this.playerOverviewSettings.setOnAction((EventHandler<ActionEvent>) event -> {
            GamblerEnum type = GamblerEnum.valueOf(this.playerOverviewSettings.getValue().toString());
            controller.setCurrentLoadSaveTypeSetting(type);
        });
    }
    public  void setMarges(HashMap<String,Integer> marges){

        GamblerStrategyFactory factory = GamblerStrategyFactory.getInstance();
        Label label1 = new Label("teststrategy");
        TextField test = new TextField();

        if(!marges.containsKey("TestStrategy")){
            test.setText(String.valueOf(factory.getStrategy("TestStrategy").getWinMultiplier()));
        }else {
            test.setText(String.valueOf(marges.get("TestStrategy")));
        }

        test.setId("TestStrategy");
        test.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.equals("")){
                    newValue="0";
                }
                controller.changeMarge(test.getId(),Integer.parseInt(newValue));
                System.out.println(" Text Changed to  " + newValue + "\n");
            }
        });

        Label label2 = new Label("EvenEyesStrategy");
        TextField even = new TextField();
        if(!marges.containsKey("EvenEyesStrategy")){
            even.setText(String.valueOf(factory.getStrategy("EvenEyesStrategy").getWinMultiplier()));
        }else {
            even.setText(String.valueOf(marges.get("EvenEyesStrategy")));
        }
        even.setId("EvenEyesStrategy");
        even.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                if(newValue.equals("")){
                    newValue="0";
                }
                controller.changeMarge(even.getId(),Integer.parseInt(newValue));
                System.out.println(" Text Changed to  " + newValue + "\n");
            }
        });

        Label label3 = new Label("SumIs21Strategy");
        TextField twenty = new TextField();
        if(!marges.containsKey("SumIs21Strategy")){
            twenty.setText(String.valueOf(factory.getStrategy("SumIs21Strategy").getWinMultiplier()));
        }else {
            twenty.setText(String.valueOf(marges.get("SumIs21Strategy")));
        }
        twenty.setId("SumIs21Strategy");
        twenty.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                if(newValue.equals("")){
                    newValue="0";
                }
                controller.changeMarge(twenty.getId(),Integer.parseInt(newValue));

                System.out.println(" Text Changed to  " + newValue + "\n");
            }
        });
        this.add(label1,0,2);
        this.add(test,1,2);

        this.add(label2,0,3);
        this.add(even,1,3);

        this.add(label3,0,4);
        this.add(twenty,1,4);
    }
}

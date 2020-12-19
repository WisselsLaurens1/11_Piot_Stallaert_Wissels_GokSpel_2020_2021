package view.panes.GamblerViewPanes;

import Controller.SettingsController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.GambleStrategey.GambleStrategies;
import model.database.GamblerEnum;


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

        this.add(saveBtn, 0,3);



        this.add(new Label("Available strategies: "), 3,0);


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
            this.add(checkBox,4, i++);
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
}

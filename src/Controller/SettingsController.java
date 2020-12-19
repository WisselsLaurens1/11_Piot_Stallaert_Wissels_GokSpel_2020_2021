package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import model.GambleStrategey.GambleStrategies;
import model.PropertiesHandler;
import model.database.GamblerEnum;
import view.View;
import view.panes.GamblerViewPanes.SettingsViewPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SettingsController {
    SettingsViewPane view;

    private GamblerEnum currentLoadSaveTypeSetting;

    private List<GambleStrategies> availableTypes = new ArrayList<>();


    public SettingsController() {
        load();
    }

    public GamblerEnum getCurrentLoadSaveTypeSetting() {
        return currentLoadSaveTypeSetting;
    }

    public void addAvailableType (GambleStrategies type) {
        availableTypes.add(type);
    }

    public void removeAvailableType(GambleStrategies type) {
        availableTypes.remove(type);
    }

    public void setCurrentLoadSaveTypeSetting(GamblerEnum currentLoadSaveTypeSetting) {
        this.currentLoadSaveTypeSetting = currentLoadSaveTypeSetting;
    }


    private void updateAvailableGambleStategiesSettings() {
        this.view.setAvailableGambleStrategiesSettings(getGambleStrategies());
    }

    public void updateLoadSettings () {
        ObservableList<GamblerEnum> options = FXCollections.observableArrayList(
                Arrays.asList(GamblerEnum.values())
        );


        GamblerEnum l = getLoadSaveType();

        if (l != null) {
            view.setPlayerOverviewSettings(options, getSelectIndexSaveLoad(options, l));
            currentLoadSaveTypeSetting = l;
        }
        else {
            view.setPlayerOverviewSettings(options, 0);
            currentLoadSaveTypeSetting = options.get(0);
        }
    }

    private int getSelectIndexSaveLoad(ObservableList<GamblerEnum> options, GamblerEnum l) {
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).equals(l)) {
                return i;
            }
        }
        return 0;
    }

    public void save () {
        saveLoadSaveType();
        saveGambleStrategies();
    }

    public void load () {
        loadLoadSaveType();
    }

    private void saveLoadSaveType () {
        PropertiesHandler propertiesHandler = new PropertiesHandler();
        if (currentLoadSaveTypeSetting != null) {
            propertiesHandler.saveLoadSaveType(currentLoadSaveTypeSetting);
        }
    }

    private void saveGambleStrategies () {
        PropertiesHandler propertiesHandler = new PropertiesHandler();
        propertiesHandler.saveGambleStrategyTypes(availableTypes);
    }


    private void loadLoadSaveType () {
        GamblerEnum loadSaveType = new PropertiesHandler().getLoadSaveType();
        if (loadSaveType != null) {
            //PlayerDB.getInstance().setLoadSaveType(loadSaveType);
        }
    }

    private GamblerEnum getLoadSaveType () {
        GamblerEnum loadSaveType = new PropertiesHandler().getLoadSaveType();
        return (loadSaveType);
    }


    private HashSet<GambleStrategies> getGambleStrategies () {
        HashSet<GambleStrategies> types = new HashSet<>();

        List<GambleStrategies> found = new PropertiesHandler().getGambleStrategyTypes();

        if (found != null && found.size() > 0) {
            types.addAll(found);
        }
        return types;
    }


    public void setView(Pane view) {
        this.view = (SettingsViewPane) view;
        this.view.setController(this);
        updateLoadSettings();
        updateAvailableGambleStategiesSettings();
    }


    public void update() {

    }
}

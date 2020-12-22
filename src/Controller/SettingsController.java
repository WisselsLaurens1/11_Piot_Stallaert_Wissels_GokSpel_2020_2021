package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import model.GambleStrategey.GambleStrategies;
import model.GambleStrategey.GamblerStrategyFactory;
import model.GameModel;
import model.PropertiesHandler;
import model.database.GamblerEnum;
import view.View;
import view.panes.GamblerViewPanes.SettingsViewPane;

import java.util.*;

public class SettingsController{
    SettingsViewPane view;
    PropertiesHandler handler = new PropertiesHandler();
    private GameModel model;
    private GamblerViewController controller;

    private GamblerEnum currentLoadSaveTypeSetting;
    private HashMap<String,Integer> marges =new HashMap<>();

    private List<GambleStrategies> availableTypes = new ArrayList<>();


    public SettingsController(GameModel model ) {
        this.model=model;


        if(handler.getmarges()==null){
            GamblerStrategyFactory factory= GamblerStrategyFactory.getInstance();
            for (GambleStrategies gambleStrategies: GambleStrategies.values()){
                marges.put(gambleStrategies.toString(),factory.getStrategy(gambleStrategies.toString()).getWinMultiplier());
            }
        } else{
            marges=handler.getmarges();

        }

    }

    public void setController(Controller controller) {
        this.controller = (GamblerViewController) controller;
    }

    public void changemarge(String strategies, int aantal){
        GamblerStrategyFactory factory= GamblerStrategyFactory.getInstance();
        marges.put(strategies,aantal);
        System.out.println(factory.getStrategy(strategies.toString()).getWinMultiplier());
    }

    private void setmarges(HashMap<String,Integer> marges){
        this.view.setmarges(marges);
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
        savemarges();
    }

    private void savemarges() {
        PropertiesHandler propertiesHandler = new PropertiesHandler();
        if (marges != null) {
            propertiesHandler.saveGambleStrategymarges(marges);
        }
        System.out.println(marges);
        System.out.println(marges.get("TestStrategy"));
        this.model.updateMarges(marges);

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
        this.controller.updatestrategies(availableTypes);
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
        setmarges(marges);
    }


    public void update() {

    }
}

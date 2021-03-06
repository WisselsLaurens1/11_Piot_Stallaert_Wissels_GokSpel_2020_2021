package view.panes.AdminViewPanes;

import Controller.Controller;
import Controller.SettingsController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.GameModel;
import model.database.DatabaseModel;

import java.io.FileNotFoundException;

public class AdminMainPane extends BorderPane {

    private Controller controller;
    private GameModel gameModel;
	public AdminMainPane(DatabaseModel database, GameProgressTabPane gameProgressTabPane, StrategiesInfoPane strategiesInfoPane ,GamblerOverviewPane gamblerOverviewPane, Controller gamblerViewController, GameModel model ) throws FileNotFoundException {

        this.controller = gamblerViewController;
        this.gameModel = model;

	    TabPane tabPane = new TabPane();

	    Tab GameProgressTabPane = new Tab("Game progress",gameProgressTabPane);

/*
        GamblerOverviewPane gamblerOverviewPane = new GamblerOverviewPane(database);
*/

        Tab spelerTab = new Tab("Spelers",gamblerOverviewPane);

        SettingsViewPane settingsPane = new SettingsViewPane();
        SettingsController settingsController = new SettingsController(model);
        settingsController.setView( settingsPane);
        settingsController.setController(gamblerViewController);

        Tab instellingTab = new Tab("Instellingen",settingsPane);
        Tab statistiekTab = new Tab("Strategies",strategiesInfoPane);
        tabPane.getTabs().add(GameProgressTabPane);
        tabPane.getTabs().add(spelerTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}
}

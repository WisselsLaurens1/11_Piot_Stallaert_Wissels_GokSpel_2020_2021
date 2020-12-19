package view.panes;

import Controller.Controller;
import Controller.SettingsController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.GameModel;
import model.database.DatabaseModel;
import model.database.GamblerEnum;
import view.View;
import view.panes.GamblerViewPanes.GamblerViewPane3;
import view.panes.GamblerViewPanes.SettingsViewPane;
import view.panes.GamblerViewPanes.customGridPane;

import java.io.FileNotFoundException;

public class AdminMainPane extends BorderPane {

    private Controller controller;
    private GameModel gameModel;
	public AdminMainPane(DatabaseModel database, Controller gamblerViewController, GameModel model ) throws FileNotFoundException {

        this.controller = gamblerViewController;
        this.gameModel = model;

	    TabPane tabPane = new TabPane();
        GameProgressTabPane gameProgressTabPane = new GameProgressTabPane(model,gamblerViewController);

        Tab GameProgressTabPane = new Tab("Game progress",gameProgressTabPane);

        GamblerOverviewPane gamblerOverviewPane = new GamblerOverviewPane(database);
        Tab spelerTab = new Tab("Spelers",gamblerOverviewPane);

        SettingsViewPane settingsPane = new SettingsViewPane();
        SettingsController settingsController = new SettingsController();
        settingsController.setView( settingsPane);

        Tab instellingTab = new Tab("Instellingen",settingsPane);
        Tab statistiekTab = new Tab("Statistieken");
        tabPane.getTabs().add(GameProgressTabPane);
        tabPane.getTabs().add(spelerTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}
}

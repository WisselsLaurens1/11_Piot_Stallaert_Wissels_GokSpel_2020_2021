package view.panes;

import Controller.Controller;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.GameModel;
import model.database.DatabaseModel;
import view.panes.GamblerViewPanes.GamblerViewPane3;
import view.panes.GamblerViewPanes.customGridPane;
import Controller.GameProgressTabController;

import java.io.FileNotFoundException;

public class AdminMainPane extends BorderPane {

    private Controller controller;
    private GameModel gameModel;
	public AdminMainPane(DatabaseModel database, Controller gamblerViewController, GameModel model ) throws FileNotFoundException {

        this.controller = gamblerViewController;
        this.gameModel = model;

	    TabPane tabPane = new TabPane();


        GameProgressTabController gameProgressTabController = new GameProgressTabController();


/*
        gameProgressTabController = (Controller) gameProgressTabController;
*/
        GameProgressTabPane gameProgressTabPane =  new GameProgressTabPane(model,gameProgressTabController);
/*


        customGridPane gameProgressTabPane =  new customGridPane(model,controller,4,4);
*/

        Tab GameProgressTabPane = new Tab("Game progress",gameProgressTabPane);

        GamblerOverviewPane gamblerOverviewPane = new GamblerOverviewPane(database);
        Tab spelerTab = new Tab("Spelers",gamblerOverviewPane);

        Tab instellingTab = new Tab("Instellingen");
        Tab statistiekTab = new Tab("Statistieken");
        tabPane.getTabs().add(GameProgressTabPane);
        tabPane.getTabs().add(spelerTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}
}

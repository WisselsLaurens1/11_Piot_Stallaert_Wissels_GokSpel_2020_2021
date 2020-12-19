package application;

import Controller.Controller;
import Controller.GamblerViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;
import model.GameModel;
import model.database.DatabaseModel;
import view.AdminView;
import view.GamblerView;
import view.View;
import Controller.GameProgressTabController;
import view.panes.GameProgressTabPane;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GokSpelMain extends Application {
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException, IOException, BiffException {

		DatabaseModel database = new DatabaseModel();

		GameModel gameModel = new GameModel(database);
		Controller gamblerViewController = new GamblerViewController(gameModel);
		Controller gameProgressTabController = new GameProgressTabController(gameModel);
		View gamblerView = new GamblerView(gamblerViewController,gameModel);
		GameProgressTabPane gameProgressTabPane = new GameProgressTabPane(gameModel,gameProgressTabController);
		AdminView adminView = new AdminView(database,gameProgressTabPane, gamblerViewController,gameModel);

		gamblerViewController.setView(gamblerView);

		/*adding observers*/
		gameModel.addObserver(gamblerView);
		gameModel.addObserver(gameProgressTabPane);

	}

	public static void main(String[] args) {
		launch(args);
	}
}

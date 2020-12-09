package application;

import Controller.Controller;
import Controller.GamblerViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;
import model.GameModel;
import view.AdminView;
import view.GamblerView;
import view.View;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GokSpelMain extends Application {
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException, IOException, BiffException {
		GameModel gameModel = new GameModel();
		AdminView adminView = new AdminView();
		Controller gamblerViewController = new GamblerViewController(gameModel);
		View gamblerView = new GamblerView(gamblerViewController,gameModel);
		gamblerViewController.setView(gamblerView);

		/*adding observers*/
		gameModel.addObserver(gamblerView);

	}

	public static void main(String[] args) {
		launch(args);
	}
}

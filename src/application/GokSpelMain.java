package application;
import Controller.Controller;
import Controller.GamblerViewController;
import Controller.StrategiesInfoController;
import javafx.application.Application;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;
import model.GameModel;
import model.database.DatabaseModel;
import view.AdminView;
import view.GamblerView;
import view.View;
import Controller.GameProgressTabController;
import view.panes.AdminViewPanes.GamblerOverviewPane;
import view.panes.AdminViewPanes.GameProgressTabPane;
import view.panes.AdminViewPanes.StrategiesInfoPane;
import java.io.IOException;

public class GokSpelMain extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException, BiffException {


		/***** models ****/
		DatabaseModel database = new DatabaseModel();
		GameModel gameModel = new GameModel(database);

		/***** controllers *****/
		Controller gamblerViewController = new GamblerViewController(gameModel);
		Controller gameProgressTabController = new GameProgressTabController(gameModel);
		StrategiesInfoController strategiesInfoController = new StrategiesInfoController(gameModel);

		/***** panes *****/
		StrategiesInfoPane strategiesInfoPane = new StrategiesInfoPane(gameModel,strategiesInfoController);
		GameProgressTabPane gameProgressTabPane = new GameProgressTabPane(gameModel,gameProgressTabController);
		GamblerOverviewPane gamblerOverviewPane = new GamblerOverviewPane(database);


		/***** views *****/
		View gamblerView = new GamblerView(gamblerViewController,gameModel);
		AdminView adminView = new AdminView(database,gameProgressTabPane, strategiesInfoPane,gamblerOverviewPane,gamblerViewController,gameModel);
		gamblerViewController.setView(gamblerView);

		
		/***** adding observers *****/
		gameModel.addObserver(gamblerView);
		gameModel.addObserver(gameProgressTabPane);
		gameModel.addObserver(strategiesInfoPane);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

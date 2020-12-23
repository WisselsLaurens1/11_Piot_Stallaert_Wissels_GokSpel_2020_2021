package view;

import Controller.Controller;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jxl.read.biff.BiffException;
import model.GameModel;
import model.database.DatabaseModel;
import view.panes.AdminViewPanes.AdminMainPane;

import model.Observer;
import view.panes.AdminViewPanes.GamblerOverviewPane;
import view.panes.AdminViewPanes.GameProgressTabPane;
import view.panes.AdminViewPanes.StrategiesInfoPane;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AdminView implements Observer {
	private Stage stage = new Stage();
	private Controller controller;
	private GameModel gameModel;
	public AdminView(DatabaseModel database, GameProgressTabPane gameProgressTabPane, StrategiesInfoPane strategiesInfoPane, GamblerOverviewPane gamblerOverviewPane, Controller gamblerViewController, GameModel model) throws FileNotFoundException, IOException, BiffException {
		this.controller = gamblerViewController;
		this.gameModel = gameModel;

		stage.setTitle("ADMIN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(630);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 600, 600);
		BorderPane borderPane = new AdminMainPane(database,gameProgressTabPane,strategiesInfoPane,gamblerOverviewPane, gamblerViewController,model);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}

	@Override
	public void update() {

	};
}

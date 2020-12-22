package view;

import Controller.Controller;
import Controller.GamblerViewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.GameModel;
import view.panes.GamblerViewPanes.GamblerViewContainerPane;

import java.io.IOException;

public class GamblerView implements View  {
	private Stage stage = new Stage();
	private Controller controller;
	private GameModel gameModel;

	private GamblerViewContainerPane gamblerViewContainer;

	public GamblerView(Controller gamblerViewController, GameModel model) throws IOException {

		this.controller = gamblerViewController;
		this.gameModel = gameModel;

		stage.setTitle("GAMBLER VIEW");
		String path = "stylesheets/GamblerViewStylesheet.css";

		stage.initStyle(StageStyle.UTILITY);
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();

		Scene scene = new Scene(root, 600, 600);
		scene.getStylesheets().add(path);

		GamblerViewContainerPane gamblerViewContainerPane = new GamblerViewContainerPane(model,gamblerViewController);
		this.gamblerViewContainer = gamblerViewContainerPane;

		stage.setScene(scene);
		stage.sizeToScene();
		root.getChildren().add(gamblerViewContainerPane);
		stage.show();
	}

	@Override
	public void update() {
		this.gamblerViewContainer.update();
	}
}

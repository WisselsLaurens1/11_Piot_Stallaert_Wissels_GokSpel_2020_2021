package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Observer;
import view.panes.GamblerViewPanes.GamblerViewContainerPane;

import java.io.IOException;

public class GamblerView implements Observer {
	private Stage stage = new Stage();		
		
	public GamblerView() throws IOException {
		stage.setTitle("GAMBLER VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();

		Scene scene = new Scene(root, 600, 600);
		String path = "stylesheets/GamblerViewStylesheet.css";
		scene.getStylesheets().add(path);
		GamblerViewContainerPane gamblerViewContainerPane = new GamblerViewContainerPane();
		GamblerViewContainerPane gamblerViewContainerPane2 = new GamblerViewContainerPane();


		System.out.println(scene.getStylesheets());
		stage.setScene(scene);
		stage.sizeToScene();
		root.getChildren().add(gamblerViewContainerPane);

		stage.show();		
	}

	@Override
	public void update() {

	}
}

package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Observer;
import view.panes.GamblerOverviewPane;
import view.panes.GamblerViewPane;

import java.io.FileNotFoundException;

public class GamblerView implements Observer {
	private Stage stage = new Stage();		
		
	public GamblerView() throws FileNotFoundException {
		stage.setTitle("GAMBLER VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 600, 600);
		GamblerViewPane gamblerViewPane = new GamblerViewPane();
/*
		String css = this.getClass().getResource("/Users/laurenswissels/Documents/Leuven/OOO/Opdracht/Project/11_Piot_Stallaert_Wissels_GokSpel_2020_2021/src/application/application.css").toExternalForm();
*/
		scene.getStylesheets().add("/Users/laurenswissels/Documents/Leuven/OOO/Opdracht/Project/11_Piot_Stallaert_Wissels_GokSpel_2020_2021/src/application/application.css");
		stage.setScene(scene);
		stage.sizeToScene();
		root.getChildren().add(gamblerViewPane);

		stage.show();		
	}

	@Override
	public void update() {

	}
}

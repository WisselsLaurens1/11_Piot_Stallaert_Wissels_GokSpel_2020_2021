package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import view.AdminView;
import view.GamblerView;
import view.panels.GamblerOverviewPane;

import java.io.FileNotFoundException;

public class GokSpelMain extends Application {
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		AdminView adminView = new AdminView();
		GamblerView gamblerView = new GamblerView();
	}
	//comment
	public static void main(String[] args) {
		launch(args);
	}
}

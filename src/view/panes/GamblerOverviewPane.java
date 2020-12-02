package view.panes;


import model.Gambler;
import model.GamblerDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;


public class GamblerOverviewPane extends GridPane{
	private TableView<Gambler> table;
	private GamblerDb gamblerdb;
	private ObservableList<Gambler> gamblers;


	public GamblerOverviewPane() throws FileNotFoundException {
		this.gamblerdb = new GamblerDb();
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
		table = new TableView<Gambler>();
		refresh();
		TableColumn<Gambler, String> colGamblerName = new TableColumn<Gambler, String>("Gambler Name");
		colGamblerName.setMinWidth(300);
		colGamblerName.setCellValueFactory(new PropertyValueFactory<Gambler, String>("playerName"));
		TableColumn<Gambler, String> colAchternaam = new TableColumn<Gambler, String>("Achternaam");
		colAchternaam.setMinWidth(100);
		colAchternaam.setCellValueFactory(new PropertyValueFactory<Gambler, String>("surname"));
		TableColumn<Gambler, String> colVoornaam = new TableColumn<Gambler, String>("voornaam");
		colVoornaam.setMinWidth(100);
		colVoornaam.setCellValueFactory(new PropertyValueFactory<Gambler, String>("name"));
		TableColumn<Gambler, Double> colSaldo = new TableColumn<Gambler, Double>("Goksaldo");
		colSaldo.setMinWidth(100);
		colSaldo.setCellValueFactory(new PropertyValueFactory<Gambler, Double>("gamblingSaldo"));
		table.getColumns().addAll(colGamblerName, colAchternaam, colVoornaam, colSaldo);

		this.getChildren().addAll(table);
	}


	public void refresh(){
		gamblers = FXCollections.observableArrayList(gamblerdb.getGamblerDb());
		table.setItems(gamblers);
		table.refresh();
	}
}

package view.panes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import model.Gambler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.PropertiesHandler;
import model.database.DatabaseModel;
import model.database.GamblerFactory;
import model.database.GamblerDbContext;
import model.database.GamblerDbInterface;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class GamblerOverviewPane extends GridPane{
	private GamblerDbContext gamblerDbContext;
	private TableView<Gambler> table;
	private ObservableList<Gambler> gamblers;
	private PropertiesHandler handler =new PropertiesHandler();

	private DatabaseModel database;

	public GamblerOverviewPane(DatabaseModel database) throws FileNotFoundException {
		this.database = database;
		gamblerDbContext = new GamblerDbContext();
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);
		ComboBox<String> bestandenComboBox = new ComboBox<String>();
		ObservableList <String> bestanden = FXCollections.observableList(gamblerDbContext.getBestandenLijst());
		bestandenComboBox.setItems(bestanden);
		bestandenComboBox.setEditable(true);
		bestandenComboBox.valueProperty().addListener(new ClickComboBoxLineHandler());
		this.add(bestandenComboBox, 0, 0);
		table = new TableView<Gambler>();
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

		this.add(table,0,1);
		if(handler.getLoadSaveType() != null){
			bestandenComboBox.setValue(handler.getLoadSaveType().toString());
		}
	}

	class ClickComboBoxLineHandler implements ChangeListener<String> {
		@Override
		public void changed(ObservableValue ov, String db, String db1) {
			GamblerDbInterface gamblerDbInterface = GamblerFactory.createDb(db1);
			gamblerDbContext.setGamblerDbInterface(gamblerDbInterface);
			HashMap<String, Gambler> gamblerDB =  gamblerDbContext.getGamblerDb();
			database.setGamblers(gamblerDB);
			ArrayList<Gambler> valuesList = new ArrayList<Gambler>(gamblerDB.values());
			gamblers = FXCollections.observableArrayList(valuesList);
			table.setItems(gamblers);
			table.refresh();
		}
	}
}

package view.panes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.paint.Color;
import model.Gambler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.GamblerFactory;
import model.database.GamblerDbContext;
import model.database.GamblerDbInterface;

import java.io.FileNotFoundException;


public class GamblerViewPane extends GridPane {
    public GamblerViewPane(){

        // TODO: 06/12/2020  set minmium size
        
        Label label = new Label("a");
        label.setMinHeight(200);
        label.setMinWidth(200);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        this.getColumnConstraints().addAll(column1, column2); // each get 50% of width


        this.add(label, 1, 1,2,1);
        Label label2 = new Label("b");

        this.add(label2, 2, 2,1,1);
        this.setStyle("-fx-background-color : #a0daff;");




    }

}

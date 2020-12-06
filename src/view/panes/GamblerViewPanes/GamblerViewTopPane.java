package view.panes.GamblerViewPanes;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;


public class GamblerViewTopPane extends GridPane {
    public GamblerViewTopPane(){

        // TODO: 06/12/2020  set minmium size


        this.setId("topView");
        Label label = new Label("a");

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column2 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column3 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column4 = new ColumnConstraints();
        column1.setPercentWidth(25);


        this.getColumnConstraints().addAll(column1, column2,column3,column4); // each get 50% of width

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(50);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(50);
        this.getRowConstraints().addAll(row1,row2);

        Label label1 = new Label("Enter player name");
        TextField textField = new TextField ();
        this.add(label1, 0,0);
        this.add(textField, 1,0);



        this.getStylesheets().add("stylesheets/GamblerViewStylesheet.css");


    }

}

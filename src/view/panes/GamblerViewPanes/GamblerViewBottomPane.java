package view.panes.GamblerViewPanes;

import javafx.scene.control.Label;
import javafx.scene.layout.*;


public class GamblerViewBottomPane extends GridPane {
    public GamblerViewBottomPane(){

        // TODO: 06/12/2020  set minmium size

        this.setId("bottomView");
        Label label = new Label("a");

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);

        this.getColumnConstraints().addAll(column1, column2); // each get 50% of width

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(50);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(50);
        this.getRowConstraints().addAll(row1,row2);


        this.getStylesheets().add("stylesheets/GamblerViewStylesheet.css");


    }

}

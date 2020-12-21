package view.panes.GamblerViewPanes;

import Controller.Controller;
import Controller.GamblerViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import model.GameModel;
import view.View;

public class GamblerViewOutputPane extends CustomGridPane {

    private CustomLabel terminalOutput;
    public GamblerViewOutputPane(GameModel gameModel, Controller gameblerViewController){
        super(gameModel, gameblerViewController, 3,8);

        terminalOutput = new CustomLabel(" ",gameModel,"getTerminalOutput()",gameModel);

        Label output = new Label("Output: ");
        this.containerPane.add(output,0,0,2,1);
        this.containerPane.add(terminalOutput.label,1,1,7,1);

    }

    public void update() {
        terminalOutput.update();
    }
}

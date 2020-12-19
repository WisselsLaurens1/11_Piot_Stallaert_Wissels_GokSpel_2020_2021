package view.panes.GamblerViewPanes;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import model.Gambler;
import model.GameModel;
import Controller.GamblerViewController;


public class GamblerViewLoginPane extends CustomGridPane{

    private CustomLabel currentPlayer;
    private CustomLabel saldo;


    public GamblerViewLoginPane(GameModel gameModel, Controller gameblerViewController){

        super(gameModel, gameblerViewController,2,8);
        GamblerViewController myController = (GamblerViewController) gameblerViewController;
        currentPlayer = new CustomLabel("Player name: ","getCurrentPlayer().getName()",gameModel);
        saldo = new CustomLabel("Saldo: ","getCurrentPlayer().getGamblingSaldo()",gameModel);

        Label playerName = new Label("Enter player name");
        TextField loginField = new TextField ();
        this.containerPane.add(playerName, 0,0,4,1);
        this.containerPane.add(loginField, 2,0,3,1);
        Button loginButton = new Button("Login");
        Button logOutButton = new Button("Logout");
        this.containerPane.add(loginButton, 5,0);
        this.containerPane.add(logOutButton, 6,0,2,1);
        this.containerPane.add(currentPlayer.label, 0,1,2,1);
        this.containerPane.add(saldo.label, 4,1,2,1);

        loginButton.setOnAction((e)->{
            myController.login(loginField.getText());
            loginField.clear();
        });

        logOutButton.setOnAction((e)->{
            myController.logout();
        });

    }

    public void update() {
        currentPlayer.update();
        saldo.update();
    }

}

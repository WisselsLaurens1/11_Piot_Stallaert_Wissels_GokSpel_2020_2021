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


public class GamblerViewTopPane extends GridPane {

    private GameModel gameModel;
    private GamblerViewController controller;
    private Label currentPlayer;
    private Label saldo;


    public GamblerViewTopPane(GameModel gameModel, Controller gameblerViewController){

        // TODO: 06/12/2020  set minmium size



        this.setId("topView");
        this.gameModel = gameModel;
        this.controller = (GamblerViewController) gameblerViewController;

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
/*
        this.setGridLinesVisible(true);
*/


        Label playerName = new Label("Enter player name");
        Label saldo = new Label("Saldo: ");
        Label currentPlayer = new Label("Current player: ");
        this.currentPlayer = currentPlayer;
        this.saldo = saldo;

        Button loginButton = new Button("Login");
        Button logOutButton = new Button("Logout");
        TextField loginField = new TextField ();
        this.add(playerName, 0,0);
        this.add(loginField, 1,0);
        this.add(loginButton, 2,0);
        this.add(logOutButton, 3,0);
        this.add(currentPlayer,0,1,2,1);

        this.add(saldo,2,1);

        this.setHgap(10); //horizontal gap in pixels => that's what you are asking for
        this.setPadding(new Insets(20, 10, 10, 10)); //margins around the whole grid
/*
        this.setGridLinesVisible(true);
*/
        loginButton.setOnAction((e)->{
            controller.login(loginField.getText());
            loginField.clear();
        });

        logOutButton.setOnAction((e)->{
            controller.logout();
        });



        this.getStylesheets().add("stylesheets/GamblerViewStylesheet.css");


    }

    public void update() {
        Gambler currentPlayer = gameModel.getCurrentPlayer();
        if (currentPlayer != null){
            this.currentPlayer.setText("Player: "+currentPlayer.getName());
            this.saldo.setText("Saldo: "+currentPlayer.getGamblingSaldo());
        }else{
            this.currentPlayer.setText("Player: ");
            this.saldo.setText("Saldo: ");
        }

        System.out.println("update");
    }

}

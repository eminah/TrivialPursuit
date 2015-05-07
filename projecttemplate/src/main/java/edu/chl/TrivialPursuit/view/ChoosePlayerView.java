package edu.chl.trivialpursuit.view;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

/*
  Application entry class (if using standard java and Swing)
*/
public class ChoosePlayerView extends BorderPane {

    Label titleLabel;
    Button numPlayers;
    Button done;

    public ChoosePlayerView() {

        //Create Stackpane components
        StackPane titlePane = new StackPane();
        titleLabel = new Label("Choose Players");
        titleLabel.getStyleClass().add("title label");

        //Add to StackPane
        titlePane.getChildren().addAll(titleLabel);

        //Create VBox Components
        VBox playerPanel = new VBox();
        playerPanel.setAlignment(Pos.CENTER);

        //Create a ComboBox (drop down list)
        ObservableList<String> options = FXCollections.observableArrayList(
                "1", "2", "3", "4", "5", "6");
        final ComboBox comboBox = new ComboBox(options);
        playerPanel.getChildren().add(comboBox);



        //Create players
        Text player1 = new Text("Player 1");
        Text player2 = new Text("Player 2");
        Text player3 = new Text("Player 3");
        Text player4 = new Text("Player 4");
        Text player5 = new Text("Player 5");
        Text player6 = new Text("Player 6");

    }

}
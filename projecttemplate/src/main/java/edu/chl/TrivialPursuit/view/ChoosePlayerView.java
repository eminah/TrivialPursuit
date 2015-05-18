package edu.chl.trivialpursuit.view;

import edu.chl.trivialpursuit.model.ChoosePlayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
  Application entry class (if using standard java and Swing)
*/
public class ChoosePlayerView extends BorderPane {

    Label numPlayersLabel;
    Button done;
    private ChoosePlayer choosePlayerModel;
    private ChoosePlayerView choosePlayerView;
    private Scene gbv;

    public ChoosePlayerView() {

        //Create Stackpane components
        //StackPane choosePlayerPane = new StackPane();
        HBox choosePanel = new HBox();
        choosePanel.setAlignment(Pos.TOP_CENTER);
        choosePanel.setPadding(new Insets(30, 0, 0, 0));
        choosePanel.setSpacing(10);

        //Add labels to StackPane
        numPlayersLabel = new Label("Choose number of players:");
        numPlayersLabel.setFont(new Font("Arial", 20));
        choosePanel.getChildren().addAll(numPlayersLabel);

        //Create a ComboBox (drop down list)
        ObservableList<String> options = FXCollections.observableArrayList(
                "2", "3", "4", "5", "6");
        final ComboBox numPlayers = new ComboBox(options);
        choosePanel.getChildren().add(numPlayers);


        //Create VBox Components
        VBox playerPanel = new VBox();
        playerPanel.setAlignment(Pos.CENTER_LEFT);
        playerPanel.setPadding(new Insets(0, 0, 0, 50));
        playerPanel.setSpacing(7);


        //Create players with text fields
        Text player1 = new Text("Player 1");
        TextField name1 = new TextField();
        name1.setMaxWidth(200);

        Text player2 = new Text("Player 2");
        TextField name2 = new TextField();
        name2.setMaxWidth(200);

        Text player3 = new Text("Player 3");
        TextField name3 = new TextField();
        name3.setMaxWidth(200);

        Text player4 = new Text("Player 4");
        TextField name4 = new TextField();
        name4.setMaxWidth(200);

        Text player5 = new Text("Player 5");
        TextField name5 = new TextField();
        name5.setMaxWidth(200);

        Text player6 = new Text("Player 6");
        TextField name6 = new TextField();
        name6.setMaxWidth(200);


        //Add playerPanel to StackPane
        playerPanel.getChildren().addAll(
                player1, name1, player2, name2, player3, name3,
                player4, name4, player5, name5, player6, name6
        );


        VBox buttonPanel = new VBox();
        buttonPanel.setAlignment(Pos.BOTTOM_RIGHT);
        buttonPanel.setPadding(new Insets(0, 30, 30, 100));

        //Create a Done-button
        done = new Button("Done");
        done.setPrefSize(80, 40);
        buttonPanel.getChildren().add(done);


        done.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            gbv = new Scene(new GameBoardView(), 1000, 500);
            stage.setScene(gbv);
            stage.show();
        });


        //Add to BorderPane
        this.setTop(choosePanel);
        this.setCenter(playerPanel);
        this.setBottom(buttonPanel);
    }


    public void addButtonListener(EventHandler handler) {
        done.setOnAction(handler);
    }


    public Button getDone() {
        return done;
    }
}
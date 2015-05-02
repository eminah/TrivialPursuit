package edu.chl.trivialpursuit.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by inatran on 15-04-20.
 */
public class StartView extends Application implements EventHandler<ActionEvent> {

    Stage window;
    Label playerLabel;
    ComboBox<Integer> howMany;
    Label playerOneLabel;
    TextField playerOneName;
    Label playerTwoLabel;
    TextField playerTwoName;
    Label playerThreeLabel;
    TextField playerThreeName;
    Label playerFourLabel;
    TextField playerFourName;
    Label playerFiveLabel;
    TextField playerFiveName;
    Label playerSixLabel;
    TextField playerSixName;
    Button doneButton;
    int numberOfPlayers = 2;

    public static void main(String[] args){launch(args);}
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Number of Players");

        howMany = new ComboBox<Integer>();
        howMany.setPrefSize(170, 20);
        playerLabel = new Label("How many would like to play the game:");
        playerOneLabel = new Label("Player 1:");
        playerOneName = new TextField();
        playerOneName.setPrefSize(100, 20);
        playerTwoLabel = new Label("Player 2:");
        playerTwoName = new TextField();
        playerTwoName.setPrefSize(100, 20);
        playerThreeLabel = new Label("Player 3:");
        playerThreeName = new TextField();
        playerThreeName.setPrefSize(100, 20);
        playerFourLabel = new Label("Player 4:");
        playerFourName = new TextField();
        playerFourName.setPrefSize(100, 20);
        playerFiveLabel = new Label("Player 5:");
        playerFiveName = new TextField();
        playerFiveName.setPrefSize(100, 20);
        playerSixLabel = new Label("Player 6:");
        playerSixName = new TextField();
        playerSixName.setPrefSize(100, 20);
        doneButton = new Button("Done");
        //Hide everything without first 2

        playerThreeLabel.setVisible(false);
        playerThreeName.setVisible(false);
        playerFourLabel.setVisible(false);
        playerFourName.setVisible(false);
        playerFiveLabel.setVisible(false);
        playerFiveName.setVisible(false);
        playerSixLabel.setVisible(false);
        playerSixName.setVisible(false);

        howMany.getItems().addAll(2, 3, 4, 5, 6);
        howMany.setPromptText("2");
        howMany.setOnAction(this);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        GridPane.setConstraints(playerLabel, 0, 0);
        GridPane.setConstraints(howMany, 1, 0);
        GridPane.setConstraints(playerOneLabel,0,5);
        GridPane.setConstraints(playerOneName,1,5);
        GridPane.setConstraints(playerTwoLabel,0,6);
        GridPane.setConstraints(playerTwoName,1,6);
        GridPane.setConstraints(playerThreeLabel,0,7);
        GridPane.setConstraints(playerThreeName,1,7);
        GridPane.setConstraints(playerFourLabel,0,8);
        GridPane.setConstraints(playerFourName,1,8);
        GridPane.setConstraints(playerFiveLabel,0,9);
        GridPane.setConstraints(playerFiveName,1,9);
        GridPane.setConstraints(playerSixLabel,0,10);
        GridPane.setConstraints(playerSixName,1,10);
        GridPane.setConstraints(doneButton,7,12);
        grid.getChildren().addAll(howMany,playerLabel,playerOneLabel,playerOneName,playerTwoLabel,playerTwoName,playerThreeLabel,playerThreeName,playerFourLabel,playerFourName,playerFiveLabel,playerFiveName,playerSixLabel,playerSixName,doneButton);
        Scene scene = new Scene(grid, 600, 300);

        window.setScene(scene);
        window.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        numberOfPlayers = howMany.getValue();


        if(howMany.getValue() >= 3){
            playerThreeLabel.setVisible(true);
            playerThreeName.setVisible(true);

        }else{
            playerThreeLabel.setVisible(false);
            playerThreeName.setVisible(false);
        }

        if(howMany.getValue() >= 4){
            playerFourLabel.setVisible(true);
            playerFourName.setVisible(true);

        }else{
            playerFourLabel.setVisible(false);
            playerFourName.setVisible(false);
        }

        if(howMany.getValue() >= 5){
            playerFiveLabel.setVisible(true);
            playerFiveName.setVisible(true);

        }else{
            playerFiveLabel.setVisible(false);
            playerFiveName.setVisible(false);
        }

        if(howMany.getValue() == 6){
            playerSixLabel.setVisible(true);
            playerSixName.setVisible(true);
            numberOfPlayers = 6;
        }else{
            playerSixLabel.setVisible(false);
            playerSixName.setVisible(false);
        }
    }

}

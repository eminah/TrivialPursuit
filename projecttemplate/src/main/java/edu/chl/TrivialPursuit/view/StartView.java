package edu.chl.TrivialPursuit.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.lang.Exception;


/**
 * Created by inatran on 15-04-20.
 *
 * Implementation started by eminahromic on 15-04-21
 */
public class StartView extends Application implements EventHandler<ActionEvent> {


    Stage window;

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Trivial Pursuit");
        //Group root = new Group();
        Scene scene = new Scene(window, 300, 250, Color.WHITE);

        Button startGame = new Button();
        startGame.setTitle("Start new game");
        startGame.setOnAction(new EventHandler<ActionEvent>)

        Button settings = new Button();
        settings.setTitle("Settings");
        settings.setOnAction(new EventHandler<ActionEvent>)

        Buttons rules = new Button();
        rules.setTitle("Rules");
        rules.setOnAction(new EventHandler<ActionEvent>)


        window.setScene(scene);
        window.sizeToScene();
        window.show();


    }



    public void handle(ActionEvent actionEvent) {

    }

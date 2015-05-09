package edu.chl.trivialpursuit.view;

import edu.chl.trivialpursuit.controller.StartController;
import edu.chl.trivialpursuit.model.Start;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;


/*
  Application entry class (if using standard java and Swing)
*/
public class TrivialPursuit extends Application {

    Stage window;

    public static void main(String[] args) {
        launch();



    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Start startModel = new Start();
        StartView startView = new StartView();
        StartController startController = new StartController(startModel,startView);

        window = primaryStage;
        Scene startScene = new Scene(startView,1000,500);
        //Min layout
        startScene.getStylesheets().add("test.css");
        window.setScene(startScene);
        window.setTitle("Trivial Pursuit - Around The World");
        window.show();
    }



}

package edu.chl.trivialpursuit.view;

import edu.chl.trivialpursuit.model.Start;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/*
  Application entry class (if using standard java and Swing)
*/
public class TrivialPursuit extends Application implements EventHandler<ActionEvent> {

    Stage window;
    Scene mainScene;



    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Scene startScene = new Scene(new StartView(),500,500);
        mainScene = new Scene(new MainView(),500,500);
        //Min layout
        startScene.getStylesheets().add("test.css");
        window.setScene(startScene);
        window.setTitle("Trivial Pursuit - The World");
        window.show();
    }

    @Override
    public void handle(ActionEvent event) {


    }
}

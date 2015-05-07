package edu.chl.trivialpursuit.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
        Scene startScene = new Scene(new StartView(),1000,500);


        //Min layout
        startScene.getStylesheets().add("test.css");
        window.setScene(startScene);

        window.setTitle("Trivial Pursuit - The World");
        window.show();
    }

    @Override
    public void handle(ActionEvent event) {
        mainScene = new Scene(new GameBoardView(),500,500);
        window.setScene(mainScene);

    }
}

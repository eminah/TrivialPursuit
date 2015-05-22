package edu.chl.trivialpursuit.view;

import com.airhacks.afterburner.injection.Injector;
import edu.chl.trivialpursuit.controller.StartController;
import edu.chl.trivialpursuit.model.Start;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/*
  Application entry class (if using standard java and Swing)
*/
public class TrivialPursuit extends Application {


 //Detta är våran main bla bla
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Injector.registerExistingAndInject(primaryStage);

        
        final StartView startView = StartView.create();
        startView.show();

        /*
        final CardView cardView = CardView.create();
        cardView.show();
        */

    }
}

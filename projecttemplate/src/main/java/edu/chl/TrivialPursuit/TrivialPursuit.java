package edu.chl.trivialpursuit;

import com.airhacks.afterburner.injection.Injector;
import edu.chl.trivialpursuit.view.StartView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
  Application entry class (if using standard java and Swing)
*/
public class TrivialPursuit extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Injector.registerExistingAndInject(primaryStage);

        final StartView startView = StartView.create();
        startView.show();
    }
}
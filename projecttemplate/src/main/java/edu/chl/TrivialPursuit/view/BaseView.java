package edu.chl.TrivialPursuit.view;

import com.airhacks.afterburner.views.FXMLView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.inject.Inject;

/**
 * Created by Rasti on 2015-05-18.
 */
public class BaseView extends FXMLView {
    final private Scene scene;
    private @Inject Stage stage;

    protected BaseView() {
        super();
        scene = new Scene(getView());
    }

    public Scene getScene() {
        return scene;
    }

    public void show() {
        stage.setScene(getScene());
        stage.setTitle("Trivial Pursuit - Around the World");
        stage.setResizable(false);
        stage.show();
    }
}
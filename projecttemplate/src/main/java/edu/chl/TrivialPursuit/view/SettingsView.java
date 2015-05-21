package edu.chl.trivialpursuit.view;

import com.airhacks.afterburner.injection.Injector;
import edu.chl.trivialpursuit.model.Settings;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

/**
 * Created by eminahromic on 2015-05-11.
 */
public final class SettingsView extends BaseView {

    public SettingsView(){
        super();
    }

    public static SettingsView create() throws IOException {
        final SettingsView settingsView = new SettingsView();
        Injector.injectMembers(SettingsView.class, settingsView);
        return settingsView;

    }
}

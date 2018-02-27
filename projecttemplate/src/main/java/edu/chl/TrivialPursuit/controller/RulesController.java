package edu.chl.TrivialPursuit.controller;

import com.sun.tools.javadoc.Start;
import edu.chl.TrivialPursuit.view.GameBoardView;
import edu.chl.TrivialPursuit.view.StartView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by eminahromic on 2015-05-21.
 */
public class RulesController {

    @FXML
    Button goBack;

    @FXML
    private void onBackPressed(ActionEvent e) throws IOException{

        final StartView startView = StartView.create();
        startView.show();
    }
}
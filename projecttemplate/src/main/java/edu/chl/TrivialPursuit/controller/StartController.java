package edu.chl.TrivialPursuit.controller;

import edu.chl.TrivialPursuit.view.ChoosePlayerView;
import edu.chl.TrivialPursuit.view.RulesView;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javax.inject.Inject;
import java.io.IOException;


public class StartController {

    private @Inject Stage stage;

    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")

    private void onStartPressed(ActionEvent e) throws IOException {

        final ChoosePlayerView chooseView = ChoosePlayerView.create();
        chooseView.show();

        e.consume();
    }

    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")

    private void onEndPressed(){

        stage.close();

    }
    @FXML
    private void rulesButtonPressed() throws IOException {
        RulesView rulesView = RulesView.create();
        rulesView.show();
    }
}

package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.view.ChoosePlayerView;
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
        //Hejsan
        final ChoosePlayerView chooseView = ChoosePlayerView.create();
        chooseView.show();


        e.consume();



    }

    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")

    private void onEndPressed(ActionEvent e){

        stage.close();

    }

}

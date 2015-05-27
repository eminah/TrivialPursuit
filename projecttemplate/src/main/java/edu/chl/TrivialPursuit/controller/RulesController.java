package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.view.GameBoardView;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by eminahromic on 2015-05-21.
 */
public class RulesController {

    private @Inject Stage stage;

    @FXML
    private void onButtonPressed(ActionEvent e) throws IOException {

        final GameBoardView gameBoard = GameBoardView.create();
        gameBoard.show();

        e.consume();
    }

    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")

    private void onEndPressed(ActionEvent e){

        stage.close();
    }
}

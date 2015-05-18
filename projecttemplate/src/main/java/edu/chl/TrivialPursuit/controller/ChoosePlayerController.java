package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.ChoosePlayer;
import edu.chl.trivialpursuit.view.ChoosePlayerView;
import edu.chl.trivialpursuit.view.GameBoardView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Rasti on 2015-05-05.
 */
public class ChoosePlayerController {

    private ChoosePlayer choosePlayerModel;
    private ChoosePlayerView choosePlayerView;
    private Scene gbv;

    public ChoosePlayerController(ChoosePlayer choosePlayerModel, ChoosePlayerView choosePlayerView) {
        this.choosePlayerModel = choosePlayerModel;
        this.choosePlayerView = choosePlayerView;

        choosePlayerView.addButtonListener(new ButtonListener());
    }

    class ButtonListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            if(event.getSource() == choosePlayerView.getDone()) {

                Stage gameBoardView = new Stage();
                gameBoardView.show();

                gbv = new Scene(new GameBoardView(), 1000, 500);
                stage.setScene(gbv);
                stage.show();
            }
        }
    }
}

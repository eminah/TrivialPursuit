package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.view.ChoosePlayerView;
import edu.chl.trivialpursuit.view.ChooseTravelView;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import javafx.event.ActionEvent;
import java.io.IOException;

/**
 * Created by Rasti on 2015-05-05.
 */
public class ChoosePlayerController {

    @FXML
    private ComboBox<String> numPlayers;

    @FXML
    private void onButtonPressed(ActionEvent e) throws IOException{
        System.out.println(numPlayers.getValue());

        final ChooseTravelView chooseTravelView = ChooseTravelView.create();
        chooseTravelView.show();


        e.consume();
    }
}

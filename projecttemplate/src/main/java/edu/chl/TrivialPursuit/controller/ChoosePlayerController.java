package edu.chl.trivialpursuit.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/**
 * Created by Rasti on 2015-05-05.
 */
public class ChoosePlayerController {

    @FXML
    private ComboBox<String> numPlayers;

    @FXML
    private void onButtonPressed() {
        System.out.println(numPlayers.getValue());
    }
}

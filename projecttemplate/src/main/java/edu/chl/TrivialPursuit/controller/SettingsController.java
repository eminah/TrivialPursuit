package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.ChoosePlayer;
import edu.chl.trivialpursuit.model.GameBoard;
import edu.chl.trivialpursuit.view.GameBoardView;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by eminahromic on 2015-05-21.
 */
public class SettingsController {

    @Inject GameBoard gameBoard;

    @FXML
    Slider slider;

    @FXML Button newNameOne, newNameTwo, newNameThree, newNameFour, newNameFive, newNameSix;

    @FXML Button backToBoard;

    @FXML TextField textField1,textField2,textField3,textField4,textField5,textField6;


    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")
    private void backToGameBord() throws IOException{
        final GameBoardView gameBoard = GameBoardView.create();
        gameBoard.show();
    }

    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")
    private void savePlayerNames(ActionEvent e){


        Button buttonPressed = (Button)e.getSource();
        Button[] buttonArray = {newNameOne, newNameTwo, newNameThree, newNameFour, newNameFive, newNameSix};
        TextField[] textFieldsArray = {textField1,textField2,textField3,textField4,textField5,textField6};
        for (int i = 0; i < gameBoard.getAmountOfPlayersPlaying(); i++){
            if (buttonPressed == buttonArray[i]){
                gameBoard.getarrayWithPlayerNameLabels().get(i).setText(textFieldsArray[i].getText());
                gameBoard.getPlayers().get(i).setName(textFieldsArray[i].getText());
            }
        }
    }
}
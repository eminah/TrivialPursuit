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
        if(buttonPressed == newNameOne){

            gameBoard.getarrayWithPlayerNameLabels().get(0).setText(textField1.getText());
            gameBoard.getPlayers().get(0).setName(textField1.getText());

        }else if (buttonPressed == newNameTwo){
            gameBoard.getarrayWithPlayerNameLabels().get(1).setText(textField2.getText());
            gameBoard.getPlayers().get(1).setName(textField2.getText());

        }else if (buttonPressed == newNameThree){
            gameBoard.getarrayWithPlayerNameLabels().get(2).setText(textField3.getText());
            gameBoard.getPlayers().get(2).setName(textField3.getText());

        }else if (buttonPressed == newNameFour){
            gameBoard.getarrayWithPlayerNameLabels().get(3).setText(textField4.getText());
            gameBoard.getPlayers().get(3).setName(textField4.getText());

        }else if (buttonPressed == newNameFive){
            gameBoard.getarrayWithPlayerNameLabels().get(4).setText(textField5.getText());
            gameBoard.getPlayers().get(4).setName(textField5.getText());

        }else{
            gameBoard.getarrayWithPlayerNameLabels().get(5).setText(textField6.getText());
            gameBoard.getPlayers().get(5).setName(textField6.getText());

        }


    }

}
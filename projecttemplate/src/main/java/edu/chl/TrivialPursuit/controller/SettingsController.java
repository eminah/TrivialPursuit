package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.ChoosePlayer;
import edu.chl.trivialpursuit.view.GameBoardView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javax.inject.Inject;
import java.awt.TextField;
import java.io.IOException;

/**
 * Created by eminahromic on 2015-05-21.
 */
public class SettingsController {

    @Inject
    ChoosePlayer player;

    @FXML
    TextField newName1, newName2, newName3, newName4, newName5, newName6;

    @FXML
    Button backToBoard;

    Slider volumeSlider = new Slider();

    private int volume;


    @FXML
    private void backToGameBord(ActionEvent e) throws IOException{
        final GameBoardView gameBoard = GameBoardView.create();
        gameBoard.show();
    }

    @FXML
    private  void saveButton1(){

        player.setNameOne(newName1.getText());

    }

    @FXML
    private void saveButton2(){

        player.setNameOne(newName2.getText());

    }

    @FXML
    private void saveButton3(){

        player.setNameOne(newName3.getText());

    }

    @FXML
    private void saveButton4(){
        player.setNameOne(newName4.getText());


    }

    @FXML
    private void saveButton5(){

        player.setNameOne(newName5.getText());

    }

    @FXML
    private void saveButton6(){

        player.setNameOne(newName6.getText());


    }
}
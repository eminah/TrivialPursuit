package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.ChoosePlayer;
import edu.chl.trivialpursuit.view.ChoosePlayerView;
import edu.chl.trivialpursuit.view.ChooseTravelView;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.inject.Inject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Rasti on 2015-05-05.
 */
public class ChoosePlayerController {

    private ArrayList <TextField> playerTexts;

    @FXML
    private ComboBox<String> numPlayers;

    @FXML
    private TextField tOne, tTwo, tThree,tFour,tFive,tSix;

    private int numberChoosed = 2;

    private boolean firstTime = true;


    @Inject ChoosePlayer choose;



    @FXML
    private void onButtonPressed(ActionEvent e) throws IOException{

        final ChooseTravelView chooseTravelView = ChooseTravelView.create();
        chooseTravelView.show();
        choose.setNumberOfPlayers(numberChoosed);

        addNamesToList();
        e.consume();
    }

    @FXML
    private void comboAction(ActionEvent e){
        if(firstTime) {
            playerTexts = new ArrayList<>();

            playerTexts.add(tOne);
            playerTexts.add(tTwo);
            playerTexts.add(tThree);
            playerTexts.add(tFour);
            playerTexts.add(tFive);
            playerTexts.add(tSix);

            this.firstTime = false;
        }

        this.numberChoosed = Integer.parseInt(numPlayers.getValue());
        for(int i = 0; i < numberChoosed; i++) {
            playerTexts.get(i).setDisable(false);

        }

        for(int j = 5; j >= numberChoosed; j--){
            playerTexts.get(j).setDisable(true);
        }


    }

    private void addNamesToList(){
        for(int i = 0; i < numberChoosed; i++) {
           String name = playerTexts.get(i).getText();
            choose.getPlayerNames().add(name);

        }


    }
}

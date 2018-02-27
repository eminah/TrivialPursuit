package edu.chl.TrivialPursuit.controller;

import edu.chl.TrivialPursuit.model.ChoosePlayer;
import edu.chl.TrivialPursuit.view.ChooseTravelView;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Rasti on 2015-05-05.
 */
public class ChoosePlayerController implements Initializable {

    @Inject
    ChoosePlayer choosePlayer;

    private ArrayList <TextField> playerTexts;
    private ArrayList <String> playerNames;
    private ArrayList <Label> starLabels;
    private int numberChosen;
    private boolean firstTime = true;
    private Font star = new Font("Verdana",18);


    @FXML private ComboBox<String> numPlayers;

    @FXML Button doneButton;

    @FXML Label starLabel, mustPromtNameOne, mustPromtNameTwo, mustPromtNameThree,
            mustPromtNameFour, mustPromtNameFive, mustPromtNameSix;

    @FXML private TextField tOne, tTwo, tThree, tFour, tFive, tSix;

    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")
    private void onButtonPressed() throws IOException{

        if(checkNames()){
            choosePlayer.setNumberOfPlayers(numberChosen = Integer.parseInt(numPlayers.getValue()));

            addNamesToList();
            setNameValues();

            final ChooseTravelView chooseTravelView = ChooseTravelView.create();
            chooseTravelView.show();

        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("You must type in the name of each player");
            alert.showAndWait();
        }


    }

    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")
    private void comboAction(){

        choosePlayer.setNumberOfPlayers(numberChosen = Integer.parseInt(numPlayers.getValue()));
        numberChosen = Integer.parseInt(numPlayers.getValue());

        for(int i = 0; i < numberChosen; i++) {
            playerTexts.get(i).setDisable(false);
        }

        for(int j = 5; j >= numberChosen; j--){
            playerTexts.get(j).setDisable(true);
            playerTexts.get(j).setText("");
        }
        setStars();
        doneButton.setDisable(false);
    }

    private boolean checkNames(){

        switch (choosePlayer.getNumberOfPlayers()){
            case 2:
                if (tOne.getText().length() >= 1 && tTwo.getText().length() >= 1 ){
                    return true;
                }
                break;
            case 3:
                if (tOne.getText().length() >= 1 && tTwo.getText().length() >= 1 && tThree.getText().length() >= 1){
                    return true;
                }
                break;
            case 4:
                if (tOne.getText().length() >= 1 && tTwo.getText().length() >= 1 && tThree.getText().length() >= 1
                    && tFour.getText().length() >= 1){
                    return true;
                }
                break;
            case 5:
                if (tOne.getText().length() >= 1 && tTwo.getText().length() >= 1 && tThree.getText().length() >= 1
                        && tFour.getText().length() >= 1 && tFive.getText().length() >= 1){
                    return true;
                }
            case 6:
                if (tOne.getText().length() >= 1 && tTwo.getText().length() >= 1 && tThree.getText().length() >= 1
                        && tFour.getText().length() >= 1 && tFive.getText().length() >= 1 && tSix.getText().length() >= 1) {
                    return true;
                }
        }
        return false;
    }

    private void addNamesToList(){
        for(int i = 0; i < numberChosen; i++) {
            String name = playerTexts.get(i).getText();
            playerNames.add(name);
        }
    }

    private void setStars(){
        disableStars();

        switch(choosePlayer.getNumberOfPlayers()){
            case 2:
                twoPlayers();
                break;
            case 3:
                threePlayers();
                break;
            case 4:
                fourPlayers();
                break;
            case 5:
                fivePlayers();
                break;
            case 6:
                sixPlayer();
                break;

            default:
                throw new IllegalArgumentException("Something wrong when setting playersName");
        }
    }

    private void disableStars(){
        for (int i = 0; i< starLabels.size(); i++){
            starLabels.get(i).setText("");
        }

    }

    private void placeStar(Label travel){
        travel.setText("*");
        travel.setFont(star);
        travel.setTextFill(Color.RED);
    }

    private void twoPlayers(){
        placeStar(mustPromtNameOne);
        placeStar(mustPromtNameTwo);
    }

    private void threePlayers(){
        twoPlayers();
        placeStar(mustPromtNameThree);

    }

    private void fourPlayers(){
        threePlayers();
        placeStar(mustPromtNameThree);
        placeStar(mustPromtNameFour);
    }

    private void fivePlayers(){
        fourPlayers();
        placeStar(mustPromtNameThree);
        placeStar(mustPromtNameFour);
        placeStar(mustPromtNameFive);
    }

    private void sixPlayer(){
        fivePlayers();
        placeStar(mustPromtNameThree);
        placeStar(mustPromtNameFour);
        placeStar(mustPromtNameFive);
        placeStar(mustPromtNameSix);
    }

    private  void setNameValues(){

        for (int i = 0; i < choosePlayer.getNumberOfPlayers(); i++) {
            switch (i) {
                case 0:
                    choosePlayer.setNameOne(playerNames.get(i));
                    break;
                case 1:
                    choosePlayer.setNameTwo(playerNames.get(i));
                    break;
                case 2:
                    choosePlayer.setNameThree(playerNames.get(i));
                    break;
                case 3:
                    choosePlayer.setNameFour(playerNames.get(i));
                    break;
                case 4:
                    choosePlayer.setNameFive(playerNames.get(i));
                    break;
                case 5:
                    choosePlayer.setNameSix(playerNames.get(i));
                    break;
                default:
                    throw new IllegalArgumentException("Something is wrong");
            }
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerTexts = new ArrayList<>();
        playerNames = new ArrayList<>();
        starLabels = new ArrayList<>();
        playerTexts.add(tOne);
        playerTexts.add(tTwo);
        playerTexts.add(tThree);
        playerTexts.add(tFour);
        playerTexts.add(tFive);
        playerTexts.add(tSix);
        starLabels.add(mustPromtNameOne);
        starLabels.add(mustPromtNameTwo);
        starLabels.add(mustPromtNameThree);
        starLabels.add(mustPromtNameFour);
        starLabels.add(mustPromtNameFive);
        starLabels.add(mustPromtNameSix);
        starLabel.setText("*");
        starLabel.setFont(new Font("Verdana", 18));
        starLabel.setTextFill(Color.RED);
    }


}

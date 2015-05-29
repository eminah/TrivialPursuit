package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.ChoosePlayer;
import edu.chl.trivialpursuit.model.ChooseTravel;
import edu.chl.trivialpursuit.view.ChoosePlayerView;
import edu.chl.trivialpursuit.view.DiceView;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by helenejarl on 2015-05-19.
 */
public class ChooseTravelController implements Initializable {

    @Inject ChoosePlayer choosePlayer;

    @Inject ChooseTravel chooseTravel;

    private ArrayList<ComboBox> theBox;
    private ArrayList<String> travelChoices;
    private Font star = new Font("Verdana",18);

    @FXML Label playerOneName,playerTwoName,playerThreeName,playerFourName,playerFiveName,playerSixName;

    @FXML Label mustChooseOne,mustChooseSec,mustChooseThird,mustChooseFourth,mustChooseFifth,mustChooseSixth;

    @FXML ComboBox<String> c1,c2,c3,c4,c5,c6;

    @FXML Button buttonDone;

    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")
    private void onBackPressed(ActionEvent e) throws IOException{

        final ChoosePlayerView chooseView = ChoosePlayerView.create();
        chooseView.show();
        e.consume();
    }

    @FXML
    private void onDonePressed(ActionEvent e) throws IOException{

        DiceView diceView = DiceView.create();
        diceView.show();
        e.consume();
    }

    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")
    private void firstChoice(){
        setStartPlace(c1, 1);
    }

    @FXML
    private void secondChoice(){
        setStartPlace(c2, 2);
    }

    @FXML
    private void thirdChoice(){
        setStartPlace(c3, 3);
    }

    @FXML
    private void fourthChoice(){
        setStartPlace(c4, 4);
    }

    @FXML
    private void fifthChoice(){
        setStartPlace(c5, 5);
    }

    @FXML
    private void sixthChoice(){
        setStartPlace(c6, 6);
    }

    private void setStartPlace(ComboBox theBoxChosen, int i){
        switch(i) {
            case 1: chooseTravel.setStartPlaceOne((String) theBoxChosen.getValue());
            checkChoices();
                break;
            case 2: chooseTravel.setStartPlaceTwo((String) theBoxChosen.getValue());
                checkChoices();
                break;
            case 3: chooseTravel.setStartPlaceThree((String) theBoxChosen.getValue());
                checkChoices();
                break;
            case 4: chooseTravel.setStartPlaceFour((String) theBoxChosen.getValue());
                checkChoices();
                break;
            case 5: chooseTravel.setStartPlaceFive((String) theBoxChosen.getValue());
                checkChoices();
                break;
            case 6: chooseTravel.setStartPlaceSix((String) theBoxChosen.getValue());
                checkChoices();
                break;
        }
    }

    private void placeStar(Label travel){
        travel.setText("*");
        travel.setFont(star);
        travel.setTextFill(Color.RED);
    }

    private void twoPlayers(){
        playerOneName.setText(choosePlayer.getNameOne());
        playerTwoName.setText(choosePlayer.getNameTwo());
        placeStar(mustChooseOne);
        placeStar(mustChooseSec);
    }

    private void threePlayers(){
        twoPlayers();
        playerThreeName.setText(choosePlayer.getNameThree());
        placeStar(mustChooseThird);

    }

    private void fourPlayers(){
        threePlayers();
        playerThreeName.setText(choosePlayer.getNameThree());
        playerFourName.setText(choosePlayer.getNameFour());
        placeStar(mustChooseThird);
        placeStar(mustChooseFourth);
    }

    private void fivePlayers(){
        fourPlayers();
        playerThreeName.setText(choosePlayer.getNameThree());
        playerFourName.setText(choosePlayer.getNameFour());
        playerFiveName.setText(choosePlayer.getNameFive());
        placeStar(mustChooseThird);
        placeStar(mustChooseFourth);
        placeStar(mustChooseFifth);
    }

    private void sixPlayer(){
        fivePlayers();
        playerThreeName.setText(choosePlayer.getNameThree());
        playerFourName.setText(choosePlayer.getNameFour());
        playerFiveName.setText(choosePlayer.getNameFive());
        playerSixName.setText(choosePlayer.getNameSix());
        placeStar(mustChooseThird);
        placeStar(mustChooseFourth);
        placeStar(mustChooseFifth);
        placeStar(mustChooseSixth);
    }

    private void checkChoices(){
        switch (choosePlayer.getNumberOfPlayers()) {
            case 2:
                if (c1.getValue() != null && c2.getValue() != null) {
                    buttonDone.setDisable(false);
                }
                break;
            case 3:
                if (c1.getValue() != null && c2.getValue() != null && c3.getValue()!= null) {
                    buttonDone.setDisable(false);
                }
                break;
            case 4:
                if (c1.getValue() != null && c2.getValue() != null && c3.getValue()!= null && c4.getValue()!=null) {
                    buttonDone.setDisable(false);
                }
                break;
            case 5:
                if (c1.getValue() != null && c2.getValue() != null && c3.getValue()!= null && c4.getValue()!=null && c5.getValue()!=null) {
                    buttonDone.setDisable(false);
                }
                break;
            case 6:
                if (c1.getValue() != null && c2.getValue() != null && c3.getValue()!= null && c4.getValue()!=null && c5.getValue()!=null && c6.getValue()!=null) {
                    buttonDone.setDisable(false);
                }
                break;
            default:
                throw new IllegalArgumentException("You must choose all continents");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        theBox = new ArrayList<>();
        theBox.add(c1);
        theBox.add(c2);
        theBox.add(c3);
        theBox.add(c4);
        theBox.add(c5);
        theBox.add(c6);
        travelChoices = new ArrayList<>();

        for(int i = 5; i >= choosePlayer.getNumberOfPlayers(); i--) {
            theBox.get(i).setDisable(true);
        }

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
}
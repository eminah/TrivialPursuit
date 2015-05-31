package edu.chl.trivialpursuit.controller;
import edu.chl.trivialpursuit.model.*;
import edu.chl.trivialpursuit.view.ChoosePlayerView;
import edu.chl.trivialpursuit.view.DiceView;
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
 * Created by Heléne Jarl on 2015-05-19.
 */
public class ChooseTravelController implements Initializable {
    @Inject
    ChoosePlayer choosePlayer;
    @Inject
    ChooseTravel chooseTravel;
    private ArrayList<ComboBox> comboBoxArray;
    private ArrayList<String> travelChoices;
    private Font star = new Font("Verdana", 18);
    @FXML
    Label playerOneName, playerTwoName, playerThreeName, playerFourName, playerFiveName, playerSixName;
    @FXML
    Label mustChooseOne, mustChooseSec, mustChooseThird, mustChooseFourth, mustChooseFifth, mustChooseSixth;
    @FXML
    ComboBox<String> choose1, choose2, choose3, choose4, choose5, choose6;
    @FXML
    Button buttonDone;
    @FXML
    private void onBackPressed(ActionEvent e) throws IOException {
        final ChoosePlayerView chooseView = ChoosePlayerView.create();
        chooseView.show();
        e.consume();
    }
    @FXML
    private void onDonePressed(ActionEvent e) throws IOException {
        for (int i = 0; i < choosePlayer.getNumberOfPlayers(); i++) {
            chooseTravel.setStartPlace((String) comboBoxArray.get(i).getValue());
        }
        DiceView diceView = DiceView.create();
        diceView.show();
        e.consume();
    }
    @FXML
    private void choice(ActionEvent e) throws IOException {
        checkChooices();
    }
    private void placeStar(Label travel) {
        travel.setText("*");
        travel.setFont(star);
        travel.setTextFill(Color.RED);
    }
    private void twoPlayers() {
        playerOneName.setText(choosePlayer.getNameOne());
        playerTwoName.setText(choosePlayer.getNameTwo());
        placeStar(mustChooseOne);
        placeStar(mustChooseSec);
    }
    private void threePlayers() {
        twoPlayers();
        playerThreeName.setText(choosePlayer.getNameThree());
        placeStar(mustChooseThird);
    }
    private void fourPlayers() {
        threePlayers();
        playerThreeName.setText(choosePlayer.getNameThree());
        playerFourName.setText(choosePlayer.getNameFour());
        placeStar(mustChooseThird);
        placeStar(mustChooseFourth);
    }
    private void fivePlayers() {
        fourPlayers();
        playerThreeName.setText(choosePlayer.getNameThree());
        playerFourName.setText(choosePlayer.getNameFour());
        playerFiveName.setText(choosePlayer.getNameFive());
        placeStar(mustChooseThird);
        placeStar(mustChooseFourth);
        placeStar(mustChooseFifth);
    }
    private void sixPlayer() {
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
    private void checkChooices() {
        switch (choosePlayer.getNumberOfPlayers()) {
            case 2:
                if (choose1.getValue() != null && choose2.getValue() != null) {
                    buttonDone.setDisable(false);
                }
                break;
            case 3:
                if (choose1.getValue() != null && choose2.getValue() != null && choose3.getValue() != null) {
                    buttonDone.setDisable(false);
                }
                break;
            case 4:
                if (choose1.getValue() != null && choose2.getValue() != null && choose3.getValue() != null && choose4.getValue() != null) {
                    buttonDone.setDisable(false);
                }
                break;
            case 5:
                if (choose1.getValue() != null && choose2.getValue() != null && choose3.getValue() != null && choose4.getValue() != null && choose5.getValue() != null) {
                    buttonDone.setDisable(false);
                }
                break;
            case 6:
                if (choose1.getValue() != null && choose2.getValue() != null && choose3.getValue() != null && choose4.getValue() != null && choose5.getValue() != null && choose6.getValue() != null) {
                    buttonDone.setDisable(false);
                }
                break;
            default:
                throw new IllegalArgumentException("You must choose all continents");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxArray = new ArrayList<>();
        comboBoxArray.add(choose1);
        comboBoxArray.add(choose2);
        comboBoxArray.add(choose3);
        comboBoxArray.add(choose4);
        comboBoxArray.add(choose5);
        comboBoxArray.add(choose6);
        travelChoices = new ArrayList<>();
        for (int i = 5; i >= choosePlayer.getNumberOfPlayers(); i--) {
            comboBoxArray.get(i).setDisable(true);
        }
        switch (choosePlayer.getNumberOfPlayers()) {
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
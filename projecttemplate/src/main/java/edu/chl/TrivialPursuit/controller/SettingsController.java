package edu.chl.TrivialPursuit.controller;

import edu.chl.TrivialPursuit.model.GameBoard;
import edu.chl.TrivialPursuit.view.GameBoardView;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.inject.Inject;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by eminahromic on 2015-05-21.
 */
public class SettingsController implements Initializable {

    @Inject
    GameBoard gameBoard;

    @FXML
    Slider slider;

    @FXML
    CheckBox checkBox;

    @FXML Button newNameOne, newNameTwo, newNameThree, newNameFour, newNameFive, newNameSix;

    @FXML Button backToBoard;

    @FXML TextField textField1,textField2,textField3,textField4,textField5,textField6;

    private TextField[] playersNameTextField;

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

    @FXML
    private void changeCheckBox(ActionEvent e) throws IOException, InterruptedException {
        checkCheckBoxValue();
    }

    private void checkCheckBoxValue() throws IOException, InterruptedException {
        AudioPlayer player = AudioPlayer.player;
        String sound = "/Users/eminahromic/Documents/TDA367/TrivialPursuit2/projecttemplate/happysong.wav";
        InputStream input = new FileInputStream(sound);
        AudioStream audioStream = new AudioStream(input);
        checkBox.setOnAction(event -> {
            Object source = event.getSource();
            if (source == checkBox) {
                if (checkBox.isSelected()) {
                    checkBox.setSelected(true);
                    player.start(audioStream);
                    System.out.print("Started playing sound");
                } else {
                    checkBox.setSelected(false);
                    player.stop(audioStream);
                    System.out.print("Stopped playing sound");
                }
            }
        });
    }

    private void setTextfields() {
        playersNameTextField[0] = textField1;
        playersNameTextField[1] = textField2;
        playersNameTextField[2] = textField3;
        playersNameTextField[3] = textField4;
        playersNameTextField[4] = textField5;
        playersNameTextField[5] = textField6;
    }

    private void setPlayerNames() {
        for (int i = 0; i < gameBoard.getAmountOfPlayersPlaying(); i++) {
            playersNameTextField[i].setText(gameBoard.getPlayers().get(i).getName());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        playersNameTextField = new TextField[6];
        setTextfields();
        setPlayerNames();

        try {
            checkCheckBoxValue();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        slider.setValue(20);
        slider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                // TODO: Connect slider to the music played when checkbox is selected.
            }
        });
    }
}
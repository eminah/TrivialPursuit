package edu.chl.TrivialPursuit.controller;

import edu.chl.TrivialPursuit.model.ChoosePlayer;
import edu.chl.TrivialPursuit.model.Dice;
import edu.chl.TrivialPursuit.model.GameBoard;
import edu.chl.TrivialPursuit.model.Player;
import edu.chl.TrivialPursuit.view.GameBoardView;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.inject.Inject;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ina Tran on 15-04-28.
 */
public class DiceController implements Initializable {

    @Inject
    Dice dice;

    @Inject
    GameBoard game;

    @Inject
    ChoosePlayer choose;

    private Timeline delay;
    private boolean firstTime = true;

    @FXML ImageView dice1;

    @FXML ImageView dice2;

    @FXML Button throwButton;

    @FXML Label who;

    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")
    private void throwDice() throws IOException{

        dice.throwDice();
        changeDiceImage(dice1, dice.getFirstDiceValue());

        throwButton.setDisable(true);
        startTimer();
    }

    private void changeDiceImage(ImageView dicePicture, int firstValue){

        int witchDice = firstValue;
            for (int i = 0;  i < 2; i++){
                switch (witchDice) {
                    case 1:
                        dicePicture.setImage(new Image("edu/chl/trivialpursuit/view/diceOne.png"));
                        break;
                    case 2:
                        dicePicture.setImage(new Image("edu/chl/trivialpursuit/view/diceTwo.png"));
                        break;
                    case 3:
                        dicePicture.setImage(new Image("edu/chl/trivialpursuit/view/diceThree.png"));
                        break;
                    case 4:
                        dicePicture.setImage(new Image("edu/chl/trivialpursuit/view/diceFour.png"));
                        break;
                    case 5:
                        dicePicture.setImage(new Image("edu/chl/trivialpursuit/view/diceFive.png"));
                        break;
                    default:
                        dicePicture.setImage(new Image("edu/chl/trivialpursuit/view/diceSix.png"));
                        break;
                }
                witchDice = dice.getSecondDiceValue();
                dicePicture = dice2;
            }
    }

    public void startTimer(){

        delay = new Timeline(new KeyFrame(Duration.seconds(0.7), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                try {
                    final GameBoardView gameBoardView = GameBoardView.create();
                    gameBoardView.show();

                    e.consume();
                }catch (IOException ex){
                    ex.printStackTrace();
                }

                throwButton.setDisable(false);
                game.fixArrow();
            }
        }));
        delay.play();
    }

    private void setName(){
      who.setText("Player:" + " " + game.getCurrentPlayerPlaying().getName());

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setName();
    }
}
package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.ChoosePlayer;
import edu.chl.trivialpursuit.model.Dice;
import edu.chl.trivialpursuit.model.GameBoard;
import edu.chl.trivialpursuit.view.GameBoardView;
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
import javafx.scene.text.Font;
import javafx.util.Duration;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by inatran on 15-04-28.
 */
public class DiceController implements Initializable {

    @Inject Dice dice;

    @Inject GameBoard game;

    @Inject ChoosePlayer choose;

    private Timeline delay;
    private Font arrow = new Font("Verdana",16);

    @FXML ImageView dice1;

    @FXML ImageView dice2;

    @FXML Button throwButton;

    @FXML Label who;

    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")
    private void throwDice(ActionEvent e) throws IOException{

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
                    case 6:
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
                fixArrow();
                setName();
            }
        }));
        delay.play();
    }

    private void fixArrow(){
        //remove the arrow
        for(int i = 0;i < game.getLabelTurns().size(); i++) {
            game.getLabelTurns().get(i).setText("");
        }
        game.getLabelTurns().get(game.getTurn()-1).setText("<-- " + dice.getTotalDiceValue() + " steps!");
        game.getLabelTurns().get(game.getTurn()-1).setFont(arrow);
    }

    private void setName(){
        switch (game.getTurn()){
            case 1:
                who.setText(choose.getNameOne() + ", throw the dice!");
                break;
            case 2:
                who.setText(choose.getNameTwo() + ", throw the dice!");
                break;
            case 3:
                who.setText(choose.getNameThree()  + ", throw the dice!");
                break;
            case 4:
                who.setText(choose.getNameFour()  + ", throw the dice!");
                break;
            case 5:
                who.setText(choose.getNameFive()  + ", throw the dice!");
                break;
            case 6:
                who.setText(choose.getNameSix()  + ", throw the dice!");
                break;
            default:
                who.setText(choose.getNameOne()  + ", throw the dice!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setName();
    }
}
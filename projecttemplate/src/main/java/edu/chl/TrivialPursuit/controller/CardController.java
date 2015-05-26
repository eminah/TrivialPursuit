package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.view.DiceView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.io.IOException;


/**
 * Created by helenejarl on 2015-05-07.
 */
public class CardController{

    private Timeline delay;

    @FXML
    Button alt1, alt2, alt3, alt4;

    @FXML
    public void altOnePressed(ActionEvent e) {

        alt1.setStyle("-fx-background-color: #65ff3c;");
        alt2.setDisable(true);
        alt3.setDisable(true);
        alt4.setDisable(true);
        startTimer();
    }

    @FXML
    public void altTwoPressed(ActionEvent e) {

        
        alt2.setStyle("-fx-background-color: #65ff3c");
        alt1.setDisable(true);
        alt3.setDisable(true);
        alt4.setDisable(true);
        startTimer();
    }

    @FXML
    public void altThreePressed(ActionEvent e) {

        alt3.setStyle("-fx-background-color: #65ff3c");
        alt1.setDisable(true);
        alt2.setDisable(true);
        alt4.setDisable(true);
        startTimer();
    }

    @FXML
    public void altFourPressed(ActionEvent e) {

        alt4.setStyle("-fx-background-color: #65ff3c");
        alt1.setDisable(true);
        alt2.setDisable(true);
        alt3.setDisable(true);
        startTimer();
    }

    /**
     * An delay that starts when you click on an alternative,
     * this delay prevents you from choose more than one alternative
     */
    public void startTimer() {

        delay = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event)  {

                alt1.setStyle("-fx-background-color: #b2b5b7");
                alt2.setStyle("-fx-background-color: #b2b5b7");
                alt3.setStyle("-fx-background-color: #b2b5b7");
                alt4.setStyle("-fx-background-color: #b2b5b7");
                alt1.setDisable(true);
                alt2.setDisable(true);
                alt3.setDisable(true);
                alt4.setDisable(true);


                //Changes back to the gameBoard
                try{
                    final DiceView diceView = DiceView.create();
                    diceView.show();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }));

        delay.play();

    }


}

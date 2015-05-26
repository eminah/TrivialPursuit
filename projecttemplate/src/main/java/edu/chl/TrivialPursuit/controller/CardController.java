package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.*;
import edu.chl.trivialpursuit.view.DiceView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by helenejarl on 2015-05-07.
 */
public class CardController implements Initializable{

    @FXML
    Label question;

    @FXML
    Button alt1, alt2, alt3, alt4;

    @Inject
    GameBoard game;



    private Timeline delay;
    private Alternative correctAlt;
    private Alternative answer;
    private Player player;


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

    /**
     * Gets continent of the card that is  connected to the current players spot
     * @param continent the continent of the specifik card that the player will get
     */
    private void setCard(Continent continent){

        if( continent == Continent.ASIA){
            //card.setCorrectAlt(Alternative.ALTERNATIVE2);
            question.setText("This is an Asia Question, please press on Asia:");
            alt1.setText("Africa");
            alt2.setText("Asia");
            alt3.setText("North America");
            alt4.setText("South Ametica");

        }else if( continent == Continent.AFRICA){

            //card.setCorrectAlt(Alternative.ALTERNATIVE1);
            question.setText("This is an Africa Question, please press on Africa:");
            alt1.setText("Africa");
            alt2.setText("Asia");
            alt3.setText("North America");
            alt4.setText("South Ametica");

        }else if(continent == Continent.NORTH_AMERICA){
            //card.setCorrectAlt(Alternative.ALTERNATIVE3);
            question.setText("This is an North America Question, please press on North America:");
            alt1.setText("Africa");
            alt2.setText("Asia");
            alt3.setText("North America");
            alt4.setText("South Ametica");

        }else{

            //card.setCorrectAlt(Alternative.ALTERNATIVE4);
            question.setText("This is an South America Question, please press on South America:");
            alt1.setText("Africa");
            alt2.setText("Asia");
            alt3.setText("North America");
            alt4.setText("South Ametica");
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setCard(game.getPlayers().get(game.getTurn() - 1).getSpot().getCard().getContinent());
    }


    public Alternative getCorrectAlt() {
        return correctAlt;
    }

    public void setCorrectAlt(Alternative correctAlt) {
        this.correctAlt = correctAlt;
    }

    public void setAnswer(Alternative answer) {
        this.answer = answer;
    }



    public boolean checkAnswer(Alternative ans){
        answer = ans;

        if( answer.equals(correctAlt)){
            //player.getCollectedContinents().add(continent);
            if (player.checkIfAllContinents()){
                player.setHasTicket(true);
            }
            return true;
        }else{
            return false;
        }
    }
}

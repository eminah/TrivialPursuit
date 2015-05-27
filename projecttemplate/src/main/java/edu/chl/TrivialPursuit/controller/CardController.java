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
import javafx.scene.text.Font;
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

    @Inject
    ChoosePlayer chooseP;

    @Inject
    Dice dice;







    private Timeline delay;
    private Alternative correctAlt;
    private Alternative answer;
    private boolean[] getTurn;
    private Font arrow = new Font("Verdana",18);




    @FXML
    public void altOnePressed(ActionEvent e) {
        checkAnswer(1,Alternative.ALTERNATIVE1);
        disableAllAlts(1);
        startTimer();
    }

    @FXML
    public void altTwoPressed(ActionEvent e) {

        checkAnswer(2, Alternative.ALTERNATIVE2);
        disableAllAlts(2);
        startTimer();
    }

    @FXML
    public void altThreePressed(ActionEvent e) {
        checkAnswer(3, Alternative.ALTERNATIVE3);
        disableAllAlts(3);
        startTimer();
    }

    @FXML
    public void altFourPressed(ActionEvent e) {
        checkAnswer(4, Alternative.ALTERNATIVE4);
        disableAllAlts(4);
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
                enableAllAlts();

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

    private void disableAllAlts(int theChoosen){

        alt1.setDisable(true);
        alt2.setDisable(true);
        alt3.setDisable(true);
        alt4.setDisable(true);

        switch (theChoosen){
            case 1:
                alt1.setDisable(false);
                break;
            case 2:
                alt2.setDisable(false);
                break;
            case 3:
                alt3.setDisable(false);
                break;
            case 4:
                alt4.setDisable(false);
                break;
        }

    }

    private void enableAllAlts(){
        alt1.setDisable(false);
        alt2.setDisable(false);
        alt3.setDisable(false);
        alt4.setDisable(false);
    }

    /**
     * Gets continent of the card that is  connected to the current players spot
     * @param continent the continent of the specifik card that the player will get
     */
    private void setCard(Continent continent){

        if( continent == Continent.ASIA){
            correctAlt = Alternative.ALTERNATIVE2;
            question.setText("This is an Asia Question, please press on Asia:");
            alt1.setText("Africa");
            alt2.setText("Asia");
            alt3.setText("North America");
            alt4.setText("South Ametica");

        }else if( continent == Continent.AFRICA){

            correctAlt = Alternative.ALTERNATIVE1;
            question.setText("This is an Africa Question, please press on Africa:");
            alt1.setText("Africa");
            alt2.setText("Asia");
            alt3.setText("North America");
            alt4.setText("South Ametica");

        }else if(continent == Continent.NORTH_AMERICA){
            correctAlt = Alternative.ALTERNATIVE3;
            question.setText("This is an North America Question, please press on North America:");
            alt1.setText("Africa");
            alt2.setText("Asia");
            alt3.setText("North America");
            alt4.setText("South Ametica");

        }else{

            correctAlt = Alternative.ALTERNATIVE4;
            question.setText("This is an South America Question, please press on South America:");
            alt1.setText("Africa");
            alt2.setText("Asia");
            alt3.setText("North America");
            alt4.setText("South Ametica");
        }

    }

    public boolean checkAnswer(int theAlt, Alternative ans){
        answer = ans;


        if( answer.equals(correctAlt)){
            Player currentPlayer = game.getPlayers().get(game.getTurn()-1);
            Continent currentContinent = game.getPlayers().get(game.getTurn()-1).getSpot().getCard().getContinent();
            currentPlayer.getCollectedContinents().add(currentContinent);

            switch(theAlt){
                case 1:
                    alt1.setStyle("-fx-background-color: lawngreen");

                    break;
                case 2:
                    alt2.setStyle("-fx-background-color: lawngreen");
                    break;
                case 3:
                    alt3.setStyle("-fx-background-color: lawngreen");

                    break;
                case 4:
                    alt4.setStyle("-fx-background-color: lawngreen");

                    break;
            }

            if (currentPlayer.checkIfAllContinents()){
                currentPlayer.setHasTicket(true);
            }
            return true;
        }else{

            switch(theAlt){
                case 1:
                    alt1.setStyle("-fx-background-color: red");

                    break;
                case 2:
                    alt2.setStyle("-fx-background-color: red");
                    break;
                case 3:
                    alt3.setStyle("-fx-background-color: red");

                    break;
                case 4:
                    alt4.setStyle("-fx-background-color: red");

                    break;
            }

            setNextTurn();
            setArrow();



            return false;
        }
    }




    public int whosTurn() {

        for(int i = 0; i < getTurn.length; i++){
            if(getTurn[i]==true){
                return i+1;
            }
        }
        return -1;
    }



    /**
     * Set next players turn
     * Called if the player answers wrong
     */



    public void setNextTurn(){

        for(int i = 0; i < getTurn.length; i++){
            if(getTurn[i]==true){
                getTurn[i] = false;
                if(i+1 == getTurn.length){
                    getTurn[0] = true;
                    game.setTurn(whosTurn());
                    break;
                }else{
                    getTurn[i+1] = true;
                    game.setTurn(whosTurn());
                    break;
                }
            }
        }

        setArrow();


    }

    public void setArrow(){



        int theOneToChange = game.getTurn() - 1;


        //remove the arrow
        for(int i = 0;i < game.getLabelTurns().size(); i++){
            game.getLabelTurns().get(i).setText("");
        }



        // places the arrow on the correct player
        switch (whosTurn()){


            case 1:
                game.getLabelTurns().get(theOneToChange).setText("<--" + +dice.getTotalDiceValue() + " steps!");
                game.getLabelTurns().get(theOneToChange).setFont(arrow);
                break;
            case 2:
                game.getLabelTurns().get(theOneToChange).setText("<--" + +dice.getTotalDiceValue() + " steps!");
                game.getLabelTurns().get(theOneToChange).setFont(arrow);
                break;
            case 3:
                game.getLabelTurns().get(theOneToChange).setText("<--" + +dice.getTotalDiceValue() + " steps!");
                game.getLabelTurns().get(theOneToChange).setFont(arrow);
                break;
            case 4:
                game.getLabelTurns().get(theOneToChange).setText("<--" + +dice.getTotalDiceValue() + " steps!");
                game.getLabelTurns().get(theOneToChange).setFont(arrow);
                break;
            case 5:
                game.getLabelTurns().get(theOneToChange).setText("<--" + +dice.getTotalDiceValue() + " steps!");
                game.getLabelTurns().get(theOneToChange).setFont(arrow);
                break;
            case 6:
                game.getLabelTurns().get(theOneToChange).setText("<--" + +dice.getTotalDiceValue() + " steps!");
                game.getLabelTurns().get(theOneToChange).setFont(arrow);
                break;
            default: throw new IllegalArgumentException("Wrong whos turn");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setCard(game.getPlayers().get(game.getTurn() - 1).getSpot().getCard().getContinent());

        getTurn = new boolean[chooseP.getNumberOfPlayers()];

        for (int i = 0; i < getTurn.length; i++) {
            getTurn[i] = false;
        }
        getTurn[0] = true;


    }


}






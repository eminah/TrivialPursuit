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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

/**
 * Created by helenejarl on 2015-05-07.
 */
public class CardController implements Initializable{

    @Inject GameBoard game;

    @Inject ChoosePlayer chooseP;

    @Inject Dice dice;

    private Timeline delay;
    private Alternative correctAlt;
    private Alternative answer;
    private boolean[] getTurn;
    private Font arrow = new Font("Verdana",18);

    @FXML Label question;

    @FXML Button alt1, alt2, alt3, alt4;

    @FXML
    public void altOnePressed(ActionEvent e) {
        checkAnswer(1,Alternative.ALTERNATIVE_ONE);
        disableAllAlts(1);
        startTimer();
    }

    @FXML
    public void altTwoPressed(ActionEvent e) {

        checkAnswer(2, Alternative.ALTERNATIVE_TWO);
        disableAllAlts(2);
        startTimer();
    }

    @FXML
    public void altThreePressed(ActionEvent e) {
        checkAnswer(3, Alternative.ALTERNATIVE_THREE);
        disableAllAlts(3);
        startTimer();
    }

    @FXML
    public void altFourPressed(ActionEvent e) {
        checkAnswer(4, Alternative.ALTERNATIVE_FOUR);
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

        if(continent == Continent.ASIA){
            correctAlt = Alternative.ALTERNATIVE_TWO;
            question.setText("This is an Asia Question, please press on Asia:");
            alt1.setText("Africa");
            alt2.setText("Asia");
            alt3.setText("North America");
            alt4.setText("South America");

        }else if(continent == Continent.AFRICA){
            correctAlt = Alternative.ALTERNATIVE_ONE;
            question.setText("This is an Africa Question, please press on Africa:");
            alt1.setText("Africa");
            alt2.setText("Asia");
            alt3.setText("North America");
            alt4.setText("South America");

        }else if(continent == Continent.NORTH_AMERICA){
            correctAlt = Alternative.ALTERNATIVE_THREE;
            question.setText("This is an North America Question, please press on North America:");
            alt1.setText("Africa");
            alt2.setText("Asia");
            alt3.setText("North America");
            alt4.setText("South America");
        }else{
            correctAlt = Alternative.ALTERNATIVE_FOUR;
            question.setText("This is an South America Question, please press on South America:");
            alt1.setText("Africa");
            alt2.setText("Asia");
            alt3.setText("North America");
            alt4.setText("South America");
        }
    }

    public boolean checkAnswer(int theAlt, Alternative ans){
        answer = ans;

        if( answer.equals(correctAlt)){
            Player currentPlayer = game.getPlayers().get(game.getTurn()-1);
            //Continent currentContinent = game.getPlayers().get(game.getTurn()-1).getSpot().getCard().getContinent();
           // currentPlayer.getCollectedContinents().add(currentContinent);
            changePic(currentPlayer);

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

            //TODO Dialog för sysout:en
            if (currentPlayer.checkIfAllContinents()){
                currentPlayer.setHasTicket(true);
                System.out.println(currentPlayer.getName() + " know have collected all continents,/n" +
                        " and now have the ticket to Europe!  ");
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
            return false;
        }
    }

    private void changePic(Player player){

        HashSet<Continent> continentSet = player.getCollectedContinents();

        if(continentSet.contains(Continent.ASIA)){
            setPic(game.getiAs(), 1);
        }
        if(continentSet.contains(Continent.AFRICA)){
            setPic(game.getiAf(), 2);
        }
        if(continentSet.contains(Continent.SOUTH_AMERICA)){
            setPic(game.getiS(), 3);
        }
        if(continentSet.contains(Continent.NORTH_AMERICA)){
            setPic(game.getiN(), 4);
        }
    }

    private void setPic(ArrayList<ImageView> iv, int i){
        int pTurn = whosTurn()-1;
        switch (whosTurn()){
            case 1:
                switch (i){
                    case 1:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/asia_gold.png"));
                        break;
                    case 2:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/africa_gold.png"));
                        break;
                    case 3:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/southAm_gold.png"));
                        break;
                    case 4:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/northAm_gold.png"));
                        break;
                }
                break;
            case 2:
                switch (i){
                    case 1:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/asia_gold.png"));
                        break;
                    case 2:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/africa_gold.png"));
                        break;
                    case 3:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/southAm_gold.png"));
                        break;
                    case 4:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/northAm_gold.png"));
                        break;
                }
                break;
            case 3:
                switch (i){
                    case 1:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/asia_gold.png"));
                        break;
                    case 2:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/africa_gold.png"));
                        break;
                    case 3:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/southAm_gold.png"));
                        break;
                    case 4:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/northAm_gold.png"));
                        break;
                }
                break;
            case 4:
                switch (i){
                    case 1:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/asia_gold.png"));
                        break;
                    case 2:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/africa_gold.png"));
                        break;
                    case 3:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/southAm_gold.png"));
                        break;
                    case 4:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/northAm_gold.png"));
                        break;
                }
                break;
            case 5:
                switch (i){
                    case 1:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/asia_gold.png"));
                        break;
                    case 2:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/africa_gold.png"));
                        break;
                    case 3:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/southAm_gold.png"));
                        break;
                    case 4:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/northAm_gold.png"));
                        break;
                }
                break;
            case 6:
                switch (i){
                    case 1:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/asia_gold.png"));
                        break;
                    case 2:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/africa_gold.png"));
                        break;
                    case 3:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/southAm_gold.png"));
                        break;
                    case 4:
                        iv.get(pTurn).setImage(new Image("edu/chl/trivialpursuit/view/northAm_gold.png"));
                        break;
                }
                break;
            default:
                throw new IllegalArgumentException("");
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //setCard(game.getPlayers().get(game.getTurn() - 1).getSpot().getCard().getContinent());

        getTurn = new boolean[chooseP.getNumberOfPlayers()];

        for (int i = 0; i < getTurn.length; i++) {
            getTurn[i] = false;
        }
        int turnIndex = game.getTurn()-1;
        switch(turnIndex) {

            case 0:
            getTurn[turnIndex] = true;
                break;
            case 1:
                getTurn[turnIndex] = true;
                break;
            case 2:
                getTurn[turnIndex] = true;
                break;
            case 3:
                getTurn[turnIndex] = true;
                break;
            case 4:
                getTurn[turnIndex] = true;
                break;
            case 5:
                getTurn[turnIndex] = true;
                break;
        }
    }
}

package edu.chl.TrivialPursuit.controller;

import edu.chl.TrivialPursuit.model.Alternative;
import edu.chl.TrivialPursuit.model.Category;
import edu.chl.TrivialPursuit.model.Continent;
import edu.chl.TrivialPursuit.model.GameBoard;
import edu.chl.TrivialPursuit.view.DiceView;
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

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Rasti on 2015-05-28.
 */
public class SouthAmericaCardController implements Initializable {

    @Inject
    GameBoard game;

    private Timeline changeViewDelay;
    private Timeline disableButtonDelay;
    private Button theButtonPressed;

    @FXML Button altOne,altTwo,altThree,altFour;

    @FXML
    Label cardPlayerNameLabel;

    @FXML
    Label question;

    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")
    private void onButtonPressed(ActionEvent e) {
        theButtonPressed = (Button) e.getSource();
        doWhenGuessed();
    }

    @SuppressFBWarnings()
    private void doWhenGuessed(){

        if(trueIfCorrectAnswer(getAnswerAsAlternative(theButtonPressed))){
            theButtonPressed.setStyle("-fx-background-color: lawngreen");
            ImageView theContinentToChange = game.getiS().get(game.getCurrentTurnNumberArrayIndex());
            theContinentToChange.setImage(new Image("edu/chl/trivialpursuit/view/southAm_gold.png"));
            game.getCurrentPlayerPlaying().getCollectedContinents().add(Continent.SOUTH_AMERICA);
            if(game.getCurrentPlayerPlaying().checkIfAllContinents()) {
                game.getCurrentPlayerPlaying().setHasTicket(true);
            }
            startTimer();
        } else {
            theButtonPressed.setStyle("-fx-background-color: red");
            game.setNextTurn(game.getAmountOfPlayersPlaying());
            startTimer();
        }
    }

    public boolean trueIfCorrectAnswer(Alternative answer){
        Alternative theCorrectAlternativeOfTheCard = game.getCurrentPlayerPlaying().getSpot().getCard().getCorrectAlternative();
        return answer == theCorrectAlternativeOfTheCard ;
    }

    public Alternative getAnswerAsAlternative(Button pressed){
        if(pressed.equals(altOne)){
            return Alternative.ALTERNATIVE_ONE;
        }else if(pressed.equals(altTwo)){
            return Alternative.ALTERNATIVE_TWO;
        }else if(pressed.equals(altThree)){
            return Alternative.ALTERNATIVE_THREE;
        }else{
            return Alternative.ALTERNATIVE_FOUR;
        }
    }

    public void startTimer() {

        disableButtonDelay = new Timeline(new KeyFrame(Duration.seconds(0.3), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event)  {
                disableAllAlternatives();
                changeViewDelay.play();
            }
        }));
        disableButtonDelay.play();


        changeViewDelay = new Timeline(new KeyFrame(Duration.seconds(0.7), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event)  {

                game.fixArrow();
                if(!game.getCurrentPlayerPlaying().isInEurope()) {
                    game.getButtonLeft().setDisable(false);
                    game.getButtonRight().setText("Go Right");
                    try {
                        final DiceView diceView = DiceView.create();
                        diceView.show();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                } else {
                    game.getButtonLeft().setDisable(true);
                    game.getButtonRight().setText("Question");

                    try {
                        GameBoardView gameBoardView = GameBoardView.create();
                        gameBoardView.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                enableAllAlternatives();
            }
        }));
    }

    public void disableAllAlternatives(){
        altOne.setDisable(true);
        altTwo.setDisable(true);
        altThree.setDisable(true);
        altFour.setDisable(true);
    }

    public void enableAllAlternatives(){
        altOne.setDisable(true);
        altTwo.setDisable(true);
        altThree.setDisable(true);
        altFour.setDisable(true);
    }

    private void checkQuestionType() {
        Category currentPlayerSpotCategory = game.getCurrentPlayerPlaying().getSpot().getCategory();
        //Correct answer: A
        switch (currentPlayerSpotCategory) {
            case CULTURE:
                question.setText("CULTURE: \nThis is a South America culture question");
                setQuestionAlternatives("A. South American Culture", "B. North American Culture", "C. Asian Culture", "D. European Culture");
                break;
            case MEDIA:
                question.setText("MEDIA: \nThis is a South America media question.");
                setQuestionAlternatives("A. South American Media", "B. Asian Media", "C. European Media", "D. African Media");
                break;
            case SPORT:
                question.setText("SPORT: \nHow many times have Brazil won the \nWorld Cup?");
                setQuestionAlternatives("A. 5", "B. 4", "C. 6", "D. 3");
                break;
            case HISTORY:
                question.setText("HISTORY: \nWhen did the first subway open in \nRio de Janeiro?");
                setQuestionAlternatives("A. 1979", "B. 1989", "C. 1969", "D. 1959");
                break;
            case TECHNIC:
                question.setText("TECHNICAL: \nThis is a South America technical \nquestion");
                setQuestionAlternatives("A. South American Technics", "B. African Technics", "C. Asian Technics", "D. North American Technics");
                break;
            case GEOGRAPHY:
                question.setText("GEOGRAPHY: \nLake Titicaca is on the border of Peru \nand what other South American country?");
                setQuestionAlternatives("A. Bolivia", "B. Colombia", "C. Uruguay", "D. Ecuador");
                break;
        }
    }

    private void setQuestionAlternatives(String firstAlternative, String secondAlternative, String thirdAlternative, String fourthAlternative) {
        altOne.setText(firstAlternative);
        altTwo.setText(secondAlternative);
        altThree.setText(thirdAlternative);
        altFour.setText(fourthAlternative);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cardPlayerNameLabel.setText("Player:" + " " + game.getCurrentPlayerPlaying().getName());
        checkQuestionType();
    }
}

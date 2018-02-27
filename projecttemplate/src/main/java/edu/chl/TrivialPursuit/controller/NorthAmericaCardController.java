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
public class NorthAmericaCardController implements Initializable {

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
    public void doWhenGuessed() {

        if(trueIfCorrectAnswer(getAnswerAsAlternative(theButtonPressed))) {
            theButtonPressed.setStyle("-fx-background-color: lawngreen");
            ImageView theContinentToChange = game.getiN().get(game.getCurrentTurnNumberArrayIndex());
            game.getCurrentPlayerPlaying().getCollectedContinents().add(Continent.NORTH_AMERICA);
            theContinentToChange.setImage(new Image("edu/chl/trivialpursuit/view/northAm_gold.png"));

            if(game.getCurrentPlayerPlaying().checkIfAllContinents()) {
                game.getCurrentPlayerPlaying().setHasTicket(true);
            }
        } else {
            theButtonPressed.setStyle("-fx-background-color: red");
            game.setNextTurn(game.getAmountOfPlayersPlaying());
        }

        startTimer();
    }

    public boolean trueIfCorrectAnswer(Alternative answer){
        Alternative theCorrectAlternativeOfTheCard = game.getPlayers().get(game.getCurrentTurnNumberArrayIndex()).getSpot().getCard().getCorrectAlternative();
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
        //Correct alternative: B
        switch (currentPlayerSpotCategory) {
            case CULTURE:
                question.setText("CULTURE: \nThis is a North America culture question");
                setQuestionAlternatives("A. Asian Culture","B. North American Culture","C. African Culture","D. European Culture");
                break;
            case MEDIA:
                question.setText("MEDIA: \nWho has won most grammys \nthroughout the years?");
                setQuestionAlternatives("A. Clint Eastwood", "B. Meryl Streep", "C. Leonardo DiCaprio","D. Jennifer Lawrence");
                break;
            case SPORT:
                question.setText("SPORT: \nWhich team has won the most Super \nBowls?");
                setQuestionAlternatives("A. Patriots","B. Steelers","C. Giants","D. Packers");
                break;
            case HISTORY:
                question.setText("HISTORY: \nWho was the first president of the US?");
                setQuestionAlternatives("A. John Adams","B. George Washington","C. James Monroe","D. John Tyler");
                break;
            case TECHNIC:
                question.setText("TECHNICAL: \nThis is a North America technical \nquestion");
                setQuestionAlternatives("A. African Technics","B. North American Tehcnics","C. South American Technics","D. Asian Technics");
                break;
            case GEOGRAPHY:
                question.setText("GEOGRAPHY: \nWhich ocean bounds the northernmost of the two \ncontinents of the Western Hemisphere??");
                setQuestionAlternatives("A. Atlantic Ocean","B. Pacific Ocean","C. Carribean Sea","D. Arctic Ocean");
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

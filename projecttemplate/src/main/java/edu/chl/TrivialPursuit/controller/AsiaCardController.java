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
public class AsiaCardController implements Initializable {
    @Inject
    GameBoard game;

    @FXML Button altOne,altTwo,altThree,altFour;

    @FXML
    Label cardPlayerNameLabel;

    @FXML
    Label question;

    private Timeline changeViewDelay;
    private Timeline disableButtonDelay;
    private Button theButtonPressed;


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
            ImageView theContinentToChange = game.getiAs().get(game.getCurrentTurnNumberArrayIndex());
            theContinentToChange.setImage(new Image("edu/chl/trivialpursuit/view/asia_gold.png"));
            game.getCurrentPlayerPlaying().getCollectedContinents().add(Continent.ASIA);

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

    public boolean trueIfCorrectAnswer(Alternative answer){
        Alternative theCorrectAlternativeOfTheCard = game.getCurrentPlayerPlaying().getSpot().getCard().getCorrectAlternative();
        return answer == theCorrectAlternativeOfTheCard ;
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
        //Correct answer: D
        switch (currentPlayerSpotCategory) {
            case CULTURE:
                question.setText("CULTURE: \nThis is an Asian culture question");
                setQuestionAlternatives("A. African Culture", "B. South American Culture", "C. North American Culture", "D. Asian Culture");
                break;
            case MEDIA:
                question.setText("MEDIA: \nWhich is the number one rated movie \nin Asia?");
                setQuestionAlternatives("A. Single Rider","B. The Villainess","C. The Merciless", "D. Ikari");
                break;
            case SPORT:
                question.setText("SPORT: \nWhich is the most popular sport in Asia?");
                setQuestionAlternatives("A. Badminton","B. Running", "C. Football", "D. Table Tennis");
                break;
            case HISTORY:
                question.setText("HISTORY: \nWhen was the Olympics held in Beijing, \nChina?");
                setQuestionAlternatives("A. 2009","B. 2007","C. 2010","D. 2008");
                break;
            case TECHNIC:
                question.setText("TECHNICAL: \nThis is an Asian technical question");
                setQuestionAlternatives("A. African Technics","B. North American Technics","C. European Technics", "D. Asian Technics");
                break;
            case GEOGRAPHY:
                question.setText("GEOGRAPHY: \nHow much of the Earth’s total \nsurface area does Asia cover?");
                setQuestionAlternatives("A. 9.8","B. 7.8","C. 10.8", "D. 8.8");
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

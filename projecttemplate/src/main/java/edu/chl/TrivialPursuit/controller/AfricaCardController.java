package edu.chl.TrivialPursuit.controller;

import edu.chl.TrivialPursuit.model.*;
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
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Rasti on 2015-05-28.
 */
public class AfricaCardController implements Initializable {

    @Inject GameBoard game;
    @Inject AfricaCard africaCard;

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
        startTimer();
    }
    @SuppressFBWarnings()
    public void doWhenGuessed() {

        if(trueIfCorrectAnswer(getAnswerAsAlternative(theButtonPressed))) {
            theButtonPressed.setStyle("-fx-background-color: lawngreen");
            ImageView theContinentToChange = game.getiAf().get(game.getCurrentTurnNumberArrayIndex());
            game.getCurrentPlayerPlaying().getCollectedContinents().add(Continent.AFRICA);
            theContinentToChange.setImage(new Image("edu/chl/trivialpursuit/view/africa_gold.png"));

            if(game.getCurrentPlayerPlaying().checkIfAllContinents()) {
                game.getCurrentPlayerPlaying().setHasTicket(true);
            }
        } else {
            theButtonPressed.setStyle("-fx-background-color: red");
            game.setNextTurn(game.getAmountOfPlayersPlaying());
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
       return africaCard.checkIfCorrectAlternative(answer);
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
        // Correct answer: C

        switch (currentPlayerSpotCategory) {
            case CULTURE:
                question.setText("CULTURE: \nThis is an African culture question");
                setQuestionAlternatives("A. South American Culture", "B. Asian Culture", "C. African Culture", "D. European Culture");
                break;
            case MEDIA:
                question.setText("MEDIA: \nWhere is Nollywood, the second biggest \nmovie industry in the world in \nterms of number of films made?");
                setQuestionAlternatives("A. Namibia", "B. Nairobi", "C. Nigeria", "D. Nelspruit");
                break;
            case SPORT:
                question.setText("SPORT: \nWhich is the most popular sport in \nAfrica?");
                setQuestionAlternatives("A. Rugby", "B. Cycling", "C. Football", "D. Aethletics");
                break;
            case HISTORY:
                question.setText("HISTORY: \nWho performed at Zimbabwe's \nindependence day celebrations in 1980?");
                setQuestionAlternatives("A. Paul Simon", "B. Tracy Chapman", "C. Bob Marley", "D. Bono");
                break;
            case TECHNIC:
                question.setText("TECHNICAL: \nThis is an African technical question");
                setQuestionAlternatives("A. Asian Technics", "B. European Technics","C. African Technics","D. North American Technics");
                break;
            case GEOGRAPHY:
                question.setText("GEOGRAPHY: \nWhat desert extends across Northern \nAfrica?");
                setQuestionAlternatives("A. Gobi", "B. Mojave", "C. Sahara", "D. Atacama");
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
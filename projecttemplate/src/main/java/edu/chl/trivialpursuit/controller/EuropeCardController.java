package edu.chl.TrivialPursuit.controller;

import edu.chl.TrivialPursuit.model.Alternative;
import edu.chl.TrivialPursuit.model.Category;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ina Tran on 2015-05-28.
 */
public class EuropeCardController implements Initializable {

    @Inject
    GameBoard game;

    @Inject Stage stage;

    private Timeline changeViewDelay;
    private Timeline disableButtonDelay;
    private Button theButtonPressed;

    @FXML Button altOne,altTwo,altThree,altFour;

    @FXML
    Label cardPlayerNameLabel;

    @FXML
    Label question;

    @FXML
    @SuppressFBWarnings()
    private void onButtonPressed(ActionEvent e) {
        theButtonPressed = (Button) e.getSource();

        doWhenGuessed();
    }

    @SuppressFBWarnings()
    public void doWhenGuessed() {
        if(trueIfCorrectAnswer(getAnswerAsAlternative(theButtonPressed))){
            theButtonPressed.setStyle("-fx-background-color: lawngreen");

            game.getCurrentPlayerPlaying().setSpot(game.getCurrentPlayerPlaying().getSpot().getRight());
            if (game.getCurrentPlayerPlaying().getSpot().getCategory() == Category.AIRPLANE){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Congratulations!");
                alert.setHeaderText(null);
                alert.setContentText(game.getCurrentPlayerPlaying().getName() + " YOU HAVE WON!!!! :D");
                alert.showAndWait();
                stage.close();
            }

            game.setNextTurn(game.getAmountOfPlayersPlaying());
            startTimer();

        }else{
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
               if (!game.getCurrentPlayerPlaying().isInEurope()) {
                   game.getButtonLeft().setDisable(false);
                   game.getButtonRight().setText("Go Right");

                   try {
                       DiceView diceView = DiceView.create();
                       diceView.show();
                   } catch (IOException e) {
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
        //Correct answer: B
        switch (currentPlayerSpotCategory) {
            case CULTURE:
                question.setText("CULTURE: \nThis is a European culture question");
                setQuestionAlternatives("A. African Culture","B. European Culture","C. North American Culture","D. South American Culture");
                break;
            case MEDIA:
                question.setText("MEDIA: \nWhich is the biggest media company \nin Europe");
                setQuestionAlternatives("A. Persgroep","B. ProSieben","C. Sky","D: MTG");
                break;
            case SPORT:
                question.setText("SPORT: \nWho is the most valuable footballer \nin Europe, 2017?");
                setQuestionAlternatives("A. Harry Kane","B. Neymar Junior","C. Lionel Messi", "D. Antoine Griezmann");
                break;
            case HISTORY:
                question.setText("HISTORY: \nWhen did the European Union release the Euro \nas a new form of currency?");
                setQuestionAlternatives("A. 2003","B. 2002","C. 2005","D. 2001");
                break;
            case TECHNIC:
                question.setText("TECHNICAL: \nThis is a European technical question");
                setQuestionAlternatives("A. South American Technics","B. European Technics","C. Asian Technics","D. North American Technics");
                break;
            case GEOGRAPHY:
                question.setText("GEOGRAPHY: \nWhich is the longest river in Europe?");
                setQuestionAlternatives("A. Elbe","B. Volga","C. Don", "D. Loire");
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
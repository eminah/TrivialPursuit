package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.AfricaCard;
import edu.chl.trivialpursuit.model.Alternative;
import edu.chl.trivialpursuit.model.Continent;
import edu.chl.trivialpursuit.model.GameBoard;
import edu.chl.trivialpursuit.view.DiceView;
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
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")
    private void onButtonPressed(ActionEvent e) {
        theButtonPressed = (Button) e.getSource();

        doWhenGuessed();
        startTimer();
    }
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cardPlayerNameLabel.setText(game.getCurrentPlayerPlaying().getName());
    }
}
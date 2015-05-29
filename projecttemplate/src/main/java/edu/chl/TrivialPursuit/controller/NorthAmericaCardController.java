package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.Alternative;
import edu.chl.trivialpursuit.model.Continent;
import edu.chl.trivialpursuit.model.GameBoard;
import edu.chl.trivialpursuit.model.Player;
import edu.chl.trivialpursuit.view.DiceView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by Rasti on 2015-05-28.
 */
public class NorthAmericaCardController {

    @Inject GameBoard game;

    private Timeline changeViewDelay;
    private Timeline disableButtonDelay;
    private Button theButtonPressed;
    private int currentPlayerTurnIndex;
    private Player currentPlayer;


    @FXML Button altOne,altTwo,altThree,altFour;

    @FXML
    public void onButtonPressed(ActionEvent e) {
        theButtonPressed = (Button) e.getSource();
        currentPlayerTurnIndex = game.getTurn()-1;
        currentPlayer = game.getPlayers().get(game.getTurn()-1);


        if(trueIfCorrectAnswer(getAnswerAsAlternative(theButtonPressed))){
            theButtonPressed.setStyle("-fx-background-color: lawngreen");
            ImageView theContinentToChange = game.getiN().get(currentPlayerTurnIndex);
            theContinentToChange.setImage(new Image("edu/chl/trivialpursuit/view/northAm_gold.png"));
            currentPlayer.getCollectedContinents().add(Continent.NORTH_AMERICA);

            startTimer();
        }else{
            theButtonPressed.setStyle("-fx-background-color: red");
            game.setNextTurn(game.getAmountOfPlayersPlaying());
            startTimer();
        }

    }

    public boolean trueIfCorrectAnswer(Alternative answer){
        currentPlayerTurnIndex = game.getTurn()-1;
        Alternative theCorrectAlternativeOfTheCard = game.getPlayers().get(currentPlayerTurnIndex).getSpot().getCard().getCorrectAlternative();
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

                try{
                    final DiceView diceView = DiceView.create();
                    diceView.show();
                }catch(IOException ex){
                    ex.printStackTrace();
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
}

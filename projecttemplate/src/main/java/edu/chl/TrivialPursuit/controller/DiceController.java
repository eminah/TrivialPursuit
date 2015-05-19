package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.Dice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.inject.Inject;


/**
 * Created by inatran on 15-04-28.
 */
public class DiceController {

    @Inject Dice dice;
    @FXML ImageView dice1;
    @FXML ImageView dice2;

    @FXML
    private void throwDices(ActionEvent e){



        dice.throwDice();

        //Change image on dice one depending on value
        switch(dice.getFirstDiceValue()){

            case 1:
                dice1.setImage(new Image("edu/chl/trivialpursuit/view/diceOne.png"));
                break;
            case 2:
                dice1.setImage(new Image("edu/chl/trivialpursuit/view/diceTwo.png"));
                break;
            case 3:
                dice1.setImage(new Image("edu/chl/trivialpursuit/view/diceThree.png"));
                break;
            case 4:
                dice1.setImage(new Image("edu/chl/trivialpursuit/view/diceFour.png"));
                break;
            case 5:
                dice1.setImage(new Image("edu/chl/trivialpursuit/view/diceFive.png"));
                break;
            case 6:
                dice1.setImage(new Image("edu/chl/trivialpursuit/view/diceSix.png"));
                break;

        }

        // Change image on dice one depending on value....

        switch(dice.getSecondDiceValue()){

            case 1:
                dice2.setImage(new Image("edu/chl/trivialpursuit/view/diceOne.png"));
                break;
            case 2:
                dice2.setImage(new Image("edu/chl/trivialpursuit/view/diceTwo.png"));
                break;
            case 3:
                dice2.setImage(new Image("edu/chl/trivialpursuit/view/diceThree.png"));
                break;
            case 4:
                dice2.setImage(new Image("edu/chl/trivialpursuit/view/diceFour.png"));
                break;
            case 5:
                dice2.setImage(new Image("edu/chl/trivialpursuit/view/diceFive.png"));
                break;
            case 6:
                dice2.setImage(new Image("edu/chl/trivialpursuit/view/diceSix.png"));
                break;

        }
    }

}




package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.ChoosePlayer;
import edu.chl.trivialpursuit.view.ChoosePlayerView;
import edu.chl.trivialpursuit.view.ChooseTravelView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.inject.Inject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Rasti on 2015-05-05.
 */
public class ChoosePlayerController implements Initializable {



    @FXML
    private ComboBox<String> numPlayers;

    @FXML
    Button doneButton;

    @FXML
    Label starLabel;

    @FXML
    private TextField tOne, tTwo, tThree,tFour,tFive,tSix;

    @Inject
    ChoosePlayer choosePlayer;

    private ArrayList <TextField> playerTexts;
    private ArrayList <String> playerNames;
    private int numberChoosed;

    private boolean firstTime = true;


    @FXML
    private void onButtonPressed(ActionEvent e) throws IOException{

        addNamesToList();
        setNameValues();

        final ChooseTravelView chooseTravelView = ChooseTravelView.create();
        chooseTravelView.show();

        e.consume();
    }




    @FXML
    private void comboAction(ActionEvent e){

        //Set value of an ints that specifies the amount of players

        choosePlayer.setNumberOfPlayers(numberChoosed = Integer.parseInt(numPlayers.getValue()));
        numberChoosed = Integer.parseInt(numPlayers.getValue());

        for(int i = 0; i < numberChoosed; i++) {
            playerTexts.get(i).setDisable(false);

        }

        for(int j = 5; j >= numberChoosed; j--){
            playerTexts.get(j).setDisable(true);
        }

        doneButton.setDisable(false);


    }

    private void addNamesToList(){
        for(int i = 0; i < numberChoosed; i++) {
           String name = playerTexts.get(i).getText();
            playerNames.add(name);
        }
    }

    private  void setNameValues(){

            for (int i = 0; i < choosePlayer.getNumberOfPlayers(); i++) {
                switch (i) {
                    case 0:
                        choosePlayer.setNameOne(playerNames.get(i));
                        break;
                    case 1:
                        choosePlayer.setNameTwo(playerNames.get(i));
                        break;
                    case 2:
                        choosePlayer.setNameThree(playerNames.get(i));
                        break;
                    case 3:
                        choosePlayer.setNameFour(playerNames.get(i));
                        break;
                    case 4:
                        choosePlayer.setNameFive(playerNames.get(i));
                        break;
                    case 5:
                        choosePlayer.setNameSix(playerNames.get(i));
                        break;
                    default:
                        throw new IllegalArgumentException("Something is wrong");
                }
            }
    }

    /**
     *
     * @return The list containing all the choosen names.
     */
    public ArrayList<String> getPlayerNames() {
        return playerNames;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerTexts = new ArrayList<>();
        playerNames = new ArrayList<>();

        playerTexts.add(tOne);
        playerTexts.add(tTwo);
        playerTexts.add(tThree);
        playerTexts.add(tFour);
        playerTexts.add(tFive);
        playerTexts.add(tSix);

        starLabel.setText("*");
        starLabel.setFont(new Font("Verdana", 18));
        starLabel.setTextFill(Color.RED);

    }

}

package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.*;
import edu.chl.trivialpursuit.view.ChoosePlayerView;
import edu.chl.trivialpursuit.view.DiceView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by helenejarl on 2015-05-19.
 */
public class ChooseTravelController implements Initializable {

    @Inject
    ChoosePlayer choosePlayer;
    @Inject
    ChooseTravel chooseTravel;
    private ArrayList<ComboBox> theBox;
    private ArrayList<String> travelChooices;
    private Font star = new Font("Verdana",18);



    @FXML
    Label playerOneName,playerTwoName,playerThreeName,playerFourName,playerFiveName,playerSixName;

    @FXML
    Label mustChooseOne,mustChooseSec,mustChooseThird,mustChooseFourth,mustChooseFifth,mustChooseSixth;

    @FXML
    ComboBox<String> c1,c2,c3,c4,c5,c6;

    @FXML
    Button buttonDone;


    @FXML
    private void onBackPressed(ActionEvent e) throws IOException{

        final ChoosePlayerView chooseView = ChoosePlayerView.create();
        chooseView.show();


        e.consume();

    }

    @FXML
    private void onDonePressed(ActionEvent e) throws IOException{


        DiceView diceView = DiceView.create();
        diceView.show();



        e.consume();

    }

    @FXML
    private void firstChooice(){
        chooseTravel.setStartPlaceOne(c1.getValue());
        checkChooices();
    }

    @FXML
    private void secondChooice(){
        chooseTravel.setStartPlaceTwo(c2.getValue());
        checkChooices();
    }

    @FXML
    private void thirdChooice(){
        chooseTravel.setStartPlaceThree(c3.getValue());
        checkChooices();

    }

    @FXML
    private void fourthChooice(){
        chooseTravel.setStartPlaceFour(c4.getValue());
        checkChooices();
    }

    @FXML
    private void fifthChooice(){
        chooseTravel.setStartPlaceFive(c5.getValue());
        checkChooices();
    }

    @FXML
    private void sixthChooice(){
        chooseTravel.setStartPlaceSix(c6.getValue());
        checkChooices();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        theBox = new ArrayList<>();
        theBox.add(c1);
        theBox.add(c2);
        theBox.add(c3);
        theBox.add(c4);
        theBox.add(c5);
        theBox.add(c6);
        travelChooices = new ArrayList<>();

        System.out.println(choosePlayer.getNumberOfPlayers());
        for(int i = 5; i >= choosePlayer.getNumberOfPlayers(); i--) {
            theBox.get(i).setDisable(true);
        }

        switch(choosePlayer.getNumberOfPlayers()){
            case 2:
                playerOneName.setText(choosePlayer.getNameOne());
                playerTwoName.setText(choosePlayer.getNameTwo());
                mustChooseOne.setText("*");
                mustChooseOne.setFont(star);
                mustChooseOne.setTextFill(Color.RED);
                mustChooseSec.setText("*");
                mustChooseSec.setFont(star);
                mustChooseSec.setTextFill(Color.RED);
                break;
            case 3:
                playerOneName.setText(choosePlayer.getNameOne());
                playerTwoName.setText(choosePlayer.getNameTwo());
                playerThreeName.setText(choosePlayer.getNameThree());
                mustChooseOne.setText("*");
                mustChooseOne.setFont(star);
                mustChooseOne.setTextFill(Color.RED);
                mustChooseSec.setText("*");
                mustChooseSec.setFont(star);
                mustChooseSec.setTextFill(Color.RED);
                mustChooseThird.setText("*");
                mustChooseThird.setFont(star);
                mustChooseThird.setTextFill(Color.RED);
                break;
            case 4:
                playerOneName.setText(choosePlayer.getNameOne());
                playerTwoName.setText(choosePlayer.getNameTwo());
                playerThreeName.setText(choosePlayer.getNameThree());
                playerFourName.setText(choosePlayer.getNameFour());
                mustChooseOne.setText("*");
                mustChooseOne.setFont(star);
                mustChooseOne.setTextFill(Color.RED);
                mustChooseSec.setText("*");
                mustChooseSec.setFont(star);
                mustChooseSec.setTextFill(Color.RED);
                mustChooseThird.setText("*");
                mustChooseThird.setFont(star);
                mustChooseThird.setTextFill(Color.RED);
                mustChooseFourth.setText("*");
                mustChooseFourth.setFont(star);
                mustChooseFourth.setTextFill(Color.RED);
                break;
            case 5:
                playerOneName.setText(choosePlayer.getNameOne());
                playerTwoName.setText(choosePlayer.getNameTwo());
                playerThreeName.setText(choosePlayer.getNameThree());
                playerFourName.setText(choosePlayer.getNameFour());
                playerFiveName.setText(choosePlayer.getNameFive());
                mustChooseOne.setText("*");
                mustChooseOne.setFont(star);
                mustChooseOne.setTextFill(Color.RED);
                mustChooseSec.setText("*");
                mustChooseSec.setFont(star);
                mustChooseSec.setTextFill(Color.RED);
                mustChooseThird.setText("*");
                mustChooseThird.setFont(star);
                mustChooseThird.setTextFill(Color.RED);
                mustChooseFourth.setText("*");
                mustChooseFourth.setFont(star);
                mustChooseFourth.setTextFill(Color.RED);
                mustChooseFifth.setText("*");
                mustChooseFifth.setFont(star);
                mustChooseFifth.setTextFill(Color.RED);
                break;
            case 6:
                playerOneName.setText(choosePlayer.getNameOne());
                playerTwoName.setText(choosePlayer.getNameTwo());
                playerThreeName.setText(choosePlayer.getNameThree());
                playerFourName.setText(choosePlayer.getNameFour());
                playerFiveName.setText(choosePlayer.getNameFive());
                playerSixName.setText(choosePlayer.getNameSix());
                mustChooseOne.setText("*");
                mustChooseOne.setFont(star);
                mustChooseOne.setTextFill(Color.RED);
                mustChooseSec.setText("*");
                mustChooseSec.setFont(star);
                mustChooseSec.setTextFill(Color.RED);
                mustChooseThird.setText("*");
                mustChooseThird.setFont(star);
                mustChooseThird.setTextFill(Color.RED);
                mustChooseFourth.setText("*");
                mustChooseFourth.setFont(star);
                mustChooseFourth.setTextFill(Color.RED);
                mustChooseFifth.setText("*");
                mustChooseFifth.setFont(star);
                mustChooseFifth.setTextFill(Color.RED);
                mustChooseSixth.setText("*");
                mustChooseSixth.setFont(star);
                mustChooseSixth.setTextFill(Color.RED);
                break;

            default:
                throw new IllegalArgumentException("Something wrong when setting playersName");
        }
    }

    private void checkChooices(){
        switch (choosePlayer.getNumberOfPlayers()) {
            case 2:
                if (c1.getValue() != null && c2.getValue() != null) {
                    buttonDone.setDisable(false);
                }
                break;
            case 3:
                if (c1.getValue() != null && c2.getValue() != null && c3.getValue()!= null) {
                    buttonDone.setDisable(false);
                }
                break;
            case 4:
                if (c1.getValue() != null && c2.getValue() != null && c3.getValue()!= null && c4.getValue()!=null) {
                    buttonDone.setDisable(false);
                }
                break;
            case 5:
                if (c1.getValue() != null && c2.getValue() != null && c3.getValue()!= null && c4.getValue()!=null && c5.getValue()!=null) {
                    buttonDone.setDisable(false);
                }
                break;
            case 6:
                if (c1.getValue() != null && c2.getValue() != null && c3.getValue()!= null && c4.getValue()!=null && c5.getValue()!=null && c6.getValue()!=null) {
                    buttonDone.setDisable(false);
                }
                break;
            default:

                throw new IllegalArgumentException("You must choose all continents");
        }
    }
}

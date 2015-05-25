package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.*;

import edu.chl.trivialpursuit.view.ChoosePlayerView;
import edu.chl.trivialpursuit.view.DiceView;
import edu.chl.trivialpursuit.view.GameBoardView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

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



    @FXML
    ComboBox<String> c1,c2,c3,c4,c5,c6;


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
    }

    @FXML
    private void secondChooice(){
        chooseTravel.setStartPlaceTwo(c2.getValue());
    }

    @FXML
    private void thirdChooice(){
        chooseTravel.setStartPlaceThree(c3.getValue());
    }

    @FXML
    private void fourthChooice(){
        chooseTravel.setStartPlaceFour(c4.getValue());
    }

    @FXML
    private void fifthChooice(){
        chooseTravel.setStartPlaceFive(c5.getValue());
    }

    @FXML
    private void sixthChooice(){
        chooseTravel.setStartPlaceSix(c6.getValue());
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
    }
}

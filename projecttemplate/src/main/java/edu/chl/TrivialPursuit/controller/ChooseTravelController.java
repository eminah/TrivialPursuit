package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.ChoosePlayer;
import edu.chl.trivialpursuit.model.Dice;
import edu.chl.trivialpursuit.model.Player;
import edu.chl.trivialpursuit.view.ChoosePlayerView;
import edu.chl.trivialpursuit.view.DiceView;
import edu.chl.trivialpursuit.view.GameBoardView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by helenejarl on 2015-05-19.
 */
public class ChooseTravelController {

    @Inject
    ChoosePlayer choose;

    //Group for player 1
    @FXML
    RadioButton p1As,p1Af,p1Oc,p1No,p1So;

    //Group for player 2
    @FXML
    RadioButton p2As,p2Af,p2Oc,p2No,p2So;

    //Group for player 3
    @FXML
    RadioButton p3As,p3Af,p3Oc,p3No,p3So;

    //Group for player 4
    @FXML
    RadioButton p4As,p4Af,p4Oc,p4No,p4So;

    //Group for player 5
    @FXML
    RadioButton p5As,p5Af,p5Oc,p5No,p5So;

    //First Group for player 6
    @FXML
    RadioButton p6As,p6Af,p6Oc,p6No,p6So;

    @FXML
    private void onBackPressed(ActionEvent e) throws IOException{

        final ChoosePlayerView chooseView = ChoosePlayerView.create();
        chooseView.show();


        e.consume();

    }

    @FXML
    private void onDonePressed(ActionEvent e) throws IOException{



        final DiceView diceView = DiceView.create();
        diceView.show();

        e.consume();

    }

}

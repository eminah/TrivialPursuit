package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.Dice;
import edu.chl.trivialpursuit.view.ChoosePlayerView;
import edu.chl.trivialpursuit.view.DiceView;
import edu.chl.trivialpursuit.view.GameBoardView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Created by helenejarl on 2015-05-19.
 */
public class ChooseTravelController {


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

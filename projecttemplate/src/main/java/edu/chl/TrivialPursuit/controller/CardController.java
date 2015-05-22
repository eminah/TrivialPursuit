package edu.chl.trivialpursuit.controller;


import edu.chl.trivialpursuit.model.Card;
import edu.chl.trivialpursuit.view.CardView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import javax.inject.Inject;
import java.io.IOException;


/**
 * Created by helenejarl on 2015-05-07.
 */
public class CardController {



    @Inject
    Card card;

    @Inject
    CardView cardView;

    @FXML
    Button alt1, alt2, alt3, alt4;



    @FXML
    public void altOnePressed(ActionEvent e) throws IOException {

    }

    @FXML
    public void altTwoPressed(ActionEvent e) throws IOException {


    }

    @FXML
    public void altThreePressed(ActionEvent e) throws IOException {

    }

    @FXML
    public void altFourPressed(ActionEvent e) throws IOException {


    }

}

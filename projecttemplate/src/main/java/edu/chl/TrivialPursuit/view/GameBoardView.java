package edu.chl.trivialpursuit.view;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

/**
 * Created by Rasti on 2015-05-04.
 */
public class GameBoardView extends FlowPane {

    Label lable = new Label("TJJJOOOO!");
    public GameBoardView(){
        this.getChildren().addAll(lable);
    }
}

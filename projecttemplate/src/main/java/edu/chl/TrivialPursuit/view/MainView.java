package edu.chl.trivialpursuit.view;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

/**
 * Created by Rasti on 2015-05-04.
 */
public class MainView extends FlowPane {

    Label lable = new Label("TJJJOOOO!");
    public MainView(){
        this.getChildren().addAll(lable);
    }
}

package edu.chl.trivialpursuit.view;
import edu.chl.trivialpursuit.controller.StartController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.layout.*;

import javax.swing.*;

public class StartView extends BorderPane {
    Label titleLable;
    private Button start;
    private Button close;

    public StartView() {
        //Create Stackpane components
        StackPane titlePane = new StackPane();
        titleLable = new Label("Trivial Pursuit - Around the World");
        titleLable.getStyleClass().add("title-lable");
        //Add to StackPane
        titlePane.getChildren().addAll(titleLable);
        //Create VBox Components
        HBox buttonPanel = new HBox();
        buttonPanel.setAlignment(Pos.CENTER);
        buttonPanel.setSpacing(70);
        start = new Button("Start Game");
        close = new Button("Exit");


        //Add to VBox
        buttonPanel.getChildren().addAll(start, close);
        //Add to BorderPane
        this.setTop(titlePane);
        this.setCenter(buttonPanel);
    }

    public void addButtonListener(EventHandler handler){
        start.setOnAction(handler);
        close.setOnAction(handler);
    }

}
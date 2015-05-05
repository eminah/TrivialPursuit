package edu.chl.trivialpursuit.view;
import edu.chl.trivialpursuit.controller.StartController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import lombok.Getter;
public class StartView extends BorderPane {
    Label titleLable;
    public Button start;
    Button close;
    TrivialPursuit pursuit = new TrivialPursuit();
    public StartView() {
        //Create Stackpane components
        StackPane titlePane = new StackPane();
        titleLable = new Label("Trivial Pursuit - The World");
        titleLable.getStyleClass().add("title-lable");
        //Add to StackPane
        titlePane.getChildren().addAll(titleLable);
        //Create VBox Components
        HBox buttonPanel = new HBox();
        buttonPanel.setAlignment(Pos.CENTER);
        buttonPanel.setSpacing(70);
        start = new Button("Start Game");
        close = new Button("Exit");
        //Lysna på knapptryckningar
        start.setOnAction(pursuit);
        close.setOnAction(new StartController());
        //Add to VBox
        buttonPanel.getChildren().addAll(start, close);
        //Add to BorderPane
        this.setTop(titlePane);
        this.setCenter(buttonPanel);
    }
    public Button getStart() {
        return start;
    }
}
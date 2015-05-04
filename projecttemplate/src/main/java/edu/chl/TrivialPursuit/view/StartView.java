package edu.chl.trivialpursuit.view;




import edu.chl.trivialpursuit.controller.StartController;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;



public class StartView extends BorderPane {


    Label titleLable;
    Button start;
    Button close;



    public StartView() {

        //Create Stackpane comp
        // onents
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
        start.setOnAction(new TrivialPursuit());
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










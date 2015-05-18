package edu.chl.trivialpursuit.controller;


import edu.chl.trivialpursuit.model.Start;
import edu.chl.trivialpursuit.view.ChoosePlayerView;
import edu.chl.trivialpursuit.view.StartView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by inatran on 15-04-28.
 */
public class StartController {

    private Start theModel;
    private StartView theView;
    private Scene cpv;

    public StartController(Start theModel, StartView theView){
        this.theModel = theModel;
        this.theView = theView;

        theView.addButtonListener(new ButtonListener());
    }

    class ButtonListener implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            if(event.getSource() == theView.getStart()) {
                cpv = new Scene(new ChoosePlayerView(), 400, 500);
                stage.setScene(cpv);
                stage.show();
            }

            if (event.getSource() == theView.getClose()){
                stage.close();
            }
        }
    }
}

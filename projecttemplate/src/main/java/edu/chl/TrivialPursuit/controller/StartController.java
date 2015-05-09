package edu.chl.trivialpursuit.controller;


import edu.chl.trivialpursuit.model.Start;
import edu.chl.trivialpursuit.view.GameBoardView;
import edu.chl.trivialpursuit.view.StartView;
import edu.chl.trivialpursuit.view.TrivialPursuit;
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
        private Scene test;

    public StartController(Start theModel, StartView theView){
        this.theModel = theModel;
        this.theView = theView;

        theView.addButtonListener(new ButtonListener());
    }

    class ButtonListener implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            test = new Scene(new GameBoardView(),1000,500);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(main);
            stage.show();

        }
    }
}

package edu.chl.trivialpursuit.controller;


import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Created by Rasti on 2015-05-14.
 */
public class GameBoardController {

    @FXML
    Canvas boardCanvas;


    public void drawBoard(){
        GraphicsContext gc = boardCanvas.getGraphicsContext2D();
        draw(gc);
    }


    // Searching for all coordinates by hand, time consuming - Helene
    private void draw(GraphicsContext gc){
        gc.drawImage(new Image("edu/chl/trivialpursuit/view/board.png"), 0, 0, boardCanvas.getWidth(), boardCanvas.getHeight());

        //Player on Asia-air
        gc.setFill(Color.PINK);
        gc.fillOval(225, 15, 10, 10);
        //Player on Africa-air
        gc.setFill(Color.BLUEVIOLET);
        gc.fillOval(438, 240, 10, 10);
        //Player on SoAm-air
        gc.setFill(Color.RED);
        gc.fillOval(235,455,10,10);
        //Player on NoAm.air
        gc.setFill(Color.CYAN);
        gc.fillOval(20,230,10,10);
    }



}

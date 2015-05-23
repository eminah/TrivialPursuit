package edu.chl.trivialpursuit.controller;
import edu.chl.trivialpursuit.model.Dice;
import edu.chl.trivialpursuit.model.GameBoard;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import javax.inject.Inject;


/**
 * Created by Rasti on 2015-05-14..
 */

public class GameBoardController {
    private Color p1 = Color.DEEPPINK;
    private int x1;
    private int y1;
    private Color p2 = Color.BLUE;
    private int x2;
    private int y2;
    private Color p3 = Color.DARKGRAY;
    private int x3;
    private int y3;
    private Color p4 = Color.YELLOW;
    private int x4;
    private int y4;
    private Color p5 = Color.RED;
    private int x5;
    private int y5;
    private Color p6 = Color.LAWNGREEN;
    private int x6;
    private int y6;;
    private Dice dice = new Dice();


    @FXML
    Canvas boardCanvas;

    @FXML
    Label playerOneName;

    @Inject
    GameBoard game;



    @FXML
    public void moveRight(){
        movePlayerRight(1,dice.getTotalDiceValue());
    }

    @FXML void moveLeft(){
        movePlayerLeft(1, dice.getTotalDiceValue());
    }

    public void drawBoard(){
        GraphicsContext gc = boardCanvas.getGraphicsContext2D();
        draw(gc);
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }
    public void setY1(int y1) {
        this.y1 = y1;
    }
    public void setX2(int x2) {
        this.x2 = x2;
    }
    public void setY2(int y2) {
        this.y2 = y2;
    }
    public void setX3(int x3) {
        this.x3 = x3;
    }
    public void setY3(int y3) {
        this.y3 = y3;
    }
    public void setX4(int x4) {
        this.x4 = x4;
    }
    public void setY4(int y4) {
        this.y4 = y4;
    }
    public void setX5(int x5) { this.x5 = x5; }
    public void setY5(int y5) { this.y5 = y5; }
    public void setX6(int x6) { this.x6 = x6; }
    public void setY6(int y6) { this.y6 = y6; }

    // Searching for all coordinates by hand, time consuming - Helene
    private void draw(GraphicsContext gc){
        gc.drawImage(new Image("edu/chl/trivialpursuit/view/board_pastell.png"), 0, 0, boardCanvas.getWidth(), boardCanvas.getHeight());
        gc.setFill(p1);
        gc.fillOval(x1, y1, 15, 15);
        gc.strokeOval(x1, y1, 15, 15);
        gc.setFill(p2);
        gc.fillOval(x2, y2, 15, 15);
        gc.strokeOval(x2, y2, 15, 15);
        gc.setFill(p3);
        gc.fillOval(x3, y3, 15, 15);
        gc.strokeOval(x3, y3, 15, 15);
        gc.setFill(p4);
        gc.fillOval(x4, y4, 15, 15);
        gc.strokeOval(x4, y4, 15, 15);
        gc.setFill(p5);
        gc.fillOval(x5, y5, 15, 15);
        gc.strokeOval(x5, y5, 15, 15);
        gc.setFill(p6);
        gc.fillOval(x6, y6, 15, 15);
        gc.strokeOval(x6, y6, 15, 15);

    }
    public void movePlayerRight(int player, int diceValue){
        switch(player){
            case 1:
                game.getPlayers().get(0).goRight(diceValue);
                setX1(game.getPlayers().get(0).getSpot().getCooX());
                setY1(game.getPlayers().get(0).getSpot().getCooY());
                break;
            case 2:
                game.getPlayers().get(1).goRight(diceValue);
                setX1(game.getPlayers().get(1).getSpot().getCooX());
                setY1(game.getPlayers().get(1).getSpot().getCooY());
                break;
            case 3:
                game.getPlayers().get(2).goRight(diceValue);
                setX1(game.getPlayers().get(2).getSpot().getCooX());
                setY1(game.getPlayers().get(2).getSpot().getCooY());
                break;
            case 4:
                game.getPlayers().get(3).goRight(diceValue);
                setX1(game.getPlayers().get(3).getSpot().getCooX());
                setY1(game.getPlayers().get(3).getSpot().getCooY());;
                break;
            case 5:
                game.getPlayers().get(4).goRight(diceValue);
                setX1(game.getPlayers().get(4).getSpot().getCooX());
                setY1(game.getPlayers().get(4).getSpot().getCooY());
                break;
            case 6:
                game.getPlayers().get(5).goRight(diceValue);
                setX1(game.getPlayers().get(5).getSpot().getCooX());
                setY1(game.getPlayers().get(5).getSpot().getCooY());
                break;
        }
    }
    /**
     *  Moves the player towards left
     *
     * @param player The player that should be moved
     * @param diceValue The amount of steps the player should be moved
     */
    public void movePlayerLeft(int player, int diceValue){
        switch(player){
            case 1:
                game.getPlayers().get(0).goLeft(diceValue);
                setX1(game.getPlayers().get(0).getSpot().getCooX());
                setY1(game.getPlayers().get(0).getSpot().getCooY());
                break;
            case 2:
                game.getPlayers().get(1).goLeft(diceValue);
                setX1(game.getPlayers().get(1).getSpot().getCooX());
                setY1(game.getPlayers().get(1).getSpot().getCooY());
                break;
            case 3:
                game.getPlayers().get(2).goLeft(diceValue);
                setX1(game.getPlayers().get(2).getSpot().getCooX());
                setY1(game.getPlayers().get(2).getSpot().getCooY());
                break;
            case 4:
                game.getPlayers().get(3).goLeft(diceValue);
                setX1(game.getPlayers().get(3).getSpot().getCooX());
                setY1(game.getPlayers().get(3).getSpot().getCooY());
                break;
            case 5:
                game.getPlayers().get(4).goLeft(diceValue);
                setX1(game.getPlayers().get(4).getSpot().getCooX());
                setY1(game.getPlayers().get(4).getSpot().getCooY());
                break;
            case 6:
                game.getPlayers().get(5).goLeft(diceValue);
                setX1(game.getPlayers().get(5).getSpot().getCooX());
                setY1(game.getPlayers().get(5).getSpot().getCooY());
                break;
        }


    }


}
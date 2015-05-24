package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.*;

import edu.chl.trivialpursuit.model.ChoosePlayer;
import edu.chl.trivialpursuit.model.Dice;
import edu.chl.trivialpursuit.model.GameBoard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.inject.Inject;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


/**
 * Created by Rasti on 2015-05-14..
 */

public class GameBoardController implements Initializable {

    private int x1,x2,x3,x4,x5,x6,y1,y2,y3,y4,y5,y6;

    private Color p1 = Color.DEEPPINK;
    private Color p2 = Color.BLUE;
    private Color p3 = Color.DARKGRAY;
    private Color p4 = Color.YELLOW;
    private Color p5 = Color.RED;
    private Color p6 = Color.LAWNGREEN;




    @FXML
    Canvas boardCanvas;

    @FXML
    Label playerOneName,playerTwoName,playerThreeName,playerFourName,playerFiveName,playerSixName;

    @Inject
    Dice dice;

    @Inject
    ChoosePlayer chooseP;

    @Inject
    ChooseTravel chooseT;

    @Inject
    GameBoard game;

    private ArrayList<Player> players;








    @FXML
    public void moveRight(){
        movePlayerRight(1, dice.getTotalDiceValue());
        drawBoard();
    }

    @FXML void moveLeft(){
        movePlayerLeft(1, dice.getTotalDiceValue());
        drawBoard();
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
        gc.fillOval(x1,y1, 15, 15);
        gc.strokeOval(x1,y1, 15, 15);
        gc.setFill(p2);
        gc.fillOval(x2,y2, 15, 15);
        gc.strokeOval(x2,y2, 15, 15);
        gc.setFill(p3);
        gc.fillOval(x3,y3, 15, 15);
        gc.strokeOval(x3,y3, 15, 15);
        gc.setFill(p4);
        gc.fillOval(x4,y4, 15, 15);
        gc.strokeOval(x4,y4, 15, 15);
        gc.setFill(p5);
        gc.fillOval(x5,y5, 15, 15);
        gc.strokeOval(x5,y5, 15, 15);
        gc.setFill(p6);
        gc.fillOval(x6,y6, 15, 15);
        gc.strokeOval(x6,y6, 15, 15);

    }
    public void movePlayerRight(int player, int diceValue){
        switch(player){
            case 1:
                players.get(0).goRight(diceValue);
                setX1(players.get(0).getSpot().getCooX());
                setY1(players.get(0).getSpot().getCooY());

                break;
            case 2:
                players.get(1).goRight(diceValue);
                setX1(players.get(1).getSpot().getCooX());
                setY1(players.get(1).getSpot().getCooY());
                break;
            case 3:
                players.get(2).goRight(diceValue);
                setX1(players.get(2).getSpot().getCooX());
                setY1(players.get(2).getSpot().getCooY());
                break;
            case 4:
                players.get(3).goRight(diceValue);
                setX1(players.get(3).getSpot().getCooX());
                setY1(players.get(3).getSpot().getCooY());;
                break;
            case 5:
                players.get(4).goRight(diceValue);
                setX1(players.get(4).getSpot().getCooX());
                setY1(players.get(4).getSpot().getCooY());
                break;
            case 6:
                players.get(5).goRight(diceValue);
                setX1(players.get(5).getSpot().getCooX());
                setY1(players.get(5).getSpot().getCooY());
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
                players.get(0).goLeft(diceValue);
                setX1(players.get(0).getSpot().getCooX());
                setY1(players.get(0).getSpot().getCooY());
                break;
            case 2:
                players.get(1).goLeft(diceValue);
                setX1(players.get(1).getSpot().getCooX());
                setY1(players.get(1).getSpot().getCooY());
                break;
            case 3:
                players.get(2).goLeft(diceValue);
                setX1(players.get(2).getSpot().getCooX());
                setY1(players.get(2).getSpot().getCooY());
                break;
            case 4:
                players.get(3).goLeft(diceValue);
                setX1(players.get(3).getSpot().getCooX());
                setY1(players.get(3).getSpot().getCooY());
                break;
            case 5:
                players.get(4).goLeft(diceValue);
                setX1(players.get(4).getSpot().getCooX());
                setY1(players.get(4).getSpot().getCooY());
                break;
            case 6:
                players.get(5).goLeft(diceValue);
                setX1(players.get(5).getSpot().getCooX());
                setY1(players.get(5).getSpot().getCooY());
                break;
        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO Göra detta snyggare förslagsvis med en for;

        players = new ArrayList<>();
        createPlayers();




        for(int i = 0; i < chooseP.getNumberOfPlayers(); i++){
            switch(i){
                case 0:
                    setX1(players.get(i).getSpot().getCooX());
                    setY1(players.get(i).getSpot().getCooY());
                    break;
                case 1:
                    setX2(players.get(i).getSpot().getCooX());
                    setY2(players.get(i).getSpot().getCooY());
                    break;
                case 2:
                    setX3(players.get(i).getSpot().getCooX());
                    setY3(players.get(i).getSpot().getCooY());
                    break;
                case 3:
                    setX4(players.get(i).getSpot().getCooX());
                    setY4(players.get(i).getSpot().getCooY());
                    break;
                case 4:
                    setX5(players.get(i).getSpot().getCooX());
                    setY5(players.get(i).getSpot().getCooY());
                    break;
                case 5:
                    setX6(players.get(i).getSpot().getCooX());
                    setY6(players.get(i).getSpot().getCooY());
                    break;
                default:
                    throw new IllegalArgumentException("Something is wrong");
            }
        }



        //The names should be the choosen ones:

        for(int i = 0; i < players.size(); i++ ){
            switch(i){
                case 0:
                    playerOneName.setText(chooseP.getNameOne());
                    playerOneName.setTextFill(p1);
                    playerOneName.setFont(new Font("Verdana",15));

                    break;
                case 1:
                    playerTwoName.setText(chooseP.getNameTwo());
                    playerTwoName.setTextFill(p2);
                    playerTwoName.setFont(new Font("Verdana", 15));
                    break;
                case 2:
                    playerThreeName.setText(chooseP.getNameThree());
                    playerThreeName.setTextFill(p3);
                    playerThreeName.setFont(new Font("Verdana", 15));
                    break;
                case 3:
                    playerFourName.setText(chooseP.getNameFour());
                    playerFourName.setTextFill(p4);
                    playerFourName.setFont(new Font("Verdana", 15));
                    break;
                case 4:
                    playerFiveName.setText(chooseP.getNameFive());
                    playerFiveName.setTextFill(p5);
                    playerFiveName.setFont(new Font("Verdana", 15));
                    break;
                case 5:
                    playerSixName.setText(chooseP.getNameSix());
                    playerSixName.setTextFill(p6);
                    playerSixName.setFont(new Font("Verdana", 15));
                    break;
                default:
                    throw new IllegalArgumentException("Something Wrong");
            }
        }

        drawBoard();

       }
    /*
    Here I create players depending on their choices of Continent and
    number of players it is.
     */
    private void createPlayers() {
        for (int i = 0; i < chooseP.getNumberOfPlayers(); i++) {
            String choosen = "";
            String name = "";

            switch (i){
                case 0:
                    choosen = chooseT.getStartPlaceOne();
                    name = chooseP.getNameOne();
                    break;
                case 1:
                    choosen = chooseT.getStartPlaceTwo();
                    name = chooseP.getNameTwo();
                    break;
                case 2:
                    choosen = chooseT.getStartPlaceThree();
                    name = chooseP.getNameThree();
                    break;
                case 3:
                    choosen = chooseT.getStartPlaceFour();
                    name = chooseP.getNameFour();
                    break;
                case 4:
                    choosen = chooseT.getStartPlaceFive();
                    name = chooseP.getNameFive();
                    break;
                case 5:
                    choosen = chooseT.getStartPlaceSix();
                    name = chooseP.getNameSix();
                    break;



            }

            switch (choosen) {
                case "Asia":
                    players.add(new Player(name,game.getSpotsOuter().get(0)));
                    break;
                case "Africa":
                    players.add(new Player(name,game.getSpotsOuter().get(7)));
                    break;
                case "South America":
                    players.add(new Player(name,game.getSpotsOuter().get(14)));
                    break;
                case "North America":
                    players.add(new Player(name,game.getSpotsOuter().get(21)));
                    break;

                default:
                    throw new IllegalArgumentException("Something is wrong");
            }
        }
    }

    


}

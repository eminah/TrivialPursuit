package edu.chl.trivialpursuit.controller;
import edu.chl.trivialpursuit.model.*;
import edu.chl.trivialpursuit.model.ChoosePlayer;
import edu.chl.trivialpursuit.model.Dice;
import edu.chl.trivialpursuit.model.GameBoard;
import edu.chl.trivialpursuit.view.CardView;
import edu.chl.trivialpursuit.view.DiceView;
import edu.chl.trivialpursuit.view.GameBoardView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
/**
 * Created by Rasti on 2015-05-14..
 */
public class GameBoardController implements Initializable {

    @FXML
    Canvas boardCanvas;
    @FXML
    Label playerOneName,playerTwoName,playerThreeName,playerFourName,playerFiveName,playerSixName;
    @FXML
    Label playerOneTurn,playerTwoTurn,playerThreeTurn,playerFourTurn,playerFiveTurn,playerSixTurn;
    @FXML
    Button left,right;
    @Inject
    Dice dice;
    @Inject
    ChoosePlayer chooseP;
    @Inject
    ChooseTravel chooseT;
    @Inject
    GameBoard game;
    private ArrayList<Player> players;
    // Initial start value of all the coordinates, negative so that they will be out of the canvas
    //private int x1 = -20,x2 = -20,x3 = -20,x4 = -20,x5 = -20,x6 = -20,y1 = -20,y2 = -20,y3 = -20,y4 = -20,y5 = -20,y6 = -20;
    private int[] coorX= {-1,-20,-20,-20,-20,-20,-20};
    private int[] coorY= {-1,-20,-20,-20,-20,-20,-20};
    private Color p1 = Color.GREENYELLOW;
    private Color p2 = Color.CYAN;
    private Color p3 = Color.RED;
    private Color p4 = Color.FUCHSIA;
    private Color p5 = Color.FORESTGREEN;
    private Color p6 = Color.BLUE;
    private Font labels = new Font("Verdana", 15);
    private Font arrow = new Font("Verdana",18);
    private ArrayList<Label> setLabelTurn;
    private Timeline setDelay;
    @FXML
    private void moveRight(){
        movePlayer(game.getTurn(), dice.getTotalDiceValue(), "R");
        right.setDisable(true);
        left.setDisable(true);
        drawBoard();
        startTimer();
    }
    @FXML
    private void moveLeft() throws IOException{
        movePlayer(game.getTurn(), dice.getTotalDiceValue(), "L");
        right.setDisable(true);
        left.setDisable(true);
        drawBoard();
        startTimer();
    }
    private void movePlayer(int player, int diceValue, String direction) {
        int correctPlayer = player - 1;
        if (direction.equals("L")) {
            players.get(correctPlayer).goLeft(diceValue);
        }else {
            players.get(correctPlayer).goRight(diceValue);
        }
        setCoordinates(player);
    }
    private void setCoordinates(int player){
        for(int i = 1; i <= player; i++){
            coorX[i] = players.get(i-1).getSpot().getCooX();
            coorY[i] = players.get(i-1).getSpot().getCooY();
        }
        drawBoard();
    }
    public void drawBoard(){
        GraphicsContext gc = boardCanvas.getGraphicsContext2D();
        draw(gc);
    }
    // Searching for all coordinates by hand, time consuming - Helene
    private void draw(GraphicsContext gc){
        gc.drawImage(new Image("edu/chl/trivialpursuit/view/board_pastell.png"), 0, 0, boardCanvas.getWidth(), boardCanvas.getHeight());
        gc.setFill(p1);
        gc.fillOval(coorX[1],coorY[1], 15, 15);
        gc.strokeOval(coorX[1],coorY[1], 15, 15);
        gc.setFill(p2);
        gc.fillOval(coorX[2]-12,coorY[2], 15, 15);
        gc.strokeOval(coorX[2]-12,coorY[2], 15, 15);
        gc.setFill(p3);
        gc.fillOval(coorX[3],coorY[3]-12, 15, 15);
        gc.strokeOval(coorX[3],coorY[3]-12, 15, 15);
        gc.setFill(p4);
        gc.fillOval(coorX[4],coorY[4]+12, 15, 15);
        gc.strokeOval(coorX[4],coorY[4]+12, 15, 15);
        gc.setFill(p5);
        gc.fillOval(coorX[5]+12,coorY[5], 15, 15);
        gc.strokeOval(coorX[5]+12,coorY[5], 15, 15);
        gc.setFill(p6);
        gc.fillOval(coorX[6]+12,coorY[6]-12, 15, 15);
        gc.strokeOval(coorX[6]+12,coorY[6]-12,  15, 15);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        players = new ArrayList<>();
        setLabelTurn = new ArrayList<>();
        createPlayers();
        game.setPlayers(players);
        setNames();
        addLabelTurns();
        game.setTurn(1);
        setArrow();
        setTheCoordinates();
        drawBoard();
    }


    //The names should be the choosen ones:
    private void setNames() {
        for (int i = 0; i < players.size(); i++) {
            switch (i) {
                case 0:
                    playerOneName.setText(chooseP.getNameOne());
                    playerOneName.setTextFill(p1);
                    playerOneName.setFont(labels);
                    break;
                case 1:
                    playerTwoName.setText(chooseP.getNameTwo());
                    playerTwoName.setTextFill(p2);
                    playerTwoName.setFont(labels);
                    break;
                case 2:
                    playerThreeName.setText(chooseP.getNameThree());
                    playerThreeName.setTextFill(p3);
                    playerThreeName.setFont(labels);
                    break;
                case 3:
                    playerFourName.setText(chooseP.getNameFour());
                    playerFourName.setTextFill(p4);
                    playerFourName.setFont(labels);
                    break;
                case 4:
                    playerFiveName.setText(chooseP.getNameFive());
                    playerFiveName.setTextFill(p5);
                    playerFiveName.setFont(labels);
                    break;
                case 5:
                    playerSixName.setText(chooseP.getNameSix());
                    playerSixName.setTextFill(p6);
                    playerSixName.setFont(labels);
                    break;
                default:
                    throw new IllegalArgumentException("Something Wrong");
            }
        }
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
                    players.add(new Player(name,game.getSpotsOuter().get(0),new HashSet<Continent>()));
                    break;
                case "Africa":
                    players.add(new Player(name,game.getSpotsOuter().get(7), new HashSet<Continent>()));
                    break;
                case "South America":
                    players.add(new Player(name,game.getSpotsOuter().get(14), new HashSet<Continent>()));
                    break;
                case "North America":
                    players.add(new Player(name,game.getSpotsOuter().get(21), new HashSet<Continent>()));
                    break;
                default:
                    throw new IllegalArgumentException("Something is wrong");
            }
        }
    }
    public void addLabelTurns(){
        for(int i = 0; i<chooseP.getNumberOfPlayers(); i++){
            switch (i){
                case 0:
                    setLabelTurn.add(playerOneTurn);
                    break;
                case 1:
                    setLabelTurn.add(playerTwoTurn);
                    break;
                case 2:
                    setLabelTurn.add(playerThreeTurn);
                    break;
                case 3:
                    setLabelTurn.add(playerFourTurn);
                    break;
                case 4:
                    setLabelTurn.add(playerFiveTurn);
                    break;
                case 5:
                    setLabelTurn.add(playerSixTurn);
                    break;
                default: throw new IllegalArgumentException ("Your bad!");
            }
        }
    }
    public void setTheCoordinates() {
        for (int i = 1; i <= chooseP.getNumberOfPlayers(); i++) {
            setCoordinates(chooseP.getNumberOfPlayers());
        }
    }
    public void setArrow(){
        switch (game.getTurn()){
            case 1:
                for(int i = 0;i < setLabelTurn.size(); i++){
                    setLabelTurn.get(i).setText("");
                }
                playerOneTurn.setText("<--" + + dice.getTotalDiceValue() + " steps!");
                playerOneTurn.setFont(arrow);
                break;
            case 2:
                for(int i = 0;i < setLabelTurn.size(); i++){
                    setLabelTurn.get(i).setText("");
                }
                playerTwoTurn.setText("<-- " +  dice.getTotalDiceValue() + " steps!");
                playerTwoTurn.setFont(arrow);
                break;
            case 3:
                for(int i = 0;i < setLabelTurn.size(); i++){
                    setLabelTurn.get(i).setText("");
                }
                playerThreeTurn.setText("<-- " + dice.getTotalDiceValue() + " steps!");
                playerThreeTurn.setFont(arrow);
                break;
            case 4:
                for(int i = 0;i < setLabelTurn.size(); i++){
                    setLabelTurn.get(i).setText("");
                }
                playerFourTurn.setText("<-- " + dice.getTotalDiceValue() + " steps!");
                playerFourTurn.setFont(arrow);
                break;
            case 5:
                for(int i = 0;i < setLabelTurn.size(); i++){
                    setLabelTurn.get(i).setText("");
                }
                playerFiveTurn.setText("<-- " + dice.getTotalDiceValue() + " steps!");
                playerFiveTurn.setFont(arrow);
                break;
            case 6:
                for(int i = 0;i < setLabelTurn.size(); i++){
                    setLabelTurn.get(i).setText("");
                }
                playerSixTurn.setText("<-- " + dice.getTotalDiceValue() + " steps!");
                playerSixTurn.setFont(arrow);
                break;
            default: throw new IllegalArgumentException("Wrong whos turn");
        }
    }
    public void startTimer() {
        setDelay = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)  {
                try{
                    final CardView cardView = CardView.create();
                    cardView.show();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
                right.setDisable(false);
                left.setDisable(false);
            }
        }));
        setDelay.play();
    }
}
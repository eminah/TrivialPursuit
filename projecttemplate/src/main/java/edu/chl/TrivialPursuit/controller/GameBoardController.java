package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.*;
import edu.chl.trivialpursuit.model.ChoosePlayer;
import edu.chl.trivialpursuit.model.Dice;
import edu.chl.trivialpursuit.model.GameBoard;
import edu.chl.trivialpursuit.view.AfricaCardView;
import edu.chl.trivialpursuit.view.DiceView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.control.Alert;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
//import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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

    @Inject Dice dice;

    @Inject ChoosePlayer chooseP;

    @Inject ChooseTravel chooseT;

    @Inject GameBoard game;

    private ArrayList<Player> players;
    private ArrayList<ImageView> imAs;
    private ArrayList<ImageView> imAf;
    private ArrayList<ImageView> imS;
    private ArrayList<ImageView> imN;
    private ArrayList<Label> setLabelTurn;
    private ArrayList<Label> playerTurnArray;
    private int[] coorX= {-1,-20,-20,-20,-20,-20,-20};
    private int[] coorY= {-1,-20,-20,-20,-20,-20,-20};
    private Color[] playerColor = {Color.GREENYELLOW,Color.CYAN,Color.RED,Color.FUCHSIA,Color.FORESTGREEN,Color.BLUE};
    private Font labels = new Font("Verdana", 15);
    private Font arrow = new Font("Verdana",16);
    private Timeline setDelay;
    private Label[] playersNameLabels;

    @FXML Canvas boardCanvas;

    @FXML Label playerOneName,playerTwoName,playerThreeName,playerFourName,playerFiveName,playerSixName;

    @FXML Label playerOneTurn,playerTwoTurn,playerThreeTurn,playerFourTurn,playerFiveTurn,playerSixTurn;

    @FXML Button left,right;

    @FXML ImageView as1,as2,as3,as4,as5,as6,af1,af2,af3,af4,af5,af6,s1,s2,s3,s4,s5,s6,n1,n2,n3,n4,n5,n6;

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

    private void draw(GraphicsContext gc){
        gc.drawImage(new Image("edu/chl/trivialpursuit/view/board_pastell.png"), 0, 0, boardCanvas.getWidth(), boardCanvas.getHeight());
        gc.setFill(playerColor[0]);
        gc.fillOval(coorX[1],coorY[1], 15, 15);
        gc.strokeOval(coorX[1],coorY[1], 15, 15);
        gc.setFill(playerColor[1]);
        gc.fillOval(coorX[2]-12,coorY[2], 15, 15);
        gc.strokeOval(coorX[2]-12,coorY[2], 15, 15);
        gc.setFill(playerColor[2]);
        gc.fillOval(coorX[3],coorY[3]-12, 15, 15);
        gc.strokeOval(coorX[3],coorY[3]-12, 15, 15);
        gc.setFill(playerColor[3]);
        gc.fillOval(coorX[4], coorY[4] + 12, 15, 15);
        gc.strokeOval(coorX[4], coorY[4] + 12, 15, 15);
        gc.setFill(playerColor[4]);
        gc.fillOval(coorX[5] + 12, coorY[5], 15, 15);
        gc.strokeOval(coorX[5] + 12, coorY[5], 15, 15);
        gc.setFill(playerColor[5]);
        gc.fillOval(coorX[6] + 12, coorY[6] - 12, 15, 15);
        gc.strokeOval(coorX[6] + 12, coorY[6] - 12, 15, 15);
    }


    private void setNames() {
        for (int i = 0; i < players.size(); i++) {
            playersNameLabels[i].setText(game.getPlayers().get(i).getName());
            playersNameLabels[i].setTextFill(playerColor[i]);
            playersNameLabels[i].setFont(labels);
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

            choosen = chooseT.contintentToStartArray.get(i);
            name = chooseP.playerNameArray.get(i);

            if (choosen.equals("Asia")){
                players.add(new Player(name,game.getSpotsOuter().get(0),new HashSet<Continent>()));
            }else if (choosen.equals("Africa")){
                players.add(new Player(name,game.getSpotsOuter().get(7), new HashSet<Continent>()));
            }else if (choosen.equals("South America")){
                players.add(new Player(name,game.getSpotsOuter().get(14), new HashSet<Continent>()));
            }else{
                players.add(new Player(name,game.getSpotsOuter().get(21), new HashSet<Continent>()));
            }
        }
    }

    public void addLabelTurns(){
        for(int i = 0; i<chooseP.getNumberOfPlayers(); i++){
            setLabelTurn.add(playerTurnArray.get(i));
        }
    }

    public void setTheCoordinates() {
        for (int i = 1; i <= chooseP.getNumberOfPlayers(); i++) {
            setCoordinates(chooseP.getNumberOfPlayers());
        }
    }

    public void startTimer() {
        int currentTurn = game.getTurn() -1;
        Player currentPlayer = game.getPlayers().get(currentTurn);
        Category currentPlayerSpotCat = currentPlayer.getSpot().getCategory();
        setDelay = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)  {
                if(currentPlayerSpotCat != Category.AIRPLANE){
                    try {
                        final AfricaCardView cardView = AfricaCardView.create();
                        cardView.show();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    right.setDisable(false);
                    left.setDisable(false);
            }else{
                    /*
                     * If the player that lands on an airplane spot owns a ticket he will be congratulated
                     * and moved to europe, else there will only be a dialog that tells the player
                     * that he needs to collect more cotinents and the turn will be switched
                     */

                    if(currentPlayer.getHasTicket()) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("CONGRATULATIONS!");
                        alert.setHeaderText("I can see that you own a ticket wich means that you have enough\n" +
                                "evidence that you have been around the world!");
                        alert.setContentText("Have a nice trip back to europe!");
                        alert.showAndWait();
                        right.setDisable(false);
                        left.setDisable(false);
                       
                        drawBoard();
                    }else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("To Bad!");
                        alert.setHeaderText("You have no ticket, wich means that you need to collect more continents!");
                        alert.setContentText("Come back when you have enough evidence that you have been arround the world, \n" +
                                " to get a ticket back to Europe");
                        alert.showAndWait();

                        right.setDisable(false);
                        left.setDisable(false);

                        if(game.getTurn() == chooseP.getNumberOfPlayers()){
                            game.setTurn(1);
                        }else{
                            game.setTurn(game.getTurn() + 1);

                            try {
                                DiceView dice = DiceView.create();
                                dice.show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                    }
                }
            }
        }));
        setDelay.play();
    }

    private void addAs(){
        imAs.add(as1);
        imAs.add(as2);
        imAs.add(as3);
        imAs.add(as4);
        imAs.add(as5);
        imAs.add(as6);
    }

    private void addAf(){
        imAf.add(af1);
        imAf.add(af2);
        imAf.add(af3);
        imAf.add(af4);
        imAf.add(af5);
        imAf.add(af6);
    }

    private void addS(){
        imS.add(s1);
        imS.add(s2);
        imS.add(s3);
        imS.add(s4);
        imS.add(s5);
        imS.add(s6);
    }

    private void addN(){
        imN.add(n1);
        imN.add(n2);
        imN.add(n3);
        imN.add(n4);
        imN.add(n5);
        imN.add(n6);
    }

    private void addPlayerNameLabelsToArray(){
        playersNameLabels[0] = playerOneName;
        playersNameLabels[1] = playerTwoName;
        playersNameLabels[2] = playerThreeName;
        playersNameLabels[3] = playerFourName;
        playersNameLabels[4] = playerFiveName;
        playersNameLabels[5] = playerSixName;
    }

    private void addLabelTurnsToArray(){
        playerTurnArray.add(playerOneTurn);
        playerTurnArray.add(playerTwoTurn);
        playerTurnArray.add(playerThreeTurn);
        playerTurnArray.add(playerFourTurn);
        playerTurnArray.add(playerFiveTurn);
        playerTurnArray.add(playerSixTurn);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        players = new ArrayList<>();
        setLabelTurn = new ArrayList<>();
        playerTurnArray = new ArrayList<>();
        addLabelTurnsToArray();
        imAs = new ArrayList<>();
        imAf = new ArrayList<>();
        imS = new ArrayList<>();
        imN = new ArrayList<>();
        playersNameLabels = new Label[6];
        createPlayers();
        addPlayerNameLabelsToArray();
        game.setPlayers(players);
        setNames();
        addLabelTurns();
        game.setLabelTurns(setLabelTurn);
        game.setTurn(1);
        game.getLabelTurns().get(0).setText("<-- " + +dice.getTotalDiceValue() + " steps!");
        game.getLabelTurns().get(0).setFont(arrow);
        addAs();
        addAf();
        addS();
        addN();
        game.setiAs(imAs);
        game.setiAf(imAf);
        game.setiS(imS);
        game.setiN(imN);
        setTheCoordinates();
        drawBoard();
    }
}
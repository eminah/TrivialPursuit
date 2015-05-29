package edu.chl.trivialpursuit.controller;

import edu.chl.trivialpursuit.model.*;
import edu.chl.trivialpursuit.view.*;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    private int numberOfPlayersPlaying;

    @FXML Canvas boardCanvas;

    @FXML Label playerOneName,playerTwoName,playerThreeName,playerFourName,playerFiveName,playerSixName;

    @FXML Label playerOneTurn,playerTwoTurn,playerThreeTurn,playerFourTurn,playerFiveTurn,playerSixTurn;

    @FXML Button left,right;

    @FXML ImageView as1,as2,as3,as4,as5,as6,af1,af2,af3,af4,af5,af6,s1,s2,s3,s4,s5,s6,n1,n2,n3,n4,n5,n6;

    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")
    private void move(ActionEvent e){
        Button buttonPressed = (Button)e.getSource();
        if(buttonPressed == right) {
            movePlayer(game.getTurn(), dice.getTotalDiceValue(),"Right" );
        }else{
            movePlayer(game.getTurn(), dice.getTotalDiceValue(),"Left" );
        }
        disableTheButtonsRightLeft();
        drawBoard();
        generateTicketDialog(checkIfSpotisAirplane());
        startTimer();
    }


    private void movePlayer(int player, int diceValue, String direction) {
        int correctPlayer = player - 1;
        if (direction.equals("Left")) {
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

        int startPlaceAsia = 0;
        int startPlaceAfrica = 7;
        int startPlaceSouthAmerica = 14;
        int startPlaceNorthAmerica = 21;

        for (int i = 0; i < numberOfPlayersPlaying; i++) {
            String chosen = "";
            String name = "";

            chosen = chooseT.continentToStartArray.get(i);
            name = chooseP.playerNameArray.get(i);

            if (chosen.equals("Asia")){
                players.add(new Player(name,game.getSpotsOuter().get(startPlaceAsia),new HashSet<Continent>()));
            }else if (chosen.equals("Africa")){
                players.add(new Player(name,game.getSpotsOuter().get(startPlaceAfrica), new HashSet<Continent>()));
            }else if (chosen.equals("South America")){
                players.add(new Player(name,game.getSpotsOuter().get(startPlaceSouthAmerica), new HashSet<Continent>()));
            }else{
                players.add(new Player(name,game.getSpotsOuter().get(startPlaceNorthAmerica), new HashSet<Continent>()));
            }
        }
    }

    public void addLabelTurns(){
        for(int i = 0; i<numberOfPlayersPlaying; i++){
            setLabelTurn.add(playerTurnArray.get(i));
        }
    }

    public void setTheCoordinates() {
        for (int i = 1; i <= numberOfPlayersPlaying; i++) {
            setCoordinates(numberOfPlayersPlaying);
        }
    }

    private boolean checkIfSpotisAirplane(){
        int currentTurn = game.getTurn() -1;
        Player currentPlayer = game.getPlayers().get(currentTurn);
        Category currentPlayerSpotCategory = currentPlayer.getSpot().getCategory();
        return currentPlayerSpotCategory == Category.AIRPLANE;
    }

    private void generateTicketDialog(boolean isOnAirplaneSpot){

        int startPlaceEurope = 0;
        int currentTurnIndex = game.getTurn() -1;
        int currentTurn = game.getTurn();
        Player currentPlayer = game.getPlayers().get(currentTurnIndex);

        if(isOnAirplaneSpot){
            if(currentPlayer.getHasTicket()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Congratulations!");
                alert.setHeaderText("You have now collected enough evidence for travelling around the world.");
                alert.setContentText("You will now fly back to Europe!");
                alert.showAndWait();

                enableTheButtonsRightLeft();

                currentPlayer.setSpot(game.getSpotsInner().get(startPlaceEurope));
                setCoordinates(currentTurn);
                drawBoard();
                game.setNextTurn(game.getAmountOfPlayersPlaying());
                currentPlayer = game.getPlayers().get(currentTurnIndex);
                Continent currentPlayerSpotContinent = currentPlayer.getSpot().getContinent();
                Category currentPlayerSpotCategory = currentPlayer.getSpot().getCategory();

                if(currentPlayerSpotContinent == Continent.EUROPE && currentPlayerSpotCategory == Category.AIRPLANE) {
                    movePlayer(currentTurn, 1, "Right");
                } else if(currentPlayerSpotContinent == Continent.EUROPE) {
                    movePlayer(currentTurn, 0, "Right");
                } else {
                    try {
                        DiceView dv = DiceView.create();
                        dv.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void startTimer() {
        int currentTurn = game.getTurn() -1;
        Player currentPlayer = game.getPlayers().get(currentTurn);
        Category currentPlayerSpotCategory = currentPlayer.getSpot().getCategory();
        Continent currentPlayerSpotContinent = currentPlayer.getSpot().getContinent();
        setDelay = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (currentPlayerSpotCategory != Category.AIRPLANE) {
                    try {
                        changeToRightView(currentPlayerSpotContinent);
                    } catch (IOException e) {
                        e.printStackTrace();
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

    private void changeToRightView(Continent continent) throws IOException{
        if(continent == Continent.AFRICA) {

            final AfricaCardView cardView = AfricaCardView.create();
            cardView.show();
            enableTheButtonsRightLeft();


        } else if(continent == Continent.ASIA){

            final AsiaCardView cardView = AsiaCardView.create();
            cardView.show();
            enableTheButtonsRightLeft();

        }else if(continent == Continent.NORTH_AMERICA){
            final NorthAmericaCardView cardView = NorthAmericaCardView.create();
            cardView.show();
            enableTheButtonsRightLeft();

        }else{
            final SouthAmericaCardView cardView = SouthAmericaCardView.create();
            cardView.show();
            enableTheButtonsRightLeft();
        }
    }

    private void enableTheButtonsRightLeft(){
        right.setDisable(false);
        left.setDisable(false);
    }
    private void disableTheButtonsRightLeft(){
        right.setDisable(true);
        left.setDisable(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        numberOfPlayersPlaying = chooseP.getNumberOfPlayers();
        game.setAmountOfPlayersPlaying(numberOfPlayersPlaying);
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
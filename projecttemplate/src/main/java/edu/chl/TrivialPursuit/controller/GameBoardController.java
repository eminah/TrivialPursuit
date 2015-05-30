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
import java.sql.Time;
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

    private Timeline getQuestionDelay;
    private Timeline europeDelay;
    private Label[] playersNameLabels;

    @FXML Canvas boardCanvas;

    @FXML Label playerOneName,playerTwoName,playerThreeName,playerFourName,playerFiveName,playerSixName;

    @FXML Label playerOneTurn,playerTwoTurn,playerThreeTurn,playerFourTurn,playerFiveTurn,playerSixTurn;

    @FXML Button left,right;

    @FXML ImageView asiaImagePlayer1,asiaImagePlayer2,asiaImagePlayer3,asiaImagePlayer4,asiaImagePlayer5,asiaImagePlayer6,
            africaImagePlayer1,africaImagePlayer2,africaImagePlayer3,africaImagePlayer4,africaImagePlayer5,africaImagePlayer6,
            southAmImagePlayer1,southAmImagePlayer2,southAmImagePlayer3,southAmImagePlayer4,southAmImagePlayer5,southAmImagePlayer6,
            northAmImagePlayer1,northAmImagePlayer2,northAmImagePlayer3,northAmImagePlayer4,northAmImagePlayer5,northAmImagePlayer6;

    @FXML
    @SuppressFBWarnings("UPM_UNCALLED_PRIVATE_METHOD")
    private void move(ActionEvent e){

        if(!game.getCurrentPlayerPlaying().isInEurope()) {
            Button buttonPressed = (Button)e.getSource();
            if(buttonPressed == right) {
                movePlayer(dice.getTotalDiceValue(), "Right" );
            }else{
                movePlayer(dice.getTotalDiceValue(), "Left" );
            }
            disableTheButtonsRightLeft();

            try {
                generateTicketDialog(checkIfSpotisAirplane());
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } else {
            if(game.getCurrentPlayerPlaying().getSpot().getCategory() == Category.AIRPLANE) {
                movePlayer(1, "Right");
                setCoordinates(game.getAmountOfPlayersPlaying());
            } else {
                movePlayer(0, "Right");
            }
        }

        startTimer();
    }


    private void movePlayer(int diceValue, String direction) {

        if (direction.equals("Left")) {
            game.getCurrentPlayerPlaying().goLeft(diceValue);
        }else {
            game.getCurrentPlayerPlaying().goRight(diceValue);
        }
        setCoordinates(game.getAmountOfPlayersPlaying());
    }

    //TODO tog bort en annan setCoordinates, tror att denna räcker
    private void setCoordinates(int amountOfPlayers){
        for(int i = 1; i <= amountOfPlayers; i++){
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


    private void createPlayers() {

        int startPlaceAsia = 0;
        int startPlaceAfrica = 7;
        int startPlaceSouthAmerica = 14;
        int startPlaceNorthAmerica = 21;

        for (int i = 0; i < game.getAmountOfPlayersPlaying(); i++) {
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
        for(int i = 0; i < game.getAmountOfPlayersPlaying(); i++){
            setLabelTurn.add(playerTurnArray.get(i));
        }
    }

    private boolean checkIfSpotisAirplane(){
        Category currentPlayerSpotCategory = game.getCurrentPlayerPlaying().getSpot().getCategory();
        return currentPlayerSpotCategory == Category.AIRPLANE;
    }

    private void generateTicketDialog(boolean isOnAirplaneSpot) throws IOException {

        /*int startPlaceEurope = 0;
        int currentTurnIndex = game.getTurn() -1;
        int currentTurn = game.getTurn();
        Player currentPlayer = game.getPlayers().get(currentTurnIndex);


            if(currentPlayer.getHasTicket()) {*/

        Continent currentPlayersSpotContinent = game.getCurrentPlayerPlaying().getSpot().getContinent();
        if(isOnAirplaneSpot && currentPlayersSpotContinent != Continent.EUROPE) {
            if(game.getCurrentPlayerPlaying().getHasTicket()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Congratulations!");
                alert.setHeaderText("You have now collected enough evidence for travelling around the world.");
                alert.setContentText("You will now fly back to Europe and will be able to go home!");
                alert.showAndWait();

                enableTheButtonsRightLeft();
                movePlayerToEurope(game.getCurrentPlayerPlaying());
                game.setNextTurn(game.getAmountOfPlayersPlaying());
                game.fixArrow();

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Too bad!");
                alert.setHeaderText(null);
                alert.setContentText("You have not collected all continents and therefor have no ticket back to Europe!");
                alert.showAndWait();

                enableTheButtonsRightLeft();
                game.setNextTurn(game.getAmountOfPlayersPlaying());
                game.fixArrow();
            }

            changeToRightViewForNextPlayer(game.getCurrentPlayerPlaying());
        }

    }

    public void startTimer() {

        Category currentPlayersSpotCategory = game.getCurrentPlayerPlaying().getSpot().getCategory();
        Continent currentPlayersSpotContinent = game.getCurrentPlayerPlaying().getSpot().getContinent();
        getQuestionDelay = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (currentPlayersSpotCategory != Category.AIRPLANE) {
                    try {
                        changeToRightCardView(currentPlayersSpotContinent);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }));

        getQuestionDelay.play();
    }

    private void addAs(){
        imAs.add(asiaImagePlayer1);
        imAs.add(asiaImagePlayer2);
        imAs.add(asiaImagePlayer3);
        imAs.add(asiaImagePlayer4);
        imAs.add(asiaImagePlayer5);
        imAs.add(asiaImagePlayer6);
    }

    private void addAf(){
        imAf.add(africaImagePlayer1);
        imAf.add(africaImagePlayer2);
        imAf.add(africaImagePlayer3);
        imAf.add(africaImagePlayer4);
        imAf.add(africaImagePlayer5);
        imAf.add(africaImagePlayer6);
    }

    private void addS(){
        imS.add(southAmImagePlayer1);
        imS.add(southAmImagePlayer2);
        imS.add(southAmImagePlayer3);
        imS.add(southAmImagePlayer4);
        imS.add(southAmImagePlayer5);
        imS.add(southAmImagePlayer6);
    }

    private void addN(){
        imN.add(northAmImagePlayer1);
        imN.add(northAmImagePlayer2);
        imN.add(northAmImagePlayer3);
        imN.add(northAmImagePlayer4);
        imN.add(northAmImagePlayer5);
        imN.add(northAmImagePlayer6);
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

    private void changeToRightCardView(Continent continent) throws IOException{

        if(continent == Continent.AFRICA) {
            final AfricaCardView cardView = AfricaCardView.create();
            cardView.show();
            enableTheButtonsRightLeft();


        } else if(continent == Continent.ASIA){
            final AsiaCardView cardView = AsiaCardView.create();
            cardView.show();
            enableTheButtonsRightLeft();

        } else if(continent == Continent.NORTH_AMERICA){
            final NorthAmericaCardView cardView = NorthAmericaCardView.create();
            cardView.show();
            enableTheButtonsRightLeft();

        } else if(continent == Continent.SOUTH_AMERICA) {
            final SouthAmericaCardView cardView = SouthAmericaCardView.create();
            cardView.show();
            enableTheButtonsRightLeft();

        } else {
            final EuropeCardView cardView = EuropeCardView.create();
            cardView.show();
            enableTheButtonsRightLeft();
            right.setText("Right");
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


    public void movePlayerToEurope(Player thePlayerToMove) {
        int startPlaceEurope = 0;
        thePlayerToMove.setSpot(game.getSpotsInner().get(startPlaceEurope));
        setCoordinates(game.getAmountOfPlayersPlaying());
        game.getCurrentPlayerPlaying().setInEurope(true);
        drawBoard();
    }

    public void changeToRightViewForNextPlayer(Player nextPlayer)throws IOException {
        if(nextPlayer.isInEurope()) {
            GameBoardView gameBoardView = GameBoardView.create();
            gameBoardView.show();
            left.setDisable(true);
            right.setText("Question");
        } else {
            DiceView diceView = DiceView.create();
            diceView.show();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game.setButtonRight(right);
        game.setButtonLeft(left);
        game.setAmountOfPlayersPlaying(chooseP.getNumberOfPlayers());
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
        game.setCurrentPlayerPlaying(game.getPlayers().get(game.getCurrentTurnNumberArrayIndex()));
        game.fixArrow();
        addAs();
        addAf();
        addS();
        addN();
        game.setiAs(imAs);
        game.setiAf(imAf);
        game.setiS(imS);
        game.setiN(imN);
        setCoordinates(game.getAmountOfPlayersPlaying());
    }
}
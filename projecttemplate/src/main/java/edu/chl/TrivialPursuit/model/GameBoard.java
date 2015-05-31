package edu.chl.trivialpursuit.model;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import org.apache.commons.lang3.tuple.ImmutablePair;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by Ina Tran on 15-05-04.
 */
public class GameBoard {

    @Inject Dice dice;

    final private ArrayList<Spot> spotsOuter;
    final private ArrayList<Spot> spotsInner;
    final private ArrayList<Card> cards;

    private ArrayList<Card> cardsInner;
    private ArrayList<Player> players;
    private ArrayList<Label> labelTurns;
    private ArrayList<ImageView> iAs;
    private ArrayList<ImageView>  iAf;
    private ArrayList<ImageView>  iS;
    private ArrayList<ImageView>  iN;
    private ArrayList<Label> arrayWithPlayerNameLabels;
    private int turn;
    private int amountOfPlayersPlaying;
    private Player currentPlayerPlaying;
    private Font arrow = new Font("Verdana", 16);
    private Button buttonRight;
    private Button buttonLeft;


    public GameBoard(){

        players = new ArrayList<>();
        labelTurns = new ArrayList<>();

        spotsOuter = new ArrayList<>();
        spotsInner = new ArrayList<>();
        cards = new ArrayList<>();
        addCardsAsia();
        addCardsAfrica();
        addCardsSouthAmerica();
        addCardsNorthAmerica();
        addSpotsToListOuter();
        setBoardingSpotsOuter();
        addSpotsToListInner();
        setBoardingSpotsInner();
    }

    //The number you need to get the current player from the Arraylist getPlayers
    public int getCurrentTurnNumberArrayIndex() {
        return this.turn-1;
    }

    public Player getCurrentPlayerPlaying() {
        return currentPlayerPlaying;
    }

    public void setCurrentPlayerPlaying(Player currentPlayerPlaying) {
        this.currentPlayerPlaying = currentPlayerPlaying;
    }

    public Button getButtonLeft() {
        return buttonLeft;
    }

    public void setButtonLeft(Button buttonLeft) {
        this.buttonLeft = buttonLeft;
    }

    public Button getButtonRight() {
        return buttonRight;
    }

    public void setButtonRight(Button buttonRight) {
        this.buttonRight = buttonRight;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public ArrayList<Label> getLabelTurns() {
        return labelTurns;
    }

    public void setLabelTurns(ArrayList<Label> labelTurns) {
        this.labelTurns = labelTurns;
    }

    public ArrayList<ImageView> getiAs() {
        return iAs;
    }

    public void setiAs(ArrayList<ImageView> iAs) {
        this.iAs = iAs;
    }

    public ArrayList<ImageView> getiAf() {
        return iAf;
    }

    public void setiAf(ArrayList<ImageView> iAf) {
        this.iAf = iAf;
    }

    public ArrayList<ImageView> getiS() {
        return iS;
    }

    public void setiS(ArrayList<ImageView> iS) {
        this.iS = iS;
    }

    public ArrayList<ImageView> getiN() {
        return iN;
    }

    public void setiN(ArrayList<ImageView> iN) {
        this.iN = iN;
    }

    public int getAmountOfPlayersPlaying() {
        return amountOfPlayersPlaying;
    }

    public void setAmountOfPlayersPlaying(int amountOfPlayersPlaying) {
        this.amountOfPlayersPlaying = amountOfPlayersPlaying;
    }

    public ArrayList<Label> getarrayWithPlayerNameLabels() {
        return arrayWithPlayerNameLabels;
    }

    public void setarrayWithPlayerNameLabels (ArrayList<Label> playerNames) {
        this.arrayWithPlayerNameLabels = playerNames;
    }

    public ArrayList<Spot> getSpotsOuter() {
        return spotsOuter;
    }

    public ArrayList<Spot> getSpotsInner() {
        return spotsInner;
    }

    private final ImmutablePair[] SPOT_DEFINITIONS_OUTER = {
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.AIRPLANE),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.GEOGRAPHY),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.CULTURE),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.HISTORY),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.SPORT),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.TECHNIC),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.MEDIA),
            new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.AIRPLANE),
            new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.GEOGRAPHY),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.CULTURE),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.HISTORY),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.SPORT),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.TECHNIC),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.MEDIA),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.AIRPLANE),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.CULTURE),
            new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.GEOGRAPHY),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.HISTORY),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.SPORT),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.TECHNIC),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.MEDIA),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.AIRPLANE),
            new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.GEOGRAPHY),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.CULTURE),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.HISTORY),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.SPORT),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.TECHNIC),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.MEDIA),
    };

    private final ImmutablePair[] SPOT_DEFINITIONS_INNER = {
            new ImmutablePair<Continent, Category>(Continent.EUROPE, Category.AIRPLANE),
            new ImmutablePair<Continent, Category>(Continent.EUROPE, Category.GEOGRAPHY),
            new ImmutablePair<Continent, Category>(Continent.EUROPE, Category.CULTURE),
            new ImmutablePair<Continent, Category>(Continent.EUROPE, Category.HISTORY),
            new ImmutablePair<Continent, Category>(Continent.EUROPE, Category.SPORT),
            new ImmutablePair<Continent, Category>(Continent.EUROPE, Category.TECHNIC),
            new ImmutablePair<Continent, Category>(Continent.EUROPE, Category.MEDIA),
    };

    // Searching for all coordinates by hand, time consuming - Helene
    private final ImmutablePair[] SPOT_DEFINITIONS_COORDINATES_OUTER = {

            //Coordinates for Asia
            new ImmutablePair<>(250,15),
            new ImmutablePair<>(315,20),
            new ImmutablePair<>(363,35),
            new ImmutablePair<>(402,60),
            new ImmutablePair<>(435,90),
            new ImmutablePair<>(468,125),
            new ImmutablePair<>(485,178),

            //Coordinates for Africa
            new ImmutablePair<>(497,230),
            new ImmutablePair<>(490,280),
            new ImmutablePair<>(475,315),
            new ImmutablePair<>(455,355),
            new ImmutablePair<>(420,390),
            new ImmutablePair<>(375,420),
            new ImmutablePair<>(325,440),

            //Coordinates for South America
            new ImmutablePair<>(260,445),
            new ImmutablePair<>(195,435),
            new ImmutablePair<>(140,415),
            new ImmutablePair<>(95,385),
            new ImmutablePair<>(65,360),
            new ImmutablePair<>(40,320),
            new ImmutablePair<>(23,280),

            //Coordinates for North America
            new ImmutablePair<>(20,230),
            new ImmutablePair<>(25,170),
            new ImmutablePair<>(50,125),
            new ImmutablePair<>(75,90),
            new ImmutablePair<>(110,60),
            new ImmutablePair<>(150,40),
            new ImmutablePair<>(190,25),
    };

    private final ImmutablePair[] SPOT_DEFINITIONS_COORDINATES_INNER = {

            //Coordinates for EUROPE
            new ImmutablePair<>(295,120),
            new ImmutablePair<>(380,190),
            new ImmutablePair<>(360,300),
            new ImmutablePair<>(250,340),
            new ImmutablePair<>(150,295),
            new ImmutablePair<>(135,200),
            new ImmutablePair<>(190,135),
    };

    public void addSpotsToListOuter(){
        for(int i = 0; i < SPOT_DEFINITIONS_OUTER.length; i++){

            spotsOuter.add(new Spot((Continent) SPOT_DEFINITIONS_OUTER[i].getLeft(),
                    (Category) SPOT_DEFINITIONS_OUTER[i].getRight(),
                    (Integer) SPOT_DEFINITIONS_COORDINATES_OUTER[i].getLeft(),
                    (Integer)SPOT_DEFINITIONS_COORDINATES_OUTER[i].getRight(), cards.get(i)
                    )
            );
        }
    }

    public void addSpotsToListInner(){
        for(int i = 0; i < SPOT_DEFINITIONS_INNER.length; i++){

            spotsInner.add(new Spot((Continent)SPOT_DEFINITIONS_INNER[i].getLeft(),
                    (Category) SPOT_DEFINITIONS_INNER[i].getRight(),
                    (Integer) SPOT_DEFINITIONS_COORDINATES_INNER[i].getLeft(),
                    (Integer) SPOT_DEFINITIONS_COORDINATES_INNER[i].getRight(),new EuropeCard())
            );
        }
    }

    //Sets the left and right spot to every spot
    public void setBoardingSpotsOuter(){

        setSpotsRight(spotsOuter);
        setSpotsLeft(spotsOuter);
    }

    public void setBoardingSpotsInner(){

        setSpotsRight(spotsInner);
        setSpotsLeft(spotsInner);
    }

    public void setSpotsRight(ArrayList<Spot> spotArray ){
        for(int i = 0; i <= spotArray.size()-1; i++){
            if(i != spotArray.size()-1) {
                spotArray.get(i).setRight(spotArray.get(i + 1));
            }else{
                spotArray.get(i).setRight(spotArray.get(0));
            }
        }
    }

    public void setSpotsLeft(ArrayList<Spot> spotArray){
        for(int j = 0; j <= spotArray.size()-1; j++){
            if (j==0){
                spotArray.get(j).setLeft(spotArray.get(spotArray.size()-1));
            }else{
                spotArray.get(j).setLeft(spotArray.get(j-1));
            }
        }
    }

    public void addCardsAfrica(){
        for(int i = 0; i < 7; i++){
            cards.add(new AfricaCard());
        }
    }

    public void addCardsNorthAmerica(){
      for(int i = 0; i<7; i++){
          cards.add(new NorthAmericaCard());
      }
    }

    public void addCardsSouthAmerica(){
        for(int i = 0; i<7; i++){
            cards.add(new SouthAmericaCard());
        }
    }

    public void addCardsAsia(){
        for(int i = 0; i<7; i++){
            cards.add(new AsiaCard());
        }
    }

    public void setNextTurn(int theAmountOfPlayers) {
        if(turn == theAmountOfPlayers) {
            turn = 1;
        } else {
            turn = turn + 1;
        }

        currentPlayerPlaying = getPlayers().get(turn-1);
    }

    public void fixArrow() {
        //remove the arrow
        for(int i = 0; i < getAmountOfPlayersPlaying(); i++) {
            getLabelTurns().get(i).setText("");
        }

        if(!getCurrentPlayerPlaying().isInEurope()) {
            getLabelTurns().get(getCurrentTurnNumberArrayIndex()).setFont(arrow);
            getLabelTurns().get(getCurrentTurnNumberArrayIndex()).setText("<--" + dice.getTotalDiceValue() + " steps");
        } else {
            getLabelTurns().get(getCurrentTurnNumberArrayIndex()).setText("<--");
        }
    }

    public void movePlayerToEurope(Player thePlayerToMove) {
        int startPlaceEurope = 0;
        thePlayerToMove.setSpot(getSpotsInner().get(startPlaceEurope));
        thePlayerToMove.setInEurope(true);

    }
}
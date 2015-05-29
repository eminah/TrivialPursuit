package edu.chl.trivialpursuit.model;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.apache.commons.lang3.tuple.ImmutablePair;
import java.util.ArrayList;

/**
 * Created by inatran on 15-05-04.
 */
public class GameBoard {

    final private ArrayList<Spot> spotsOuter;
    final private ArrayList<Spot> spotsInner;
    final private ArrayList<Card> cards;

   // private ArrayList<Card> cardsInner;
    private ArrayList<Player> players;
    private ArrayList<Label> labelTurns;
    private ArrayList<ImageView> iAs;
    private ArrayList<ImageView>  iAf;
    private ArrayList<ImageView>  iS;
    private ArrayList<ImageView>  iN;
    private int turn;
    private int amountOfPlayersPlaying;

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
        //addSpotsToListInner();
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

    /*public void addSpotsToListInner(){
        for(int i = 0; i < SPOT_DEFINITIONS_INNER.length; i++){

            spotsInner.add(new Spot((Continent)SPOT_DEFINITIONS_INNER[i].getLeft(),
                    (Category) SPOT_DEFINITIONS_INNER[i].getRight(),
                    (Integer) SPOT_DEFINITIONS_COORDINATES_INNER[i].getLeft(),
                    (Integer) SPOT_DEFINITIONS_COORDINATES_INNER[i].getRight(),)
            );
        }
    }*/

    //Sets the left and right spot to every spot
    public void setBoardingSpotsOuter(){

       //Set the right spot to the current spot
        for(int i = 0; i <= spotsOuter.size()-1; i++){
            if(i != spotsOuter.size()-1) {
                spotsOuter.get(i).setRight(spotsOuter.get(i + 1));
            }else{
                spotsOuter.get(i).setRight(spotsOuter.get(0));
            }
        }

        //Set the left spot to the current spot
        for(int j = 0; j <= spotsOuter.size()-1; j++){
            if (j==0){
                spotsOuter.get(j).setLeft(spotsOuter.get(spotsOuter.size()-1));
            }else{
                spotsOuter.get(j).setLeft(spotsOuter.get(j-1));
            }
        }
    }

    public void setBoardingSpotsInner(){
        //Set the right spot to the current spot
        for(int i = 0; i <= spotsInner.size()-1; i++){
            if(i != spotsInner.size()-1) {
                spotsInner.get(i).setRight(spotsInner.get(i + 1));
            }else{
                spotsInner.get(i).setRight(spotsInner.get(0));
            }
        }

        //Set the left spot to the current spot
        for(int j = 0; j <= spotsInner.size()-1; j++){
            if (j==0){
                spotsInner.get(j).setLeft(spotsInner.get(spotsInner.size()-1));
            }else{
                spotsInner.get(j).setLeft(spotsInner.get(j-1));
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
    }

    public ArrayList<Spot> getSpotsOuter() {
        return spotsOuter;
    }

   /* public ArrayList<Spot> getSpotsInner() {
        return spotsInner;
    }*/

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
}
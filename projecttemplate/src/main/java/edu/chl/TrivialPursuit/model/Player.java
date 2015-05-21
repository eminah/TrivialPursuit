package edu.chl.trivialpursuit.model;

import edu.chl.trivialpursuit.controller.GameBoardController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Rasti on 2015-04-23.
 */




public  class Player {

    @Inject
    ChoosePlayer choosePlayer;

    @Inject
    GameBoardController gameBoardController;



    private int numerOfPlayers = choosePlayer.getNumberOfPlayers();
    private String name;
    private Spot spot;
    private boolean hasTicket = false; //Will be set to true when player has collected all Contintents
    private HashSet<Continent> collectedContinents;
    private boolean[] getTurn = new boolean[numerOfPlayers];




    /**
     *
     * The constructor creats a new HashSet, where the collected continents will be added.
     *
     * @param name the name of the player
     * @param spot the spot that the player chooses to start
     */
    public Player(String name, Spot spot) {
        this.name = name;
        this.spot = spot;
        collectedContinents = new HashSet<>();

        for(int i = 0; i < numerOfPlayers; i++){
            getTurn[i] = false;
        }
        getTurn[0] = true;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public HashSet<Continent> getCollectedContinents() {
        return collectedContinents;
    }


    /**
     *
     * @param steps the amount of steps the player goes to the left Direction
     *
     */
    public void goLeft(int steps){
        for(int i = 0; i<steps; i++){
            spot = spot.getLeft();
        }
    }

    /**
     *
     * @param steps the amount of steps the player goes to the right Direction
     */
    public void goRight(int steps){
        for(int i = 0; i<steps; i++){
            spot = spot.getRight();
        }

    }


    /**
     * Set next players turn
     * Called if the player answers wrong
     */
    public void setNextTurn(){
        for(int i = 0; i < numerOfPlayers; i++){
            if(getTurn[i]==true){
                getTurn[i] = false;
                if(i+1 == numerOfPlayers){
                    getTurn[0] = true;
                }else{
                    getTurn[i+1] = true;
                }
            }
        }
    }

    public int whosTurn() {

        for(int i = 0; i < numerOfPlayers; i++){
            if(getTurn[i]==true){
                return i+1;
            }
        }
        return -1;
    }


    /**
     *  Moves the player towards right
     *
     * @param player The player that should be moved
     * @param diceValue The amount of steps the player should be moved
     */
    public void movePlayerRight(int player, int diceValue){


        switch(player){
            case 1:
                goRight(diceValue);
                gameBoardController.setX1(spot.getCooX());
                gameBoardController.setY1(spot.getCooY());

                break;

            case 2:
                goRight(diceValue);
                gameBoardController.setX2(spot.getCooX()-15);
                gameBoardController.setY2(spot.getCooY());

                break;

            case 3:
                goRight(diceValue);
                gameBoardController.setX3(spot.getCooX());
                gameBoardController.setY3(spot.getCooY()-15);

                break;

            case 4:
                goRight(diceValue);
                gameBoardController.setX4(spot.getCooX()+15);
                gameBoardController.setY4(spot.getCooY());

                break;

            case 5:
                goRight(diceValue);
                gameBoardController.setX5(spot.getCooX());
                gameBoardController.setY5(spot.getCooY()+15);

                break;

            case 6:
                goRight(diceValue);
                gameBoardController.setX6(spot.getCooX()-10);
                gameBoardController.setY6(spot.getCooY()+10);

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
                goLeft(diceValue);
                gameBoardController.setX1(spot.getCooX());
                gameBoardController.setY1(spot.getCooY());

                break;

            case 2:
                goLeft(diceValue);
                gameBoardController.setX2(spot.getCooX()-15);
                gameBoardController.setY2(spot.getCooY());

                break;

            case 3:
                goLeft(diceValue);
                gameBoardController.setX3(spot.getCooX());
                gameBoardController.setY3(spot.getCooY()-15);

                break;

            case 4:
                goLeft(diceValue);
                gameBoardController.setX4(spot.getCooX()+15);
                gameBoardController.setY4(spot.getCooY());

                break;

            case 5:
                goLeft(diceValue);
                gameBoardController.setX5(spot.getCooX());
                gameBoardController.setY5(spot.getCooY()+15);

                break;

            case 6:
                goLeft(diceValue);
                gameBoardController.setX6(spot.getCooX()-10);
                gameBoardController.setY6(spot.getCooY()+10);

                break;
        }
    }

    public boolean getHasTicket() {
        return hasTicket;
    }

    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    public boolean checkIfAllContinents(){
       return collectedContinents.size() == 5;
    }
}



package edu.chl.trivialpursuit.model;

import edu.chl.trivialpursuit.controller.ChooseTravelController;
import edu.chl.trivialpursuit.controller.GameBoardController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * Created by Rasti on 2015-04-23.
 */

public  class Player {


    @Inject
    GameBoard game;

    @Inject
    GameBoardController gameBoardController;




    private String name;
    private Spot spot;
    private boolean hasTicket = false; //Will be set to true when player has collected all Contintents
    private HashSet<Continent> collectedContinents;



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



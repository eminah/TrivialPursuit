package edu.chl.TrivialPursuit.model;

import java.util.HashSet;

/**
 * Created by Rasti on 2015-04-23.
 */
public  class Player {

    private String name;
    private Spot spot;
    private boolean hasTicket; //Will be set to true when player has collected all Contintents
    private boolean inEurope;
    private HashSet<Continent> collectedContinents;
    private int turn;

    /**
     * The constructor creats a new HashSet, where the collected continents will be added.
     *
     * @param name the name of the player
     * @param spot the spot that the player chooses to start
     * @param hashSet the set that will contain the players collected cotinents
     */
    public Player(String name, Spot spot, HashSet<Continent> hashSet) {
        this.name = name;
        this.spot = spot;
        this.collectedContinents = hashSet;
        hasTicket = false;
        inEurope = false;
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

    public boolean getHasTicket() {
        return hasTicket;
    }

    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    public boolean checkIfAllContinents(){
        return collectedContinents.size() == 4;
    }

    public boolean isInEurope() {
        return inEurope;
    }

    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public HashSet<Continent> getCollectedContinents() {
        return collectedContinents;
    }

    public void setCollectedContinents(HashSet<Continent> collectedContinents) {
        this.collectedContinents = collectedContinents;
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
}
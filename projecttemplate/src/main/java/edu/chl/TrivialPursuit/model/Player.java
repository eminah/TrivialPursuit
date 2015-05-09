package edu.chl.trivialpursuit.model;

/**
 * Created by Rasti on 2015-04-23.
 */


    public  class Player {

    private String name;
    private Spot spot;
    private boolean hasTicket = false; //Will be set to true when player has collected all Contintents


    /**
     *
     * @param name the name of the player
     * @param spot the spot that the player chooses to start
     */
    public Player(String name, Spot spot) {
        this.name = name;
        this.spot = spot;
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

    /*
        Helene varje spelare skall ha en EnumSet där vi ska lägga in kontinenter.
        Varje gång en spelare gissar rätt på en fråga skall vi lägga till den
        kontinenten där spelaren befinner sig in i seten. Sen får vi använda metoden contains
        för att kolla vilka världsdelar som varje spelare har samlat. Se även till skapa en
        medod som heter något i stil med containsAll där du kollar om spelaren lyckats att
        samla alla kontinenter. Har spelare det så sätter du hasTicket till true.
        
     */

}



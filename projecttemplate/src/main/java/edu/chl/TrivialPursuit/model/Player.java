package edu.chl.trivialpursuit.model;

/**
 * Created by Rasti on 2015-04-23.
 */


    public  class Player {

    private String name;
    private Spot spot;

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

    public void goLeft(int steps){
        for(int i = 0; i<steps; i++){
            spot = spot.getLeft();
        }


    }

    public void goRight(int steps){
        for(int i = 0; i<steps; i++){
            spot = spot.getRight();
        }
    }

    // Någon metod som håller koll på vilka världsdelar spelaren har

    // Någon metod som sätter vilka världsdelar spelaren har



}



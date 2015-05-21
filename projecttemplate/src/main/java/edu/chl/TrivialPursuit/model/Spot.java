package edu.chl.trivialpursuit.model;



/**
 * Created by Rasti on 2015-05-02.
 */

public class Spot {


    private Continent continent;
    private Category category;
    private Spot right;
    private Spot left;
    private int cooX;
    private int cooY;

    /**
     *

     * @param continent The continent of the spot
     * @param category The Category of the spot
     */
    public Spot(Continent continent, Category category, int x, int y){

        this.continent = continent;
        this.category = category;
        cooX = x;
        cooY = y;

    }

    public Continent getContinent() {
        return continent;
    }

    public Category getCategory() {
        return category;
    }

    public Spot getRight() { return right;}

    public void setRight(Spot right) {
        this.right = right;
    }

    public Spot getLeft() {
        return left;
    }

    public void setLeft(Spot left) {
        this.left = left;
    }

    public int getCooX() {
        return cooX;
    }

    public int getCooY() {
        return cooY;
    }
}

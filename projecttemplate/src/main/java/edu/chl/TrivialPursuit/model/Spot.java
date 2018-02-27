package edu.chl.TrivialPursuit.model;

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
    private Card card;

    public Spot(Continent continent, Category category, int theXCoordinate, int theYCoordinate , Card card){

        this.continent = continent;
        this.category = category;
        cooX = theXCoordinate;
        cooY = theYCoordinate;
        this.card = card;
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

    public Card getCard() {
        return card;
    }
}
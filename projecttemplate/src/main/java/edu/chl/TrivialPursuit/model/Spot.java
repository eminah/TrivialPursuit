package edu.chl.trivialpursuit.model;



/**
 * Created by Rasti on 2015-05-02.
 */

public class Spot {


    private Continent continent;
    private Category category;
    private Spot right;
    private Spot left;

    /**
     *

     * @param continent The continent of the spot
     * @param category The Category of the spot
     */
    public Spot(Continent continent, Category category){

        this.continent = continent;
        this.category = category;

    }

    public Continent getContinent() {
        return continent;
    }

    public Category getCategory() {
        return category;
    }

    public Spot getRight() {
        return right;
    }

    public void setRight(Spot right) {
        this.right = right;
    }

    public Spot getLeft() {
        return left;
    }

    public void setLeft(Spot left) {
        this.left = left;
    }


}

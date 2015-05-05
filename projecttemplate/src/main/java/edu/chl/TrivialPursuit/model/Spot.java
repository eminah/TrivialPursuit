package edu.chl.trivialpursuit.model;

import lombok.Getter;

/**
 * Created by Rasti on 2015-05-02.
 */

public class Spot {

    private int index;
    private Continent continent;
    private Category category;

    /**
     *
     * @param index The spot number
     * @param continent The continent of the spot
     * @param category The Category of the spot
     */
    public Spot(int index, Continent continent, Category category){
        this.index = index;
        this.continent = continent;
        this.category = category;
    }

}

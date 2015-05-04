package edu.chl.trivialpursuit.model;

import lombok.Getter;

/**
 * Created by Rasti on 2015-05-02.
 */
public class Spot {

    @Getter private int index;
    @Getter private Continent continent;
    @Getter private Category category;

    /**
     *
     * @param index Helps sorting the spots in a list
     * @param continent The continent of the spot
     * @param category The Category of the spotc
     */
    public Spot(int index, Continent continent,Category category){
        this.index = index;
        this.continent = continent;
        this.category = category;
    }
}

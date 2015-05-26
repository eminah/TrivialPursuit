package edu.chl.trivialpursuit.model;


/**
 * Created by helenejarl on 2015-05-07.
 */
public class Card {

    private Category category;
    private Continent continent;

    /**
     *
     * @param ca the category of the card
     * @param co the continent of the card
     */

    // We removed the category to simplify the game for now,
    // TODO we will not use the Category, maybe later if time
    public Card(Continent co, Category ca){
        category = ca;
        continent = co;
    }

    public Category getCategory() {
        return category;
    }

    public Continent getContinent() {
        return continent;
    }


}

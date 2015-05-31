package edu.chl.trivialpursuit.model;


/**
 * Created by Heléne Jarl on 2015-05-07.
 */
public class Card {
    private Alternative correctAlternative;

    public Card(){

    }

    public boolean checkIfCorrectAlternative (Alternative alternative){
        return alternative == this.getCorrectAlternative();
    }


    public Alternative getCorrectAlternative() {
        return correctAlternative;
    }

    public void setCorrectAlternative(Alternative correctAlternative) {
        this.correctAlternative = correctAlternative;
    }
}

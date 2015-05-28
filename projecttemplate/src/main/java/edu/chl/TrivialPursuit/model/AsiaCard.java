package edu.chl.trivialpursuit.model;

/**
 * Created by Rasti on 2015-05-28.
 */
public class AsiaCard extends Card {

    private Alternative correctAlternative;

    public AsiaCard(){
        correctAlternative = Alternative.ALTERNATIVE_FOUR;
    }

    public Alternative getCorrectAlternative() {
        return correctAlternative;
    }

    public void setCorrectAlternative(Alternative correctAlternative) {
        this.correctAlternative = correctAlternative;
    }
}

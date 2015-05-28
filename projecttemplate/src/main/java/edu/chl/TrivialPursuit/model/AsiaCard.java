package edu.chl.trivialpursuit.model;

/**
 * Created by Rasti on 2015-05-28.
 */
public class AsiaCard {

    private Alternative correctAlternative;

    public AsiaCard(Alternative correctAlternative){
        this.correctAlternative = correctAlternative;
    }

    public Alternative getCorrectAlternative() {
        return correctAlternative;
    }

    public void setCorrectAlternative(Alternative correctAlternative) {
        this.correctAlternative = correctAlternative;
    }
}

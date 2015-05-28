package edu.chl.trivialpursuit.model;

/**
 * Created by Rasti on 2015-05-28.
 */
public class AfricaCard {

    private Alternative correctAlternative;

    public AfricaCard(Alternative correctAlternative){
        this.correctAlternative = correctAlternative;
    }

    public Alternative getCorrectAlternative() {
        return correctAlternative;
    }

    public void setCorrectAlternative(Alternative correctAlternative) {
        this.correctAlternative = correctAlternative;
    }


}

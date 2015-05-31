package edu.chl.trivialpursuit.model;

/**
 * Created by Rasti on 2015-05-28.
 */
public class AfricaCard extends Card {

    private Alternative correctAlternative;

    public AfricaCard(){
        this.correctAlternative = Alternative.ALTERNATIVE_THREE;
    }



    public Alternative getCorrectAlternative() {
        return correctAlternative;
    }

    public void setCorrectAlternative(Alternative correctAlternative) {
        this.correctAlternative = correctAlternative;
    }
}

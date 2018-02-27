package edu.chl.TrivialPursuit.model;

/**
 * Created by Rasti on 2015-05-28.
 */
public class SouthAmericaCard extends Card {

    private Alternative correctAlternative;

    public SouthAmericaCard(){
        correctAlternative = Alternative.ALTERNATIVE_ONE;
    }

    public Alternative getCorrectAlternative() {
        return correctAlternative;
    }

    public void setCorrectAlternative(Alternative correctAlternative) {
        this.correctAlternative = correctAlternative;
    }


}

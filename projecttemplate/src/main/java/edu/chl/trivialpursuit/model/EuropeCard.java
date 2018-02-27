package edu.chl.TrivialPursuit.model;

import edu.chl.TrivialPursuit.model.Card;

/**
 * Created by Rasti on 2015-05-28.
 */
public class EuropeCard extends Card {

    private Alternative correctAlternative;

    public EuropeCard(){
        this.correctAlternative = Alternative.ALTERNATIVE_TWO;
    }

    
    public Alternative getCorrectAlternative() {
        return correctAlternative;
    }

    public void setCorrectAlternative(Alternative correctAlternative) {
        this.correctAlternative = correctAlternative;
    }


}

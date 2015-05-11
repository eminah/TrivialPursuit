package edu.chl.trivialpursuit.model;

import java.util.Locale;

/**
 * Created by helenejarl on 2015-05-07.
 */
public class Card {

    private Category category;
    private Continent continent;
    private Alternative correctAlt;
    private Alternative answer;
    private Player player;

    /**
     *
     * @param ca the category of the card
     * @param co the continent of the card
     * @param correct the correct alternative of the card
     */

    public Card(Category ca, Continent co, Alternative correct){
        category = ca;
        continent = co;
        correctAlt = correct;
    }

    public Category getCategory() {
        return category;
    }

    public Continent getContinent() {
        return continent;
    }

    public Alternative getCorrectAlt() {
        return correctAlt;
    }

    public void setAnswer(Alternative answer) {
        this.answer = answer;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void checkAnswer(Alternative ans){
        answer = ans;

        if( answer.equals(correctAlt)){
            player.getCollectedContinents().add(continent);
            if (player.checkIfAllContinents()){
                player.setHasTicket(true);
            }
        }
    }


}

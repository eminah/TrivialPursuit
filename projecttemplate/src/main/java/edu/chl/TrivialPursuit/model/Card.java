package edu.chl.trivialpursuit.model;


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
     */

    // We removed the category to simplify the game for now,
    // TODO we will add it later if there is time
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

    public Alternative getCorrectAlt() {
        return correctAlt;
    }

    public void setCorrectAlt(Alternative correctAlt) {
        this.correctAlt = correctAlt;
    }

    public void setAnswer(Alternative answer) {
        this.answer = answer;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean checkAnswer(Alternative ans){
        answer = ans;

        if( answer.equals(correctAlt)){
            player.getCollectedContinents().add(continent);
            if (player.checkIfAllContinents()){
                player.setHasTicket(true);
            }
            return true;
        }else{
            return false;
        }
    }
}

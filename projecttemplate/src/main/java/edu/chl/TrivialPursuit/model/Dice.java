package edu.chl.TrivialPursuit.model;

import java.util.Random;

/**
 * Created by Rasti on 2015-04-23.
 */
public class Dice {
    private int firstDiceValue;
    private int secondDiceValue;
    private Random random;
    public Dice(){
        firstDiceValue = -1;
        secondDiceValue = -1;
        random = new Random();
    }

    public int getFirstDiceValue(){
        return firstDiceValue;
    }
    public int getSecondDiceValue(){
        return secondDiceValue;
    }
    public int getTotalDiceValue(){
        return firstDiceValue+secondDiceValue;
    }
    public void throwDice(){
        firstDiceValue = 1 + random.nextInt(6);
        secondDiceValue = 1 + random.nextInt(6);


    }
}


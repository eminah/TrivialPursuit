package edu.chl.TrivialPursuit.model;

import junit.framework.TestCase;
import org.junit.*;

/**
 * Created by Rasti on 2015-05-30.
 */
public class DiceTest extends TestCase {
    Dice dice = new Dice();


    @Test
    public void testThrowDice() throws Exception {

        for(int i = 0; i < 1000; i++){
            /*System.out.println("Value of dices BEFORE last throw");
            System.out.println("first dice value:" + dice.getFirstDiceValue());
            System.out.println("second dice value:" + dice.getSecondDiceValue());*/
            dice.throwDice();
           /* System.out.println("Value of dices AFTER last throw");
            System.out.println("first dice value:" + dice.getFirstDiceValue());
            System.out.println("second dice value:" + dice.getSecondDiceValue());*/
            assertTrue(dice.getFirstDiceValue() >= 1 && dice.getFirstDiceValue() <= 6);
            assertTrue(dice.getSecondDiceValue() >= 1 && dice.getSecondDiceValue() <= 6);

        }

    }
}
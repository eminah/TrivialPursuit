package edu.chl.trivialpursuit.model;

import junit.framework.TestCase;

/**
 * Created by eminahromic on 2015-05-31.
 */
public class EuropeCardTest extends TestCase {

    Card europeCard = new EuropeCard();

    public void testCheckIfCorrectAlternative() throws Exception {

        assertTrue(europeCard.checkIfCorrectAlternative(europeCard.getCorrectAlternative()));

        europeCard.setCorrectAlternative(Alternative.ALTERNATIVE_FOUR);
        assertTrue(europeCard.checkIfCorrectAlternative(Alternative.ALTERNATIVE_FOUR));

        assertTrue(europeCard.checkIfCorrectAlternative(europeCard.getCorrectAlternative()));


    }
}
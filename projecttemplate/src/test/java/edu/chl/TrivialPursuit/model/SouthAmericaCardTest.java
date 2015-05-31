package edu.chl.trivialpursuit.model;

import junit.framework.TestCase;

/**
 * Created by eminahromic on 2015-05-31.
 */
public class SouthAmericaCardTest extends TestCase {

    Card southAmericaCard = new SouthAmericaCard();

    public void testCheckIfCorrectAlternative() throws Exception {

        assertTrue(southAmericaCard.checkIfCorrectAlternative(southAmericaCard.getCorrectAlternative()));

        southAmericaCard.setCorrectAlternative(Alternative.ALTERNATIVE_FOUR);
        assertTrue(southAmericaCard.checkIfCorrectAlternative(Alternative.ALTERNATIVE_FOUR));

        assertTrue(southAmericaCard.checkIfCorrectAlternative(southAmericaCard.getCorrectAlternative()));

    }
}
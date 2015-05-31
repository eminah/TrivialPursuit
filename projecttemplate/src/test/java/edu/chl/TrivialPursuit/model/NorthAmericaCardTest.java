package edu.chl.trivialpursuit.model;

import junit.framework.TestCase;

/**
 * Created by eminahromic on 2015-05-31.
 */
public class NorthAmericaCardTest extends TestCase {

    Card nortAmericaCard = new NorthAmericaCard();
    public void testCheckIfCorrectAlternative() throws Exception {

        assertTrue(nortAmericaCard.checkIfCorrectAlternative(nortAmericaCard.getCorrectAlternative()));

        nortAmericaCard.setCorrectAlternative(Alternative.ALTERNATIVE_ONE);
        assertTrue(nortAmericaCard.checkIfCorrectAlternative(Alternative.ALTERNATIVE_ONE));

        assertTrue(nortAmericaCard.checkIfCorrectAlternative(nortAmericaCard.getCorrectAlternative()));

    }
}
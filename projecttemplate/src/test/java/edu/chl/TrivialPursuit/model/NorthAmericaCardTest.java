package edu.chl.trivialpursuit.model;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by eminahromic on 2015-05-31.
 */
public class NorthAmericaCardTest extends TestCase {

    Card nortAmericaCard = new NorthAmericaCard();

    @Test
    public void testCheckIfCorrectAlternative() throws Exception {



        nortAmericaCard.setCorrectAlternative(Alternative.ALTERNATIVE_ONE);
        assertTrue(nortAmericaCard.checkIfCorrectAlternative(Alternative.ALTERNATIVE_ONE));

        assertTrue(nortAmericaCard.checkIfCorrectAlternative(nortAmericaCard.getCorrectAlternative()));

    }
}
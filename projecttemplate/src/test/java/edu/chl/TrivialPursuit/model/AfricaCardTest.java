package edu.chl.trivialpursuit.model;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Rasti on 2015-05-30.
 */
public class AfricaCardTest extends TestCase {
    AfricaCard africaCard =  new AfricaCard();

    @Test
    public void testCheckIfCorrectAlternative() throws Exception {
        assertTrue(africaCard.checkIfCorrectAlternative(africaCard.getCorrectAlternative()));

    }
}
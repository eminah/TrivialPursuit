package edu.chl.TrivialPursuit.model;

import edu.chl.TrivialPursuit.model.Card;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by eminahromic on 2015-05-31.
 */
public class EuropeCardTest extends TestCase {

    Card europeCard = new EuropeCard();

    @Test
    public void testCheckIfCorrectAlternative() throws Exception {

      

        europeCard.setCorrectAlternative(Alternative.ALTERNATIVE_FOUR);
        assertTrue(europeCard.checkIfCorrectAlternative(Alternative.ALTERNATIVE_FOUR));

        assertTrue(europeCard.checkIfCorrectAlternative(europeCard.getCorrectAlternative()));


    }
}
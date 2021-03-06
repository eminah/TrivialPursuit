package edu.chl.TrivialPursuit.model;

import edu.chl.TrivialPursuit.model.AsiaCard;
import edu.chl.TrivialPursuit.model.Card;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by eminahromic on 2015-05-31.
 */
public class AsiaCardTest extends TestCase {
    Card asiaCard = new AsiaCard();

    @Test
    public void testCheckIfCorrectAlternative() throws Exception {

        assertTrue(asiaCard.checkIfCorrectAlternative(asiaCard.getCorrectAlternative()));
        asiaCard.setCorrectAlternative(Alternative.ALTERNATIVE_TWO);
        assertTrue(asiaCard.checkIfCorrectAlternative(Alternative.ALTERNATIVE_TWO));
    }
}

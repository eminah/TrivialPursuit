package edu.chl.TrivialPursuit.model;

import edu.chl.TrivialPursuit.model.AfricaCard;
import edu.chl.TrivialPursuit.model.Alternative;
import edu.chl.TrivialPursuit.model.Card;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Rasti on 2015-05-30.
 */
public class AfricaCardTest extends TestCase {
    Card africaCard = new AfricaCard();

    @Test
    public void testCheckIfCorrectAlternative() throws Exception {

        assertTrue(africaCard.checkIfCorrectAlternative(africaCard.getCorrectAlternative()));
        africaCard.setCorrectAlternative(Alternative.ALTERNATIVE_ONE);
        assertTrue(africaCard.checkIfCorrectAlternative(Alternative.ALTERNATIVE_ONE));
    }
}
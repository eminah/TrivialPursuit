package edu.chl.TrivialPursuit.model;

import edu.chl.TrivialPursuit.model.Alternative;
import edu.chl.TrivialPursuit.model.Card;
import edu.chl.TrivialPursuit.model.NorthAmericaCard;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by eminahromic on 2015-05-31.
 */
public class NorthAmericaCardTest extends TestCase {

    Card nortAmericaCard = new NorthAmericaCard();

    @Test
    public void testCheckIfCorrectAlternative() throws Exception {


        assertTrue(nortAmericaCard.checkIfCorrectAlternative(nortAmericaCard.getCorrectAlternative()));
        nortAmericaCard.setCorrectAlternative(Alternative.ALTERNATIVE_ONE);
        assertTrue(nortAmericaCard.checkIfCorrectAlternative(Alternative.ALTERNATIVE_ONE));
    }
}
package edu.chl.trivialpursuit.model;
import junit.framework.TestCase;
import org.junit.Test;
/**
 * Created by Heléne Jarl on 2015-05-31.
 */
public class ChooseTravelTest extends TestCase {
    ChooseTravel startPlace = new ChooseTravel();
    @Test
    public void testSetStartPlace() throws Exception {
        assertTrue(startPlace.continentToStartArray.isEmpty());
        startPlace.setStartPlace("Africa");
        assertTrue(!startPlace.continentToStartArray.isEmpty());
        assertEquals("Africa",startPlace.continentToStartArray.get(0));

    }
}
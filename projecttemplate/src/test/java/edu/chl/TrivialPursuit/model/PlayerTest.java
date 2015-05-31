package edu.chl.trivialpursuit.model;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by eminahromic on 2015-05-31.
 */
public class PlayerTest extends TestCase {
    Card asiaCard = new AsiaCard();
    Spot spot = new Spot(Continent.AFRICA,Category.CULTURE,15,15,asiaCard);
    HashSet<Continent> hashSet = new HashSet<>();
    Player player = new Player("Adam",spot , hashSet );

    @Test
    public void testCheckIfAllContinents() throws Exception {
        hashSet.add(Continent.AFRICA);
        assertFalse(player.checkIfAllContinents());
        hashSet.add(Continent.ASIA);
        hashSet.add(Continent.NORTH_AMERICA);
        hashSet.add(Continent.SOUTH_AMERICA);
        assertTrue(player.checkIfAllContinents());
    }

    @Test
    public void testIsInEurope() throws Exception {

    }
}
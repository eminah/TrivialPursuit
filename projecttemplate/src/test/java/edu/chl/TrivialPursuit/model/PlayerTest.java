package edu.chl.TrivialPursuit.model;

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
    GameBoard gameBoard = new GameBoard();


    @Test
    public void testCheckIfNotAllContintents(){
        hashSet.add(Continent.AFRICA);
        assertFalse(player.checkIfAllContinents());
    }

    @Test
    public void testCheckIfAllContinents() {
        hashSet.add(Continent.AFRICA);
        hashSet.add(Continent.ASIA);
        hashSet.add(Continent.NORTH_AMERICA);
        hashSet.add(Continent.SOUTH_AMERICA);
        assertTrue(player.checkIfAllContinents());
    }
    @Test
    public void testIfCorrectSpot(){
        int startPlaceAsia = 0;
        player.setSpot(gameBoard.getSpotsOuter().get(startPlaceAsia));
        assertFalse(player.getSpot().getContinent() == Continent.AFRICA);
        assertTrue(player.getSpot().getContinent() == Continent.ASIA);
        assertTrue(player.getSpot().getCategory() == Category.AIRPLANE);


    }

    @Test
    public void testIsInEurope() throws Exception {
        player.setInEurope(true);
        assertTrue(player.isInEurope());
        player.setInEurope(false);
        assertFalse(player.isInEurope());
    }

    @Test
    public void testIfCorrectName() throws Exception {
        player.setName("William");
        assertEquals("William", player.getName());
    }
}
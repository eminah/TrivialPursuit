package edu.chl.trivialpursuit.model;

import edu.chl.trivialpursuit.controller.GameBoardController;
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
    public void testCheckIfAllContinents() throws Exception {
        hashSet.add(Continent.AFRICA);
        assertFalse(player.checkIfAllContinents());
        hashSet.add(Continent.ASIA);
        hashSet.add(Continent.NORTH_AMERICA);
        hashSet.add(Continent.SOUTH_AMERICA);
        assertTrue(player.checkIfAllContinents());
    }
    @Test
    public void testIfCorrectSpot(){
        int startPlaceAsia = 0;
        assertTrue(player.getSpot().getContinent() == Continent.AFRICA);
        assertTrue(player.getSpot().getCategory()== Category.CULTURE);
        player.setSpot(gameBoard.getSpotsOuter().get(startPlaceAsia));
        assertFalse(player.getSpot().getContinent() == Continent.AFRICA);
        assertTrue(player.getSpot().getContinent() == Continent.ASIA);
        assertTrue(player.getSpot().getCategory() == Category.AIRPLANE);


    }

    @Test
    public void testIsInEurope() throws Exception {
        assertFalse(player.isInEurope());
        player.setInEurope(true);
        assertTrue(player.isInEurope());
        player.setInEurope(false);
        assertFalse(player.isInEurope());
    }

    @Test
    public void testIfCorrectName() throws Exception {
        assertEquals("Adam", player.getName());
        player.setName("William");
        assertEquals("William", player.getName());
    }
}
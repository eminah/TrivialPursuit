package edu.chl.trivialpursuit.model;

import junit.framework.TestCase;
import org.junit.Test;

import javax.inject.Inject;
import java.util.HashSet;

/**
 * Created by eminahromic on 2015-05-31.
 */
public class GameBoardTest extends TestCase {


    GameBoard gameBoard = new GameBoard();
    Card nortAmericaCard = new NorthAmericaCard();
    Spot spot = new Spot(Continent.AFRICA,Category.CULTURE,15,15,nortAmericaCard);
    HashSet<Continent> hashSet = new HashSet<>();
    Player playerAnna = new Player("Anna", spot, hashSet);


    @Test
    public void testAddSpotsToListOuter() throws Exception {

        gameBoard.addSpotsToListOuter();
        assertTrue(!gameBoard.getSpotsOuter().isEmpty());
    }

    @Test
    public void testAddSpotsToListInner() throws Exception {
        gameBoard.addSpotsToListInner();
        assertTrue(!gameBoard.getSpotsInner().isEmpty());

    }


    //@Test
    //public void testSetNextTurn() throws Exception {

    //}

    @Test
    public void testMovePlayerToEurope() throws Exception {

        assertTrue(playerAnna.getSpot().getContinent() == Continent.AFRICA);
        assertTrue(playerAnna.getSpot().getCategory() == Category.CULTURE);
        gameBoard.movePlayerToEurope(playerAnna);
        assertFalse(playerAnna.getSpot().getContinent() == Continent.AFRICA);
        assertTrue(playerAnna.getSpot().getContinent() == Continent.EUROPE);
        assertTrue(playerAnna.getSpot().getCategory() == Category.AIRPLANE);


    }
}
package edu.chl.trivialpursuit.model;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by eminahromic on 2015-05-31.
 */
public class SpotTest extends TestCase {

    GameBoard gameBoard = new GameBoard();

    @Test
    public void testIfSpotLeftIsCorrect(){
        int airPortSpotEurope = 0;
        int historySpotEurope = 3;
        int sportSpotEurope = 4;
        int mediaSpotEurope = 6;
        gameBoard.addSpotsToListInner();
        gameBoard.addSpotsToListOuter();
        assertTrue(gameBoard.getSpotsInner().get(airPortSpotEurope).getLeft() == gameBoard.getSpotsInner().get(mediaSpotEurope));
        assertTrue(gameBoard.getSpotsInner().get(sportSpotEurope).getLeft() == gameBoard.getSpotsInner().get(historySpotEurope));
    }

    @Test
    public void testIfSpotRigthIsCorrect(){
        int airPortSpotEurope = 0;
        int historySpotEurope = 3;
        int sportSpotEurope = 4;
        int mediaSpotEurope = 6;
        gameBoard.addSpotsToListInner();
        gameBoard.addSpotsToListOuter();
        assertTrue(gameBoard.getSpotsInner().get(mediaSpotEurope).getRight() == gameBoard.getSpotsInner().get(airPortSpotEurope));
        assertTrue(gameBoard.getSpotsInner().get(historySpotEurope).getRight()==gameBoard.getSpotsInner().get(sportSpotEurope));

    }

    @Test
    public void testIfCoordinatesIsCorrect(){
        int startSpotAsia = 0;
        int startSpotAfrica = 7;
        int startSpotSouthAmerica =14;
        int starSpotNorthAmerica = 21;
        int startSpotEurope = 0;
        gameBoard.addSpotsToListInner();
        gameBoard.addSpotsToListOuter();
        assertEquals(250, gameBoard.getSpotsOuter().get(startSpotAsia).getCooX());
        assertEquals(15, gameBoard.getSpotsOuter().get(startSpotAsia).getCooY());

        assertEquals(497, gameBoard.getSpotsOuter().get(startSpotAfrica).getCooX());
        assertEquals(230, gameBoard.getSpotsOuter().get(startSpotAfrica).getCooY());

        assertEquals(260, gameBoard.getSpotsOuter().get(startSpotSouthAmerica).getCooX());
        assertEquals(445, gameBoard.getSpotsOuter().get(startSpotSouthAmerica).getCooY());

        assertEquals(20, gameBoard.getSpotsOuter().get(starSpotNorthAmerica).getCooX());
        assertEquals(230,gameBoard.getSpotsOuter().get(starSpotNorthAmerica).getCooY());

        assertEquals(295, gameBoard.getSpotsInner().get(startSpotEurope).getCooX());
        assertEquals(120,gameBoard.getSpotsInner().get(startSpotEurope).getCooY());
    }
}
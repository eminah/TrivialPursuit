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
        Spot startAsia =  gameBoard.getSpotsOuter().get(startSpotAsia);
        Spot startSouthAmerica =  gameBoard.getSpotsOuter().get(startSpotSouthAmerica);
        Spot startNorthAmerica =  gameBoard.getSpotsOuter().get(starSpotNorthAmerica);
        Spot startAfrica =  gameBoard.getSpotsOuter().get(startSpotAfrica);
        Spot startEurope =  gameBoard.getSpotsInner().get(startSpotEurope);

        gameBoard.addSpotsToListInner();
        gameBoard.addSpotsToListOuter();
        assertEquals(250, startAsia.getCooX());
        assertEquals(15, startAsia.getCooY());

        assertEquals(497, startAfrica.getCooX());
        assertEquals(230, startAfrica.getCooY());

        assertEquals(260, startSouthAmerica.getCooX());
        assertEquals(445, startSouthAmerica.getCooY());

        assertEquals(20, startNorthAmerica.getCooX());
        assertEquals(230,startNorthAmerica.getCooY());

        assertEquals(295,startEurope.getCooX());
        assertEquals(120,startEurope.getCooY());
    }
}
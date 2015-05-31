package edu.chl.trivialpursuit.model;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

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
    public void testIfCoordinatesIsCorrect(Spot spot){
        int startSpotAsia = 0;

        gameBoard.addSpotsToListInner();
        gameBoard.addSpotsToListOuter();

        Spot startAsia =  gameBoard.getSpotsOuter().get(startSpotAsia);

        assertEquals(250, startAsia.getCooX());
        assertEquals(15, startAsia.getCooY());
    }

}
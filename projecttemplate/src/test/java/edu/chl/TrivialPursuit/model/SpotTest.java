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
       // int startSpotAfrica = 7;
        //int startSpotSouthAmerica =14;
        //int starSpotNorthAmerica = 21;
        //int startSpotEurope = 0;


        Spot startAsia =  gameBoard.getSpotsOuter().get(startSpotAsia);
       // Spot startSouthAmerica =  gameBoard.getSpotsOuter().get(startSpotSouthAmerica);
       // Spot startNorthAmerica =  gameBoard.getSpotsOuter().get(starSpotNorthAmerica);
        //Spot startAfrica =  gameBoard.getSpotsOuter().get(startSpotAfrica);
        //Spot startEurope =  gameBoard.getSpotsInner().get(startSpotEurope);

        //Spot[] spots = {startAsia,startAfrica,startSouthAmerica, startNorthAmerica,startEurope};
        //assertCoordinates(spots);

        gameBoard.addSpotsToListInner();
        gameBoard.addSpotsToListOuter();

        assertEquals(250,startAsia.getCooX());
        assertEquals(15,startAsia.getCooY());




    }
    /*@Test
    private void assertCoordinates (Spot[] spot){
        for(int i = 0; i < 5; i++){
            switch (i){
                case 0:

                    break;
                case 1:
                    assertEquals(497,spot[i].getCooX());
                    assertEquals(230,spot[i].getCooY());
                    break;
                case 2:
                    assertEquals(260,spot[i].getCooX());
                    assertEquals(445,spot[i].getCooY());
                    break;
                case 3:
                    assertEquals(20,spot[i].getCooX());
                    assertEquals(230,spot[i].getCooY());
                    break;
                default:
                    assertEquals(295,spot[i].getCooX());
                    assertEquals(120,spot[i].getCooY());
                    break;

            }

        }*/



}
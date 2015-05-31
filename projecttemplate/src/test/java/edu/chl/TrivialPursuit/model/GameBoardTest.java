package edu.chl.trivialpursuit.model;

import junit.framework.TestCase;
import org.junit.Test;

import javax.inject.Inject;
import java.util.ArrayList;
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
    Player playerOne = new Player("Emil", spot, hashSet);
    Player playerTwo = new Player("Emil", spot, hashSet);
    Player playerThree = new Player("Emil", spot, hashSet);


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

    @Test
    public void testSetNextTurn() throws Exception {

        ArrayList <Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        players.add(playerThree);
        gameBoard.setPlayers(players);
        System.out.println("Testing setNextTurn with three players");
        //Before you have set any turn at all:
        assertEquals(0, gameBoard.getTurn());
        //When you call setNextTurn the first time
        gameBoard.setNextTurn(3);
        assertEquals(1, gameBoard.getTurn());
        //When you call setNextTurn the second time
        gameBoard.setNextTurn(3);
        assertEquals(2 , gameBoard.getTurn());
        //When you call setNextTurn the third time
        gameBoard.setNextTurn(3);
        assertEquals(3, gameBoard.getTurn());
        //When you call setNextTurn the fourth time
        gameBoard.setNextTurn(3);
       assertTrue(gameBoard.getTurn() == 1);

    }

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
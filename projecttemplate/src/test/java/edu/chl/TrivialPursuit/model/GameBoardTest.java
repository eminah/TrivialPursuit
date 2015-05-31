package edu.chl.trivialpursuit.model;

import junit.framework.TestCase;

import java.util.HashSet;

/**
 * Created by eminahromic on 2015-05-31.
 */
public class GameBoardTest extends TestCase {

    Card nortAmericaCard = new NorthAmericaCard();
    Spot spot = new Spot(Continent.AFRICA,Category.CULTURE,15,15,nortAmericaCard);
    HashSet<Continent> hashSet = new HashSet<>();

    public void testAddSpotsToListOuter() throws Exception {

    }

    public void testAddSpotsToListInner() throws Exception {

    }

    public void testAddCardsAfrica() throws Exception {

    }

    public void testAddCardsNorthAmerica() throws Exception {

    }

    public void testAddCardsSouthAmerica() throws Exception {

    }

    public void testAddCardsAsia() throws Exception {

    }

    public void testSetNextTurn() throws Exception {

    }

    public void testMovePlayerToEurope() throws Exception {

        Player player = new Player("Anna", spot, hashSet);

    }
}
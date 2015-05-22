package edu.chl.trivialpursuit.model;

import org.apache.commons.lang3.tuple.ImmutablePair;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by inatran on 15-05-04.
 */
public class GameBoard {

    private ArrayList<Spot> spotsOuter;
    private ArrayList<Spot> spotsInner;
    private ArrayList<Player> players;
    @Inject
    private ChoosePlayer chooseP;
    @Inject
    private ChooseTravel chooseT;


    public GameBoard(){
        spotsOuter = new ArrayList<>();
        spotsInner = new ArrayList<>();
        players = new ArrayList<>();
        addSpotsToListOuter();
        setBoardingSpotsOuter();
        addSpotsToListInner();
        createPlayers();

    }

    private final ImmutablePair[] SPOT_DEFINITIONS_OUTER = {
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.AIRPLANE),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.GEOGRAPHY),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.CULTURE),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.HISTORY),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.SPORT),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.TECHNIC),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.MEDIA),
            new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.AIRPLANE),
            new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.GEOGRAPHY),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.CULTURE),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.HISTORY),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.SPORT),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.TECHNIC),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.MEDIA),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.AIRPLANE),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.CULTURE),
            new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.GEOGRAPHY),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.HISTORY),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.SPORT),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.TECHNIC),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.MEDIA),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.AIRPLANE),
            new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.GEOGRAPHY),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.CULTURE),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.HISTORY),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.SPORT),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.TECHNIC),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.MEDIA),



    };

    private final ImmutablePair[] SPOT_DEFINITIONS_INNER = {
            new ImmutablePair<Continent, Category>(Continent.EUROPE, Category.AIRPLANE),
            new ImmutablePair<Continent, Category>(Continent.EUROPE, Category.GEOGRAPHY),
            new ImmutablePair<Continent, Category>(Continent.EUROPE, Category.CULTURE),
            new ImmutablePair<Continent, Category>(Continent.EUROPE, Category.HISTORY),
            new ImmutablePair<Continent, Category>(Continent.EUROPE, Category.SPORT),
            new ImmutablePair<Continent, Category>(Continent.EUROPE, Category.TECHNIC),
            new ImmutablePair<Continent, Category>(Continent.EUROPE, Category.MEDIA),
    };

    private final ImmutablePair[] SPOT_DEFINITIONS_COORDINATES_OUTER = {

            //Coordinates for Asia
            new ImmutablePair<>(225,15),
            new ImmutablePair<>(280,26),
            new ImmutablePair<>(320,45),
            new ImmutablePair<>(355,60),
            new ImmutablePair<>(385,90),
            new ImmutablePair<>(415,130),
            new ImmutablePair<>(429, 183),

            //Coordinates for Africa
            new ImmutablePair<>(438,240),
            new ImmutablePair<>(432,290),
            new ImmutablePair<>(418,325),
            new ImmutablePair<>(397,360),
            new ImmutablePair<>(370,395),
            new ImmutablePair<>(330,425),
            new ImmutablePair<>(285,448),

            //Coordinates for South America
            new ImmutablePair<>(235,255),
            new ImmutablePair<>(170,448),
            new ImmutablePair<>(130,425),
            new ImmutablePair<>(90,395),
            new ImmutablePair<>(60,365),
            new ImmutablePair<>(35,330),
            new ImmutablePair<>(25,290),

            //Coordinates for North America
            new ImmutablePair<>(20,230),
            new ImmutablePair<>(25,175),
            new ImmutablePair<>(50,130),
            new ImmutablePair<>(70,95),
            new ImmutablePair<>(100,65),
            new ImmutablePair<>(135,45),
            new ImmutablePair<>(170,25),
    };

    private final ImmutablePair[] SPOT_DEFINITIONS_COORDINATES_INNER = {

            //Coordinates for EUROPE
            new ImmutablePair<>(260,125),
            new ImmutablePair<>(235,200),
            new ImmutablePair<>(320,310),
            new ImmutablePair<>(225,350),
            new ImmutablePair<>(135,305),
            new ImmutablePair<>(120,215),
            new ImmutablePair<>(170,140),
    };

    public ArrayList<Spot> getSpotsOuter() {
        return spotsOuter;
    }

    public ArrayList<Spot> getSpotsInner() {
        return spotsInner;
    }



    public void addSpotsToListOuter(){
        for(int i = 0; i < SPOT_DEFINITIONS_OUTER.length; i++){

            spotsOuter.add(new Spot((Continent) SPOT_DEFINITIONS_OUTER[i].getLeft(),
                    (Category) SPOT_DEFINITIONS_OUTER[i].getRight(),
                    (Integer) SPOT_DEFINITIONS_COORDINATES_OUTER[i].getLeft(),
                    (Integer)SPOT_DEFINITIONS_COORDINATES_OUTER[i].getRight()));
            System.out.println(SPOT_DEFINITIONS_COORDINATES_OUTER[i].getLeft());

        }
    }
    public void addSpotsToListInner(){
        for(int i = 0; i < SPOT_DEFINITIONS_INNER.length; i++){

            spotsInner.add(new Spot((Continent)SPOT_DEFINITIONS_INNER[i].getLeft(),
                    (Category) SPOT_DEFINITIONS_INNER[i].getRight(),
                    (Integer) SPOT_DEFINITIONS_COORDINATES_INNER[i].getLeft(),
                    (Integer) SPOT_DEFINITIONS_COORDINATES_INNER[i].getRight()));

        }
    }
    //Sets the left and right spot to every spot
    public void setBoardingSpotsOuter(){

       //Set the right spot to the current spot
        for(int i = 0; i <= spotsOuter.size()-1; i++){
            if(i != spotsOuter.size()-1) {
                spotsOuter.get(i).setRight(spotsOuter.get(i + 1));
            }else{
                spotsOuter.get(i).setRight(spotsOuter.get(0));
            }
        }

        //Set the left spot to the current spot

        for(int j = 0; j <= spotsOuter.size()-1; j++){
            if (j==0){
                spotsOuter.get(j).setLeft(spotsOuter.get(spotsOuter.size()-1));
            }else{
                spotsOuter.get(j).setLeft(spotsOuter.get(j-1));
            }
        }
    }

    public void setBoardingSpotsInner(){
        //Set the right spot to the current spot
        for(int i = 0; i <= spotsInner.size()-1; i++){
            if(i != spotsInner.size()-1) {
                spotsInner.get(i).setRight(spotsInner.get(i + 1));
            }else{
                spotsInner.get(i).setRight(spotsInner.get(0));
            }
        }

        //Set the left spot to the current spot

        for(int j = 0; j <= spotsInner.size()-1; j++){
            if (j==0){
                spotsInner.get(j).setLeft(spotsInner.get(spotsInner.size()-1));
            }else{
                spotsInner.get(j).setLeft(spotsInner.get(j-1));
            }
        }
    }

    /*
    Here I create players depending on their choices of Continent and
    number of players it is.
     */
    private void createPlayers() {
        for (int i = 0; i < 6; i++) {
            //String choosen = (String) theBox.get(i).getValue();

            String choosen = "Asia";

            switch (choosen) {
                case "Asia":
                   players.add(new Player("Rasti",getSpotsOuter().get(0)));
                    break;
                case "Africa":
                    players.add(new Player((String)chooseP.getPlayerNames().get(i),getSpotsOuter().get(7)));
                    break;
                case "South America":
                    players.add(new Player((String)chooseP.getPlayerNames().get(i),getSpotsOuter().get(14)));
                    break;
                case "North America":
                    players.add(new Player((String)chooseP.getPlayerNames().get(i),getSpotsOuter().get(21)));
                    break;

                default:
                    System.out.println("Something");
                    //TODO Popup där vi säger att den måste välja något.
            }
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }



}

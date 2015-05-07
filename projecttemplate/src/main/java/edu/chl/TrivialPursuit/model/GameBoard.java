package edu.chl.trivialpursuit.model;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;

/**
 * Created by inatran on 15-05-04.
 */
public class GameBoard {

    private ArrayList<Spot> spots = new ArrayList<>();

    private final ImmutablePair[] SPOT_DEFINITIONS = {
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.AIRPLANE),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.CULTURE),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.HISTORY),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.SPORT),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.TECHNIC),
           new ImmutablePair<Continent, Category>(Continent.ASIA, Category.ENTERTAINMENT),
           new ImmutablePair<Continent, Category>(Continent.OCEANIA, Category.AIRPLANE),
           new ImmutablePair<Continent, Category>(Continent.OCEANIA, Category.CULTURE),
           new ImmutablePair<Continent, Category>(Continent.OCEANIA, Category.HISTORY),
           new ImmutablePair<Continent, Category>(Continent.OCEANIA, Category.SPORT),
           new ImmutablePair<Continent, Category>(Continent.OCEANIA, Category.TECHNIC),
           new ImmutablePair<Continent, Category>(Continent.OCEANIA, Category.ENTERTAINMENT),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.AIRPLANE),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.CULTURE),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.HISTORY),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.SPORT),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.TECHNIC),
           new ImmutablePair<Continent, Category>(Continent.AFRICA, Category.ENTERTAINMENT),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.AIRPLANE),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.CULTURE),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.HISTORY),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.SPORT),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.TECHNIC),
           new ImmutablePair<Continent, Category>(Continent.SOUTH_AMERICA, Category.ENTERTAINMENT),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.AIRPLANE),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.CULTURE),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.HISTORY),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.SPORT),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.TECHNIC),
           new ImmutablePair<Continent, Category>(Continent.NORTH_AMERICA, Category.ENTERTAINMENT),



    };
    
    public GameBoard(){
        addSpotsToList();
        setBoardingSpots();
    }

    public void addSpotsToList(){
        for(int i = 0; i < SPOT_DEFINITIONS.length; i++){

            spots.add(new Spot((Continent)SPOT_DEFINITIONS[i].getLeft(),(Category)SPOT_DEFINITIONS[i].getRight()));

        }
    }
    //Sets the left and right spot to every spot
    public void setBoardingSpots(){

       //Set the right spot to the current spot
        for(int i = 0; i < spots.size(); i++){
            if(i != spots.size()) {
                spots.get(i).setRight(spots.get(i + 1));
            }else{
                spots.get(i).setRight(spots.get(0));
            }
        }

        //Set the left spot to the current spot

        for(int j = 0; j < spots.size(); j++){
            if (j==0){
                spots.get(j).setLeft(spots.get(spots.size()));
            }else{
                spots.get(j).setLeft(spots.get(j-1));
            }
        }
    }

}

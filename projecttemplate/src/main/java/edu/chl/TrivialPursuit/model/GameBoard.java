package edu.chl.trivialpursuit.model;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;

/**
 * Created by inatran on 15-05-04.
 */
public class GameBoard {

    private ArrayList<Spot> spotsOuter = new ArrayList<>();
    private ArrayList<Spot> spotsInner = new ArrayList<>();

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

    public ArrayList<Spot> getSpotsOuter() {
        return spotsOuter;
    }

    public ArrayList<Spot> getSpotsInner() {
        return spotsInner;
    }

    public GameBoard(){
        addSpotsToListOuter();
        setBoardingSpotsOuter();
        addSpotsToListInner();
    }

    public void addSpotsToListOuter(){
        for(int i = 0; i < SPOT_DEFINITIONS_OUTER.length; i++){

            spotsOuter.add(new Spot((Continent)SPOT_DEFINITIONS_OUTER[i].getLeft(),
                    (Category)SPOT_DEFINITIONS_OUTER[i].getRight()));

        }
    }
    public void addSpotsToListInner(){
        for(int i = 0; i < SPOT_DEFINITIONS_INNER.length; i++){

            spotsInner.add(new Spot((Continent)SPOT_DEFINITIONS_INNER[i].getLeft(),
                    (Category)SPOT_DEFINITIONS_INNER[i].getRight()));

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

}

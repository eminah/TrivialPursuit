package edu.chl.trivialpursuit.model;
import java.util.ArrayList;
/**
 * Created by Heléne Jarl on 2015-05-19.
 */
public class ChooseTravel {
    private String startPlaceOne,startPlaceTwo,startPlaceThree,startPlaceFour,startPlaceFive,startPlaceSix ;
    public ArrayList<String> contintentToStartArray = new ArrayList<>();
    public void setArray(String continent){
        contintentToStartArray.add(continent);
    }
    public void setStartPlace(String startPlace, int numberOfPlyer){
        switch(numberOfPlyer) {
            case 1:
                setStartPlaceOne(startPlace);
                break;
            case 2:
                setStartPlaceTwo(startPlace);
                break;
            case 3:
                setStartPlaceThree(startPlace);
                break;
            case 4:
                setStartPlaceFour(startPlace);
                break;
            case 5:
                setStartPlaceFive(startPlace);
                break;
            case 6:
                setStartPlaceSix(startPlace);
                break;
        }
    }
    public String getStartPlaceOne() {
        return startPlaceOne;
    }
    public void setStartPlaceOne(String startPlaceOne) {
        setArray(startPlaceOne);
        this.startPlaceOne = startPlaceOne;
    }
    public String getStartPlaceTwo() {
        return startPlaceTwo;
    }
    public void setStartPlaceTwo(String startPlaceTwo) {
        setArray(startPlaceTwo);
        this.startPlaceTwo = startPlaceTwo;
    }
    public String getStartPlaceThree() {
        return startPlaceThree;
    }
    public void setStartPlaceThree(String startPlaceThree) {
        setArray(startPlaceThree);
        this.startPlaceThree = startPlaceThree;
    }
    public String getStartPlaceFour() {
        return startPlaceFour;
    }
    public void setStartPlaceFour(String startPlaceFour) {
        setArray(startPlaceFour);
        this.startPlaceFour = startPlaceFour;
    }
    public String getStartPlaceFive() {
        return startPlaceFive;
    }
    public void setStartPlaceFive(String startPlaceFive) {
        setArray(startPlaceFive);
        this.startPlaceFive = startPlaceFive;
    }
    public String getStartPlaceSix() {
        return startPlaceSix;
    }
    public void setStartPlaceSix(String startPlaceSix) {
        setArray(startPlaceSix);
        this.startPlaceSix = startPlaceSix;
    }
}
package edu.chl.trivialpursuit.model;
import java.util.ArrayList;
/**
 * Created by Heléne Jarl on 2015-05-19.
 */
public class ChooseTravel {

    public ArrayList<String> continentToStartArray = new ArrayList<>();
    public void setArray(String continent){
        continentToStartArray.add(continent);
    }
    public void setStartPlace(String startPlace){
        setArray(startPlace);
    }
}
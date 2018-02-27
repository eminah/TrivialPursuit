package edu.chl.TrivialPursuit.model;
import java.util.ArrayList;

/**
 * Created by Rasti on 2015-05-05.
 */
public class ChoosePlayer {

    private int numberOfPlayers;
    private String nameOne, nameTwo, nameThree, nameFour,nameFive, nameSix;
    public ArrayList<String> playerNameArray = new ArrayList<>();

    public ChoosePlayer(){

        numberOfPlayers = 0;
    }

    private void setArray(String name){

        playerNameArray.add(name);
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getNameOne() {
        return nameOne;
    }

    public void setNameOne(String nameOne) {
        setArray(nameOne);
        this.nameOne = nameOne;
    }

    public String getNameTwo() {
        return nameTwo;
    }

    public void setNameTwo(String nameTwo) {
        setArray(nameTwo);
        this.nameTwo = nameTwo;
    }

    public String getNameThree() {
        return nameThree;
    }

    public void setNameThree(String nameThree) {
        setArray(nameThree);
        this.nameThree = nameThree;
    }

    public String getNameFour() {
        return nameFour;
    }

    public void setNameFour(String nameFour) {
        setArray(nameFour);
        this.nameFour = nameFour;
    }

    public String getNameFive() {
        return nameFive;
    }

    public void setNameFive(String nameFive) {
        setArray(nameFive);
        this.nameFive = nameFive;
    }

    public String getNameSix() {
        return nameSix;
    }

    public void setNameSix(String nameSix) {
        setArray(nameSix);
        this.nameSix = nameSix;
    }
}
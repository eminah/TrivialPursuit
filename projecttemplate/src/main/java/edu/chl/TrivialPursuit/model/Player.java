package edu.chl.trivialpursuit.model;

/**
 * Created by Rasti on 2015-04-23.
 */
public class Player {

    private int position;
    private String nam;

    public Player(String nam, int position){

        this.position = position;
        this.nam = nam;
    }

    public Player(String nam){
        this.nam = nam;
        this.position = 0;

    }

    public int getPlayerPosition(){
        return position;
    }
}

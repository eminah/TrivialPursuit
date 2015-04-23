package edu.chl.TrivialPursuit.model;

/**
 * Created by Rasti on 2015-04-23.
 */
/**
 * Created by Rasti on 2015-04-23.
 */
public class Player {

    private int position;
    private String name;

    public Player(String name, int position){

        this.position = position;
        this.name = name;
    }

    public Player(String name){
        this.name = name;
        this.position = 0;

    }

    public int getPlayerPosition(){
        return position;
    }
}

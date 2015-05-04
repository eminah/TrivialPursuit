package edu.chl.trivialpursuit.model;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by Rasti on 2015-04-23.
 */
<<<<<<< HEAD


import lombok.Data;

public @Data class Player {

    private int position;
    private String name;
=======
 public  class Player {

    @Getter @Setter private String name;
    @Getter @Setter private Spot spot;

    // Någon metod som håller koll på vilka världsdelar spelaren har

    // Någon metod som sätter vilka världsdelar spelaren har
>>>>>>> startGui


}



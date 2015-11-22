package TP_AOC.v1.Materiel.Materiels;


import TP_AOC.v1.Materiel.Interface.Molette;
import TP_AOC.v1.Materiel.Materiel;

/**
 * 
 */
public class Materiel_Molette implements Molette {


    Materiel materiel;
    /**
     * Default constructor
     */
    public Materiel_Molette(Materiel materiel) {
        this.materiel = materiel;
    }


    /**
     * 
     */
    public float position() {
        return 0;
    }

}
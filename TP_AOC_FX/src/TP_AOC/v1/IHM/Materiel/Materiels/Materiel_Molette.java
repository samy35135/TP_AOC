package TP_AOC.v1.IHM.Materiel.Materiels;


import TP_AOC.v1.IHM.Materiel.Interface.Molette;
import TP_AOC.v1.IHM.Materiel.Materiel;

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
    public int position() {
        return (int) materiel.getIhm().getSlider().getValue();
    }

}
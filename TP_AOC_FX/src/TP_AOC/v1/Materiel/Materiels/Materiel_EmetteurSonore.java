package TP_AOC.v1.Materiel.Materiels;


import TP_AOC.v1.Materiel.Interface.EmetteurSonore;
import TP_AOC.v1.Materiel.Materiel;

/**
 * 
 */
public class Materiel_EmetteurSonore implements EmetteurSonore {
    Materiel materiel;
    /**
     * Default constructor
     */
    public Materiel_EmetteurSonore(Materiel materiel) {
        this.materiel = materiel;
    }

    @Override
    public void emettreSonTempo() {

    }

    @Override
    public void emettreSonMesure() {

    }
}
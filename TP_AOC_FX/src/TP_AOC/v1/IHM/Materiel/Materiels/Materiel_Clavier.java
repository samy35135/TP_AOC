package TP_AOC.v1.IHM.Materiel.Materiels;


import TP_AOC.v1.IHM.Materiel.Interface.Clavier;
import TP_AOC.v1.IHM.Materiel.Materiel;

/**
 * 
 */
public class Materiel_Clavier implements Clavier {
    Materiel materiel;
    /**
     * Default constructor
     */
    public Materiel_Clavier(Materiel materiel) {
        this.materiel = materiel;
    }


    /**
     * Retourne true si le bouton i est enfoncé, false si il est relaché,
     * Le 1 est start, le 2 est stop, le  3 est Inc et le 4 est dec.
     * @param i
     */
    public boolean touchePressee(int i) {
        // TODO implement here
    	return false;
    }

}
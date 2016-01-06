package TP_AOC.v2.IHM.Materiel.Materiels;


import TP_AOC.v2.IHM.Materiel.Interface.Clavier;
import TP_AOC.v2.IHM.Materiel.Materiel;

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
        switch (i){
            case 1:
                return materiel.getIhm().getOnandoff().isPressed();
            case 2:
                return materiel.getIhm().getOnandoff().isPressed();
            case 3:
                return materiel.getIhm().getButtonplus().isPressed();
            case 4:
                return materiel.getIhm().getButtonmoins().isPressed();
            default:
                return false;
        }
    }

}
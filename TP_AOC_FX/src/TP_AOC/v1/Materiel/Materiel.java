package TP_AOC.v1.Materiel;


import TP_AOC.v1.IHM.java.IIHM;
import TP_AOC.v1.Materiel.Interface.Afficheur;
import TP_AOC.v1.Materiel.Interface.Clavier;
import TP_AOC.v1.Materiel.Interface.Molette;

/**
 * Permet d'accéder aux interfaces de contrôle du matériel
 */
public class Materiel {

    public IIHM ihm;

    public Afficheur afficheur;

    public Molette molette;

    public Materiel.EmetteurSonore emetteurSonore;

    public Materiel.Materiel_Clavier clavier;

    /**
     * Default constructor
     */
    public Materiel() {
        afficheur = new Materiel.Materiel_Afficheur();

        molette = new Materiel.Materiel_Molette();

    }


    /**
     * @return
     */
    public static Clavier getClavier() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public static Molette getMolette() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public static Materiel.EmetteurSonore getEmetteurSonore() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public static Afficheur getAfficheur() {
        // TODO implement here
        return null;
    }

}
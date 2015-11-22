package TP_AOC.v1.Materiel;


import TP_AOC.v1.Engine.Horloge.Horloge;
import TP_AOC.v1.IHM.java.IIHM;

/**
 * Permet d'accéder aux interfaces de contrôle du matériel
 */
public class Materiel {

    public IIHM ihm;

    public Afficheur afficheur;

    public Molette molette;

    public EmetteurSonore emetteurSonore;

    public Materiel_Clavier clavier;

    /**
     * Default constructor
     */
    public Materiel() {
        afficheur = new Materiel_Afficheur();

        molette = new Materiel_Molette();

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
    public static EmetteurSonore getEmetteurSonore() {
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
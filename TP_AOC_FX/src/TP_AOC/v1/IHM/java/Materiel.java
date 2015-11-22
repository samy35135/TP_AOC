package TP_AOC.v1.IHM.java;


import TP_AOC.v1.Engine.Horloge.Horloge;
import TP_AOC.v1.IHM.java.composantFonctionnel.Afficheur;

/**
 * Permet d'accéder aux interfaces de contrôle du matériel
 */
public class Materiel {

    /**
     * Default constructor
     */
    public Materiel() {
    }

    /**
     * 
     */
    public Afficheur afficheur;

    /**
     * 
     */
    public Materiel_Molette molette;

    /**
     * 
     */
    public EmetteurSonore emetteurSonore;



    /**
     * 
     */
    public Materiel_Clavier clavier;

    /**
     * @return
     */
    public static Horloge getHorloge() {
        // TODO implement here
        return null;
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
package TP_AOC.v1.Materiel;


import TP_AOC.v1.IHM.java.IIHM;
import TP_AOC.v1.Materiel.Interface.*;
import TP_AOC.v1.Materiel.Materiels.*;

/**
 * Permet d'accéder aux interfaces de contrôle du matériel
 */
public class Materiel {


    public IIHM ihm;

    public Afficheur afficheur;

    public Molette molette;

    public EmetteurSonore emetteurSonore;

    public Clavier clavier;

    /**
     * Default constructor
     */
    public Materiel() {
        afficheur = new Materiel_Afficheur(this);
        molette = new Materiel_Molette(this);
        emetteurSonore = new Materiel_EmetteurSonore(this);
        clavier = new Materiel_Clavier(this);
    }



    /**
     * @return
     */
    public Clavier getClavier() {
        return clavier;
    }

    /**
     * @return
     */
    public Molette getMolette() {
        return molette;
    }

    /**
     * @return
     */
    public  EmetteurSonore getEmetteurSonore() {
        return emetteurSonore;
    }

    /**
     * @return
     */
    public Afficheur getAfficheur() {
        return afficheur;
    }

    public IIHM getIhm() {
        return ihm;
    }

    public void setIhm(IIHM ihm) {
        this.ihm = ihm;
    }

}
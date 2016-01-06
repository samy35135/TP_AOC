package TP_AOC.v1.IHM.Materiel;


import TP_AOC.v1.IHM.Vue.IHM;
import TP_AOC.v1.IHM.Materiel.Interface.*;
import TP_AOC.v1.IHM.Materiel.Materiels.*;

/**
 * Permet d'accéder aux interfaces de contrôle du matériel
 */
public class Materiel {


    public IHM ihm;

    private Afficheur afficheur;

    private Molette molette;

    private EmetteurSonore emetteurSonore;

    private Clavier clavier;

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

    public IHM getIhm() {
        return ihm;
    }

    public void setIhm(IHM ihm) {
        this.ihm = ihm;
    }

}
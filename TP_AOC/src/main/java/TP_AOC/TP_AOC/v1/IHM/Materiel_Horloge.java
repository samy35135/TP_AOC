package TP_AOC.TP_AOC.v1.IHM;

import java.util.*;

/**
 * 
 */
public class Materiel_Horloge implements Horloge {

    /**
     * Default constructor
     */
    public Materiel_Horloge() {
    }


    /**
     * Appel périodique de l'opération execute() de cmd,
     * toutes les périodesEnSecondes secondes,
     * avec une précision d'une miliseconde
     * @param cmd 
     * @param periodeEnSecondes
     */
    public void activerPeriodiquement(Command cmd, float periodeEnSecondes) {
        // TODO implement here
    }

    /**
     * Appel de l'opération execute() de cmd, 
     * après un délai de délaiEnSecondes secondes,
     * avec une précision d'une millisecondes
     * @param cmd 
     * @param delaiEnSecondes
     */
    public void activerApresDelai(Command cmd, float delaiEnSecondes) {
        // TODO implement here
    }

    /**
     * @param cmd
     */
    public void desactiver(Command cmd) {
        // TODO implement here
    }

}
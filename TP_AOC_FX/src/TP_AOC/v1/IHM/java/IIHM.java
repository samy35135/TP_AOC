package TP_AOC.v1.IHM.java;

import TP_AOC.v1.IHM.java.CommandIHM.CommandIHM;

/**
 * Created by samyabh on 22/11/2015.
 */
public interface IIHM {
    /**
     * Permet de démarrer l'IHM, de lancer la fenêtre
     */
    public void demarrer();

    public void addCommandIHM(SignalIHM signalihm,CommandIHM cmd);
}

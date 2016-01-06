package TP_AOC.v2.IHM.Materiel.Interface;

/**
 * Created by samyabh on 22/11/2015.
 */
public interface EmetteurSonore {
    /**
     * Permet d'emettre le son pour le tempo
     * @throws Exception 
     */
    public void emettreSonTempo();
    /**
     * Permet d'emettre le son pour la mesure
     */
    public void emettreSonMesure();
}

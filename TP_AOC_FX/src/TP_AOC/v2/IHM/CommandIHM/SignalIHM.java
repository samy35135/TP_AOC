package TP_AOC.v2.IHM.CommandIHM;

/**
 * Created by samyabh on 05/01/2016.
 */
public enum SignalIHM {
    Demarrer, Arreter, UpdateMolette, AugmenterMesure, ReduireMesure;
    /**
     * @return
     */
    public String toString() {
        switch (this) {
            case Demarrer:
                return "Demarrer";
            case Arreter:
                return "Arreter";
            case UpdateMolette:
                return "UpdateMolette";
            case AugmenterMesure:
                return "AugmenterMesure";
            case ReduireMesure:
                return "ReduireMesure";
            default:
                return "Default";
        }
    }
}
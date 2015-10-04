package v1;

import java.util.*;

/**
 * 
 */
public interface Horloge {

    /**
     * Appel périodique de l'opération execute() de cmd,
     * toutes les périodesEnSecondes secondes,
     * avec une précision d'une miliseconde
     * @param cmd 
     * @param periodeEnSecondes
     */
    public void activerPeriodiquement(Command cmd, float periodeEnSecondes);

    /**
     * Appel de l'opération execute() de cmd, 
     * après un délai de délaiEnSecondes secondes,
     * avec une précision d'une millisecondes
     * @param cmd 
     * @param delaiEnSecondes
     */
    public void activerApresDelai(Command cmd, float delaiEnSecondes);

    /**
     * @param cmd
     */
    public void desactiver(Command cmd);

}
package TP_AOC.v1.Engine.Horloge;


/**
 * 
 */
public interface Horloge {

    /**
     * permet de changer la fréquence de répétition
     */
    public void changerFrequence(int frequence);
    /**
     * permet de démarrer à la fréquence donner préalablement
     */
    public void demarrer();

    /**
     * Permet d'arrêter l'appel à l'engine
     */
    public void stop();
}
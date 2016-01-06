package TP_AOC.v2.IHM.Materiel.Interface;

/**
 * 
 */
public interface Afficheur {


    /**
     * 1 : pour led tempo
     * 2 : pour led mesure
     * @param numLED
     */
    public void allumerLED(int numLED);
    public void eteindreLED(int numLED);

    /**
     * Affiche un entier sur l'afficheur externe du métronome
     * @param valeurTempo
     */
    public void afficherTempo(int valeurTempo);

}
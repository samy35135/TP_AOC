package TP_AOC.v1.Materiel;

import TP_AOC.v1.Materiel.Afficheur;

/**
 * 
 */
public class Materiel_Afficheur implements Afficheur {

    /**
     * Default constructor
     */
    public Materiel_Afficheur() {
    }
    /**
     * 1 : pour led tempo
     * 2 : pour led mesure
     * @param numLED
     */
    public void allumerLED(int numLED) {
        switch (numLED){
            case 1 :
                /**
                 * Allumer LED1
                 */
                break;
            case 2 :
                /**
                 * Allumer LED2
                 */
                break;
            default : break;
        }
    }

    /**
     * 1 : pour led tempo
     * 2 : pour led mesure
     * @param numLED
     */
    public void eteindreLED(int numLED) {
        switch (numLED){
            case 1 :
                /**
                 * Eteindre LED1
                 */
                break;
            case 2 :
                /**
                 * Eteindre LED2
                 */
                break;
            default : break;
        }
    }

    @Override
    public void afficherTempo(int valeurTempo) {
        /**
         * Afficher valeurTempo à l'écran
         */
    }


}
package TP_AOC.v1.Materiel.Materiels;

import TP_AOC.v1.Materiel.Interface.Afficheur;
import TP_AOC.v1.Materiel.Materiel;


public class Materiel_Afficheur implements Afficheur {

    Materiel materiel;
    /**
     * Default constructor
     */
    public Materiel_Afficheur(Materiel materiel) {
        this.materiel = materiel;
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
		materiel.getIhm().changerAffichageTempo("" + valeurTempo);
	}

}
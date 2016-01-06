package TP_AOC.v2.IHM.Materiel.Materiels;

import TP_AOC.v2.IHM.Materiel.Interface.Afficheur;
import javafx.scene.shape.Circle;
import TP_AOC.v2.IHM.Materiel.Materiel;


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
				allumerLEDTemps();
				break;
			case 2 :
				allumerLEDMesure();
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
				eteindreLEDTemps();
				break;
			case 2 :
				eteindreLEDMesure();
				break;
			default : break;
		}
	}
	@Override
	public void afficherTempo(int valeurTempo) {
		//System.out.println("Materiel_Afficheur...  afficherTempo - Début");
		materiel.getIhm().changerAffichageTempo("" + valeurTempo);
		//System.out.println("Materiel_Afficheur...  afficherTempo - Fin");
	}


	public void allumerLEDMesure() {
		Circle ledgaucheMesure=materiel.getIhm().getLedgaucheMesure();
		ledgaucheMesure.getStyleClass().remove(0);
		ledgaucheMesure.getStyleClass().add(0, "onmesure");
	}

	public void eteindreLEDMesure() {
		Circle ledgaucheMesure=materiel.getIhm().getLedgaucheMesure();
		ledgaucheMesure.getStyleClass().remove(0);
		ledgaucheMesure.getStyleClass().add(0, "off");
	}


	public void allumerLEDTemps() {
		Circle leddroiteTemps = materiel.getIhm().getLeddroiteTemps();
		leddroiteTemps.getStyleClass().remove(0);
		leddroiteTemps.getStyleClass().add(0, "ontemps");
	}

	public void eteindreLEDTemps() {
		Circle leddroiteTemps = materiel.getIhm().getLeddroiteTemps();
		leddroiteTemps.getStyleClass().remove(0);
		leddroiteTemps.getStyleClass().add(0, "off");
	}


}
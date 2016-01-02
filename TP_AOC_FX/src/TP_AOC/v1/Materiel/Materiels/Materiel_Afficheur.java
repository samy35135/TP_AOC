package TP_AOC.v1.Materiel.Materiels;

import TP_AOC.v1.Materiel.Interface.Afficheur;
import javafx.scene.shape.Circle;
import TP_AOC.v1.Materiel.Materiel;


public class Materiel_Afficheur implements Afficheur {

    Materiel materiel;
    /**
     * Default constructor
     */
    public Materiel_Afficheur(Materiel materiel) {
        this.materiel = materiel;
    }
    ///////////////////////////pas utilisé
	@Override
	public void allumerLED(int i) {
		// TODO Auto-generated method stub
		switch(i){
		case 1 : allumerLEDTemps();
		case 2 : allumerLEDMesure();
		}
	}
	@Override
	public void eteindreLED(int i) {
		// TODO Auto-generated method stub
		switch(i){
		case 1 : eteindreLEDTemps();
		case 2 : eteindreLEDMesure();
		}
	}
	//////////////////////////////////////
	@Override
	public void allumerLEDTemps() {
		// TODO Auto-generated method stub
		Circle leddroiteTemps=materiel.getIhm().getLeddroiteTemps();
		if(leddroiteTemps.getStyleClass().contains("off")){
			leddroiteTemps.getStyleClass().remove(0);
		}
		leddroiteTemps.getStyleClass().add(0, "ontemps");	
	}
	@Override
	public void eteindreLEDTemps() {
		// TODO Auto-generated method stub
		Circle leddroiteTemps=materiel.getIhm().getLeddroiteTemps();
		if(leddroiteTemps.getStyleClass().contains("ontemps")){
			leddroiteTemps.getStyleClass().remove(0);
		}
		leddroiteTemps.getStyleClass().add(0, "off");		
	}
	@Override
	public void allumerLEDMesure() {
		// TODO Auto-generated method stub
		Circle ledgaucheMesure=materiel.getIhm().getLedgaucheMesure();
		if(ledgaucheMesure.getStyleClass().contains("off")){
			ledgaucheMesure.getStyleClass().remove(0);
		}
		ledgaucheMesure.getStyleClass().add(0, "onmesure");
	}
	@Override
	public void eteindreLEDMesure() {
		// TODO Auto-generated method stub
		Circle ledgaucheMesure=materiel.getIhm().getLedgaucheMesure();
		if(ledgaucheMesure.getStyleClass().contains("onmesure")){
			ledgaucheMesure.getStyleClass().remove(0);
		}
		ledgaucheMesure.getStyleClass().add(0, "off");
	}
   
    @Override
    public void afficherTempo(int valeurTempo) {
        materiel.getIhm().changerAffichageTempo("" + valeurTempo);
    }


}
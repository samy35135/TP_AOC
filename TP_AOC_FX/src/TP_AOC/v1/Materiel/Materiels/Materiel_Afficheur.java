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
	@Override
	public void allumerLEDTemps() {
		// TODO Auto-generated method stub
		materiel.getIhm().allumerLeddroiteTemps();
		
	}
	@Override
	public void eteindreLEDTemps() {
		// TODO Auto-generated method stub
		materiel.getIhm().eteindreLeddroiteTemps();
		
	}
	@Override
	public void allumerLEDMesure() {
		// TODO Auto-generated method stub
		materiel.getIhm().allumerLedgaucheMesure();
	}
	@Override
	public void eteindreLEDMesure() {
		// TODO Auto-generated method stub
		materiel.getIhm().eteindreLedgaucheMesure();
		
	}
   
    @Override
    public void afficherTempo(int valeurTempo) {
        materiel.getIhm().changerAffichageTempo("" + valeurTempo);
    }

}
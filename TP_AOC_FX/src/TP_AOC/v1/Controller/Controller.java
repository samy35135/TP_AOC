package TP_AOC.v1.Controller;

import TP_AOC.v1.Engine.Command.Command;
import TP_AOC.v1.Engine.Engine;
import TP_AOC.v1.Engine.IEngine;
import TP_AOC.v1.Engine.Command.MarquerMesure;
import TP_AOC.v1.Engine.Command.MarquerTemps;
import TP_AOC.v1.Engine.SignalMoteur;
import TP_AOC.v1.Engine.Command.UpdateMarche;
import TP_AOC.v1.Engine.Command.UpdateMesure;
import TP_AOC.v1.Engine.Command.UpdateTemps;
import TP_AOC.v1.IHM.java.IIHM;
import TP_AOC.v1.Materiel.Materiel;


/**
 * 
 */
public class Controller implements IController {

	IEngine moteur;



	Materiel materiel;

	IIHM ihm;
	Command marquerTemps;
	Command marquerMesure;
	
    /**
     * Default constructor
     */
    public Controller() {
    	initialisation_moteur();
    }

	/**
	 * Permet d'initialiser le moteur avec les commandes associées :
	 * MarquerMesure
	 * MarquerTemps
	 * UpdateMarche
	 * UpdateTemps
	 * UpdateMesure
	 */
    private void initialisation_moteur(){
		System.out.println("Controller...  initialisation_moteur - Début");
    	moteur = new Engine();
    	moteur.addCommand(SignalMoteur.MarquerMesure, new MarquerMesure(this));
    	moteur.addCommand(SignalMoteur.MarquerTemps, new MarquerTemps(this));  	
    	moteur.addCommand(SignalMoteur.UpdateMarche, new UpdateMarche(this));  	
    	moteur.addCommand(SignalMoteur.UpdateTemps, new UpdateTemps(this));  	
    	moteur.addCommand(SignalMoteur.UpdateMesure, new UpdateMesure(this));
		System.out.println("Controller...  initialisation_moteur - Fin");
    }

	@Override
	public void demarrer() {
		System.out.println("Controller ... demarrer ");
		if(!moteur.getEtatMarche())
			moteur.setEtatMarche(true);
	}

	@Override
	public void arreter(){
		System.out.println("Controller ... arrêter ");
		if(moteur.getEtatMarche())
			moteur.setEtatMarche(false);
	}


	@Override
	public void marquerTemps() {
		System.out.println("Controller ... marquerTemps ");
	}


	@Override
	public void updateEnMarche(){
		if (moteur.getEtatMarche()){
			// faire action ici
		}
		// si pas en marche couper côté graphique ?
	}

	@Override
	public void updateMesure() {
		/**
		 * Si décalage entre les deux LEDS? allumer TEMPO, ALLUMER MESURE, ETEINDRE MESURE,ETEINDRE TEMPO
		 */
		materiel.afficheur.allumerLED(1);
		materiel.afficheur.eteindreLED(1);
	}

	@Override
	public void updateTemps() {
		materiel.getAfficheur().afficherTempo(moteur.getTempo());
	}



	@Override
	public void augmenterMesure() {
		moteur.setNbTempsMesures(moteur.getNbTempsMesures()+1);
	}

	@Override
	public void decrementerMesure() {
		moteur.setNbTempsMesures(moteur.getNbTempsMesures()-1);
	}


	public IIHM getIhm() {
		return ihm;
	}

	public void setIhm(IIHM ihm) {
		this.ihm = ihm;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
}
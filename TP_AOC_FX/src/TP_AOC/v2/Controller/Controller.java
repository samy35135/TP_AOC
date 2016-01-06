package TP_AOC.v2.Controller;

import TP_AOC.v2.Engine.Engine;
import TP_AOC.v2.Engine.IEngine;
import TP_AOC.v2.Engine.Command.MarquerMesure;
import TP_AOC.v2.Engine.Command.MarquerTemps;
import TP_AOC.v2.Engine.SignalMoteur;
import TP_AOC.v2.Engine.Command.UpdateMarche;
import TP_AOC.v2.Engine.Command.UpdateMesure;
import TP_AOC.v2.Engine.Command.UpdateTemps;
import TP_AOC.v2.IHM.CommandIHM.*;
import TP_AOC.v2.IHM.Materiel.Materiel;
import TP_AOC.v2.IHM.CommandIHM.SignalIHM;


/**
 * 
 */
public class Controller implements IController {

	IEngine moteur;
	Materiel materiel;

	IImplemCommand ihm;

	public static final int TEMP_AFFICHAGE_LED_MS = 20;
    /**
     * Default constructor
     */
    public Controller() {}

	public void initialiser(){
		initialisation_moteur();
		initialisation_ihm();
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


	private void initialisation_ihm(){
		System.out.println("Controller...  initialisation_ihm - Début");
		ihm.addCommandIHM(SignalIHM.Arreter, new Arreter(this));
		ihm.addCommandIHM(SignalIHM.AugmenterMesure, new AugmenterMesure(this));
		ihm.addCommandIHM(SignalIHM.Demarrer, new Demarrer(this));
		ihm.addCommandIHM(SignalIHM.ReduireMesure, new ReduireMesure(this));
		ihm.addCommandIHM(SignalIHM.UpdateMolette, new UpdateMolette(this));
		//ihm.demarrer();
		System.out.println("Controller...  initialisation_ihm - Fin");
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
		if(moteur.getEtatMarche()){
			moteur.setEtatMarche(false);
			materiel.getAfficheur().eteindreLED(2);
			materiel.getAfficheur().eteindreLED(1);
		}
	}	


	@Override
	public void setTempoDepuisIHM() {
		System.out.println("Controller ... setTempoDepuisIHM ");
		moteur.setTempo(materiel.getMolette().position());
	}


	@Override
	public void updateEnMarche(){
		if (moteur.getEtatMarche()){
			// faire action ici
		}
	}

	@Override
	public void updateMesure() {
		/**
		 * Si décalage entre les deux LEDS? allumer TEMPO, ALLUMER MESURE, ETEINDRE MESURE,ETEINDRE TEMPO
		 */
		materiel.getAfficheur().allumerLED(2);
		materiel.getAfficheur().allumerLED(1);
		materiel.getEmetteurSonore().emettreSonMesure();
		materiel.getEmetteurSonore().emettreSonTempo();
		try {
			Thread.sleep(TEMP_AFFICHAGE_LED_MS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		materiel.getAfficheur().eteindreLED(2);
		materiel.getAfficheur().eteindreLED(1);
	}

	/**
	 * Permet de marquer le temps à l'IHM
	 */
	@Override
	public void marquerTemps(){
		materiel.getAfficheur().allumerLED(1);
		materiel.getEmetteurSonore().emettreSonTempo();
		try {
			Thread.sleep(TEMP_AFFICHAGE_LED_MS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		materiel.getAfficheur().eteindreLED(1);
	}

	@Override
	public void updateTemps() {
		System.out.println("Controller...  updateTemps - Début");
		int tempo = moteur.getTempo();
		materiel.getAfficheur().afficherTempo(tempo);
	}

	@Override
	public void augmenterMesure() {
		moteur.setNbTempsMesures(moteur.getNbTempsMesures()+1);
	}

	@Override
	public void decrementerMesure() {
		moteur.setNbTempsMesures(moteur.getNbTempsMesures()-1);
	}


	public IImplemCommand getIhm() {
		return ihm;
	}

	public void setIhm(IImplemCommand ihm) {
		this.ihm = ihm;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
}
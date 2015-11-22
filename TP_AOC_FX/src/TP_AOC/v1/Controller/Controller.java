package TP_AOC.v1.Controller;

import TP_AOC.v1.Engine.Commande.Command;
import TP_AOC.v1.Engine.Engine;
import TP_AOC.v1.Engine.IEngine;
import TP_AOC.v1.Engine.Commande.MarquerMesure;
import TP_AOC.v1.Engine.Commande.MarquerTemps;
import TP_AOC.v1.Engine.SignalMoteur;
import TP_AOC.v1.Engine.Commande.UpdateMarche;
import TP_AOC.v1.Engine.Commande.UpdateMesure;
import TP_AOC.v1.Engine.Commande.UpdateTemps;
import TP_AOC.v1.IHM.java.IHM;
import TP_AOC.v1.IHM.java.IIHM;


/**
 * 
 */
public class Controller implements IController {

	IEngine moteur;



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
		if(!moteur.getEtatMarche())
			moteur.setEtatMarche(true);
	}
	
	@Override
	public void marquerMesure() {
		System.out.println("Controller ... marquerMesure ");
		
	}

	@Override
	public void marquerTemps() {
		System.out.println("Controller ... marquerTemps ");
	}
	

	@Override
	public void updateEnMarche(IEngine engine){
		if (engine.getEtatMarche()){
			// faire action ici
		}
		// si pas en marche couper côté graphique ?
	}

	@Override
	public void updateMesure(IEngine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTemps(IEngine engine) {
		// TODO Auto-generated method stub
		
	}

	public IIHM getIhm() {
		return ihm;
	}

	public void setIhm(IIHM ihm) {
		this.ihm = ihm;
	}

}
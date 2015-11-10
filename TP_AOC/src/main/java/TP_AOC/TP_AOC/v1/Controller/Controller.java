package TP_AOC.TP_AOC.v1.Controller;

import TP_AOC.TP_AOC.v1.Engine.Command;
import TP_AOC.TP_AOC.v1.Engine.Engine;
import TP_AOC.TP_AOC.v1.Engine.IEngine;
import TP_AOC.TP_AOC.v1.Engine.MarquerMesure;
import TP_AOC.TP_AOC.v1.Engine.MarquerTemps;
import TP_AOC.TP_AOC.v1.Engine.SignalMoteur;
import TP_AOC.TP_AOC.v1.Engine.UpdateMarche;
import TP_AOC.TP_AOC.v1.Engine.UpdateMesure;
import TP_AOC.TP_AOC.v1.Engine.UpdateTemps;


/**
 * 
 */
public class Controller implements IController {

	IEngine moteur;
	Command marquerTemps;
	Command marquerMesure;
	
    /**
     * Default constructor
     */
    public Controller() {
    	initialisation_moteur();
    }
  
    private void initialisation_moteur(){
    	moteur = new Engine();
    	moteur.addCommand(SignalMoteur.MarquerMesure, new MarquerMesure(this));
    	moteur.addCommand(SignalMoteur.MarquerTemps, new MarquerTemps(this));  	
    	moteur.addCommand(SignalMoteur.UpdateMarche, new UpdateMarche(this));  	
    	moteur.addCommand(SignalMoteur.UpdateTemps, new UpdateTemps(this));  	
    	moteur.addCommand(SignalMoteur.UpdateMesure, new UpdateMesure(this));  	
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
	
	/**
	 * MAIN 
	 */
	public static void main(String[] args) {
		Controller c =new Controller();
		c.demarrer();
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



}
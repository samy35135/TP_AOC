package TP_AOC.TP_AOC.v1.Controller;

import TP_AOC.TP_AOC.v1.Engine.Command;
import TP_AOC.TP_AOC.v1.Engine.Engine;
import TP_AOC.TP_AOC.v1.Engine.IEngine;
import TP_AOC.TP_AOC.v1.Engine.MarquerMesure;
import TP_AOC.TP_AOC.v1.Engine.MarquerTemps;
import TP_AOC.TP_AOC.v1.Engine.SignalMoteur;


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
  
    public void initialisation_moteur(){
    	moteur = new Engine();
    	moteur.addCommand(SignalMoteur.MarquerMesure, new MarquerMesure(this));
    	moteur.addCommand(SignalMoteur.MarquerTemps, new MarquerTemps(this));  	
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
		new Controller();
	}

	@Override
	public void updateEnMarche(IEngine engine){
		if (engine.getEtatMarche()){
			// faire action ici
		}
	}



}
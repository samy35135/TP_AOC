package TP_AOC.TP_AOC.v1.Controller;

import TP_AOC.TP_AOC.v1.Engine.Command;
import TP_AOC.TP_AOC.v1.Engine.Engine;
import TP_AOC.TP_AOC.v1.Engine.IEngine;

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
    	moteur = new Engine();
    }

    
    public void initialisation_moteur(){
    	
    }
}
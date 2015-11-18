package TP_AOC.v1.Engine.Commande;

import TP_AOC.v1.Controller.IController;
import TP_AOC.v1.Engine.IEngine;

public class UpdateTemps implements Command {

	private IEngine moteur;
    /**
     * 
     */
	private IController controller;
    
    /**
     * Default constructor
     */
    public UpdateTemps(IController controller) {
    	System.out.println("UpdateTemps ...  Constructeur");
    	this.controller = controller;
    }

	@Override
	public void execute() {
		System.out.println("UpdateTemps ...  execute");
		controller.updateEnMarche(moteur);
	}
	
	public IEngine getMoteur() {
		return moteur;
	}
	public void setMoteur(IEngine moteur) {
		this.moteur = moteur;
	}
	
	
}
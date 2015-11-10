package TP_AOC.TP_AOC.v1.Engine;

import TP_AOC.TP_AOC.v1.Controller.IController;

public class UpdateMesure implements Command{

	private IEngine moteur;
    /**
     * 
     */
	private IController controller;
    
    /**
     * Default constructor
     */
    public UpdateMesure(IController controller) {
    	System.out.println("UpdateMesure ...  Constructeur");
    	this.controller = controller;
    }

	@Override
	public void execute() {
		System.out.println("UpdateMesure ...  execute");
		controller.updateEnMarche(moteur);
	}
	
	public IEngine getMoteur() {
		return moteur;
	}
	public void setMoteur(IEngine moteur) {
		this.moteur = moteur;
	}
	
	
}

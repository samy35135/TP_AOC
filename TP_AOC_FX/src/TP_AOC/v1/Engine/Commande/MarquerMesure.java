package TP_AOC.v1.Engine.Commande;

import TP_AOC.v1.Controller.IController;

/**
 * 
 */
public class MarquerMesure implements Command {
    /**
     * 
     */
	private IController controller;

    /**
     * Default constructor
     */
    public MarquerMesure(IController controller) {
    	System.out.println("MarquerMesure ...  Constructeur");
    	this.controller = controller;
    }

	@Override
	public void execute() {
		controller.marquerMesure();
	}
}
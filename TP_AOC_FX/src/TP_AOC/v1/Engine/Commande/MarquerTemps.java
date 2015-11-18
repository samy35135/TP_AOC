package TP_AOC.v1.Engine.Commande;

import TP_AOC.v1.Controller.IController;

/**
 * 
 */
public class MarquerTemps implements Command {
    /**
     * 
     */
    private IController controller;

    /**
     * Default constructor
     */
    public MarquerTemps(IController controller) {
    	System.out.println("MarquerTemps ...  Constructeur");
    	this.controller = controller;
    }

    /**
     * 
     */
    public void execute() {
    	controller.marquerTemps();
    }

}
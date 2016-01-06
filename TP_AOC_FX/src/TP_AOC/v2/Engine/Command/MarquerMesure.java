package TP_AOC.v2.Engine.Command;

import TP_AOC.v2.Controller.IController;

/**
 * 
 */
public class MarquerMesure implements Command {
    /**
     *
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
		controller.updateMesure();
	}
}
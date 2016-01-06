package TP_AOC.v2.Engine.Command;

import TP_AOC.v2.Controller.IController;

public class UpdateTemps implements Command {

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
		controller.updateTemps();
	}
	

}
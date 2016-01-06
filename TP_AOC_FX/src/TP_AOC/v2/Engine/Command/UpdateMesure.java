package TP_AOC.v2.Engine.Command;

import TP_AOC.v2.Controller.IController;

public class UpdateMesure implements Command {


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
		controller.updateMesure();
	}

	
}

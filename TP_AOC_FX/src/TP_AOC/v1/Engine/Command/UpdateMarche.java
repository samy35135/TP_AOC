package TP_AOC.v1.Engine.Command;

import TP_AOC.v1.Controller.IController;
import TP_AOC.v1.Engine.IEngine;

public class UpdateMarche implements Command {


    /**
     * 
     */
	private IController controller;
    
    /**
     * Default constructor
     */
    public UpdateMarche(IController controller) {
    	System.out.println("UpdateMarche ...  Constructeur");
    	this.controller = controller;
    }

	@Override
	public void execute() {
		System.out.println("UpdateMarche ...  execute");
		controller.updateEnMarche();
	}
	

	
}

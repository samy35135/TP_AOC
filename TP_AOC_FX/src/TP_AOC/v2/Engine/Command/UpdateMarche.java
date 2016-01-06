package TP_AOC.v2.Engine.Command;

import TP_AOC.v2.Controller.IController;

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

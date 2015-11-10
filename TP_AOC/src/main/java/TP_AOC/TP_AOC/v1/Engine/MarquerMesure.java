package TP_AOC.TP_AOC.v1.Engine;

import java.util.*;

import TP_AOC.TP_AOC.v1.Controller.IController;

/**
 * 
 */
public class MarquerMesure implements Command{
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
		
	}
}
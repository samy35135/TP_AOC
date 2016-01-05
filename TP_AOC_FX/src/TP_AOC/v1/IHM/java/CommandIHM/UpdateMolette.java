package TP_AOC.v1.IHM.java.CommandIHM;

import TP_AOC.v1.Controller.IController;

/**
 * Created by samyabh on 05/01/2016.
 */
public class UpdateMolette implements CommandIHM {
    /**
     *
     */
    private IController controller;

    /**
     * Default constructor
     */
    public UpdateMolette(IController controller) {
        System.out.println("UpdateMolette ...  Constructeur");
        this.controller = controller;
    }

    @Override
    public void execute() {
        //gérer côte controller
        controller.setTempoDepuisIHM();
    }
}

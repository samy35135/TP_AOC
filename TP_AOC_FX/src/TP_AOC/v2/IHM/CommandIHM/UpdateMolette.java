package TP_AOC.v2.IHM.CommandIHM;

import TP_AOC.v2.Controller.IController;

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

package TP_AOC.v2.IHM.CommandIHM;

import TP_AOC.v2.Controller.IController;

/**
 * Created by samyabh on 05/01/2016.
 */
public class ReduireMesure implements CommandIHM {
    /**
     *
     */
    private IController controller;

    /**
     * Default constructor
     */
    public ReduireMesure(IController controller) {
        System.out.println("ReduireMesure ...  Constructeur");
        this.controller = controller;
    }

    @Override
    public void execute() {
        //gérer côte controller
        controller.decrementerMesure();
    }
}

package TP_AOC.v1.IHM.java.CommandIHM;

import TP_AOC.v1.Controller.IController;

/**
 * Created by samyabh on 05/01/2016.
 */
public class Arreter implements CommandIHM {
    /**
     *
     */
    private IController controller;

    /**
     * Default constructor
     */
    public Arreter(IController controller) {
        System.out.println("Arreter ...  Constructeur");
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.arreter();
    }
}

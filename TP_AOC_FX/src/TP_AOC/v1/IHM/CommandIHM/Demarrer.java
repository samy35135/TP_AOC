package TP_AOC.v1.IHM.CommandIHM;

import TP_AOC.v1.Controller.IController;

/**
 * Created by samyabh on 05/01/2016.
 */
public class Demarrer implements CommandIHM {

    /**
     *
     */
    private IController controller;

    /**
     * Default constructor
     */
    public Demarrer(IController controller) {
        System.out.println("Demarrer ...  Constructeur");
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.demarrer();
    }
}

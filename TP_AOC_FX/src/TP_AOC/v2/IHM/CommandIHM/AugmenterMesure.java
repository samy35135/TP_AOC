package TP_AOC.v2.IHM.CommandIHM;

import TP_AOC.v2.Controller.IController;

/**
 * Created by samyabh on 05/01/2016.
 */
public class AugmenterMesure implements CommandIHM {

    /**
     *
     */
    private IController controller;

    /**
     * Default constructor
     */
    public AugmenterMesure(IController controller) {
        System.out.println("AugmenterMesure ...  Constructeur");
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.augmenterMesure();
    }
}

package TP_AOC.v1;


import TP_AOC.v1.Controller.Controller;
import TP_AOC.v1.IHM.Vue.IHM;
import TP_AOC.v1.IHM.Materiel.Materiel;

public class Client {


    public static void main(String[] args) {
        Controller controller = new Controller();
        IHM ihm = new IHM();
        Materiel materiel = new Materiel();

        controller.setMateriel(materiel);
        materiel.setIhm(ihm);
        controller.setIhm(ihm);
        controller.initialiser();


        ihm.demarrer();

    }
}

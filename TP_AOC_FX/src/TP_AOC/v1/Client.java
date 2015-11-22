package TP_AOC.v1;


import TP_AOC.v1.Controller.Controller;
import TP_AOC.v1.IHM.java.IHM;
import TP_AOC.v1.Materiel.Materiel;

public class Client {


    public static void main(String[] args) {
        Controller controller;
        controller = new Controller();

        IHM ihm;
        ihm = new IHM();

        Materiel materiel;
        materiel = new Materiel();



        // Le controller connait Materiel mais pas l'ihm
        // Materiel connait l'ihm mais pas le controller
        // l'ihm connait le controller

        controller.setIhm(ihm);


        controller.setMateriel(materiel);
        materiel.setIhm(ihm);
        // amélioration des getters et setter comme le projet editeur de l'année dernière ?
        ihm.setController(controller);



        // démarrage de l'application
        ihm.demarrer();



    }
}

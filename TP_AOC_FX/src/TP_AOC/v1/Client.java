package TP_AOC.v1;


import TP_AOC.v1.Controller.Controller;
import TP_AOC.v1.IHM.java.IHM;

public class Client {


    public static void main(String[] args) {
        Controller controller;
        controller = new Controller();
        IHM ihm;
        ihm = new IHM();

        controller.setIhm(ihm);
        // amélioration des getters et setter comme le projet editeur de l'année dernière ?
        ihm.setController(controller);
        ihm.demarrer();



    }
}

package TP_AOC.v2;


import TP_AOC.v2.Controller.Controller;
import TP_AOC.v2.IHM.Adapter.Adapter;
import TP_AOC.v2.IHM.CommandIHM.IImplemCommand;
import TP_AOC.v2.IHM.Vue.IHM;
import TP_AOC.v2.IHM.Materiel.Materiel;
import javafx.application.Platform;

public class Client {


    public static void main(String[] args) {
        Controller controller = new Controller();
        IHM ihm = new IHM();
        Materiel materiel = new Materiel();
        IImplemCommand adapter = new Adapter();


        ((Adapter) adapter).setMateriel(materiel);
        controller.setMateriel(materiel);

        materiel.setIhm(ihm);
        controller.setIhm(adapter);
        controller.initialiser();

        ((Adapter) adapter).demarrer();

        // mise en place d'un petit tempo pour l'horloge adapter afin que l'utilisateur ne clique pas trop vite.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ihm.demarrer();
    }
}

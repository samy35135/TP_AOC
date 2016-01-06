package TP_AOC.v2.IHM.Adapter;

import TP_AOC.v2.IHM.Adapter.Adapters.AdapterBoutonMesure;
import TP_AOC.v2.IHM.Adapter.Adapters.AdapterBoutonStartAndStop;
import TP_AOC.v2.IHM.Adapter.Adapters.AdapterMolette;
import TP_AOC.v2.IHM.CommandIHM.CommandIHM;
import TP_AOC.v2.IHM.CommandIHM.IImplemCommand;
import TP_AOC.v2.IHM.Materiel.Materiel;
import TP_AOC.v2.IHM.CommandIHM.SignalIHM;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by samyabh on 06/01/2016.
 */
public class Adapter implements IImplemCommand {
    private final int FREQ_ACTUALISATION_MS = 80;
    private HorlogeAdapter horlogeAdapter;
    private Materiel materiel;
    private Map<SignalIHM,CommandIHM> map_commandes;
    private InterfaceAdapters adapterBoutonMesure;
    private InterfaceAdapters adapterBoutonStartAndStop;
    private InterfaceAdapters adapterMolette;

    public Adapter(){
        map_commandes = new HashMap<>();
        adapterBoutonMesure = new AdapterBoutonMesure(this);
        adapterBoutonStartAndStop = new AdapterBoutonStartAndStop(this);
        adapterMolette = new AdapterMolette(this);
        horlogeAdapter = new HorlogeAdapter(this, FREQ_ACTUALISATION_MS);
    }

    public void demarrer(){
        horlogeAdapter.demarrer();
    }
    public void appelerAdapters(){
        adapterBoutonMesure.verification();
        adapterBoutonStartAndStop.verification();
        adapterMolette.verification();
    }
    /****** Commandes IHM ******/
    @Override
    public void addCommandIHM(SignalIHM signalihm, CommandIHM cmd) {
        if(!map_commandes.containsKey(signalihm)){
            map_commandes.put(signalihm, cmd);
            System.out.println("Adapter ... ajout " + signalihm.toString());
        }else{
            System.out.println("Adapter ... refus ajout " + signalihm.toString());
        }
    }

    public Map<SignalIHM, CommandIHM> getMap_commandes() {
        return map_commandes;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

}

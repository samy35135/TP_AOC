package TP_AOC.v2.IHM.Adapter.Adapters;

import TP_AOC.v2.IHM.Adapter.Adapter;
import TP_AOC.v2.IHM.Adapter.Interface.BoutonStartAndStop;
import TP_AOC.v2.IHM.Adapter.InterfaceAdapters;
import TP_AOC.v2.IHM.CommandIHM.SignalIHM;

/**
 * Created by samyabh on 06/01/2016.
 */
public class AdapterBoutonStartAndStop implements BoutonStartAndStop, InterfaceAdapters{

    private Adapter adapter;

    private boolean enroute = false;

    public AdapterBoutonStartAndStop(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void demarrer() {
        adapter.getMap_commandes().get(SignalIHM.Demarrer).execute();
    }

    @Override
    public void arreter() {
        adapter.getMap_commandes().get(SignalIHM.Arreter).execute();
    }

    @Override
    public void verification() {
        if (adapter.getMateriel().getClavier().touchePressee(1)){
            if (enroute){
                enroute = false;
                arreter();
            } else{
                demarrer();
                enroute = true;
            }
        }
    }
}
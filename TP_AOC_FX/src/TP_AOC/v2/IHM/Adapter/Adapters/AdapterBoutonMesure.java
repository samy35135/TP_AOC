package TP_AOC.v2.IHM.Adapter.Adapters;

import TP_AOC.v2.IHM.Adapter.Adapter;
import TP_AOC.v2.IHM.Adapter.Interface.BoutonsMesureAdapter;
import TP_AOC.v2.IHM.Adapter.InterfaceAdapters;
import TP_AOC.v2.IHM.CommandIHM.SignalIHM;

/**
 * Created by samyabh on 06/01/2016.
 */
public class AdapterBoutonMesure implements BoutonsMesureAdapter, InterfaceAdapters {
    private Adapter adapter;

    public AdapterBoutonMesure(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void augmenterMesure() {
        adapter.getMap_commandes().get(SignalIHM.AugmenterMesure).execute();
    }

    @Override
    public void reduireMesure() {
        adapter.getMap_commandes().get(SignalIHM.ReduireMesure).execute();
    }

    @Override
    public void verification() {
        if (adapter.getMateriel().getClavier().touchePressee(3))
            augmenterMesure();
        if (adapter.getMateriel().getClavier().touchePressee(4))
            reduireMesure();
    }
}

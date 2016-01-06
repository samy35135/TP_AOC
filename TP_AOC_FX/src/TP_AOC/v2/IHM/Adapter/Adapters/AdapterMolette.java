package TP_AOC.v2.IHM.Adapter.Adapters;

import TP_AOC.v2.IHM.Adapter.Adapter;
import TP_AOC.v2.IHM.Adapter.Interface.Molette;
import TP_AOC.v2.IHM.Adapter.InterfaceAdapters;
import TP_AOC.v2.IHM.CommandIHM.SignalIHM;

/**
 * Created by samyabh on 06/01/2016.
 */
public class AdapterMolette implements Molette,InterfaceAdapters {
    private Adapter adapter;
    private int dernierePos = 0;
    private boolean envoie = false;
    public AdapterMolette(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void updateMolette() {
        adapter.getMap_commandes().get(SignalIHM.UpdateMolette).execute();
    }

    @Override
    public void verification() {
        int pos = adapter.getMateriel().getMolette().position();
        if(pos == dernierePos && envoie){
            envoie = false;
            updateMolette();
        }else if(pos != dernierePos){
            dernierePos = pos;
            envoie = true;
        }
    }
}

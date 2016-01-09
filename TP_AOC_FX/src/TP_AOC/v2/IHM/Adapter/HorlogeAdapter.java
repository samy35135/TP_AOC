package TP_AOC.v2.IHM.Adapter;


import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by samyabh on 06/01/2016.
 */
public class HorlogeAdapter {

    private Timer t;
    Adapter adapter;
    private int frequence;

    public HorlogeAdapter(Adapter adapter, int frequence) {
        t = new Timer();
        this.adapter = adapter;
        this.frequence = frequence;

    }

    public void demarrer() {
        t = new Timer();
        t.schedule(new Repeter(), 2000, frequence);
    }

    public void stop(){
        t.cancel();
    }

    class Repeter extends TimerTask {
        public void run() {
            adapter.appelerAdapters();
        }
    }
}

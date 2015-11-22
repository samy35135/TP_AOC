package TP_AOC.v1.Engine.Horloge;

import TP_AOC.v1.Engine.Engine;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Appel à marquerTempo de l'Engine quand suivant la fréquence
 * @author samyabh
 */
public class Horloge_Tempo implements Horloge{
	private Timer t;
	private Engine engine;
	private int frequence;
	
	public Horloge_Tempo( Engine engine,int frequence) {
		t = new Timer();
		this.engine = engine;
		this.frequence = frequence;
	}
	@Override
	public void changerFrequence(int frequence){
		stop();
		this.frequence = frequence;
		demarrer();
	}
	@Override
	public void demarrer(){
		t.schedule(new Repeter(), 0, frequence*1000);
	}
	@Override
	public void stop(){
		t.cancel();
	}
	
	class Repeter extends TimerTask {
		public void run() {
			engine.marquerTempo();
		}
	}
}
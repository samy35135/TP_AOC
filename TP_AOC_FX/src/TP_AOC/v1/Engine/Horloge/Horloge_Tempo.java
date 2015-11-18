package TP_AOC.v1.Engine.Horloge;

import TP_AOC.v1.Engine.Engine;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Toute les fréquences la classe fait cmd.executer();
 * @author samyabh
 */
public class Horloge_Tempo {
	private Timer t;
	private Engine engine;
	private int frequence;
	
	public Horloge_Tempo( Engine engine,int frequence) {
		t = new Timer();
		this.engine = engine;
		this.frequence = frequence;
	}
	
	public void changerFrequence(int frequence){
		stop();
		this.frequence = frequence;
		demarrer();
	}
	
	public void demarrer(){
		t.schedule(new Repeter(), 0, frequence*1000);
	}
	public void stop(){
		t.cancel();
	}
	
	class Repeter extends TimerTask {
		public void run() {
			engine.marquerTempo();
		}
	}
}
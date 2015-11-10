package TP_AOC.TP_AOC.v1.Engine;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Toute les fréquences la classe fait cmd.executer();
 * @author samyabh
 *
 */
public class Horloge_Tempo {
	private Timer t;
	private Command cmd;
	private int frequence;
	
	public Horloge_Tempo( Command cmd,int frequence) {
		t = new Timer();
		this.cmd = cmd;
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
			cmd.execute();
		}
	}
}
package TP_AOC.TP_AOC.v1.Engine;

import java.util.Hashtable;
import java.util.Map;

import javax.swing.Timer;

public class Engine implements IEngine{

	private int tempo = 1;
	private int mesure = 5;
	Map<SignalMoteur, Command> map_commandes;

	/**
	 * permet de determiner si le moteur est en marche ou non
	 */
	private boolean etatMarche;

	public Engine(){
		System.out.println("Engine ...  Constructeur");
		etatMarche = false;
		map_commandes = new Hashtable();
	}

	@Override
	public int getTempo() {
		return tempo;
	}

	@Override
	public void setTempo(int t) {
		this.tempo = t;
	}

	@Override
	public int getNbTempsMesures() {
		return mesure;
	}

	@Override
	public void setNbTempsMesures(int t) {
		this.mesure = t;

	}

	@Override
	public void addCommand(SignalMoteur signalMoteur, Command cmd) {
		if(!map_commandes.containsKey(signalMoteur)){
			map_commandes.put(signalMoteur, cmd);
			System.out.println("Engine ... ajout " + signalMoteur.toString());
		}else{
			System.out.println("Engine ... refus ajout " + signalMoteur.toString());
		}
	}


	@Override
	/**
	 * affecte la variable etatMarche si mode est différent
	 */
	public void setEtatMarche(boolean mode) {
		/*if (etatMarche != mode)
			etatMarche = mode;*/
		if(etatMarche != mode) return;
		if(mode){
			
		}else{
			
		}
	}

	/**
	 * Retourne etatMarche
	 */
	public boolean getEtatMarche() {
		return etatMarche;
	}
}
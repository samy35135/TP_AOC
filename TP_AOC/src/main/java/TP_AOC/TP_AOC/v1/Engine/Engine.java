package TP_AOC.TP_AOC.v1.Engine;

import java.util.Hashtable;
import java.util.Map;


public class Engine implements IEngine{

	private int tempo = 60;
	private int mesure = 1;
	
	private Horloge_Tempo horloge_marquer_tempo;
	
	public static final int TEMPO_MAX = 7;
	public static final int TEMPO_MIN = 1;
	Map<SignalMoteur, Command> map_commandes;

	/**
	 * permet de determiner si le moteur est en marche ou non
	 */
	private boolean etatMarche;

	public Engine(){
		System.out.println("Engine ...  Constructeur");
		etatMarche = false;
		map_commandes = new Hashtable<SignalMoteur, Command>();
		horloge_marquer_tempo = new Horloge_Tempo(map_commandes.get(SignalMoteur.MarquerTemps), tempo/60);
	}

	@Override
	public int getTempo() {
		return tempo;
	}

	@Override
	public void setTempo(int t) {
		if( TEMPO_MIN <= t  && t <= TEMPO_MAX )
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
		if(etatMarche == mode) return;
		
		// Il y a un chagement d'état à faire
		if(mode){
			horloge_marquer_tempo.demarrer();
		}else{
			horloge_marquer_tempo.stop();
		}
	}

	/**
	 * Retourne etatMarche
	 */
	public boolean getEtatMarche() {
		return etatMarche;
	}
}
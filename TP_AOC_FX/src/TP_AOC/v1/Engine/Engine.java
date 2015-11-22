package TP_AOC.v1.Engine;

import TP_AOC.v1.Engine.Command.Command;
import TP_AOC.v1.Engine.Horloge.Horloge;
import TP_AOC.v1.Engine.Horloge.Horloge_Tempo;

import java.util.Hashtable;
import java.util.Map;


public class Engine implements IEngine{

	private int tempo = 60;
	private int mesure = 2;
	private int temps_fait = 0;

	// constante 30 et 300
	//
	private Horloge horloge;
	private Horloge_Tempo horloge_marquer_tempo;
	
	public static final int TEMPO_MAX = 7;
	public static final int TEMPO_MIN = 2;
	Map<SignalMoteur, Command> map_commandes;

	/**
	 * permet de determiner si le moteur est en marche ou non
	 */
	private boolean etatMarche;

	public Engine(){
		System.out.println("Engine ...  Constructeur");
		etatMarche = false;
		map_commandes = new Hashtable<SignalMoteur, Command>();
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
		temps_fait = 0;
		this.mesure = t;

	}
	/**
	 * Permet d'envoyer un tempo ainsi que la mesure  au controller
	 */
	public void marquerTempo(){
		temps_fait ++;
		map_commandes.get(SignalMoteur.MarquerTemps).execute();
		if(temps_fait == mesure ){
			map_commandes.get(SignalMoteur.MarquerMesure).execute();
			temps_fait = 0;
		}
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
			horloge_marquer_tempo = (horloge_marquer_tempo == null) ? new Horloge_Tempo(this, 60/tempo) : horloge_marquer_tempo;
			horloge_marquer_tempo.demarrer();
		}else{
			horloge_marquer_tempo.stop();
			temps_fait = 0;
		}
	}

	/**
	 * Retourne etatMarche
	 */
	public boolean getEtatMarche() {
		return etatMarche;
	}
}
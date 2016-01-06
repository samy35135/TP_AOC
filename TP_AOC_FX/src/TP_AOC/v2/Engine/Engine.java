package TP_AOC.v2.Engine;

import TP_AOC.v2.Engine.Command.Command;
import TP_AOC.v2.Engine.Horloge.Horloge_Tempo;

import java.util.Hashtable;
import java.util.Map;


public class Engine implements IEngine {

	private int tempo = 60;
	private int mesure = 2;
	private int temps_fait = 0;

	private Horloge_Tempo horloge_marquer_tempo;
	
	public static final int TEMPO_MAX = 300;
	public static final int TEMPO_MIN = 30;

	public static final int MESURE_MAX = 7;
	public static final int MESURE_MIN = 2;
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
		System.out.println("Engine ... getTempo : " + tempo);
		return tempo;
	}

	@Override
	public void setTempo(int t) {
		if( TEMPO_MIN <= t  && t <= TEMPO_MAX && etatMarche){
			if(t!=this.tempo){
				this.tempo = t;
				temps_fait = 0;
				horloge_marquer_tempo.changerFrequence(((double)60/tempo));
				map_commandes.get(SignalMoteur.UpdateTemps).execute();
			}
		}
	}

	@Override
	public int getNbTempsMesures() {
		return mesure;
	}

	@Override
	public void setNbTempsMesures(int t) {
		temps_fait = 0;
		if( MESURE_MIN <= t  && t <= MESURE_MAX )
			this.mesure = t;
		System.out.println("Engine ... setNbTempsMesures valeur actuelle : " + this.mesure);

	}
	/**
	 * Permet d'envoyer un tempo ainsi que la mesure au controller
	 */
	public void marquerTempo(){
		temps_fait ++;
		if(temps_fait == mesure ){
			map_commandes.get(SignalMoteur.MarquerMesure).execute();
			temps_fait = 0;
		}else{
			map_commandes.get(SignalMoteur.MarquerTemps).execute();
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
			etatMarche = true;
			map_commandes.get(SignalMoteur.UpdateTemps).execute();
			horloge_marquer_tempo = (horloge_marquer_tempo == null) ? new Horloge_Tempo(this, 60/tempo) : horloge_marquer_tempo;
			horloge_marquer_tempo.demarrer();

		}else{
			etatMarche = false;
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
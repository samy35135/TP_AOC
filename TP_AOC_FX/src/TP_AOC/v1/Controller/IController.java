package TP_AOC.v1.Controller;

import TP_AOC.v1.Engine.IEngine;

/**
 * 
 */
public interface IController {

	/**
	 * Permet au controller de marquer une mesure à l'ihm
	 */
	public void marquerMesure();

	/**
	 * Permet au controller de marquer un tempo à l'ihm
	 * @throws Exception 
	 */
	public void marquerTemps();


	public void updateEnMarche();

	/**
	 * Permet à l'engine de dire au controller que ça valeur à changé
	 */
	public void updateMesure();
	public void updateTemps();

	/**
	 * permet au controller d'augmenter la mesure de l'engine de 1
	 */
	public void augmenterMesure();
	/**
	 * permet au controller de réduire la mesure de l'engine de 1
	 */
	public void decrementerMesure();

	/**
	 * Permet de démarrer le moteur si celui-ci n'est pas en marche
	 */
	public void demarrer();
	/**
	 * Permet d'arrêter le moteur si celui-ci est en marche
	 */
	public void arreter();
}
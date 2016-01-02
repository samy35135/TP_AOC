package TP_AOC.v1.Controller;

import TP_AOC.v1.Engine.IEngine;

/**
 * 
 */
public interface IController {

	/**
	 * Permet au controller de marquer un tempo à l'ihm
	 */
	public void marquerTemps();


	public void updateEnMarche();


	/**
	 * P Permet à l'engine de dire au controller que la valeur de Temps a changé
	 */
	public void updateTemps();

	/**
	 * permet au controller de changer le tempo de l'engine
	 */
	public void setTempoDepuisIHM(int value);

	/**
	 * Permet à l'engine de dire au controller que la valeur de Mesure a changé
	 */
	public void updateMesure();
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
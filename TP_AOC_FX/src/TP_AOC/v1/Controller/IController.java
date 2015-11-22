package TP_AOC.v1.Controller;

import TP_AOC.v1.Engine.IEngine;

/**
 * 
 */
public interface IController {
	public void marquerMesure();
	public void marquerTemps();
	public void updateEnMarche(IEngine engine);
	public void updateMesure(IEngine engine);
	public void updateTemps(IEngine engine);

	/**
	 * Permet de démarrer le moteur si celui-ci n'est pas en marche
	 */
	public void demarrer();

	/**
	 * Permet d'arrêter le moteur si celui-ci est en marche
	 */
	public void arreter();
}
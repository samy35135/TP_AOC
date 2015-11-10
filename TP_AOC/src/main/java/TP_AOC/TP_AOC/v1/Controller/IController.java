package TP_AOC.TP_AOC.v1.Controller;

import java.util.*;

import TP_AOC.TP_AOC.v1.Engine.IEngine;

/**
 * 
 */
public interface IController {
	public void marquerMesure();
	public void marquerTemps();
	public void updateEnMarche(IEngine engine);
	public void demarrer();
}
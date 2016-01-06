package TP_AOC.v2.Engine;

import TP_AOC.v2.Engine.Command.Command;
import TP_AOC.v2.Engine.SignalMoteur;

/**
 * 
 */
public interface IEngine {

    /**
     * @return
     */
    public int getTempo();

    /**
     * @param t
     */
    public void setTempo(int t);

    /**
     * @return
     */
    public int getNbTempsMesures();

    /**
     * @param t
     */
    public void setNbTempsMesures(int t);

    /**
     * @param mode
     */
    public void setEtatMarche(boolean mode);

    /**
     * @param signalMoteur 
     * @param cmd
     */
    public void addCommand(SignalMoteur signalMoteur, Command cmd);

    /**
     * @return
     */
    public boolean getEtatMarche();

}
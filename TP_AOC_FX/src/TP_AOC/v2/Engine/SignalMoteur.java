package TP_AOC.v2.Engine;

/**
 * 
 */
public enum SignalMoteur {
	UpdateMarche, MarquerTemps, MarquerMesure, UpdateMesure, UpdateTemps;
	


	/** 
	 *
	 * @return
	 */
	public String toString() {
		switch(this) {
		case UpdateMarche : return "UpdateMarche";
		case MarquerTemps : return "MarquerTemps";
		case MarquerMesure : return "MarquerMesure";
		case UpdateMesure : return "UpdateMesure";
		case UpdateTemps : return "UpdateTemps";
		default : return "Default";
		}
	}
}
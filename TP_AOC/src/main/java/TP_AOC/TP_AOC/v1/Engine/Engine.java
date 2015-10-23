package TP_AOC.TP_AOC.v1.Engine;

public class Engine implements IEngine{
	/**
	 * permet de determiner si le moteur est en marche ou non
	 */
	boolean etatMarche;
	
	public Engine(){
		etatMarche = false;
	}

	@Override
	public int gererTempo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTempo(int t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNbTempsMesures() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNbTempsMesures(int t) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	@Override
	/**
	 * affecte la variable etatMarche si mode est différent
	 */
	public void setEtatMarche(boolean mode) {
		if (etatMarche != mode)
				etatMarche = mode;
	}

	@Override
	public void addCommand(SignalMoteur signalMoteur, Command cmd) {
		// TODO Auto-generated method stub
	}

	/**
	 * Retourne etatMarche
	 */
	public boolean getEtatMarche() {
		return etatMarche;
	}

}

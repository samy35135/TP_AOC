package TP_AOC.v1.Materiel.Interface;

/**
 * 
 */
public interface Afficheur {

	
	public void allumerLED(int i);
	public void eteindreLED(int i);
    /**
     * allume la led tempo(doite)
     */
    public void allumerLEDTemps();

    /**
     * eteinds la led tempo(doite)
     */
    public void eteindreLEDTemps();
    
    /**
     * allume la led mesure(gauche)
     */
    public void allumerLEDMesure();
    
    /**
     * eteinds la led mesure(gauche)
     */
    public void eteindreLEDMesure();
    /**
     * Affiche un entier sur l'afficheur externe du métronome
     * @param valeurTempo
     */
    public void afficherTempo(int valeurTempo);

}
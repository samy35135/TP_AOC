package TP_AOC.v1.Engine.Horloge;


import TP_AOC.v1.Engine.Commande.Command;

/**
 * 
 */
public class Materiel_Horloge implements Horloge {

    /**
     * Default constructor
     */
    public Materiel_Horloge() {
    }



	
	   /**
     * Appel périodique de l'opération execute() de cmd,
     * toutes les périodesEnSecondes secondes,
     * avec une précision d'une miliseconde
     * @param cmd 
     * @param periodeEnSecondes
     */
    @Override
	public void activerPeriodiquement(Command cmd, float periodeEnSecondes) {
		// TODO Auto-generated method stub
		
	}


	@Override
    /**
     * Appel de l'opération execute() de cmd, 
     * après un délai de délaiEnSecondes secondes,
     * avec une précision d'une millisecondes
     * @param cmd 
     * @param delaiEnSecondes
     */
	public void activerApresDelai(Command cmd, float delaiEnSecondes) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void desactiver(Command cmd) {
		// TODO Auto-generated method stub
		
	}

}
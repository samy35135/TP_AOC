package TP_AOC.v1.IHM.java;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public interface BStartandStop {
	public void initialisationStart();
	public void gestioneventstartandstop(ActionEvent event);
	public void BoutonEtatStart(ObservableList<String> css);
	public void BoutonEtatStop(ObservableList<String> css);
	public boolean getEtat();
	public void setEtat(boolean etat);

}

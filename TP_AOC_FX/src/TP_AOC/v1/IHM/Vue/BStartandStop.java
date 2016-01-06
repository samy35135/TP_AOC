package TP_AOC.v1.IHM.Vue;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public interface BStartandStop {
	public void gestioneventstartandstop(ActionEvent event);
	public void BoutonEtatOFF(ObservableList<String> css);
	public void BoutonEtatON(ObservableList<String> css);
	public boolean getEtat();
	public void setEtat(boolean etat);

}

package TP_AOC.v1.IHM.Vue;

import java.net.URL;
import java.util.*;

import TP_AOC.v1.IHM.CommandIHM.CommandIHM;
import TP_AOC.v1.IHM.CommandIHM.IImplemCommand;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class IHM extends Application implements Initializable, BStartandStop, IIHM, IImplemCommand {

	private static Scene scene;
	private static Map<SignalIHM,CommandIHM> map_commandes = new HashMap<>();
	private Boolean etat;//etat du bouton ON/OFF initialisé à false

	@FXML
	private AnchorPane layout; //fx:id="layout"
	@FXML
	private Button onandoff;//fx:id="onandoff"
	@FXML
	private Button buttonplus; //fx:id="buttonplus"
	@FXML
	private Button buttonmoins;//fx:id="buttonmoins"
	@FXML
	private static Label affichagetempo;//fx:id="affichagetempo"
	/*
	@FXML
	private Label affichagetpparmesure;//fx:id="affichagetpparmesure"
	*/
	@FXML
	private Circle ledgaucheMesure;//fx:id="ledgaucheMesure"
	@FXML
	private Circle leddroiteTemps;//fx:id="leddroiteTemps"
	@FXML
	private Slider slider;//fx:id="slider"

	/**
	 * Controller
	 */
	public IHM() {
	}


	/***************************************
	 * Fenêtre graphique
	 ***************************************/

	@Override
	public void demarrer() {
		launch();
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/TP_AOC_v1.fxml"));
			Parent root = loader.load();
			scene = new Scene(root, 600, 320);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialisation des caractéristiques de la fenêtre
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initialisationFenetre();
	}

	/**
	 * Initialise bouton et leds au démarrage
	 */
	public void initialisationFenetre() {
		BoutonEtatOFF(onandoff.getStyleClass());
		ledgaucheMesure.getStyleClass().add(0, "off");
		leddroiteTemps.getStyleClass().add(0, "off");
		slider.setMin(30);
		slider.setMax(300);
		slider.setValue(60);

		slider.valueProperty().addListener((observable, oldValue, newValue) -> {
			if (oldValue.intValue() != newValue.intValue()) {
				changerAffichageTempo("" + newValue.intValue());
				map_commandes.get(SignalIHM.UpdateMolette).execute();
			}
		});
	}

	/***************************************
	 * Afficheur Tempo
	 ***************************************/

	public void changerAffichageTempo(String value) {
		getAffichagetempo().setText(value);
	}

	/***************************************
	 * Slider
	 ***************************************/

	public void changerValSlider(int value) {
		getSlider().setValue(value);
	}

	/***************************************     BStartandStop   ***************************************/

	/**
	 * permet de gerer les évenement du bouton start and stop
	 *
	 * @param event
	 */
	@FXML
	@Override
	public void gestioneventstartandstop(ActionEvent event) {
		if (onandoff.getStyleClass().contains("onbutton")) {
			BoutonEtatOFF(onandoff.getStyleClass());
		} else {
			BoutonEtatON(onandoff.getStyleClass());
		}
	}

	/**
	 * permet de définir le css de l'état start
	 *
	 * @param css
	 */
	@Override
	public void BoutonEtatON(ObservableList<String> css) {
		setEtat(true);
		disableornot(getEtat());
		css.remove(0);
		css.add(0, "onbutton");
		onandoff.setText("ON");

	}

	/**
	 * permet de définir le css de l'état stop
	 *
	 * @param css
	 */
	@Override
	public void BoutonEtatOFF(ObservableList<String> css) {
		setEtat(false);
		disableornot(getEtat());
		css.remove(0);
		css.add(0, "offbutton");
		onandoff.setText("OFF");

	}
	/**
	 * permet de verrouiller ou déverouiller les composants
	 * slider et boutons (+/-) en fonction de l'état(ON/OFF)
	 *
	 * @param etat boolean
	 */
	public void disableornot(boolean etat) {
		if(etat){
			buttonplus.setDisable(false);
			buttonmoins.setDisable(false);
			slider.setDisable(false);
		}else{
			buttonplus.setDisable(true);
			buttonmoins.setDisable(true);
			slider.setDisable(true);
		}
	}
	
	@Override
	public boolean getEtat() {
		return etat;
	}

	@Override
	public void setEtat(boolean etat) {
		this.etat = etat;
		if (this.etat){
			map_commandes.get(SignalIHM.Demarrer).execute();
		} else {
			getMap_commandes().get(SignalIHM.Arreter).execute();
		}
	}

	/***************************************
	 * LEDS
	 ****************************************/


	public Circle getLedgaucheMesure() {
		return (Circle) scene.lookup("#ledgaucheMesure");
	}

	public Circle getLeddroiteTemps() {
		return (Circle) scene.lookup("#leddroiteTemps");
	}

	/***************************************
	 * TEMPO
	 ****************************************/
	public Label getAffichagetempo() {
		return (Label) scene.lookup("#affichagetempo");
	}

	public Slider getSlider() {
		return (Slider) scene.lookup("#slider");
	}
	/***************************************    Mesure    ***************************************/

	/**
	 * Permet d'augmenter la mesure
	 *
	 * @param event
	 */
	@FXML
	public void augmenterMesure(ActionEvent event) {
		map_commandes.get(SignalIHM.AugmenterMesure).execute();
	}

	/**
	 * Permet de réduire la mesure
	 *
	 * @param event
	 */
	@FXML
	public void reduireMesure(ActionEvent event) {
		map_commandes.get(SignalIHM.ReduireMesure).execute();
	}


	/***************************************    Commandes IHM    ***************************************/

	@Override
	public void addCommandIHM(SignalIHM signalihm, CommandIHM cmd) {
		if(!map_commandes.containsKey(signalihm)){
			map_commandes.put(signalihm, cmd);
			System.out.println("IHM ... ajout " + signalihm.toString());
		}else{
			System.out.println("IHM ... refus ajout " + signalihm.toString());
		}
	}


	public static Map<SignalIHM, CommandIHM> getMap_commandes() {
		return map_commandes;
	}

	public static void setMap_commandes(Map<SignalIHM, CommandIHM> map_commandes) {
		IHM.map_commandes = map_commandes;
	}

}
package TP_AOC.v1.IHM.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import TP_AOC.v1.Controller.IController;
import TP_AOC.v1.Materiel.Interface.EmetteurSonore;
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
import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class IHM extends Application implements Initializable, BStartandStop, IIHM {

	/**
	 * Yo ma2thieu, petite liste de chose à faire :
	 * //FAIT - Passer l'état initial du bouton start à FAUX au démarrage
	 * //FAIT - Bien passer par setEtat quand tu changes l'état, ça appelle le controller
	 * //MOI je l'M bi1 - Faudrait supprimer l'afficheurs mesure, parce que sinon on devrra produire du code dnas al V2 après
	 * //FAIT - Faire en sorte que Materiel_afficheur, allume les bonnes leds en fonction des paramètes
	 * - remplir emettreSonTempo emettreSonMesure (tu peux mettre des sons différents)
	 * - empecher toute action tant que c'est pas ON, si ça passe à OFF, re-empecher toute action
	 */
	private static IController controller;

	private static Scene scene;

	private boolean retour_moteur = false;

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

	private Boolean etat;//etat du bouton ON/OFF initialisé à false

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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../assets/TP_AOC.fxml"));

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
				controller.setTempoDepuisIHM(newValue.intValue());
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
		css.remove(0);
		css.add(0, "offbutton");
		onandoff.setText("OFF");

	}

	@Override
	public boolean getEtat() {
		return etat;
	}

	@Override
	public void setEtat(boolean etat) {
		this.etat = etat;
		if (this.etat)
			controller.demarrer();
		else {
			controller.arreter();
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
		controller.augmenterMesure();
	}

	/**
	 * Permet de réduire la mesure
	 *
	 * @param event
	 */
	@FXML
	public void reduireMesure(ActionEvent event) {
		controller.decrementerMesure();
	}


	/***************************************
	 * getter And Setter
	 ***************************************/

	public IController getController() {
		return controller;
	}

	public void setController(IController controller) {
		this.controller = controller;
	}

}
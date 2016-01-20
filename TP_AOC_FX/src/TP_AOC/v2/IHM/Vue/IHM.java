package TP_AOC.v2.IHM.Vue;

import java.net.URL;
import java.util.*;

import javafx.application.Application;
import javafx.application.Platform;
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

public class IHM extends Application implements Initializable, IIHM {

	private static Scene scene;

	@FXML
	private AnchorPane layout; //fx:id="layout"
	@FXML
	private Button onandoff;//fx:id="onandoff"
	@FXML
	private  Button buttonplus; //fx:id="buttonplus"
	@FXML
	private  Button buttonmoins;//fx:id="buttonmoins"
	@FXML
	private  Label affichagetempo;//fx:id="affichagetempo"
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/TP_AOC/v2/IHM/assets/TP_AOC.fxml"));
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
	}

	/***************************************
	 * Afficheur Tempo
	 ***************************************/

	public void changerAffichageTempo(String value) {
		System.out.println("DEBUG --- CHANGER VALEUR "  + value);
		Platform.runLater(new Runnable() {
			@Override public void run() {
				getAffichagetempo().setText(value);
			}
		});

	}

	/***************************************     BStartandStop   ***************************************/

	/**
	 * permet de gerer les évenement du bouton start and stop
	 *
	 * @param event
	 */
	@FXML
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
	public void BoutonEtatON(ObservableList<String> css) {
		disableornot(true);
		css.remove(0);
		css.add(0, "onbutton");
		onandoff.setText("ON");

	}

	/**
	 * permet de définir le css de l'état stop
	 *
	 * @param css
	 */
	public void BoutonEtatOFF(ObservableList<String> css) {
		disableornot(false);
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

	public Button getOnandoff() {
		return (Button) scene.lookup("#onandoff");
	}

	public Button getButtonplus() {
		return (Button) scene.lookup("#buttonplus");
	}

	public Button getButtonmoins() {
		return (Button) scene.lookup("#buttonmoins");
	}
}

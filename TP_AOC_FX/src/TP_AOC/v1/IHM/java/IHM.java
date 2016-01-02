package TP_AOC.v1.IHM.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import TP_AOC.v1.Controller.IController;
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

public class IHM  extends Application implements Initializable, BStartandStop, IIHM, LEDs, EmetteurSonore {

	/**
	 * Yo ma2thieu, petite liste de chose à faire :
	 * //FAIT - Passer l'état initial du bouton start à FAUX au démarrage
	 * //FAIT - Bien passer par setEtat quand tu changes l'état, ça appelle le controller
	 * //MOI je l'M bi1 - Faudrait supprimer l'afficheur mesure, parce que sinon on devrra produire du code dnas al V2 après
	 * //FAIT - Faire en sorte que Materiel_afficheur, allume les bonnes leds en fonction des paramètes
	 *  - remplir emettreSonTempo emettreSonMesure (tu peux mettre des sons différents)
	 */
	private static IController controller;

	@FXML
	private AnchorPane layout; //fx:id="layout"
	@FXML
	private Button onandoff;//fx:id="onandoff"
	@FXML
	private Button buttonplus; //fx:id="buttonplus"
	@FXML
	private Button buttonmoins;//fx:id="buttonmoins"
	@FXML
	private Label affichagetempo;//fx:id="affichagetempo"
	@FXML
	private Label affichagetpparmesure;//fx:id="affichagetpparmesure"
	@FXML
	private Circle ledgaucheMesure;//fx:id="ledgauche"
	@FXML
	private Circle leddroiteTemps;//fx:id="leddroite"
	@FXML
	private Slider slider;//fx:id="slider"
	
	private Boolean etat;//etat du bouton ON/OFF initialisé à false
	/**
	 * Controller
	 */
	public IHM(){}


	/***************************************    Fenêtre graphique   ***************************************/

	@Override
	public void demarrer(){
		launch();
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../assets/TP_AOC.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root,600,320);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * Initialisation des caractéristiques de la fenêtre
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initialisationFenetre();
		try {
			emettreSonTempo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		slider.setMin(30);
		slider.setMax(300);
		slider.setValue(60);
		slider.setBlockIncrement(10);
		double slidervalue = slider.getValue();
		String valueslider=String.valueOf(slidervalue);
		//Number oldValue = Double.parseDouble(text);	
		/*slider.valueProperty().addListener(new ChangeListener<Number>() {
		      @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
		        if (newValue == null) {
		          //affichagetempo.setText("150");
		          return;
		        }
		       // affichagetempo.setText(Math.round(newValue.intValue()) + "");
		      }
		    });*/
	}
	/**
	 * Initialise bouton et leds au démarrage
	 */
	public void initialisationFenetre(){
		BoutonEtatOFF(onandoff.getStyleClass());	
		eteindreLedgaucheMesure();
		eteindreLeddroiteTemps();	
	}

	/***************************************     Afficheur Tempo   ***************************************/

	public void changerAffichageTempo(String value){
		//affichagetempo.setText(value);
	}



	/***************************************     BStartandStop   ***************************************/

	/**
	 * permet de gerer les évenement du bouton start and stop
	 * @param event
	 */
	@FXML
	@Override
	public void gestioneventstartandstop(ActionEvent event){
		if(onandoff.getStyleClass().contains("onbutton")){BoutonEtatOFF(onandoff.getStyleClass());
		}else{BoutonEtatON(onandoff.getStyleClass());}
	}

	/**
	 * permet de définir le css de l'état start
	 * @param css
     */
	@Override
	public void BoutonEtatON(ObservableList<String> css) {
		// TODO Auto-generated method stub
		css.remove(0);
		css.add(0, "onbutton");
		onandoff.setText("ON");
	}

	/**
	 * permet de définir le css de l'état stop
	 * @param css
     */
	@Override
	public void BoutonEtatOFF(ObservableList<String> css) {
		// TODO Auto-generated method stub
		setEtat(false);
		css.remove(0);
		css.add(0, "offbutton");
		onandoff.setText("OFF");
		
	}
	@Override
	public boolean getEtat(){
		return etat;
	}
	@Override
	public void setEtat(boolean etat){
		this.etat=etat;
		if(this.etat)
			controller.demarrer();
		else{
			controller.arreter();
		}
	}
	/***************************************     LEDS   ***************************************/
	@Override
	public void allumerLedgaucheMesure() {
		// TODO Auto-generated method stub
		if(ledgaucheMesure.getStyleClass().contains("off")){
			ledgaucheMesure.getStyleClass().remove(0);
		}
		ledgaucheMesure.getStyleClass().add(0, "onmesure");
	}
	@Override
	public void eteindreLedgaucheMesure() {
		// TODO Auto-generated method stub
		if(ledgaucheMesure.getStyleClass().contains("onmesure")){
			ledgaucheMesure.getStyleClass().remove(0);
		}
		ledgaucheMesure.getStyleClass().add(0, "off");
	}
	@Override
	public void allumerLeddroiteTemps() {
		// TODO Auto-generated method stub
		if(leddroiteTemps.getStyleClass().contains("off")){
			leddroiteTemps.getStyleClass().remove(0);
		}
		leddroiteTemps.getStyleClass().add(0, "ontemps");
	}
	@Override
	public void eteindreLeddroiteTemps() {
		// TODO Auto-generated method stub
		if(leddroiteTemps.getStyleClass().contains("ontemps")){
			leddroiteTemps.getStyleClass().remove(0);
		}
		leddroiteTemps.getStyleClass().add(0, "off");
	}
	/***************************************    SON   ***************************************/
	@Override
	public void emettreSonTempo() throws Exception {
		// TODO Auto-generated method stub
	    String gongFile = "/songs/son1.mp3";
	    InputStream in = new FileInputStream(gongFile);
	 
	    // create an audiostream from the inputstream
	    AudioStream audioStream = new AudioStream(in);
	    AudioData audiodata = audioStream.getData();
	    AudioDataStream audiostream = new AudioDataStream(audiodata);
	    // play the audio clip with the audioplayer class
	    AudioPlayer.player.start(audiostream);
		
	}


	@Override
	public void emettreSonMesure() {
		// TODO Auto-generated method stub
		
	}

	/***************************************    Mesure    ***************************************/

	/**
	 * Permet d'augmenter la mesure
	 * @param event
     */
	@FXML
	public void augmenterMesure(ActionEvent event){
		controller.augmenterMesure();
	}

	/**
	 * Permet de réduire la mesure
	 * @param event
     */
	@FXML
	public void reduireMesure(ActionEvent event){
		controller.decrementerMesure();
	}



	/***************************************   getter and setters   ***************************************/

	public IController getController() {
		return controller;
	}
	public void setController(IController controller) { this.controller = controller; }
}

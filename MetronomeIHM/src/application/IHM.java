package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class IHM implements Initializable, BStartandStop {
	
	@FXML
	private AnchorPane layout; //fx:id="layout"
	@FXML
	private Button startandstop;//fx:id="startandstop"
	@FXML
	private Button buttonplus; //fx:id="buttonplus"
	@FXML
	private Button buttonmoins;//fx:id="buttonmoins"
	@FXML
	private Label affichagetempo;//fx:id="affichagetempo"
	@FXML
	private Label affichagetpparmesure;//fx:id="affichagetpparmesure"
	@FXML
	private Circle ledgauche;//fx:id="ledgauche"
	@FXML
	private Circle leddroite;//fx:id="leddroite"
	@FXML
	private Slider slider;//fx:id="slider"
	
	private Boolean etat;
	/**
	 * Controller
	 */
	public IHM(){}
	/**
     * 
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		slider.setMin(30);
		slider.setMax(300);
		slider.setValue(40);
		slider.setBlockIncrement(10);
		double slidervalue = slider.getValue();
		String valueslider=String.valueOf(slidervalue);
		affichagetempo.setText(valueslider);
		//Number oldValue = Double.parseDouble(text);
		initialisationStart();
		slider.valueProperty().addListener(new ChangeListener<Number>() {
		      @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
		        if (newValue == null) {
		          affichagetempo.setText("150");
		          return;
		        }
		        affichagetempo.setText(Math.round(newValue.intValue()) + "");
		      }
		    });
	}
	
	@FXML
	public void gestioneventstartandstop(ActionEvent event){
		ObservableList<String> cssclass;
		cssclass=startandstop.getStyleClass();
		if(cssclass.contains("startbutton")){BoutonEtatStop(cssclass);
		}else{BoutonEtatStart(cssclass);}
	}
	
	public void initialisationStart(){
		startandstop.getStyleClass().add(0,"startbutton");
		etat=true;
		setEtat(etat);
		startandstop.setText("START");		
	}
	
	public void BoutonEtatStart(ObservableList<String> css){
		css.remove(0);
		css.add(0, "startbutton");
		startandstop.setText("START");
	}
	
	public void BoutonEtatStop(ObservableList<String> css){
		css.remove(0);
		css.add(0, "stopbutton");
		etat=false; 
		setEtat(etat);
		startandstop.setText("STOP");
	}
	
	public boolean getEtat(){
		return etat;
	}
	public void setEtat(boolean etat){
		this.etat=etat;
	}
	@FXML
	public void augmenterTemps(ActionEvent event){}
	@FXML
	public void reduireTemps(ActionEvent event){}

}

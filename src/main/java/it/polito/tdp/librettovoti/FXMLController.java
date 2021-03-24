package it.polito.tdp.librettovoti;

import java.awt.TextArea;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Libretto;
import model.Voto;

public class FXMLController {
	
	private Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextArea txtResult;

    @FXML
    private TextField txtEsame;

    @FXML
    private TextField txtVoto;
    
    @FXML
    private DatePicker datepickeresame;

    @FXML
    void handleInserisci(ActionEvent event) {
    	//Leggi e controlli i dati
    	String nomeEsame=txtEsame.getText();
    	
    	if(nomeEsame.length()==0) {
    		txtResult.setText("ERRORE: nome esame vuoto");
    		return;
    	}
    	
    	String votoEsame=txtVoto.getText();
    	
    	int votoInt=0;
    	try {
    		votoInt = Integer.parseInt(votoEsame);
    	}catch(NumberFormatException e) {
    		txtResult.setText("ERRORE: il voto deve essere numerico");
    		return;
    	}
    	if(votoInt<18 || votoInt>30) {
    		txtResult.setText("Il voto deve essere compreso tra 18 e 30");
    		return;
    	}
    	
    //	String dataEsame=txtData.getText();
    //	LocalDate data;
    //	try{
    //		data=LocalDate.parse(dataEsame);
    //	}catch(DateTimeParseException e) {
    //		txtResult.setText("La data non è nel formato corretto");
    //		return;
    //	}
    	
    	LocalDate data=datepickeresame.getValue();
    	if(data==null) {
    		txtResult.setText("ERRORE: inserire la data");
    		return;
    	}
    	//esegui l'azione
    	Voto voto=new Voto(nomeEsame,votoInt, data);
    	model.add(voto);
    	
    	//aggiorna i risultati (nella view)
    	txtResult.setText(model.toString());
    	txtEsame.clear();
    	txtVoto.clear();
    	datepickeresame.setValue(null);
    }
    
    public void setModel(Libretto model) {
    	this.model=model;
    }

    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert datepickeresame != null : "fx:id=\"datepickeresame\" was not injected: check your FXML file 'Scene.fxml'.";
    }
}

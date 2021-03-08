package model;

import java.time.LocalDate;

//POJO - Plain Old Java Object
//Java bean
//semplice contenitore dati, senza logica

/**
 * Memorizza il risultato di un esame singolo
 * @param nomecorso Nome del corso Voto
 * @author Utente
 *
 */

public class Voto {

	private String nomecorso;
	private int voto;  //30L come lo rappresento?
	private LocalDate data; //superamento esame
	
	public Voto(String nomecorso, int voto, LocalDate data) {
		this.nomecorso = nomecorso;
		this.voto = voto;
		this.data = data;
	}

	public String getNomecorso() {
		return nomecorso;
	}

	public void setNomecorso(String nomecorso) {
		this.nomecorso = nomecorso;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Esame " + nomecorso + " superato con " + voto + " il " + data;
	}
	
	
}

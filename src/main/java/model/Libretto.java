package model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List<Voto> voti;
	
	public Libretto() {
		this.voti= new ArrayList<Voto>();
	}
	
	public void add(Voto v) {
		voti.add(v);
	}

	@Override
	public String toString() {
		String s="";
		for(Voto v: this.voti) {
			s+=v.toString()+"\n";
		}
		return s;
	}
	
	//secondo punto
	/*
	public void stampaVotiUguali(int punteggio) {
		//il libretto stampa da solo i voti
		//metodo troppo specifico, stampa e basta
	}
	
	public String votiUguali1(int punteggio) {
		//calcolau una stringa che contiene i voti, sarà poi il chiamante a stamparli
		//metodo più generale, posso fare altro ai voti trovati
		//non so però cosa voglio stampare, solo il nome?
		return null;
	}
	*/
	
	public List<Voto> listaVotiUguali(int punteggio) {
		//restituisce solo i voti uguali al criterio, e decide poi il test come stamparlo
		List<Voto> risultato=new ArrayList<Voto>();
		for(Voto v:this.voti) {
			if(v.getVoto()==punteggio)
				risultato.add(v);
		}
		return risultato;
	}
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato=new Libretto();
		for(Voto v:this.voti) {
			if(v.getVoto()==punteggio)
				risultato.add(v);
		}
		return risultato;
	}
	
	/**
	 * Ricerca un voto del corso di cui è specificato il nome
	 * Se il corso non esiste restituisce null
	 * @param nomecorso
	 * @return
	 */
	
	//terzo punto
	public Voto ricercaCorso(String nomecorso) {
		Voto risultato=null;
		for(Voto v: this.voti)
			if(v.getNomecorso().equals(nomecorso))
				risultato=v;
		return risultato;
	}
	
}

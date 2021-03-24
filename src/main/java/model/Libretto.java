package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Libretto {

	private List<Voto> voti;
	private Map<String,Voto> votimap; //idetitymap: nome esame -> oggetto Voto
	
	public Libretto() {
		this.voti= new ArrayList<Voto>();
		this.votimap=new HashMap<String,Voto>();
	}
	
	public void add(Voto v) {
		voti.add(v);
		this.votimap.put(v.getNomecorso(), v);
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
//		Voto risultato=null;
//		for(Voto v: this.voti)
//			if(v.getNomecorso().equals(nomecorso))
//				risultato=v;
//		return risultato;
		return this.votimap.get(nomecorso);
	}
	
	//quarto punto
	/**
	 * Verifica se nel libretto c'è gia un voto con stesso esame ma stessa votazione
	 * @param v
	 * @return
	 */
	public boolean esisteDuplicato(Voto vo) {
		/*boolean trovato=false;
		for(Voto v:this.voti)
			if(v.getNomecorso().equals(vo.getNomecorso()) && v.getVoto()==vo.getVoto()) {
				trovato=true;
				break;
			}
		return trovato;*/
		Voto trovato=this.votimap.get(vo.getNomecorso());
		if(trovato == null)
			return false;
		
		if(trovato.getVoto()==vo.getVoto())
			return true;
		else
			return false;
	}
	
	//quinto punto
	/**
	 * Verifica se nel libretto c'è gia un voto con stesso esame ma votazione diversa
	 */
	public boolean esisteConflitto(Voto vo) {
		/*
		 * boolean trovato=false; for(Voto v:this.voti)
		 * if(v.getNomecorso().equals(vo.getNomecorso()) && v.getVoto()!=vo.getVoto()) {
		 * 	trovato=true; 
		 * 	break; 
		 * } 
		 * return trovato;
		 */
		Voto trovato=this.votimap.get(vo.getNomecorso());
		if(trovato == null)
			return false;
		
		if(trovato.getVoto()!=vo.getVoto())
			return true;
		else
			return false;
	}
	
}

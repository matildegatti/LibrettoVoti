package model;

import java.time.LocalDate;
//import java.util.List;

public class TestLibretto {
	
	public static void main(String[] args) {
		
		System.out.println("Test metodi di Libretto");
	
		Libretto libretto = new Libretto();
		Voto v1= new Voto("Analisi 1", 30, LocalDate.of(2019, 02, 15));
		libretto.add(v1);
		libretto.add(new Voto("Fisica 1", 28, LocalDate.of(2019, 02, 10)));
		libretto.add(new Voto("Informatica", 24, LocalDate.of(2019, 02, 05)));
		libretto.add(new Voto("Algebra", 25, LocalDate.of(2019, 03, 05)));
		
		System.out.println(libretto);
		
		//List<Voto> venticinque=libretto.listaVotiUguali(25);   meno comodo per la stampa
		//System.out.println(venticinque);
		
		Libretto venticinque=libretto.votiUguali(25);
		System.out.println(venticinque);
		
		Voto risultato=libretto.ricercaCorso("Algebra");
		System.out.println(risultato);
		
		Voto algebra=libretto.ricercaCorso("Algebra");
		Voto algebradoppio=new Voto("Algebra", 25, LocalDate.of(2019, 03, 05));
		Voto algebraconflitto=new Voto("Algebra", 29, LocalDate.of(2019, 03, 05));
		System.out.println(algebradoppio + " doppione di " + algebra+"?  " + libretto.esisteDuplicato(algebradoppio));
		System.out.println(algebraconflitto + " conflitto di " + algebra+"?  "+libretto.esisteConflitto(algebraconflitto));
	}
	

}

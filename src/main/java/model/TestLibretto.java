package model;

import java.time.LocalDate;

public class TestLibretto {
	
	public static void main(String[] args) {
		
		System.out.println("Test metodi di Libretto");
	
		Libretto libretto = new Libretto();
		Voto v1= new Voto("Analisi 1", 30, LocalDate.of(2019, 02, 15));
		libretto.add(v1);
		libretto.add(new Voto("Fisica 1", 28, LocalDate.of(2019, 02, 10)));
		libretto.add(new Voto("Informatica", 24, LocalDate.of(2019, 02, 05)));
		
		System.out.println(libretto.toString());
	}

}

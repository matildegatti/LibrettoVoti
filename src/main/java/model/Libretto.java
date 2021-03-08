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
	
	
}

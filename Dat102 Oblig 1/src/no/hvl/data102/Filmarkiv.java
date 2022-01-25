package no.hvl.data102;

import no.hvl.data102.adt.FilmarkivADT;
import no.hvl.data102.adt.Sjanger;

public class Filmarkiv implements FilmarkivADT {

	private Film[] filmArkiv;
	private int antall;

	public Filmarkiv(int antall) {

		filmArkiv = new Film[antall];
	}

	@Override
	public void visFilm(int nr) {
		for (Film a : filmArkiv) {
			
			if (a != null) 
				if(a.getFilmNr() == nr)
				System.out.println(a);
		}

	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == filmArkiv.length)
			utvid();
		filmArkiv[antall] = nyFilm;
		antall++;
	}
	
	private void utvid() {
		Film[] tmp = new Film[antall*2];
		
		for(int i = 0; i < antall; i++) {
			tmp[i] = filmArkiv[i];
		}
		
		filmArkiv = tmp;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int antall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		return 0;
	}

}

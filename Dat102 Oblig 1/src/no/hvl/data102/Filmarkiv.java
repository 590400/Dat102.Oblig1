package no.hvl.data102;

import java.util.HashMap;

import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

	private Film[] filmArkiv;
	private int antall = 0;

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
		for(int i = 0; i < antall; i++) {
			if (filmArkiv[i].getFilmNr() == filmnr) {
				filmArkiv[antall] = filmArkiv[i];
				filmArkiv[antall] = null;
				antall--;
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		HashMap<Integer, Film> tmp = new HashMap<Integer, Film>();
		
		for (Film i : filmArkiv) {
			if(i.getTittel().contains(delstreng)) {
				tmp.put(i.getFilmNr(), i);
			}
		}
		if(!tmp.isEmpty()) {
			Film[] tmpFilm = new Film[filmArkiv.length];
			int antall = 0;
			for(Film i : tmp.values()) {
				tmpFilm[antall] = i;
				antall++;
			}
			return trimTab(tmpFilm, tmp.size());
		}
		return null;
	}

	@Override
	public int antall() {
		
		return antall;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;
		for(Film i : filmArkiv){
			if(i.getSjanger().equals(sjanger))
				antall++;
		}
		return antall;
	}
	@Override
	public Film[] soekProdusent(String delstreng) {
		HashMap<Integer, Film> tmp = new HashMap<Integer, Film>();
		
		for (Film i : filmArkiv) {
			if(i.getProdusent().contains(delstreng)) {
				tmp.put(i.getFilmNr(), i);
			}
		}
		if(!tmp.isEmpty()) {
			Film[] tmpFilm = new Film[filmArkiv.length];
			int antall = 0;
			for(Film i : tmp.values()) {
				tmpFilm[antall] = i;
				antall++;
			}
			return trimTab(tmpFilm, tmp.size());
		}
		return null;
	}
	
	
	 private Film[] trimTab(Film[] tab, int n) { 
		  // n er antall elementer 
		  Film[] nytab = new Film[n]; 
		  int i = 0; 
		  while (i < n) { 
		   nytab[i] = tab[i]; 
		   i++; 
		  } 
		  return nytab; 
		 }

}

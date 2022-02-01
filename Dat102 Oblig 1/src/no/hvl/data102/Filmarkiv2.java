
package no.hvl.data102;

import java.util.HashMap;

import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	private int antall;
	private LinearNode<Film> start;

	public Filmarkiv2() {

		antall = 0;
		start = null;
	}

	@Override
	public Film finnFilm(int nr) {

		LinearNode<Film> tmp = start;

		for (int i = 0; i < antall && tmp != null; i++) {
			if (tmp.getElement().getFilmNr() == nr) {
				return tmp.getElement();
			} else
				tmp = tmp.getNeste();
		}
		return null;
	}

	@Override
	public void visFilm(int nr) {
		System.out.println(finnFilm(nr).toString());
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nynode = new LinearNode<Film>(nyFilm);
		nynode.setNeste(start);
		start = nynode;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false;
		LinearNode<Film> forrige = start;
		LinearNode<Film> denne = start.getNeste();

		for (int i = 0; i < antall; i++) {
			if (denne.getElement().getFilmNr() == filmnr) {
				forrige.setNeste(denne.getNeste());
				slettet = true;
				antall--;
			} else {
				forrige = denne;
				denne = denne.getNeste();
			}
		}
		return slettet;

	}

	/**
	 * Søker og henter Filmer med en gitt delstreng i tittelen.
	 * 
	 * @param delstreng som må være i tittel
	 * @return tabell med filmer som har delstreng i tittel
	 */
	public Film[] soekTittel(String delstreng) {
		
		Film[] tmp = new Film[antall];
		LinearNode<Film> denne = start;
		int antall = 0;

		for (int i = 0; i < this.antall; i++) {
			if (denne.getElement().getTittel().contains(delstreng)) {
				tmp[antall] = denne.getElement();
				antall++;
			}
		}
		
		if(antall != 0) return trimTab(tmp, antall);

		return null;

	}

	/**
	 * Søker og henter Filmer med en gitt delstreng i Produsenten.
	 * 
	 * @param delstreng som må være i Produsent
	 * @return tabell med filmer som har delstreng i Produsent
	 */

	public Film[] soekProdusent(String delstreng) {
		Film[] tmp = new Film[antall];
		LinearNode<Film> denne = start;
		int antall = 0;

		for (int i = 0; i < this.antall; i++) {
			if (denne.getElement().getProdusent().contains(delstreng)) {
				tmp[antall] = denne.getElement();
				antall++;
			}
		}
		
		if(antall != 0) return trimTab(tmp, antall);

		return null;

	}

	/**
	 * Finner antall filmer med gitt sjanger
	 * 
	 * @param sjanger
	 * @return antall filmer av gitt sjanger.
	 */
	public int antall(Sjanger sjanger) {
		int antall = 0;
		LinearNode<Film> denne = start;
		
		for(int i = 0; i < this.antall; i++) {
			if(denne.getElement().getSjanger().equals(sjanger))
				antall++;
		}
		
		return antall;
	}

	/**
	 * 
	 * @return antall filmer i arkivet
	 */
	public int antall() {
		return antall;
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

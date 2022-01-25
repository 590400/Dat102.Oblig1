package no.hvl.data102;

import java.util.Objects;

public class Film {
	private int filmNr;
	private String produsent;
	private String tittel;
	private int lansert;
	private String selskap;
	
	public Film(){
		filmNr = 0;
		produsent = null;
		tittel = null;
		lansert = 0;
		selskap = null;
	}
	
	public Film(int filmNr, int lansert, String produsent, String tittel, String selskap){
		this.filmNr = filmNr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lansert = lansert;
		this.selskap = selskap;
	}

	public int getFilmNr() {
		return filmNr;
	}

	public void setFilmNr(int filmNr) {
		this.filmNr = filmNr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLansert() {
		return lansert;
	}

	public void setLansert(int lansert) {
		this.lansert = lansert;
	}

	public String getSelskap() {
		return selskap;
	}

	public void setSelskap(String selskap) {
		this.selskap = selskap;
	}
	
	
	public int hashCode() {
		return Objects.hash(filmNr, lansert, produsent, selskap, tittel);
	}

	public boolean equals(int filmNr) {
		return this.filmNr == filmNr;
	}

}

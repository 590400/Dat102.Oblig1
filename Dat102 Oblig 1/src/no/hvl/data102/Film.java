package no.hvl.data102;

import java.util.Objects;

import no.hvl.data102.adt.FilmarkivADT;

public class Film {
	private int filmNr;
	private String produsent;
	private String tittel;
	private int lansert;
	private String selskap;
	private Sjanger sjanger;
	
	public Film(){
		filmNr = 0;
		produsent = null;
		tittel = null;
		lansert = 0;
		selskap = null;
	}
	
	public Film(int filmNr, int lansert, String produsent, String tittel, String selskap, Sjanger sjanger){
		this.filmNr = filmNr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lansert = lansert;
		this.selskap = selskap;
		this.sjanger = sjanger;
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
	
	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public int hashCode() {
	    Integer temp = filmNr; 
	    return temp.hashCode(); 
	} 
	
	public boolean equals(int filmNr) {
		return this.filmNr == filmNr;
	}

}

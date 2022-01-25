package no.hvl.data102.klient;

import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;
import no.hvl.data102.adt.FilmarkivADT;


public class Meny {
	private Tekstgrensesnitt tekstgr;  
	 private FilmarkivADT filmarkiv;  
	  
	 public Meny(FilmarkivADT filmarkiv){ 
	  tekstgr = new Tekstgrensesnitt();  
	  this.filmarkiv = filmarkiv; 
	 } 
	  
	 public void start(){ 
	  Film film1 = new Film(0, 2001, "Dreamworks Animation", "Shrek", "Disney", Sjanger.ACTION);
	  Film film2 = new Film(1, 2004, "Dreamworks Animation", "Shrek2", "Disney", Sjanger.ACTION);
	  Film film3 = new Film(2, 2007, "Dreamworks Animation", "Shrek3", "Disney", Sjanger.ACTION);
	  Film film4 = new Film(3, 2010, "Dreamworks Animation", "Shrek4", "Disney", Sjanger.ACTION);
	  
	  filmarkiv.leggTilFilm(film1);
	  filmarkiv.leggTilFilm(film2);
	  filmarkiv.leggTilFilm(film3);
	  filmarkiv.leggTilFilm(film4);  
	  
	 } 
}

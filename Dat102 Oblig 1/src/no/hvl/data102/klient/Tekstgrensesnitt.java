package no.hvl.data102.klient;


import java.util.Scanner;

import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;
import no.hvl.data102.adt.FilmarkivADT;

public class Tekstgrensesnitt {
	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv inn filmNr:");
		int filmNr = input.nextInt();
		input.next();

		System.out.println("Skriv inn Produsent:");
		String produsent = input.next();

		System.out.println("Skriv inn Tittel:");
		String tittel = input.next();

		System.out.println("Skriv inn Selskap:");
		String selskap = input.next();

		System.out.println("Skriv inn Lanseringsår:");
		int lansert = input.nextInt();
		input.next();

		System.out.println("Skriv inn Sjanger(ACTION/DRAMA/HISTORY/SCIFI):");
		Sjanger sjanger = Sjanger.valueOf(input.next());

		input.close();
		return new Film(filmNr, lansert, produsent, tittel, selskap, sjanger);

	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) { 
		  String tostring = "[";
		  
		  tostring += "FilmNummer = " + film.getFilmNr() + " ,";
		  tostring += "Produsent = " + film.getProdusent() + " ,";
		  tostring += "Selskap = " + film.getSelskap() + " ,";
		  tostring += "Tittel = " + film.getTittel() + " ,";
		  tostring += "Lansert = " + film.getLansert() + " ,";
		  tostring += "Sjanger = " + film.getSjanger() + "]";
		  
		  System.out.println(tostring);
		 }

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		for (Film i : filma.soekTittel(delstreng)) {
			visFilm(i);
		}
	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		for(Film i : filma.soekProdusent(delstreng)) {
			visFilm(i);
		}
	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filma) {
		System.out.println("Antall filmer = " + filma.antall());
		System.out.println("Antall action filmer = " + filma.antall(Sjanger.ACTION));
		System.out.println("Antall drama filmer = " + filma.antall(Sjanger.DRAMA));
		System.out.println("Antall history filmer = " + filma.antall(Sjanger.HISTORY));
		System.out.println("Antall scifi filmer = " + filma.antall(Sjanger.SCIFI));
	}
	

	// ... Ev. andre metoder
}

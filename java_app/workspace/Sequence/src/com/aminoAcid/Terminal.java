package com.aminoAcid;

import com.sequence.AminoAcid;

public class Terminal extends AminoAcid{
	// Variable de classe
	private static int nbTer = 0;
	
	// Variables d'instance
	private char syn1L = '|';
	private String syn3L = "Stop";
	private String[] codons = {"TAA", "TAG", "TGA"};
	
	// Constructeur
	public Terminal() {
		nbTer ++;
	}

	// Getters and Setters
	public static int getNbTer() {
		return nbTer;
	}

	public char getSyn1L() {
		return syn1L;
	}

	public String getSyn3L() {
		return syn3L;
	}
	
	public String[] getCodons() {
		return codons;
	}
}

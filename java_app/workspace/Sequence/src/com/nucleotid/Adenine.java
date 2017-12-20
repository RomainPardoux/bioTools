package com.nucleotid;

import com.sequence.Nucleotid;

public class Adenine extends Nucleotid{

	// Variable de classe
	private static int nbAde = 0;

	// Variables d'instance
	private char syn1L = 'A';
	private String syn3L = "ADE";
	private String formuleBrute = "C5H5N5";
	private int nbCarbonAtom = 5, nbHydrogenAtom = 5, nbAzoteAtom = 5;
	private double masseMolaire = 313.2;
	private double solubilite = 0.103;
	private int extinctionCoef = 15200;

	//Constructeur
	public Adenine() {
	}

	public static int getNbAde() {
		return nbAde;
	}

	public char getSyn1L() {
		return syn1L;
	}

	public String getSyn3L() {
		return syn3L;
	}

	public String getFormuleBrute() {
		return formuleBrute;
	}

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}

	public double getSolubilite() {
		return solubilite;
	}

	public double getMasseMolaire() {
		return masseMolaire;
	}

	public int getExtinctionCoef() {
		return extinctionCoef;
	}

}

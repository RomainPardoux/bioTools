package com.nucleotid;

import com.sequence.Nucleotid;

public class Guanine extends Nucleotid{

	// Variable de classe
	private static int nbGua = 0;

	// Variables d'instance
	private char syn1L = 'G';
	private String syn3L = "GUA";
	private String formuleBrute = "C5H5N5O";
	private int nbCarbonAtom = 5, nbHydrogenAtom = 5, nbAzoteAtom = 5, nbOxygenAtom = 1;
	private double masseMolaire = 329.2;
	private double solubilite = 0.103;
	private int extinctionCoef = 12010;

	//Constructeur
	public Guanine() {
		nbGua ++;
	}

	public static int getNbGua() {
		return nbGua;
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

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public double getMasseMolaire() {
		return masseMolaire;
	}

	public double getSolubilite() {
		return solubilite;
	}

	public int getExtinctionCoef() {
		return extinctionCoef;
	}
}

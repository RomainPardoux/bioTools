package com.nucleotid;

import com.sequence.Nucleotid;

public class Thymine extends Nucleotid{

	// Variable de classe
	private static int nbThy = 0;

	// Variables d'instance
	private char syn1L = 'T';
	private String syn3L = "THY";
	private String formuleBrute = "C5H6N2O2";
	private int nbCarbonAtom = 5, nbHydrogenAtom = 6, nbAzoteAtom = 2, nbOxygenAtom = 2;
	private double masseMolaire = 304.2;
	private double solubilite = 0.103;
	private int extinctionCoef = 8400;

	//Constructeur
	public Thymine() {
		nbThy ++;

	}

	public static int getNbThy() {
		return nbThy;
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

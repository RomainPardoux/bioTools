package com.nucleotid;

import com.sequence.Nucleotid;

public class Uracile extends Nucleotid{

	// Variable de classe
	private static int nbUra = 0;

	// Variables d'instance
	private char syn1L = 'U';
	private String syn3L = "URA";
	private String formuleBrute = "C4H4N2O2";
	private int nbCarbonAtom = 4, nbHydrogenAtom = 4, nbAzoteAtom = 2, nbOxygenAtom = 2;
	private double masseMolaire = 306.2;
	private double solubilite = 0.103;
	private int extinctionCoef = 10000;

	//Constructeur
	public Uracile() {
		nbUra ++;
	}

	public static int getNbUra() {
		return nbUra;
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

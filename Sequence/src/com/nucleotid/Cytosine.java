package com.nucleotid;

import com.sequence.Nucleotid;

public class Cytosine extends Nucleotid{

	// Variable de classe
	private static int nbCyt = 0;

	// Variables d'instance
	private char syn1L = 'C';
	private String syn3L = "CYT";
	private String formuleBrute = "C4H5N3O";
	private int nbCarbonAtom = 4, nbHydrogenAtom = 5, nbAzoteAtom = 3, nbOxygenAtom = 1;
	private double masseMolaire = 289.2;
	private int extinctionCoef = 7050;

	//Constructeur
	public Cytosine() {
		nbCyt ++;
	}

	public static int getNbCyt() {
		return nbCyt;
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

	public int getExtinctionCoef() {
		return extinctionCoef;
	}
}

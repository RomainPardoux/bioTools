package com.sequence;

public class Nucleotid {

	// Variables d'instance
	private char syn1L;
	private String syn3L = "";
	private String formuleBrute = "";
	private int nbCarbonAtom = 0, nbHydrogenAtom = 0, nbAzoteAtom = 0,nbOxygenAtom = 0;
	private double masseMolaire = 0.0;
	private double solubilite = 0.0;
	private int extinctionCoef = 0;

	// Constructeur
	public Nucleotid() {
		
	}

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
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

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}

	public double getMasseMolaire() {
		return masseMolaire;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public double getSolubilite() {
		return solubilite;
	}

	public int getExtinctionCoef() {
		return extinctionCoef;
	}
}

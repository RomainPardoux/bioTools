package com.sequence;

public class Nucleotid {

	protected static int nbAde = 0;
	// Variables d'instance
	protected char syn1L;
	protected String syn3L = "";
	protected String formuleBrute = "";
	protected int nbCarbonAtom = 0, nbHydrogenAtom = 0, nbAzoteAtom = 0,nbOxygenAtom = 0;
	protected double masseMolaire = 0.0;
	protected double solubilite = 0.0;

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
}

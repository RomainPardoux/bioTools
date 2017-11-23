package com.nucleotid;

import com.sequence.Nucleotid;

public class Guanine extends Nucleotid{

	// Variable de classe
	private static int nbAde = 0;

	// Variables d'instance
	private char syn1L = 'G';
	private String syn3L = "GUA";
	private String formuleBrute = "C5H5N5O";
	private int nbCarbonAtom = 5, nbHydrogenAtom = 5, nbAzoteAtom = 5, nbOxygenAtom = 1;
	private double masseMolaire = 135.13;
	private double solubilite = 0.103;

	//Constructeur
	public Guanine() {
		super.formuleBrute = this.formuleBrute;
		super.masseMolaire = this.masseMolaire;
		super.nbAzoteAtom = this.nbAzoteAtom;
		super.nbCarbonAtom = this.nbCarbonAtom;
		super.nbHydrogenAtom = this.nbHydrogenAtom;
		super.solubilite = this.solubilite;
		super.syn1L = this.syn1L;
		super.syn3L = this.syn3L;
		super.nbAde = this.nbAde;
		super.nbOxygenAtom = this.nbOxygenAtom;
	}
}

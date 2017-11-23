package com.nucleotid;

import com.sequence.Nucleotid;

public class Thymine extends Nucleotid{

	// Variable de classe
	private static int nbAde = 0;

	// Variables d'instance
	private char syn1L = 'T';
	private String syn3L = "THY";
	private String formuleBrute = "C5H6N2O2";
	private int nbCarbonAtom = 5, nbHydrogenAtom = 6, nbAzoteAtom = 2, nbOxygenAtom = 2;
	private double masseMolaire = 135.13;
	private double solubilite = 0.103;

	//Constructeur
	public Thymine() {
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

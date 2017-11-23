package com.nucleotid;

import com.sequence.Nucleotid;

public class Uracile extends Nucleotid{

	// Variable de classe
	private static int nbAde = 0;

	// Variables d'instance
	private char syn1L = 'U';
	private String syn3L = "URA";
	private String formuleBrute = "C4H4N2O2";
	private int nbCarbonAtom = 4, nbHydrogenAtom = 4, nbAzoteAtom = 2, nbOxygenAtom = 2;
	private double masseMolaire = 135.13;
	private double solubilite = 0.103;

	//Constructeur
	public Uracile() {
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

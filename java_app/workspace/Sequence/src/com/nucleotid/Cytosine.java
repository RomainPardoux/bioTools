package com.nucleotid;

import com.sequence.Nucleotid;

public class Cytosine extends Nucleotid{

	// Variable de classe
	private static int nbAde = 0;

	// Variables d'instance
	private char syn1L = 'C';
	private String syn3L = "CYT";
	private String formuleBrute = "C4H5N3O";
	private int nbCarbonAtom = 4, nbHydrogenAtom = 5, nbAzoteAtom = 3, nbOxygenAtom = 1;
	private double masseMolaire = 111.102;

	//Constructeur
	public Cytosine() {
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

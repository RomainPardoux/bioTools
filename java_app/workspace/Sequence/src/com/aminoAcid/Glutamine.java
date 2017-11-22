package com.aminoAcid;

import com.sequence.AminoAcid;

public class Glutamine extends AminoAcid{


	// Variable de classe
	private static int nbGln = 0;
	
	// Variables d'instance
	private char syn1L = 'Q';
	private String syn3L = "GLN";
	private String formuleBrute = "C5H10N2O3";
	private int nbCarbonAtom = 5, nbHydrogenAtom = 10, nbAzoteAtom = 2, nbOxygenAtom = 3;
	private double masseMolaire = 146.1445;
	private double precisionMasseMolaire = 0.006;
	private String[] codons = {"CAG", "CAA"};
	private  double pHIsoelectrique = 5.65;
	private double pKaCOOH = 2.18, pKaNH3 = 9.0;
	SideChaineProperties sideChainProperty = SideChaineProperties.SPECIAL;
	private String [] halfLife = {"0.8 hour", "10 min", ">10 hour"};
	private double hydropathie = - 3.50;
	
	// Constructeur
	public Glutamine() {
		nbGln ++;
	}

	// Getters and Setters
	public static int getNbGln() {
		return nbGln;
	}

	public String[] getHalfLife() {
		return halfLife;
	}

	public double getHydropathie() {
		return hydropathie;
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
	
	public double getMasseMolaire() {
		return masseMolaire;
	}

	public double getPrecisionMasseMolaire() {
		return precisionMasseMolaire;
	}

	public String[] getCodons() {
		return codons;
	}

	public double getpHIsoelectrique() {
		return pHIsoelectrique;
	}

	public double getpKaCOOH() {
		return pKaCOOH;
	}

	public double getpKaNH3() {
		return pKaNH3;
	}

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}	
}

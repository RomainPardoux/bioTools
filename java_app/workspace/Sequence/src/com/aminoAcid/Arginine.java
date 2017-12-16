package com.aminoAcid;

import com.sequence.AminoAcid;

public class Arginine extends AminoAcid{

	// Variable de classe
	private static int nbArg = 0;
	
	// Variables d'instance
	private char syn1L = 'R';
	private String syn3L = "ARG";
	private String formuleBrute = "C6H14N4O2";
	private int nbCarbonAtom = 6, nbHydrogenAtom = 14, nbAzoteAtom = 4, nbOxygenAtom = 2;
	private double masseMolaire = 174.201;
	private double precisionMasseMolaire = 0.0072;
	private double masseVolumique = 1.1;
	private String[] codons = {"AGA", "AGG", "CGU", "GCC", "CGA", "CGG"};
	private  double pHIsoelectrique = 10.76;
	private double pKaCOOH = 2.03, pKaNH3 = 9.0, pKaR = 12.10;
	private SideChaineProperties sideChainProperty = SideChaineProperties.POSITIVE_CHARGED;
	private String [] halfLife = {"1 hour", "2 min", "2 min"};
	private double hydropathie = - 4.50;
	
	// Constructeur
	public Arginine() {
		nbArg ++;
	}
	
	// Getters and Setters

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbArg() {
		return nbArg;
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

	public double getMasseVolumique() {
		return masseVolumique;
	}

	public String[] getCodons() {
		return codons;
	}

	public double getpHIsoelectrique() {
		return pHIsoelectrique;
	}

	public double getpKaR() {
		return pKaR;
	}

	public double getpKaNH3() {
		return pKaNH3;
	}

	public double getpKaCOOH() {
		return pKaCOOH;
	}

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}
}

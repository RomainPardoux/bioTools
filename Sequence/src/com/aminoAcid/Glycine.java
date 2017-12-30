package com.aminoAcid;

import com.sequence.AminoAcid;

public class Glycine extends AminoAcid{

	
	// Variable de classe
	private static int nbGly = 0;
	
	// Variables d'instance
	private char syn1L = 'G';
	private String syn3L = "GLY";
	private String formuleBrute = "C2H5NO2";
	private int nbCarbonAtom = 2, nbHydrogenAtom = 5, nbAzoteAtom = 1, nbOxygenAtom = 2;
	private double masseMolaire = 75.0666;
	private double precisionMasseMolaire = 0.0028;
	private double solubilite = 225;
	private double masseVolumique = 1.607;
	private String[] codons = {"GGU", "GGC", "GGA", "GGG"};
	private  double pHIsoelectrique = 5.97;
	private double pKaCOOH = 2.34, pKaNH3 = 9.58;
	private SideChaineProperties sideChainProperty = SideChaineProperties.SPECIAL;
	private String [] halfLife = {"30 hour", ">20 hour", ">10 hour"};
	private double hydropathie = - 0.40;
	
	// Constructeur
	public Glycine() {
		nbGly ++;
	}

	// Getters and Setters

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbGly() {
		return nbGly;
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

	public double getSolubilite() {
		return solubilite;
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

	public double getpKaCOOH() {
		return pKaCOOH;
	}

	public double getpKaNH3() {
		return pKaNH3;
	}

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}
}

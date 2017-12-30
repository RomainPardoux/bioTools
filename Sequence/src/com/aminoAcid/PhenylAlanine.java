package com.aminoAcid;

import com.sequence.AminoAcid;

public class PhenylAlanine extends AminoAcid{

	// Variable de classe
	private static int nbPhe = 0;
	
	// Variables d'instance
	private char syn1L = 'F';
	private String syn3L = "PHE";
	private String formuleBrute = "C9H11NO2";
	private int nbCarbonAtom = 9, nbHydrogenAtom = 11, nbAzoteAtom = 1, nbOxygenAtom = 2;
	private double masseMolaire = 165.1891;
	private double precisionMasseMolaire = 0.0088;
	private String[] codons = {"UUC", "UUU"};
	private  double pHIsoelectrique = 5.48;
	private double pKaCOOH = 2.18, pKaNH3 = 9.09;
	private SideChaineProperties sideChainProperty = SideChaineProperties.HYDROPHOBIC;
	private String [] halfLife = {"1.1 hour", "3 min", "2 min"};
	private double hydropathie = 2.80;
	
	// Constructeur
	public PhenylAlanine() {
		nbPhe ++;
	}

	// Getters and Setters

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbPhe() {
		return nbPhe;
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
}

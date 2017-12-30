package com.aminoAcid;

import com.sequence.AminoAcid;

public class Isoleucine extends AminoAcid{

	// Variable de classe
	private static int nbIle = 0;
	
	// Variables d'instance
	private char syn1L = 'I';
	private String syn3L = "ILE";
	private String formuleBrute = "C6H13NO2";
	private int nbCarbonAtom = 6, nbHydrogenAtom = 13, nbAzoteAtom = 1, nbOxygenAtom = 2;
	private double masseMolaire = 131.1729;
	private double precisionMasseMolaire = 0.0065;
	private String[] codons = {"AUU", "AUC", "AUA"};
	private  double pHIsoelectrique = 6.02;
	private double pKaCOOH = 2.26, pKaNH3 = 9.60;
	private SideChaineProperties sideChainProperty = SideChaineProperties.HYDROPHOBIC;
	private String [] halfLife = {"20 hour", "30 min", ">10 hour"};
	private double hydropathie = 4.50;
	
	// Constructeur
	public Isoleucine() {
		nbIle ++;
	}

	// Getters and Setters

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbIle() {
		return nbIle;
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
	
	public double getpKaNH3() {
		return pKaNH3;
	}

	public double getpKaCOOH() {
		return pKaCOOH;
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

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}
}

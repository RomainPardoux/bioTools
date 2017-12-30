package com.aminoAcid;

import com.sequence.AminoAcid;

public class Leucine extends AminoAcid{

	// Variable de classe
	private static int nbLeu = 0;
	
	// Variables d'instance
	private char syn1L = 'L';
	private String syn3L = "LEU";
	private String formuleBrute = "C6H13NO2";
	private int nbCarbonAtom = 6, nbHydrogenAtom = 13, nbAzoteAtom = 1, nbOxygenAtom = 2;
	private double masseMolaire = 131.1729;
	private double precisionMasseMolaire = 0.0065;
	private String[] codons = {"UUA", "UUG", "CUA", "CUC", "CUC", "CUG"};
	private  double pHIsoelectrique = 5.98;
	private double pKaCOOH = 2.32, pKaNH3 = 9.58;
	private SideChaineProperties sideChainProperty = SideChaineProperties.HYDROPHOBIC;
	private String [] halfLife = {"5.5 hour", "3 min", "2 min"};
	private double hydropathie = 3.80;
	
	// Constructeur
	public Leucine() {
		nbLeu ++;
	}
	
	// Getters and Setters

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbLeu() {
		return nbLeu;
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

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}
}

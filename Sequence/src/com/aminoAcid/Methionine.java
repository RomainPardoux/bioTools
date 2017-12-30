package com.aminoAcid;

import com.sequence.AminoAcid;

public class Methionine extends AminoAcid{

	// Variable de classe
	private static int nbMet = 0;
	
	// Variables d'instance
	private char syn1L = 'M';
	private String syn3L = "MET";
	private String formuleBrute = "C5H11NO2S";
	private int nbCarbonAtom = 5, nbHydrogenAtom = 11, nbAzoteAtom = 1, nbOxygenAtom = 2, nbSufferAtom = 1;
	private double masseMolaire = 149.211;
	private double precisionMasseMolaire = 0.011;
	private String[] codons = {"AUG"};
	private  double pHIsoelectrique = 5.74;
	private double pKaCOOH = 2.16, pKaNH3 = 9.08;
	private SideChaineProperties sideChainProperty = SideChaineProperties.HYDROPHOBIC;
	private String [] halfLife = {"30 hour", ">20 hour", ">10 hour"};
	private double hydropathie = 1.90;
	
	// Constructeur
	public Methionine() {
		nbMet ++;
	}

	// Getters and Setters

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbMet() {
		return nbMet;
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

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public int getNbSufferAtom() {
		return nbSufferAtom;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}
}

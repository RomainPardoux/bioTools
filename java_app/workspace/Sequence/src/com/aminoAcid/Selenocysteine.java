package com.aminoAcid;

import com.sequence.AminoAcid;

public class Selenocysteine extends AminoAcid{

	// Variable de classe
	private static int nbSec = 0;
	
	// Variables d'instance
	private char syn1L = 'U';
	private String syn3L = "SEC";
	private String formuleBrute = "C3H7NO2Se";
	private int nbCarbonAtom = 3, nbHydrogenAtom = 7, nbAzoteAtom = 1, nbOxygenAtom = 2, nbSelenoAtom = 1;
	private double masseMolaire = 168.05;
	private double precisionMasseMolaire = 0.03;
	private double solubilite = 166.5;
	private double masseVolumique = 1.4;
	private String[] codons = {"UGA"};
	private  double pHIsoelectrique = 5.47;
	private double pKaCOOH = 1.9, pKaNH3 = 10.0;
	private String sideChainProperty = "special";
	
	// Constructeur
	public Selenocysteine() {
		nbSec ++;
	}

	// Getters and Setters
	public static int getNbSec() {
		return nbSec;
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

	public double getpKaNH3() {
		return pKaNH3;
	}

	public double getpKaCOOH() {
		return pKaCOOH;
	}

	public String getSideChainProperty() {
		return sideChainProperty;
	}

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public int getNbSelenoAtom() {
		return nbSelenoAtom;
	}
}

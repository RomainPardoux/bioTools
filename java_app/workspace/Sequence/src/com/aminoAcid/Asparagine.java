package com.aminoAcid;

import com.sequence.AminoAcid;

public class Asparagine extends AminoAcid{

	// Variable de classe
	private static int nbAsn = 0;

	// Variables d'instance
	private char syn1L = 'N';
	private String syn3L = "ASN";
	private String formuleBrute = "C4H8N2O3";
	private int nbCarbonAtom = 4, nbHydrogenAtom = 8, nbAzoteAtom = 2, nbOxygenAtom = 3;
	private double masseMolaire = 132.1179;
	private double precisionMasseMolaire = 0.0051;
	private double solubilite = 25.1;
	private double masseVolumique = 1;
	private String[] codons = {"AAU", "AAC"};
	private  double pHIsoelectrique = 5.41;
	private double pKaCOOH = 2.16, pKaNH3 = 8.76;
	private SideChaineProperties sideChainProperty = SideChaineProperties.POLAR_UNCHARGED;
	private String [] halfLife = {"1.4 hour", "3 min", ">10 hour"};
	private double hydropathie = - 3.50;

	// Constructeur
	public Asparagine() {
		nbAsn ++;
	}

	//Getters and Setters
	

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbAsn() {
		return nbAsn;
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

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}
}

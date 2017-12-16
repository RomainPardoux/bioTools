package com.aminoAcid;

import com.sequence.AminoAcid;

public class Tyrosine extends AminoAcid{

	// Variable de classe
	private static int nbTyr = 0;
	
	// Variables d'instance
	private char syn1L = 'Y';
	private String syn3L = "TYR";
	private String formuleBrute = "C9H11NO3";
	private int nbCarbonAtom = 9, nbHydrogenAtom = 11, nbAzoteAtom = 1, nbOxygenAtom = 3;
	private double masseMolaire = 181.1885;
	private double precisionMasseMolaire = 0.0091;
	private double solubilite = 0.479;
	private String[] codons = {"UAU", "UAC"};
	private  double pHIsoelectrique = 5.66;
	private double pKaCOOH = 2.24, pKaNH3 = 9.04, pKaR = 10.10;
	private SideChaineProperties sideChainProperty = SideChaineProperties.HYDROPHOBIC;
	private int extinctionCoef = 1490;
	private String [] halfLife = {"2.8 hour", "10 min", "2 min"};
	private double hydropathie = - 1.30;
	
	// Constructeur
	public Tyrosine() {
		nbTyr ++;
	}
	
	// Getters and Setters

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbTyr() {
		return nbTyr;
	}

	public int getExtinctionCoef() {
		return extinctionCoef;
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

	public String[] getCodons() {
		return codons;
	}

	public double getpHIsoelectrique() {
		return pHIsoelectrique;
	}

	public double getpKaCOOH() {
		return pKaCOOH;
	}

	public double getpKaR() {
		return pKaR;
	}

	public double getpKaNH3() {
		return pKaNH3;
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
}

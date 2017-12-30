package com.aminoAcid;

import com.sequence.AminoAcid;

public class Cysteine extends AminoAcid{

	
	// Variable de classe
	private static int nbCys = 0;
	
	// Variables d'instance
	private char syn1L = 'C';
	private String syn3L = "CYS";
	private String formuleBrute = "C3H7NO2S";
	private int nbCarbonAtom = 3, nbHydrogenAtom = 7, nbAzoteAtom = 1, nbOxygenAtom = 2, nbSufferAtom = 1;
	private double masseMolaire = 121.158;
	private double precisionMasseMolaire = 0.009;
	private double solubilite = 280;
	private String[] codons = {"UGU", "UGC"};
	private  double pHIsoelectrique = 5.07;
	private double pKaCOOH = 1.91, pKaNH3 = 10.28, pKaR = 8.14;
	private SideChaineProperties sideChainProperty = SideChaineProperties.SPECIAL;
	private int extinctionCoef = 125;
	private String [] halfLife = {"1.2 hour", ">20 hour", ">10 hour"};
	private double hydropathie = 2.50;
	
	// Constructeur
	public Cysteine() {
		nbCys ++;
	}
	
	// Getters and Setters

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbCys() {
		return nbCys;
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

	public double getpKaNH3() {
		return pKaNH3;
	}

	public double getpKaR() {
		return pKaR;
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

	public int getNbSufferAtom() {
		return nbSufferAtom;
	}

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}
}

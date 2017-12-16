package com.aminoAcid;

import com.sequence.AminoAcid;

public class Serine extends AminoAcid{

	// Variable de classe
	private static int nbSer = 0;
	
	// Variables d'instance
	private char syn1L = 'S';
	private String syn3L = "SER";
	private String formuleBrute = "C3H7NO3";
	private int nbCarbonAtom = 3, nbHydrogenAtom = 7, nbAzoteAtom = 1, nbOxygenAtom = 3;
	private double masseMolaire = 105.0926;
	private double precisionMasseMolaire = 0.004;
	private double solubilite = 364;
	private String[] codons = {"UCU", "UCA", "UCG", "UCC", "AGU", "AGC"};
	private  double pHIsoelectrique = 5.68;
	private double pKaCOOH = 2.13, pKaNH3 = 9.05;
	private SideChaineProperties sideChainProperty = SideChaineProperties.POLAR_UNCHARGED;
	private String [] halfLife = {"1.9 hour", ">20 hour", ">10 hour"};
	private double hydropathie = - 0.8;
	
	// Constructeur
	public Serine() {
		nbSer ++;
	}
	
	// Getters and Setters

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbSer() {
		return nbSer;
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

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}
}

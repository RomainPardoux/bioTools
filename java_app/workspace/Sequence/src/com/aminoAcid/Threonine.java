package com.aminoAcid;

import com.sequence.AminoAcid;

public class Threonine extends AminoAcid{

	// Variable de classe
	private static int nbThr = 0;
	
	// Variables d'instance
	private char syn1L = 'T';
	private String syn3L = "THR";
	private String formuleBrute = "C4H9NO3";
	private int nbCarbonAtom = 4, nbHydrogenAtom = 9, nbAzoteAtom = 1, nbOxygenAtom = 3;
	private double masseMolaire = 119.1192;
	private double precisionMasseMolaire = 0.0049;
	private double solubilite = 90.0;
	private String[] codons = {"ACU", "ACC", "ACA", "ACG"};
	private  double pHIsoelectrique = 5.6;
	private double pKaCOOH = 2.20, pKaNH3 = 8.96;
	private SideChaineProperties sideChainProperty = SideChaineProperties.POLAR_UNCHARGED;
	private String [] halfLife = {"7.2 hour", ">20 hour", ">10 hour"};
	private double hydropathie = - 0.7;
	
	// Constructeur
	public Threonine() {
		nbThr ++;
	}

	// Getters and Setters

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbThr() {
		return nbThr;
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

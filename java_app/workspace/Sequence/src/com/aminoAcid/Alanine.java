package com.aminoAcid;

import com.sequence.AminoAcid;

public class Alanine extends AminoAcid{

	// Variable de classe
	private static int nbAla = 0;
	
	// Variables d'instance
	private char syn1L = 'A';
	private String syn3L = "ALA";
	private String formuleBrute = "C3H7NO2";
	private int nbCarbonAtom = 3, nbHydrogenAtom = 7, nbAzoteAtom = 1, nbOxygenAtom = 2;
	private double masseMolaire = 89.0932;
	private double precisionMasseMolaire = 0.0037;
	private double solubilite = 166.5;
	private double masseVolumique = 1.4;
	private String[] codons = {"GCU", "GCC", "GCA", "GCG"};
	private  double pHIsoelectrique = 6.0;
	private double pKaCOOH = 2.33, pKaNH3 = 9.71;
	SideChaineProperties sideChainProperty = SideChaineProperties.HYDROPHOBIC;
	private String [] halfLife = {"4.4 hour", ">20 hour", ">10 hour"};
	private double hydropathie = 1.80;
	
	// Constructeur
	public Alanine() {
		nbAla ++;
	}


	// Getters and Setters
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

	public static int getNbAla() {
		return nbAla;
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

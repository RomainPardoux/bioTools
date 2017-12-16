package com.aminoAcid;

import com.sequence.AminoAcid;

public class AsparticAcid extends AminoAcid{

	// Variable de classe
	private static int nbAsp = 0;
	
	// Variables d'instance
	private char syn1L = 'D';
	private String syn3L = "ASP";
	private String formuleBrute = "C4H7NO4";
	private int nbCarbonAtom = 4, nbHydrogenAtom = 7, nbAzoteAtom = 1, nbOxygenAtom = 4;
	private double masseMolaire = 133.1027;
	private double precisionMasseMolaire = 0.0051;
	private double solubilite = 4.5;
	private double masseVolumique = 1.7;
	private String[] codons = {"GAU", "GAC"};
	private  double pHIsoelectrique = 2.77;
	private double pKaCOOH = 1.95, pKaNH3 = 9.66, pKaR = 3.71;
	private SideChaineProperties sideChainProperty = SideChaineProperties.NEGATIVE_CHARGED;
	private String [] halfLife = {"1.1 hour", "3 min", ">10 hour"};
	private double hydropathie = - 3.50;
	
	// Constructeur
	public AsparticAcid() {
		nbAsp ++;
	}

	// Getters and Setters	
	public static int getNbAsp() {
		return nbAsp;
	}

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
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

	public double getpKaR() {
		return pKaR;
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

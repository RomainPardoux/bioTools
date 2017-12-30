package com.aminoAcid;

import com.sequence.AminoAcid;

public class Tryptophan extends AminoAcid{

	// Variable de classe
	private static int nbTrp = 0;
	
	// Variables d'instance
	private char syn1L = 'W';
	private String syn3L = "TRP";
	private String formuleBrute = "C11H12N2O2";
	private int nbCarbonAtom = 11, nbHydrogenAtom = 12, nbAzoteAtom = 2, nbOxygenAtom = 2;
	private double masseMolaire = 204.2252;
	private double precisionMasseMolaire = 0.0106;
	private double solubilite = 13.1;
	private double masseVolumique = 1.4;
	private String[] codons = {"UGG"};
	private  double pHIsoelectrique = 5.89;
	private double pKaCOOH = 2.38, pKaNH3 = 9.34;
	private SideChaineProperties sideChainProperty = SideChaineProperties.HYDROPHOBIC;
	private int extinctionCoef = 5500;
	private String [] halfLife = {"2.8 hour", "3 min", "2 min"};
	private double hydropathie = - 0.9;
	
	// Constructeur
	public Tryptophan() {
		nbTrp ++;
	}
	
	// Getters and Setters

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbTrp() {
		return nbTrp;
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

	public double getpKaNH3() {
		return pKaNH3;
	}

	public double getpKaCOOH() {
		return pKaCOOH;
	}

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}

	public int getExtinctionCoef() {
		return extinctionCoef;
	}
}

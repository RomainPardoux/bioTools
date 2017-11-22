package com.sequence;

import com.aminoAcid.SideChaineProperties;

public abstract class AminoAcid {

	// Variables d'instance
	protected char syn1L;
	protected String syn3L = "";
	protected String formuleBrute = "";
	private int nbCarbonAtom = 0, nbHydrogenAtom = 0, nbAzoteAtom = 0, nbOxygenAtom = 0, nbSufferAtom = 0, nbSelenoAtom;
	protected double masseMolaire = 0.0;
	protected double precisionMasseMolaire = 0.0;
	protected double solubilite = 0.0;
	protected double masseVolumique = 0.0;
	protected String[] codons;
	protected  double pHIsoelectrique = 0.0;
	protected double pKaCOOH = 0.0, pKaNH3 = 0.0, pKaR = 0.0;
	SideChaineProperties sideChainProperty = SideChaineProperties.SPECIAL;
	private int extinctionCoef = 0;
	protected String [] halfLife = {"", "", ""};
	protected double hydropathie = 0.00;
	
	// Constructeur
	public AminoAcid() {}

	// Getters and Setters
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

	public double getpKaR() {
		return pKaR;
	}

	public double getpKaCOOH() {
		return pKaCOOH;
	}

	public double getpKaNH3() {
		return pKaNH3;
	}

	public int getNbSelenoAtom() {
		return nbSelenoAtom;
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

	public int getNbSufferAtom() {
		return nbSufferAtom;
	}

	public int getExtinctionCoef() {
		return extinctionCoef;
	}

	public String [] getHalfLife() {
		return halfLife;
	}

	public double getHydropathie() {
		return hydropathie;
	}
}

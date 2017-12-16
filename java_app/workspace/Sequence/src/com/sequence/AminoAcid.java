package com.sequence;

import com.aminoAcid.SideChaineProperties;

public abstract class AminoAcid {

	// Variables d'instance
	private char syn1L;
	private String syn3L = "";
	private String formuleBrute = "";
	private int nbCarbonAtom = 0, nbHydrogenAtom = 0, nbAzoteAtom = 0, nbOxygenAtom = 0, nbSufferAtom = 0, nbSelenoAtom;
	private double masseMolaire = 0.0;
	private double precisionMasseMolaire = 0.0;
	private double solubilite = 0.0;
	private double masseVolumique = 0.0;
	private String[] codons;
	private  double pHIsoelectrique = 0.0;
	private double pKaCOOH = 0.0, pKaNH3 = 0.0, pKaR = 0.0;
	private int extinctionCoef = 0;
	private String [] halfLife = {"", "", ""};
	private double hydropathie = 0.00;
	private SideChaineProperties sideChainProperty = SideChaineProperties.SPECIAL;
	
	// Constructeur
	public AminoAcid() {
	}

	// Getters and Setters	
	
	
	public char getSyn1L() {
		return syn1L;
	}

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
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

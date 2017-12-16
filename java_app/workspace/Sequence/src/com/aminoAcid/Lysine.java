package com.aminoAcid;

import com.sequence.AminoAcid;

public class Lysine extends AminoAcid{

	// Variable de classe
	private static int nbLys = 0;
	
	// Variables d'instance
	private char syn1L = 'K';
	private String syn3L = "LYS";
	private String formuleBrute = "C6H14N2O2";
	private int nbCarbonAtom = 6, nbHydrogenAtom = 14, nbAzoteAtom = 2, nbOxygenAtom = 2;
	private double masseMolaire = 146.1876;
	private double precisionMasseMolaire = 0.0068;
	private String[] codons = {"AAG", "AAA"};
	private  double pHIsoelectrique = 9.74;
	private double pKaCOOH = 2.15, pKaNH3 = 10.67, pKaR = 9.16;
	private SideChaineProperties sideChainProperty = SideChaineProperties.POSITIVE_CHARGED;
	private String [] halfLife = {"1.3 hour", "3 min", "2 min"};
	private double hydropathie = - 3.90;
	
	// Constructeur
	public Lysine() {
		nbLys ++;
	}
	
	// Getters and Setters

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbLys() {
		return nbLys;
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

	public String[] getCodons() {
		return codons;
	}

	public double getpHIsoelectrique() {
		return pHIsoelectrique;
	}

	public double getpKaR() {
		return pKaR;
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

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}
}

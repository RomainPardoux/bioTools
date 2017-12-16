package com.aminoAcid;

import com.sequence.AminoAcid;

public class Valine extends AminoAcid{

	// Variable de classe
	private static int nbVal = 0;
	
	// Variables d'instance
	private char syn1L = 'V';
	private String syn3L = "VAL";
	private String formuleBrute = "C5H11NO2";
	private int nbCarbonAtom = 5, nbHydrogenAtom = 11, nbAzoteAtom = 1, nbOxygenAtom = 2;
	private double masseMolaire = 117.1463;
	private double precisionMasseMolaire = 0.0056;
	private String[] codons = {"GUU", "GUC", "GUA", "GUG"};
	private  double pHIsoelectrique = 5.96;
	private double pKaCOOH = 2.27, pKaNH3 = 9.52;
	private SideChaineProperties sideChainProperty = SideChaineProperties.HYDROPHOBIC;
	private String [] halfLife = {"100 hour", ">20 hour", ">10 hour"};
	private double hydropathie = 4.20;
	
	// Constructeur
	public Valine() {
		nbVal ++;
	}
	
	// Getters and Setters

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbVal() {
		return nbVal;
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

	public double getpKaCOOH() {
		return pKaCOOH;
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

	public String [] getHalfLife() {
		return halfLife;
	}
}

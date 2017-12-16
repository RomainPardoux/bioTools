package com.aminoAcid;

import com.sequence.AminoAcid;

public class Proline extends AminoAcid{

	// Variable de classe
	private static int nbPro = 0;
	
	// Variables d'instance
	private char syn1L = 'P';
	private String syn3L = "PRO";
	private String formuleBrute = "C3H7NO2";
	private int nbCarbonAtom = 5, nbHydrogenAtom = 9, nbAzoteAtom = 1, nbOxygenAtom = 2;
	private double masseMolaire = 115.1305;
	private double precisionMasseMolaire = 0.0054;
	private String[] codons = {"CCU", "CCC", "CCA", "CCG"};
	private  double pHIsoelectrique = 6.3;
	private double pKaCOOH = 1.95, pKaNH3 = 10.47;
	private SideChaineProperties sideChainProperty = SideChaineProperties.SPECIAL;
	private String [] halfLife = {">20 hour", ">20 hour", "?"};
	private double hydropathie = - 1.60;
	
	// Constructeur
	public Proline() {
		nbPro ++;
	}

	// Getters and Setters

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbPro() {
		return nbPro;
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

	public double getpKaNH3() {
		return pKaNH3;
	}

	public double getpKaCOOH() {
		return pKaCOOH;
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

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}
}

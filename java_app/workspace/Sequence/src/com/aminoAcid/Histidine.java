package com.aminoAcid;

import com.sequence.AminoAcid;

public class Histidine extends AminoAcid{

	// Variable de classe
	private static int nbHis = 0;
	
	// Variables d'instance
	private char syn1L = 'H';
	private String syn3L = "HIS";
	private String formuleBrute = "C6H9N3O2";
	private int nbCarbonAtom = 6, nbHydrogenAtom = 9, nbAzoteAtom = 3, nbOxygenAtom = 2;
	private double masseMolaire = 155.1546;
	private double precisionMasseMolaire = 0.0066;
	private double solubilite = 166.5;
	private double masseVolumique = 1.4;
	private String[] codons = {"GAU", "CAC"};
	private  double pHIsoelectrique = 7.59;
	private double pKaCOOH = 1.7, pKaNH3 = 9.09, pKaR = 6.04;
	SideChaineProperties sideChainProperty = SideChaineProperties.POSITIVE_CHARGED;
	private String [] halfLife = {"3.5 hour", "10 min", ">10 hour"};
	private double hydropathie = - 3.20;
	
	// Constructeur
	public Histidine() {
		nbHis ++;
	}

	// Getters and Setters
	public static int getNbHis() {
		return nbHis;
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

	public double getpKaR() {
		return pKaR;
	}

	public double getpKaNH3() {
		return pKaNH3;
	}
	
	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}
}

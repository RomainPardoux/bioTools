package com.aminoAcid;

import com.sequence.AminoAcid;

public class Asparagine extends AminoAcid{

	// Variable de classe
	private static int nbAsn = 0;

	// Variables d'instance
	private char syn1L = 'N';
	private String syn3L = "ASN";
	private String formuleBrute = "C4H8N2O3";
	private int nbCarbonAtom = 4, nbHydrogenAtom = 8, nbAzoteAtom = 2, nbOxygenAtom = 3;
	private double masseMolaire = 132.1179;
	private double precisionMasseMolaire = 0.0051;
	private double solubilite = 25.1;
	private double masseVolumique = 1;
	private String[] codons = {"AAU", "AAC"};
	private  double pHIsoelectrique = 5.41;
	private double pKaCOOH = 2.16, pKaNH3 = 8.76;
	private String sideChainProperty = "uncharged";
	private String [] halfLife = {"1.4 hour", "3 min", ">10 hour"};
	private double hydropathie = - 3.50;

	// Constructeur
	public Asparagine() {
		nbAsn ++;
	}

	//Getters and Setters
	
	public static int getNbAsn() {
		return nbAsn;
	}


	public String[] getHalfLife() {
		return halfLife;
	}

	public double getHydropathie() {
		return hydropathie;
	}

	public static void setNbAsn(int nbAsn) {
		Asparagine.nbAsn = nbAsn;
	}


	public char getSyn1L() {
		return syn1L;
	}


	public void setSyn1L(char syn1l) {
		syn1L = syn1l;
	}


	public String getSyn3L() {
		return syn3L;
	}


	public void setSyn3L(String syn3l) {
		syn3L = syn3l;
	}


	public String getFormuleBrute() {
		return formuleBrute;
	}


	public void setFormuleBrute(String formuleBrute) {
		this.formuleBrute = formuleBrute;
	}


	public double getMasseMolaire() {
		return masseMolaire;
	}


	public void setMasseMolaire(double masseMolaire) {
		this.masseMolaire = masseMolaire;
	}


	public double getPrecisionMasseMolaire() {
		return precisionMasseMolaire;
	}


	public void setPrecisionMasseMolaire(double precisionMasseMolaire) {
		this.precisionMasseMolaire = precisionMasseMolaire;
	}


	public double getSolubilite() {
		return solubilite;
	}


	public void setSolubilite(double solubilite) {
		this.solubilite = solubilite;
	}


	public double getMasseVolumique() {
		return masseVolumique;
	}


	public void setMasseVolumique(double masseVolumique) {
		this.masseVolumique = masseVolumique;
	}


	public String[] getCodons() {
		return codons;
	}


	public void setCodons(String[] codons) {
		this.codons = codons;
	}


	public double getpHIsoelectrique() {
		return pHIsoelectrique;
	}


	public void setpHIsoelectrique(double pHIsoelectrique) {
		this.pHIsoelectrique = pHIsoelectrique;
	}

	public double getpKaCOOH() {
		return pKaCOOH;
	}

	public void setpKaCOOH(double pKaCOOH) {
		this.pKaCOOH = pKaCOOH;
	}

	public double getpKaNH3() {
		return pKaNH3;
	}

	public void setpKaNH3(double pKaNH3) {
		this.pKaNH3 = pKaNH3;
	}

	public String getSideChainProperty() {
		return sideChainProperty;
	}

	public void setSideChainProperty(String sideChainProperty) {
		this.sideChainProperty = sideChainProperty;
	}

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}

	public void setNbHydrogenAtom(int nbHydrogenAtom) {
		this.nbHydrogenAtom = nbHydrogenAtom;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}

	public void setNbAzoteAtom(int nbAzoteAtom) {
		this.nbAzoteAtom = nbAzoteAtom;
	}

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public void setNbCarbonAtom(int nbCarbonAtom) {
		this.nbCarbonAtom = nbCarbonAtom;
	}

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public void setNbOxygenAtom(int nbOxygenAtom) {
		this.nbOxygenAtom = nbOxygenAtom;
	}

}

package com.aminoAcid;

import com.sequence.AminoAcid;

public class Tyrosine extends AminoAcid{

	// Variable de classe
	private static int nbTyr = 0;
	
	// Variables d'instance
	private char syn1L = 'Y';
	private String syn3L = "TYR";
	private String formuleBrute = "C9H11NO3";
	private int nbCarbonAtom = 9, nbHydrogenAtom = 11, nbAzoteAtom = 1, nbOxygenAtom = 3;
	private double masseMolaire = 181.1885;
	private double precisionMasseMolaire = 0.0091;
	private double solubilite = 0.479;
	private String[] codons = {"UAU", "UAC"};
	private  double pHIsoelectrique = 5.66;
	private double pKaCOOH = 2.24, pKaNH3 = 9.04, pKaR = 10.10;
	private String sideChainProperty = "hydrophobic";
	private int extinctionCoef = 1490;
	
	// Constructeur
	public Tyrosine() {
		nbTyr ++;
		initAa();
	}

	// InitClasseAA
	public void initAa(){
		super.setSyn1L(syn1L);
		super.setSyn3L(syn3L);
		super.setFormuleBrute(formuleBrute);
		super.setMasseMolaire(masseMolaire);
		super.setPrecisionMasseMolaire(precisionMasseMolaire);
		super.setSolubilite(solubilite);
		super.setCodons(codons);
		super.setpHIsoelectrique(pHIsoelectrique);
		super.setExtinctionCoef(extinctionCoef);
	}
	
	// Getters and Setters
	public static int getNbTyr() {
		return nbTyr;
	}

	public static void setNbTyr(int nbTyr) {
		Tyrosine.nbTyr = nbTyr;
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

	public double getpKaR() {
		return pKaR;
	}

	public void setpKaR(double pKaR) {
		this.pKaR = pKaR;
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

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public void setNbOxygenAtom(int nbOxygenAtom) {
		this.nbOxygenAtom = nbOxygenAtom;
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
}

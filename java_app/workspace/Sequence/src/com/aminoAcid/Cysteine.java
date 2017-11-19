package com.aminoAcid;

import com.sequence.AminoAcid;

public class Cysteine extends AminoAcid{

	
	// Variable de classe
	private static int nbCys = 0;
	
	// Variables d'instance
	private char syn1L = 'C';
	private String syn3L = "CYS";
	private String formuleBrute = "C3H7NO2S";
	private int nbCarbonAtom = 3, nbHydrogenAtom = 7, nbAzoteAtom = 1, nbOxygenAtom = 2, nbSufferAtom = 1;
	private double masseMolaire = 121.158;
	private double precisionMasseMolaire = 0.009;
	private double solubilite = 280;
	private String[] codons = {"UGU", "UGC"};
	private  double pHIsoelectrique = 5.07;
	private double pKaCOOH = 1.91, pKaNH3 = 10.28, pKaR = 8.14;
	private String sideChainProperty = "special";
	private int extinctionCoef = 125;
	
	// Constructeur
	public Cysteine() {
		nbCys ++;
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
	public static int getNbCys() {
		return nbCys;
	}

	public static void setNbCys(int nbCys) {
		Cysteine.nbCys = nbCys;
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

	public double getpKaNH3() {
		return pKaNH3;
	}

	public void setpKaNH3(double pKaNH3) {
		this.pKaNH3 = pKaNH3;
	}

	public double getpKaR() {
		return pKaR;
	}

	public void setpKaR(double pKaR) {
		this.pKaR = pKaR;
	}

	public String getSideChainProperty() {
		return sideChainProperty;
	}

	public void setSideChainProperty(String sideChainProperty) {
		this.sideChainProperty = sideChainProperty;
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

	public int getNbSufferAtom() {
		return nbSufferAtom;
	}

	public void setNbSufferAtom(int nbSufferAtom) {
		this.nbSufferAtom = nbSufferAtom;
	}

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}

	public void setNbHydrogenAtom(int nbHydrogenAtom) {
		this.nbHydrogenAtom = nbHydrogenAtom;
	}

}

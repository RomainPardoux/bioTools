package com.aminoAcid;

import com.sequence.AminoAcid;

public class PhenylAlanine extends AminoAcid{

	// Variable de classe
	private static int nbPhe = 0;
	
	// Variables d'instance
	private char syn1L = 'F';
	private String syn3L = "PHE";
	private String formuleBrute = "C9H11NO2";
	private int nbCarbonAtom = 9, nbHydrogenAtom = 11, nbAzoteAtom = 1, nbOxygenAtom = 2;
	private double masseMolaire = 165.1891;
	private double precisionMasseMolaire = 0.0088;
	private String[] codons = {"UUC", "UUU"};
	private  double pHIsoelectrique = 5.48;
	private double pKaCOOH = 2.18, pKaNH3 = 9.09;
	private String sideChainProperty = "hydrophobic";
	private String [] halfLife = {"1.1 hour", "3 min", "2 min"};
	private double hydropathie = 2.80;
	
	// Constructeur
	public PhenylAlanine() {
		nbPhe ++;
		initAa();
	}
	
	// InitClasseAA
	public void initAa(){
		super.setSyn1L(syn1L);
		super.setSyn3L(syn3L);
		super.setFormuleBrute(formuleBrute);
		super.setMasseMolaire(masseMolaire);
		super.setPrecisionMasseMolaire(precisionMasseMolaire);
		super.setCodons(codons);
		super.setpHIsoelectrique(pHIsoelectrique);
		super.setHalfLife(halfLife);
		super.setHydropathie(hydropathie);
	}

	// Getters and Setters
	public static int getNbPhe() {
		return nbPhe;
	}

	public static void setNbPhe(int nbPhe) {
		PhenylAlanine.nbPhe = nbPhe;
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

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public void setNbCarbonAtom(int nbCarbonAtom) {
		this.nbCarbonAtom = nbCarbonAtom;
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

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public void setNbOxygenAtom(int nbOxygenAtom) {
		this.nbOxygenAtom = nbOxygenAtom;
	}

}

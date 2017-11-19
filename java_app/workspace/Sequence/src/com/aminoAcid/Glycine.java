package com.aminoAcid;

import com.sequence.AminoAcid;

public class Glycine extends AminoAcid{

	
	// Variable de classe
	private static int nbGly = 0;
	
	// Variables d'instance
	private char syn1L = 'G';
	private String syn3L = "GLY";
	private String formuleBrute = "C2H5NO2";
	private int nbCarbonAtom = 2, nbHydrogenAtom = 5, nbAzoteAtom = 1, nbOxygenAtom = 2;
	private double masseMolaire = 75.0666;
	private double precisionMasseMolaire = 0.0028;
	private double solubilite = 225;
	private double masseVolumique = 1.607;
	private String[] codons = {"GGU", "GGC", "GGA", "GGG"};
	private  double pHIsoelectrique = 5.97;
	private double pKaCOOH = 2.34, pKaNH3 = 9.58;
	private String sideChainProperty = "special";
	
	// Constructeur
	public Glycine() {
		nbGly ++;
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
		super.setMasseVolumique(masseVolumique);
		super.setCodons(codons);
		super.setpHIsoelectrique(pHIsoelectrique);
	}

	// Getters and Setters
	public static int getNbGly() {
		return nbGly;
	}

	public static void setNbGly(int nbGly) {
		Glycine.nbGly = nbGly;
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

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public void setNbCarbonAtom(int nbCarbonAtom) {
		this.nbCarbonAtom = nbCarbonAtom;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}

	public void setNbAzoteAtom(int nbAzoteAtom) {
		this.nbAzoteAtom = nbAzoteAtom;
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

}

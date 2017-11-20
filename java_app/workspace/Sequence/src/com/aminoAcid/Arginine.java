package com.aminoAcid;

import com.sequence.AminoAcid;

public class Arginine extends AminoAcid{

	// Variable de classe
	private static int nbArg = 0;
	
	// Variables d'instance
	private char syn1L = 'R';
	private String syn3L = "ARG";
	private String formuleBrute = "C6H14N4O2";
	private int nbCarbonAtom = 6, nbHydrogenAtom = 14, nbAzoteAtom = 4, nbOxygenAtom = 2;
	private double masseMolaire = 174.201;
	private double precisionMasseMolaire = 0.0072;
	private double masseVolumique = 1.1;
	private String[] codons = {"AGA", "AGG", "CGU", "GCC", "CGA", "CGG"};
	private  double pHIsoelectrique = 10.76;
	private double pKaCOOH = 2.03, pKaNH3 = 9.0, pKaR = 12.10;
	private String sideChainProperty = "positive_charged";
	private String [] halfLife = {"1 hour", "2 min", "2 min"};
	private double hydropathie = - 4.50;
	
	// Constructeur
	public Arginine() {
		nbArg ++;
		initAa();
	}

	// InitClasseAA
	public void initAa(){
		super.setSyn1L(syn1L);
		super.setSyn3L(syn3L);
		super.setFormuleBrute(formuleBrute);
		super.setMasseMolaire(masseMolaire);
		super.setPrecisionMasseMolaire(precisionMasseMolaire);
		super.setMasseVolumique(masseVolumique);
		super.setCodons(codons);
		super.setpHIsoelectrique(pHIsoelectrique);
		super.setHalfLife(halfLife);
		super.setHydropathie(hydropathie);
	}
	
	// Getters and Setters
	public static int getNbArg() {
		return nbArg;
	}

	public static void setNbArg(int nbArg) {
		Arginine.nbArg = nbArg;
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

	public double getpKaCOOH() {
		return pKaCOOH;
	}

	public void setpKaCOOH(double pKaCOOH) {
		this.pKaCOOH = pKaCOOH;
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

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public void setNbOxygenAtom(int nbOxygenAtom) {
		this.nbOxygenAtom = nbOxygenAtom;
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

}

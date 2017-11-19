package com.aminoAcid;

import com.sequence.AminoAcid;

public class Selenocysteine extends AminoAcid{

	// Variable de classe
	private static int nbSec = 0;
	
	// Variables d'instance
	private char syn1L = 'U';
	private String syn3L = "SEC";
	private String formuleBrute = "C3H7NO2Se";
	private int nbCarbonAtom = 3, nbHydrogenAtom = 7, nbAzoteAtom = 1, nbOxygenAtom = 2, nbSelenoAtom = 1;
	private double masseMolaire = 168.05;
	private double precisionMasseMolaire = 0.03;
	private double solubilite = 166.5;
	private double masseVolumique = 1.4;
	private String[] codons = {"UGA"};
	private  double pHIsoelectrique = 5.47;
	private double pKaCOOH = 1.9, pKaNH3 = 10.0;
	private String sideChainProperty = "special";
	
	// Constructeur
	public Selenocysteine() {
		nbSec ++;
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
	public static int getNbSec() {
		return nbSec;
	}

	public static void setNbSec(int nbSec) {
		Selenocysteine.nbSec = nbSec;
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

	public int getNbSelenoAtom() {
		return nbSelenoAtom;
	}

	public void setNbSelenoAtom(int nbSelenoAtom) {
		this.nbSelenoAtom = nbSelenoAtom;
	}

}

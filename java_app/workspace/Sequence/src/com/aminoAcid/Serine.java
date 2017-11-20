package com.aminoAcid;

import com.sequence.AminoAcid;

public class Serine extends AminoAcid{

	// Variable de classe
	private static int nbSer = 0;
	
	// Variables d'instance
	private char syn1L = 'S';
	private String syn3L = "SER";
	private String formuleBrute = "C3H7NO3";
	private int nbCarbonAtom = 3, nbHydrogenAtom = 7, nbAzoteAtom = 1, nbOxygenAtom = 3;
	private double masseMolaire = 105.0926;
	private double precisionMasseMolaire = 0.004;
	private double solubilite = 364;
	private String[] codons = {"UCU", "UCA", "UCG", "UCC", "AGU", "AGC"};
	private  double pHIsoelectrique = 5.68;
	private double pKaCOOH = 2.13, pKaNH3 = 9.05;
	private String sideChainProperty = "polar_uncharged";
	private String [] halfLife = {"1.9 hour", ">20 hour", ">10 hour"};
	private double hydropathie = - 0.8;
	
	// Constructeur
	public Serine() {
		nbSer ++;
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
		super.setHalfLife(halfLife);
		super.setHydropathie(hydropathie);
	}
	
	// Getters and Setters
	public static int getNbSer() {
		return nbSer;
	}

	public static void setNbSer(int nbSer) {
		Serine.nbSer = nbSer;
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
}

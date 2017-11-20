package com.aminoAcid;

import com.sequence.AminoAcid;

public class Glutamine extends AminoAcid{


	// Variable de classe
	private static int nbGln = 0;
	
	// Variables d'instance
	private char syn1L = 'Q';
	private String syn3L = "GLN";
	private String formuleBrute = "C5H10N2O3";
	private int nbCarbonAtom = 5, nbHydrogenAtom = 10, nbAzoteAtom = 2, nbOxygenAtom = 3;
	private double masseMolaire = 146.1445;
	private double precisionMasseMolaire = 0.006;
	private String[] codons = {"CAG", "CAA"};
	private  double pHIsoelectrique = 5.65;
	private double pKaCOOH = 2.18, pKaNH3 = 9.0;
	private String sideChainProperty = "special";
	private String [] halfLife = {"0.8 hour", "10 min", ">10 hour"};
	private double hydropathie = - 3.50;
	
	// Constructeur
	public Glutamine() {
		nbGln ++;
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
	public static int getNbGln() {
		return nbGln;
	}

	public static void setNbGln(int nbGln) {
		Glutamine.nbGln = nbGln;
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

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}

	public void setNbHydrogenAtom(int nbHydrogenAtom) {
		this.nbHydrogenAtom = nbHydrogenAtom;
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

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public void setNbOxygenAtom(int nbOxygenAtom) {
		this.nbOxygenAtom = nbOxygenAtom;
	}
	
}

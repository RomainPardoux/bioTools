package com.aminoAcid;

import com.sequence.AminoAcid;

public class GlutamicAcid extends AminoAcid{

	// Variable de classe
	private static int nbGlu = 0;
	
	// Variables d'instance
	private char syn1L = 'E';
	private String syn3L = "GLU";
	private String formuleBrute = "C5H9NO4";
	private int nbCarbonAtom = 5, nbHydrogenAtom = 9, nbAzoteAtom = 1, nbOxygenAtom = 4;
	private double masseMolaire = 147.1293;
	private double precisionMasseMolaire = 0.006;
	private double masseVolumique = 1.538;
	private String[] codons = {"GAA", "GAG"};
	private  double pHIsoelectrique = 3.22;
	private double pKaCOOH = 2.16, pKaNH3 = 9.58, pKaR = 4.15;
	private String sideChainProperty = "negative_charged";
	
	// Constructeur
	public GlutamicAcid() {
		nbGlu ++;
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
	}
	
	// Getters and Setters
	public static int getNbGlu() {
		return nbGlu;
	}

	public static void setNbGlu(int nbGlu) {
		GlutamicAcid.nbGlu = nbGlu;
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

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public void setNbOxygenAtom(int nbOxygenAtom) {
		this.nbOxygenAtom = nbOxygenAtom;
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

}

package com.sequence;

public abstract class AminoAcid {

	// Variables d'instance
	private char syn1L;
	private String syn3L = "";
	private String formuleBrute = "";
	private int nbCarbonAtom = 3, nbHydrogenAtom = 0, nbAzoteAtom = 0, nbOxygenAtom = 0, nbSufferAtom = 0, nbSelenoAtom;
	private double masseMolaire = 0.0;
	private double precisionMasseMolaire = 0.0;
	private double solubilite = 0.0;
	private double masseVolumique = 0.0;
	private String[] codons;
	private  double pHIsoelectrique = 0.0;
	private double pKaCOOH = 0.0, pKaNH3 = 0.0, pKaR = 0.0;
	private String sideChainProperty = "";
	private int extinctionCoef = 0;
	
	// Constructeur
	public AminoAcid(char syn1l, String syn3l, String formuleBrute, double masseMolaire, double precisionMasseMolaire,
			double solubilite, double masseVolumique, String[] codons, double pHIsoelectrique) {
		super();
		syn1L = syn1l;
		syn3L = syn3l;
		this.formuleBrute = formuleBrute;
		this.masseMolaire = masseMolaire;
		this.precisionMasseMolaire = precisionMasseMolaire;
		this.solubilite = solubilite;
		this.masseVolumique = masseVolumique;
		this.codons = codons;
		this.pHIsoelectrique = pHIsoelectrique;
	}

	public AminoAcid() {}

	// Getters and Setters
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

	public String getSideChainProperty() {
		return sideChainProperty;
	}

	public void setSideChainProperty(String sideChainProperty) {
		this.sideChainProperty = sideChainProperty;
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

	public double getpKaNH3() {
		return pKaNH3;
	}

	public void setpKaNH3(double pKaNH3) {
		this.pKaNH3 = pKaNH3;
	}

	public int getNbSelenoAtom() {
		return nbSelenoAtom;
	}

	public void setNbSelenoAtom(int nbSelenoAtom) {
		this.nbSelenoAtom = nbSelenoAtom;
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

	public int getExtinctionCoef() {
		return extinctionCoef;
	}

	public void setExtinctionCoef(int extinctionCoef) {
		this.extinctionCoef = extinctionCoef;
	}	
}

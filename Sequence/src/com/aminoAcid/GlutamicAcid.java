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
	private SideChaineProperties sideChainProperty = SideChaineProperties.NEGATIVE_CHARGED;
	private String [] halfLife = {"1 hour", "30 min", ">10 hour"};
	private double hydropathie = - 3.50;
	
	// Constructeur
	public GlutamicAcid() {
		nbGlu ++;
	}
	
	// Getters and Setters
	

	public SideChaineProperties getSideChainProperty() {
		return sideChainProperty;
	}
	
	public static int getNbGlu() {
		return nbGlu;
	}

	public String[] getHalfLife() {
		return halfLife;
	}

	public double getHydropathie() {
		return hydropathie;
	}

	public char getSyn1L() {
		return syn1L;
	}

	public String getSyn3L() {
		return syn3L;
	}

	public String getFormuleBrute() {
		return formuleBrute;
	}

	public double getMasseMolaire() {
		return masseMolaire;
	}

	public double getPrecisionMasseMolaire() {
		return precisionMasseMolaire;
	}

	public double getMasseVolumique() {
		return masseVolumique;
	}

	public String[] getCodons() {
		return codons;
	}

	public double getpHIsoelectrique() {
		return pHIsoelectrique;
	}

	public double getpKaNH3() {
		return pKaNH3;
	}

	public double getpKaR() {
		return pKaR;
	}

	public double getpKaCOOH() {
		return pKaCOOH;
	}

	public int getNbOxygenAtom() {
		return nbOxygenAtom;
	}

	public int getNbCarbonAtom() {
		return nbCarbonAtom;
	}

	public int getNbAzoteAtom() {
		return nbAzoteAtom;
	}

	public int getNbHydrogenAtom() {
		return nbHydrogenAtom;
	}
}

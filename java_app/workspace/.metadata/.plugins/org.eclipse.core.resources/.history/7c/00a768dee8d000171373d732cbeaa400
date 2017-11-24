package com.sequence;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.aminoAcid.Alanine;
import com.aminoAcid.Arginine;
import com.aminoAcid.Asparagine;
import com.aminoAcid.AsparticAcid;
import com.aminoAcid.Cysteine;
import com.aminoAcid.GlutamicAcid;
import com.aminoAcid.Glutamine;
import com.aminoAcid.Glycine;
import com.aminoAcid.Histidine;
import com.aminoAcid.Isoleucine;
import com.aminoAcid.Leucine;
import com.aminoAcid.Lysine;
import com.aminoAcid.Methionine;
import com.aminoAcid.PhenylAlanine;
import com.aminoAcid.Proline;
import com.aminoAcid.Selenocysteine;
import com.aminoAcid.Serine;
import com.aminoAcid.Threonine;
import com.aminoAcid.Tryptophan;
import com.aminoAcid.Tyrosine;
import com.aminoAcid.Valine;

public class SequenceNucleique implements Sequence{

	/* Declaration des variables d'instance */
	private String sequence = "", nomSeq = "", typeSeq = "dna";
	private int nbMonomer = 0;
	private Double mW = 0.0; 
	private BigDecimal mWRound;
	private ArrayList<Nucleotid> nucleotidList;
	private Nucleotid nucleotid;
	/* Variable Atom */
	private int  nbCatom, nbNatom, nbOatom, nbSatom, nbHatom, nbAtom;
	
	/* Constructeurs */
	public SequenceNucleique() {	}

	public SequenceNucleique(String seq, String nom) {
		this.sequence = seq;
		this.nomSeq = nom;
		initConstructeur();
	}

	
	
	private void initConstructeur() {
		// TODO Auto-generated method stub
		
	}

	//Fonctions de classe
	//1. Fonctions generiques
	
	//1.1 Alimente la liste aminoAcidList ou nucleotidList
	@Override
	public void addMonomer(String seq) {
		seq = seq.toLowerCase();
		nucleotidList = new ArrayList<Nucleotid>();
		for (int i = 0; i < seq.length(); i++) {
			char nucleotid = seq.charAt(i);
			nucleotidList.add(new Nucleotid());
		} 
	}
	
	public SequenceNucleique(String seq) {
		this.sequence = seq;
		initConstructeur();
	}
	
	@Override
	public int countMonomer(ArrayList<AminoAcid> aminoAcidList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void countAtom(ArrayList<AminoAcid> aminoAcidList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double computeMW(ArrayList<AminoAcid> aminoAcidList) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.sequence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.aminoAcid.Serine;
import com.aminoAcid.Terminal;
import com.aminoAcid.Threonine;
import com.aminoAcid.Tryptophan;
import com.aminoAcid.Tyrosine;
import com.aminoAcid.Valine;
import com.nucleotid.Adenine;
import com.nucleotid.Cytosine;
import com.nucleotid.Guanine;
import com.nucleotid.Thymine;
import com.nucleotid.Uracile;

public class SequenceNucleique{

	/* Declaration des variables d'instance */
	private String sequence = "", nomSeq = "", typeSeq = "";
	private boolean isDna = false, isRna = false;
	private int nbMonomer = 0;
	private Double mwSsDna = 0.0, mwDsDna = 0.0, mwSsRna = 0.0; 
	private BigDecimal mwSsDnaRound, mwDsDnaRound, mwSsRnaRound;
	private ArrayList<Nucleotid> nucleotidList, nucleotidListReverse, nucleotidListComplement, nucleotidListReverseComplement;
	private ArrayList<AminoAcid> seqTranslate53F1, seqTranslate53F2, seqTranslate53F3, seqTranslate35F1, seqTranslate35F2, seqTranslate35F3;
	/* Variable Atom */
	private int  nbCatom, nbNatom, nbOatom, nbHatom, nbAtom, nbAde, nbThy, nbCyt, nbGua, nbUra;
	/* Code genetique */
	private HashMap<String, AminoAcid> mapCodeGene = new HashMap<String, AminoAcid>();

	/* Constructeurs */
	public SequenceNucleique() {}

	public SequenceNucleique(String seq, String nom) {
		this.sequence = seq;
		this.nomSeq = nom;
		initConstructeur();
	}

	public SequenceNucleique(String seq) {
		this.sequence = seq;
		initConstructeur();
	}

	//1. Fonctions de classe
	private void initConstructeur() {
		// TODO Auto-generated method stub
		DetermineType(sequence);
//		transcrit(sequence);
		initMapCodeGene();	
		addMonomer(sequence);
		countMonomer(nucleotidList);
		countNucleotid(nucleotidList);
		countAtom(nucleotidList);	
		computeMW(nucleotidList);
		complement(nucleotidList);
		reverse(nucleotidList);
		reverseComplement(nucleotidListReverse);
		translate(nucleotidList, nucleotidListReverseComplement);
	}

	//2. Determine le type ADN ou ARN
	private void DetermineType(String sequence) {
		String regexSeqDna = "^[aAtTcCgG]*$";
		String regexSeqRna = "^[aAuUcCgG]*$";
		if (sequence.matches(regexSeqDna)) {
			this.isDna = true;
			this.isRna = false;
			this.typeSeq = "dna";
		}
		if (sequence.matches(regexSeqRna)) {
			this.isDna = false;
			this.isRna = true;
			this.typeSeq = "rna";
		}
	}

	//3. Alimente la liste nucleotidList 
	public void addMonomer(String seq) {
		seq = seq.toLowerCase();
		nucleotidList = new ArrayList<Nucleotid>();
		for (int i = 0; i < seq.length(); i++) {
			char nucleotid = seq.charAt(i);
			switch (nucleotid) {
			case 'a':
				nucleotidList.add(new Adenine());	
				break;
			case 't':
				nucleotidList.add(new Thymine());	
				break;
			case 'c':
				nucleotidList.add(new Cytosine());
				break;
			case 'g':
				nucleotidList.add(new Guanine());
				break;
			case 'u':
				nucleotidList.add(new Uracile());
				break;
			} 
		}
	}

	//4. Compte le nombre de monomeres dans la liste
	private int countMonomer(ArrayList<Nucleotid> nucleotidList) {
		nbMonomer = nucleotidList.size();
		return nbMonomer;
	}

	//5. Compte le nombre d'atome dans la sequence
	private void countAtom(ArrayList<Nucleotid> nucleotidList) {
		int cAtomBuffer = 0;
		int nAtomBuffer = 0;
		int oAtomBuffer = 0;
		int hAtomBuffer = 0;
		int totAtomBuffer = 0;
		for (int i = 0; i <nucleotidList.size(); i++) {
			cAtomBuffer += nucleotidList.get(i).getNbCarbonAtom();
			nAtomBuffer += nucleotidList.get(i).getNbAzoteAtom();
			hAtomBuffer += nucleotidList.get(i).getNbHydrogenAtom();
			oAtomBuffer += nucleotidList.get(i).getNbOxygenAtom();
		}
		oAtomBuffer -= (nucleotidList.size() - 1);
		hAtomBuffer -= (2 * (nucleotidList.size() - 1));
		totAtomBuffer = cAtomBuffer + nAtomBuffer + oAtomBuffer + hAtomBuffer;
		this.nbAtom = totAtomBuffer;
		this.nbCatom = cAtomBuffer;
		this.nbNatom = nAtomBuffer;
		this.nbOatom = oAtomBuffer;
		this.nbHatom = hAtomBuffer;
	}

	//2.1 Compte le nbre d acide amine dans la sequence
	private void countNucleotid(ArrayList<Nucleotid> nucleotidList){
		for (int i = 0; i < nucleotidList.size(); i++) {
			switch (nucleotidList.get(i).getSyn1L()) {
			case 'A':
				this.nbAde ++;
				break;
			case 'G':
				this.nbGua ++;
				break;
			case 'T':
				this.nbThy ++;
				break;
			case 'C':
				this.nbCyt ++;
				break;
			case 'U':
				this.nbUra ++;
				break;
			}
		}
	}



	//6. Calcul le poids moleculaire de la sequence
	private void computeMW(ArrayList<Nucleotid> nucleotidList) {
		if(isDna){
			for (int i = 0; i < nucleotidList.size(); i++) {
				this.mwSsDna += nucleotidList.get(i).getMasseMolaire();
				this.mwDsDna += (nucleotidList.get(i).getMasseMolaire() * 2);
			}
			this.mwSsDna += 79;
			this.mwDsDna += 157.9;
		}
		if(isRna){
			for (int i = 0; i < nucleotidList.size(); i++) {
				this.mwSsRna += nucleotidList.get(i).getMasseMolaire();
			}
			this.mwSsRna += 157.9;
		}		
		this.mwSsDnaRound = (new BigDecimal(this.mwSsDna)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.mwSsRnaRound = (new BigDecimal(this.mwSsRna)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.mwDsDnaRound = (new BigDecimal(this.mwDsDna)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	//7. Reverse la sequence
	private ArrayList<Nucleotid> reverse (ArrayList<Nucleotid> nucleotidList) {
		this.nucleotidListReverse = new ArrayList<Nucleotid>();
		for (int i = nucleotidList.size() - 1; i >= 0 ; i--) {
			nucleotidListReverse.add(nucleotidList.get(i));
		}
		return nucleotidListReverse;
	}

	//8. Complement la sequence
	private ArrayList<Nucleotid> complement (ArrayList<Nucleotid> nucleotidList) {
		this.nucleotidListComplement = new ArrayList<Nucleotid>();
		for (int i = 0 ; i < nucleotidList.size() ; i++) {
			if (nucleotidList.get(i).getSyn3L().equals("ADE")){
				nucleotidListComplement.add(new Thymine());
			}else if (nucleotidList.get(i).getSyn3L().equals("CYT")){
				nucleotidListComplement.add(new Guanine());
			}else if (nucleotidList.get(i).getSyn3L().equals("GUA")){
				nucleotidListComplement.add(new Cytosine());
			}else if (nucleotidList.get(i).getSyn3L().equals("THY")){
				nucleotidListComplement.add(new Adenine());
			}else if (nucleotidList.get(i).getSyn3L().equals("URA")){
				nucleotidListComplement.add(new Adenine());
			}
		}
		return nucleotidListComplement;
	}

	//9. Reverse Complement la sequence
	private ArrayList<Nucleotid> reverseComplement (ArrayList<Nucleotid> nucleotidListReverse) {
		this.nucleotidListReverseComplement = new ArrayList<Nucleotid>();
		for (int i = 0 ; i < nucleotidListReverse.size() ; i++) {
			if (nucleotidListReverse.get(i).getSyn3L().equals("ADE")){
				nucleotidListReverseComplement.add(new Thymine());
			}else if (nucleotidListReverse.get(i).getSyn3L().equals("CYT")){
				nucleotidListReverseComplement.add(new Guanine());
			}else if (nucleotidListReverse.get(i).getSyn3L().equals("GUA")){
				nucleotidListReverseComplement.add(new Cytosine());
			}else if (nucleotidListReverse.get(i).getSyn3L().equals("THY")){
				nucleotidListReverseComplement.add(new Adenine());
			}else if (nucleotidListReverse.get(i).getSyn3L().equals("URA")){
				nucleotidListReverseComplement.add(new Adenine());
			}
		}
		return nucleotidListReverseComplement;
	}

	//10. Traduit la sequence
	private void translate (ArrayList<Nucleotid> nucleotidList, ArrayList<Nucleotid> nucleotidListReverseComplement) {
		String codon53F1 = "";
		String codon53F2 = "";
		String codon53F3 = "";
		String codon35F1 = "";
		String codon35F2 = "";
		String codon35F3 = "";
		seqTranslate53F1 = new ArrayList<AminoAcid>();
		seqTranslate35F2 = new ArrayList<AminoAcid>();
		seqTranslate35F3 = new ArrayList<AminoAcid>();
		seqTranslate35F1 = new ArrayList<AminoAcid>();
		seqTranslate53F2 = new ArrayList<AminoAcid>();
		seqTranslate53F3 = new ArrayList<AminoAcid>();
		for (int i = 0; ( i + 2 ) < nucleotidList.size(); i += 3) {
			codon53F1 = String.valueOf(nucleotidList.get(i).getSyn1L());
			codon53F1 += String.valueOf(nucleotidList.get(i + 1).getSyn1L());
			codon53F1 += String.valueOf(nucleotidList.get(i + 2).getSyn1L());
			codon53F1 = codon53F1.toLowerCase();
			codon53F1.replace('u', 't');
			seqTranslate53F1.add(mapCodeGene.get(codon53F1));
		}
		for (int i = 1; ( i + 2 ) < nucleotidList.size(); i += 3) {
			codon53F2 = String.valueOf(nucleotidList.get(i).getSyn1L());
			codon53F2 += String.valueOf(nucleotidList.get(i + 1).getSyn1L());
			codon53F2 += String.valueOf(nucleotidList.get(i + 2).getSyn1L());
			codon53F2 = codon53F2.toLowerCase();
			codon53F2.replace('u', 't');
			seqTranslate53F2.add(mapCodeGene.get(codon53F2));
		}
		for (int i = 2; ( i + 2 ) < nucleotidList.size(); i += 3) {
			codon53F3 = String.valueOf(nucleotidList.get(i).getSyn1L());
			codon53F3 += String.valueOf(nucleotidList.get(i + 1).getSyn1L());
			codon53F3 += String.valueOf(nucleotidList.get(i + 2).getSyn1L());
			codon53F3 = codon53F3.toLowerCase();
			codon53F3.replace('u', 't');
			seqTranslate53F3.add(mapCodeGene.get(codon53F3));
		}
		for (int i = 0; ( i + 2 ) < nucleotidListReverseComplement.size(); i += 3) {
			codon35F1 = String.valueOf(nucleotidListReverseComplement.get(i).getSyn1L());
			codon35F1 += String.valueOf(nucleotidListReverseComplement.get(i + 1).getSyn1L());
			codon35F1 += String.valueOf(nucleotidListReverseComplement.get(i + 2).getSyn1L());
			codon35F1 = codon35F1.toLowerCase();
			codon35F1.replace('u', 't');
			seqTranslate35F1.add(mapCodeGene.get(codon35F1));
		}
		for (int i = 1; ( i + 2 ) < nucleotidListReverseComplement.size(); i += 3) {
			codon35F2 = String.valueOf(nucleotidListReverseComplement.get(i).getSyn1L());
			codon35F2 += String.valueOf(nucleotidListReverseComplement.get(i + 1).getSyn1L());
			codon35F2 += String.valueOf(nucleotidListReverseComplement.get(i + 2).getSyn1L());
			codon35F2 = codon35F2.toLowerCase();
			codon35F2.replace('u', 't');
			seqTranslate35F2.add(mapCodeGene.get(codon35F2));
		}
		for (int i = 2; ( i + 2 ) < nucleotidListReverseComplement.size(); i += 3) {
			codon35F3 = String.valueOf(nucleotidListReverseComplement.get(i).getSyn1L());
			codon35F3 += String.valueOf(nucleotidListReverseComplement.get(i + 1).getSyn1L());
			codon35F3 += String.valueOf(nucleotidListReverseComplement.get(i + 2).getSyn1L());
			codon35F3 = codon35F3.toLowerCase();
			codon35F3.replace('u', 't');
			seqTranslate35F3.add(mapCodeGene.get(codon35F3));
		}
	}

	//11. Initialise la map du code genetique
	private void initMapCodeGene() {
		// TODO Auto-generated method stub
		mapCodeGene.put("ttt", new PhenylAlanine());
		mapCodeGene.put("ttc", new PhenylAlanine());
		mapCodeGene.put("tta", new Leucine());
		mapCodeGene.put("ttg", new Leucine());
		mapCodeGene.put("tct", new Serine());
		mapCodeGene.put("tcc", new Serine());
		mapCodeGene.put("tca", new Serine());
		mapCodeGene.put("tcg", new Serine());
		mapCodeGene.put("tat", new Tyrosine());
		mapCodeGene.put("tac", new Tyrosine());
		mapCodeGene.put("tgt", new Cysteine());
		mapCodeGene.put("tgc", new Cysteine());
		mapCodeGene.put("tgg", new Tryptophan());
		mapCodeGene.put("ctt", new Leucine());
		mapCodeGene.put("ctc", new Leucine());
		mapCodeGene.put("cta", new Leucine());
		mapCodeGene.put("ctg", new Leucine());
		mapCodeGene.put("cct", new Proline());
		mapCodeGene.put("cca", new Proline());
		mapCodeGene.put("ccg", new Proline());
		mapCodeGene.put("ccc", new Proline());
		mapCodeGene.put("cat", new Histidine());
		mapCodeGene.put("cac", new Histidine());
		mapCodeGene.put("caa", new Glutamine());
		mapCodeGene.put("cag", new Glutamine());
		mapCodeGene.put("cgt", new Arginine());
		mapCodeGene.put("cga", new Arginine());
		mapCodeGene.put("cgc", new Arginine());
		mapCodeGene.put("cgg", new Arginine());
		mapCodeGene.put("att", new Isoleucine());
		mapCodeGene.put("atc", new Isoleucine());
		mapCodeGene.put("ata", new Isoleucine());
		mapCodeGene.put("atg", new Methionine());
		mapCodeGene.put("aca", new Threonine());
		mapCodeGene.put("act", new Threonine());
		mapCodeGene.put("acc", new Threonine());
		mapCodeGene.put("acg", new Threonine());
		mapCodeGene.put("aat", new Asparagine());
		mapCodeGene.put("aac", new Asparagine());
		mapCodeGene.put("aaa", new Lysine());
		mapCodeGene.put("aag", new Lysine());
		mapCodeGene.put("agt", new Serine());
		mapCodeGene.put("agc", new Serine());
		mapCodeGene.put("aga", new Arginine());
		mapCodeGene.put("agg", new Arginine());
		mapCodeGene.put("gta", new Valine());
		mapCodeGene.put("gtc", new Valine());
		mapCodeGene.put("gtg", new Valine());
		mapCodeGene.put("gtt", new Valine());
		mapCodeGene.put("gca", new Alanine());
		mapCodeGene.put("gct", new Alanine());
		mapCodeGene.put("gcc", new Alanine());
		mapCodeGene.put("gcg", new Alanine());
		mapCodeGene.put("gat", new AsparticAcid());
		mapCodeGene.put("gac", new AsparticAcid());
		mapCodeGene.put("gaa", new GlutamicAcid());
		mapCodeGene.put("gag", new GlutamicAcid());
		mapCodeGene.put("gga", new Glycine());
		mapCodeGene.put("ggg", new Glycine());
		mapCodeGene.put("ggc", new Glycine());
		mapCodeGene.put("ggt", new Glycine());
		mapCodeGene.put("taa", new Terminal());
		mapCodeGene.put("tag", new Terminal());
		mapCodeGene.put("tga", new Terminal());
	}

	//12. Renvoi la seq proteique reformater
	public String formateSeq(ArrayList<AminoAcid> aminoAcidList){
		String formatedSeq = "";
		for (int i = 0; i < aminoAcidList.size(); i++) {
			formatedSeq += aminoAcidList.get(i).getSyn1L();
		}
		return formatedSeq;
	}

	//Transcription de la sequence
	private String transcrit(String seq){
		if (this.isRna) {
			this.sequence = seq.replace('u', 't');
			this.isDna = true;
			this.isRna = false;
			this.typeSeq = "dna";
		}
		return this.sequence;
	}
	
	//Methode generique to string
	@Override
	public String toString() {
		String msgDynamique = "";
		if(isDna){
			msgDynamique = "\n\nMolecular weight for dsDNA (MW): " + mwDsDnaRound + " g/mol ";
			msgDynamique += "\nMolecular weight for ssDNA (MW): " + mwSsDnaRound + " g/mol ";	
		}else if(isRna){
			msgDynamique = "\n\nMolecular weight for ssRNA (MW): " + mwSsRnaRound + " g/mol ";		
		}
		
		return "-----------------------------------------------------------------------------------" +
				"\n\nSequence name: " + nomSeq + 
				"\n\nType of sequence: " + typeSeq + 
				"\n\nNumber of nucleotids: " + nbMonomer +
				"\n\nMolecular weigth:" + msgDynamique +
				"\n\nTranslate: " + 
				"\n\n3'5' Frame 1" + "\n" + formateSeq(seqTranslate53F1) +
				"\n\n3'5' Frame 2" + "\n" + formateSeq(seqTranslate53F2) +
				"\n\n3'5' Frame 3" + "\n" + formateSeq(seqTranslate53F3) +
				"\n\n5'3' Frame 1" + "\n" + formateSeq(seqTranslate35F1) +
				"\n\n5'3' Frame 2" + "\n" + formateSeq(seqTranslate35F2) +
				"\n\n5'3' Frame 3" + "\n" + formateSeq(seqTranslate35F3) +
				"\n\n---------------------------------------------------------------------------------";
	}


	//
	//	//Reverse Transcription de la sequence
	//	private String reverseTranscrit(String seq){
	//		if (this.isRna) {
	//			sequence = seq.replace('t', 'u');
	//			this.isDna = false;
	//			this.isRna = true;
	//			this.typeSeq = "rna";
	//		}
	//		return sequence;
	//	}

	// getters and setters
	public String getSequence() {
		return sequence;
	}

	public String getNomSeq() {
		return nomSeq;
	}

	public String getTypeSeq() {
		return typeSeq;
	}

	public int getNbMonomer() {
		return nbMonomer;
	}


	public Double getMwSsDna() {
		return mwSsDna;
	}

	public Double getMwDsDna() {
		return mwDsDna;
	}

	public Double getMwSsRna() {
		return mwSsRna;
	}

	public ArrayList<Nucleotid> getNucleotidList() {
		return nucleotidList;
	}

	public ArrayList<Nucleotid> getNucleotidListReverse() {
		return nucleotidListReverse;
	}

	public ArrayList<Nucleotid> getNucleotidListComplement() {
		return nucleotidListComplement;
	}

	public ArrayList<Nucleotid> getNucleotidListReverseComplement() {
		return nucleotidListReverseComplement;
	}

	public ArrayList<AminoAcid> getSeqTranslate53F1() {
		return seqTranslate53F1;
	}

	public ArrayList<AminoAcid> getSeqTranslate53F2() {
		return seqTranslate53F2;
	}

	public ArrayList<AminoAcid> getSeqTranslate53F3() {
		return seqTranslate53F3;
	}

	public ArrayList<AminoAcid> getSeqTranslate35F1() {
		return seqTranslate35F1;
	}

	public ArrayList<AminoAcid> getSeqTranslate35F2() {
		return seqTranslate35F2;
	}

	public ArrayList<AminoAcid> getSeqTranslate35F3() {
		return seqTranslate35F3;
	}

	public int getNbCatom() {
		return nbCatom;
	}

	public int getNbNatom() {
		return nbNatom;
	}

	public int getNbOatom() {
		return nbOatom;
	}

	public int getNbHatom() {
		return nbHatom;
	}

	public int getNbAtom() {
		return nbAtom;
	}

	public boolean isDna() {
		return isDna;
	}

	public boolean isRna() {
		return isRna;
	}

	public BigDecimal getMwSsDnaRound() {
		return mwSsDnaRound;
	}

	public BigDecimal getMwDsDnaRound() {
		return mwDsDnaRound;
	}

	public BigDecimal getMwSsRnaRound() {
		return mwSsRnaRound;
	}

	public int getNbAde() {
		return nbAde;
	}

	public int getNbThy() {
		return nbThy;
	}

	public int getNbCyt() {
		return nbCyt;
	}

	public int getNbGua() {
		return nbGua;
	}

	public int getNbUra() {
		return nbUra;
	}
}

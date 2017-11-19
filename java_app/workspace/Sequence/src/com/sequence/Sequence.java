package com.sequence;
import java.math.BigDecimal;
import java.util.ArrayList;
import com.aminoAcid.*;

public final class Sequence {

	/* Declaration des variables d'instance */
	private String sequence = "", nomSeq = "", typeSeq = "", formule = "";
	private String [] halfLife = {"","",""};
	private int nbMonomer = 0, extCoef, extCoefWithoutCys;
	private Double mW = 0.0, pHI = 0.0, abs01Perc, abs01PercWithoutCys, aliphIndex; 
	private BigDecimal mWRound, pHIRound, abs01PercRound, abs01PercWithoutCysRound, aliphIndexRound;
	protected ArrayList<AminoAcid> aminoAcidList;
	protected AminoAcid aminoAcid;
	protected ArrayList<Nucleotid> nucleotidList;
	protected Nucleotid nucleotid;
	/* Variable Amino Acid */
	private int nbAla, nbArg, nbAsn, nbAsp, nbCys, nbGlu, nbGln, nbGly, nbHis,
	nbIso, nbLeu, nbLys, nbMet, nbPhe, nbPro, nbSec, nbSer, nbThr, nbTrp, nbTyr, nbVal, 
	nbPositiveAA, nbNegativeAA, nbCatom, nbNatom, nbOatom, nbSatom, nbSeAtom, nbHatom, nbAtom;

	/* Constructeurs */
	public Sequence() {	}

	public Sequence(String seq, String nom) {
		this.sequence = seq;
		this.nomSeq = nom;
		ctrlTypeSeq(sequence);
		addMonomer(sequence);
		this.nbMonomer = countMonomer(aminoAcidList);
		countAminoAcid(aminoAcidList);
		this.mW = computeMW(aminoAcidList);
		this.mWRound = (new BigDecimal(this.mW)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.pHI = computePHI(aminoAcidList);
		this.pHIRound = (new BigDecimal(this.pHI)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.countChargedAminoAcid(aminoAcidList);
		this.countAtom(aminoAcidList);
		this.setExtCoef(computeExtinctionCoef(aminoAcidList));
		this.setExtCoefWithoutCys(computeExtinctionCoefWithoutCys(aminoAcidList));
		this.abs01Perc = computeAbs01Perc(aminoAcidList);
		this.abs01PercRound = (new BigDecimal(this.abs01Perc)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.abs01PercWithoutCys = computeAbs01PercWithoutCys(aminoAcidList);
		this.abs01PercWithoutCysRound = (new BigDecimal(this.abs01PercWithoutCys)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.aliphIndex = computeAliphaticIndex(aminoAcidList);
		this.aliphIndexRound = (new BigDecimal(this.aliphIndex)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.setHalfLife(getHalfLife(aminoAcidList));
	}



	public Sequence(String seq) {
		this.sequence = seq;
		ctrlTypeSeq(sequence);
		addMonomer(sequence);
		this.nbMonomer = countMonomer(aminoAcidList);
		countAminoAcid(aminoAcidList);
		this.mW = computeMW(aminoAcidList);
		this.mWRound = (new BigDecimal(this.mW)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.pHI = computePHI(aminoAcidList);
		this.pHIRound = (new BigDecimal(this.pHI)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.countChargedAminoAcid(aminoAcidList);
		this.countAtom(aminoAcidList);
		this.setExtCoef(computeExtinctionCoef(aminoAcidList));
		this.setExtCoefWithoutCys(computeExtinctionCoefWithoutCys(aminoAcidList));
		this.abs01Perc = computeAbs01Perc(aminoAcidList);
		this.abs01PercRound = (new BigDecimal(this.abs01Perc)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.abs01PercWithoutCys = computeAbs01PercWithoutCys(aminoAcidList);
		this.abs01PercWithoutCysRound = (new BigDecimal(this.abs01PercWithoutCys)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.aliphIndex = computeAliphaticIndex(aminoAcidList);
		this.aliphIndexRound = (new BigDecimal(this.aliphIndex)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.setHalfLife(getHalfLife(aminoAcidList));
	}

	//Fonctions de classe
	//1. Fonctions generiques
	//1.1 Controle du type de la sequence (protein, dna or undifinied)
	public void ctrlTypeSeq(String seq){
		// ctrl regex
		String regexSeqProt = "^([ ]*)?[mM][RrHhKkDdEeSsTtNnQqCcUuGgPpAaVvIiLlMmFfYyWw]*$";
		String regexSeqDna = "^[aAtTcCgGuU]*$";
		if ( seq.matches(regexSeqProt)){
			typeSeq = "protein";
		}
		else if ( seq.matches(regexSeqDna)){
			typeSeq = "dna";
		} else {
			typeSeq = "undefined";
		}
	}
	
	//1.2 Alimente la liste aminoAcidList ou nucleotidList
	public void addMonomer(String seq){
		seq = seq.toLowerCase();
		if(typeSeq.equals("protein")){
			aminoAcidList = new ArrayList<AminoAcid>();
			for (int i = 0; i < seq.length(); i++) {
				char aminoAcid = seq.charAt(i);
				switch (aminoAcid) {
				case 'a':
					aminoAcidList.add(new Alanine());	
					break;
				case 'v':
					aminoAcidList.add(new Valine());	
					break;
				case 'i':
					aminoAcidList.add(new Isoleucine());	
					break;
				case 'l':
					aminoAcidList.add(new Leucine());	
					break;
				case 'm':
					aminoAcidList.add(new Methionine());	
					break;
				case 'f':
					aminoAcidList.add(new PhenylAlanine());	
					break;
				case 'y':
					aminoAcidList.add(new Tyrosine());	
					break;
				case 'w':
					aminoAcidList.add(new Tryptophan());	
					break;
				case 's':
					aminoAcidList.add(new Serine());	
					break;
				case 't':
					aminoAcidList.add(new Threonine());	
					break;
				case 'n':
					aminoAcidList.add(new Asparagine());	
					break;
				case 'q':
					aminoAcidList.add(new Glutamine());	
					break;
				case 'c':
					aminoAcidList.add(new Cysteine());	
					break;
				case 'u':
					aminoAcidList.add(new Selenocysteine());	
					break;
				case 'g':
					aminoAcidList.add(new Glycine());	
					break;
				case 'p':
					aminoAcidList.add(new Proline());	
					break;
				case 'r':
					aminoAcidList.add(new Arginine());	
					break;
				case 'h':
					aminoAcidList.add(new Histidine());	
					break;
				case 'k':
					aminoAcidList.add(new Lysine());	
					break;
				case 'd':
					aminoAcidList.add(new AsparticAcid());	
					break;
				case 'e':
					aminoAcidList.add(new GlutamicAcid());	
					break;
				default:
					break;
				}
			}
		} else if(typeSeq.equals("dna")){
			nucleotidList = new ArrayList<Nucleotid>();
			for (int i = 0; i < seq.length(); i++) {
				char nucleotid = seq.charAt(i);
				nucleotidList.add(new Nucleotid(nucleotid));
			} 
		}
		else {
			System.out.println("Une erreure s'est produite ...");
		}
	}

	//1.3 Compte le nbre de monomere dans la sequence
	public int countMonomer(ArrayList<AminoAcid> aminoAcidList){
		nbMonomer = aminoAcidList.size();
		return nbMonomer;
	}
	
	//2. Fonctions propre a l analyse proteique
	//2.1 Compte le nbre d acide amine dans la sequence
	public void countAminoAcid(ArrayList<AminoAcid> aminoAcidList){
		for (int i = 0; i < aminoAcidList.size(); i++) {
			switch (aminoAcidList.get(i).getSyn1L()) {
			case 'A':
				this.nbAla ++;
				break;
			case 'V':
				this.nbVal ++;
				break;
			case 'I':
				this.nbIso ++;
				break;
			case 'L':
				this.nbLeu ++;
				break;
			case 'M':
				this.nbMet ++;
				break;
			case 'F':
				this.nbPhe ++;
				break;
			case 'Y':
				this.nbTyr ++;
				break;
			case 'W':
				this.nbTrp ++;
				break;
			case 'S':
				this.nbSer ++;
				break;
			case 'T':
				this.nbThr ++;
				break;
			case 'N':
				this.nbAsn ++;
				break;
			case 'Q':
				this.nbGln ++;
				break;
			case 'C':
				this.nbCys ++;
				break;
			case 'U':
				this.nbSec ++;
				break;
			case 'G':
				this.nbGly ++;
				break;
			case 'P':
				this.nbPro ++;
				break;
			case 'R':
				this.nbArg ++;
				break;
			case 'H':
				this.nbHis ++;
				break;
			case 'K':
				this.nbLys ++;
				break;
			case 'D':
				this.nbAsp ++;
				break;
			case 'E':
				this.nbGlu ++;
				break;
			default:
				break;
			}
		}
	}

	//2.2 Compte le nbre d aa charger dans la sequence
	public void countChargedAminoAcid(ArrayList<AminoAcid> aminoAcidList){
		for (int i = 0; i <aminoAcidList.size(); i++) {
			if (aminoAcidList.get(i).getSideChainProperty().equals("positive_charged")) {
				this.nbPositiveAA ++;
			}else if (aminoAcidList.get(i).getSideChainProperty().equals("negative_charged")) {
				this.nbNegativeAA ++;
			}
		}
	}
	
	//2.3 Compte le nombre d'atome dans la sequence proteique
	public void countAtom(ArrayList<AminoAcid> aminoAcidList){
		int cAtomBuffer = 0;
		int nAtomBuffer = 0;
		int oAtomBuffer = 0;
		int hAtomBuffer = 0;
		int sAtomBuffer = 0;
		int seAtomBuffer = 0;
		int totAtomBuffer = 0;
		for (int i = 0; i <aminoAcidList.size(); i++) {
			cAtomBuffer += aminoAcidList.get(i).getNbCarbonAtom();
			nAtomBuffer += aminoAcidList.get(i).getNbAzoteAtom();
			hAtomBuffer += aminoAcidList.get(i).getNbHydrogenAtom();
			oAtomBuffer += aminoAcidList.get(i).getNbOxygenAtom();
			sAtomBuffer += aminoAcidList.get(i).getNbSufferAtom();
			seAtomBuffer += aminoAcidList.get(i).getNbSelenoAtom();
		}
		oAtomBuffer -= (aminoAcidList.size() - 1);
		hAtomBuffer -= (2 * (aminoAcidList.size() - 1));
		totAtomBuffer = cAtomBuffer + nAtomBuffer + oAtomBuffer + hAtomBuffer + sAtomBuffer + seAtomBuffer;
		this.setNbAtom(totAtomBuffer);
		this.setNbCatom(cAtomBuffer);
		this.setNbNatom(nAtomBuffer);
		this.setNbOatom(oAtomBuffer);
		this.setNbHatom(hAtomBuffer);
		this.setNbSatom(sAtomBuffer);
		this.setNbSeAtom(seAtomBuffer);
	}
	
	//2.4 Calcul le poid moleculaire de la sequence proteique
	public Double computeMW(ArrayList<AminoAcid> aminoAcidList){
		Double MWTotal = 0.0;
		Double MW = 0.0;
		for (int i = 0; i < aminoAcidList.size(); i++) {
			MW = aminoAcidList.get(i).getMasseMolaire();
			MWTotal += MW;
		}
		MWTotal = MWTotal - ((aminoAcidList.size() - 1) * 18.01528);
		return MWTotal;
	}

	//2.5 Calcul le pHI de la seq proteique
	public Double computePHI(ArrayList<AminoAcid> aminoAcidList){
		Double pHI = 0.0;
		ArrayList<Double> listPKa = new ArrayList<Double>();
		int cptrPositiveCharge = 0; 
		Double pKaBas = 0.0;
		Double pKaHaut = 0.0;
		// alimente une liste en pKa dans l'ordre croissant
		listPKa.add(aminoAcidList.get(0).getpKaNH3());
		listPKa.add(aminoAcidList.get(aminoAcidList.size()-1).getpKaCOOH());
		for (int i = 0; i < aminoAcidList.size(); i++) {
			if (aminoAcidList.get(i).getSideChainProperty().equals("positive_charged")) {
				listPKa.add(aminoAcidList.get(i).getpKaR());
				cptrPositiveCharge++;
			}
			if (aminoAcidList.get(i).getSideChainProperty().equals("negative_charged")) {
				listPKa.add(aminoAcidList.get(i).getpKaR());
			}
		}
		listPKa.sort(null);
		// Recupere le pka haut et bas et fait une moyenne
		pKaBas = listPKa.get(cptrPositiveCharge);
		pKaHaut = listPKa.get(cptrPositiveCharge + 1);
		pHI = (pKaBas + pKaHaut) / 2;
		pHIRound = (new BigDecimal(pHI)).setScale(2, BigDecimal.ROUND_HALF_UP);
		return pHI;
	}
	
	//2.6 Calcul le coefficiant d'extinction molaire de la proteine
	public int computeExtinctionCoef(ArrayList<AminoAcid> aminoAcidList){
		int cem = 0;
		for (int i = 0; i < aminoAcidList.size(); i++) {
			if( aminoAcidList.get(i).getSyn1L() == 'W'){
				cem += aminoAcidList.get(i).getExtinctionCoef();
			}
			if( aminoAcidList.get(i).getSyn1L() == 'Y'){
				cem += aminoAcidList.get(i).getExtinctionCoef();
			}
			if( aminoAcidList.get(i).getSyn1L() == 'C'){
				cem += aminoAcidList.get(i).getExtinctionCoef();
			}
		}
		return cem;
	}

	//2.7 Calcul le coefficiant d'extinction molaire de la proteine sans prendre en compte les cysteines
	public int computeExtinctionCoefWithoutCys(ArrayList<AminoAcid> aminoAcidList){
		int cem = (getNbTyr() * 1280) + (getNbTrp() * 5690);
		return cem;
	}
	
	//2.8 Calcul l'aborbance � 0.1 pourcent de proteine
	public Double computeAbs01Perc(ArrayList<AminoAcid> aminoAcidList){
		int cem = computeExtinctionCoef(aminoAcidList);
		Double mw = computeMW(aminoAcidList);
		Double abs01Perc = (double)cem / mw;
		return abs01Perc;
	}
	
	//2.9 Calcul l'aborbance � 0.1 pourcent de proteine sans prendre en compte les cysteines
	public Double computeAbs01PercWithoutCys(ArrayList<AminoAcid> aminoAcidList){
		int cem = computeExtinctionCoefWithoutCys(aminoAcidList);
		Double mw = computeMW(aminoAcidList);
		Double abs01Perc = (double)cem / mw;
		return abs01Perc;
	}
	
	//2.10 Calcul l'index aliphatique de la proteine
	/*Detail du calcul: p(ala) + 2.9 * p(val) + 3.9 * ( p(ile) + p(leu) ) */
	public Double computeAliphaticIndex(ArrayList<AminoAcid> aminoAcidList){
		Double alpihIndex = ((double)(this.getNbAla() * 100) / (double)this.getNbMonomer()) 
							+ 2.9 * ((double)(this.getNbVal() * 100) / (double)this.getNbMonomer()) 
							+ 3.9 * ((double)((this.getNbIso() * 100) / (double)this.getNbMonomer()) 
							+ ((double)(this.getNbLeu() * 100) / (double)this.getNbMonomer()));
		return alpihIndex;
	}
	
	//2.11 Determine le In vivo half life de la proteine
	public String [] getHalfLife(ArrayList<AminoAcid> aminoAcidList) {
		this.halfLife = aminoAcidList.get(0).getHalfLife();
		return halfLife;
	}
	
	//2.11 Renvoie le nombre d'acide amin� rens�gn� en parametre
	public int getNbAa(char aA){
		switch (aA) {
		case 'A':
			return this.nbAla ;
		case 'V':
			return this.nbVal ;

		case 'I':
			return this.nbIso ;

		case 'L':
			return this.nbLeu ;

		case 'M':
			return this.nbMet ;

		case 'F':
			return this.nbPhe ;

		case 'Y':
			return this.nbTyr ;

		case 'W':
			return this.nbTrp ;

		case 'S':
			return this.nbSer ;

		case 'T':
			return this.nbThr ;

		case 'N':
			return this.nbAsn ;

		case 'Q':
			return this.nbGln ;

		case 'C':
			return this.nbCys ;

		case 'U':
			return this.nbSec ;

		case 'G':
			return this.nbGly ;

		case 'P':
			return this.nbPro ;

		case 'R':
			return this.nbArg ;

		case 'H':
			return this.nbHis ;

		case 'K':
			return this.nbLys ;

		case 'D':
			return this.nbAsp ;

		case 'E':
			return this.nbGlu;

		default:
			return 0;

		}
	}

	//2.12 Renvoi la seq proteique reformater
	public String formateSeq(ArrayList<AminoAcid> aminoAcidList){
		String formatedSeq = "";
		for (int i = 0; i < aminoAcidList.size(); i++) {
			formatedSeq += aminoAcidList.get(i).getSyn1L();
		}
		return formatedSeq;
	}

	//2.13 Renvoi une description de la composition de la seq en acide amine
	public String describeAminoAcidComposition(ArrayList<AminoAcid> aminoAcidList){
		String aAComposition = "";
		ArrayList<String> aminAc = new ArrayList<String>();
		boolean doublon = false;
		Double pourcAa = 0.0;
		for (int i = 0; i < aminoAcidList.size(); i++) {
			for (int j = 0; j < aminAc.size(); j++) {
				if(aminAc.get(j).equals(aminoAcidList.get(i).getSyn3L())){
					doublon = true;
					break;
				}
			}
			aminAc.add(aminoAcidList.get(i).getSyn3L());
			if(!doublon){
				pourcAa =  ((double)(this.getNbAa(aminoAcidList.get(i).getSyn1L()) * 100) / (double)this.nbMonomer);
				BigDecimal pourcAaRound = (new BigDecimal(pourcAa)).setScale(2, BigDecimal.ROUND_HALF_UP);
				aAComposition += "\n" + aminoAcidList.get(i).getSyn3L()
						+ "  (" + aminoAcidList.get(i).getSyn1L() + ")  "
						+ getNbAa(aminoAcidList.get(i).getSyn1L())
						+ "  " + pourcAaRound + " % "
						+ "  " + aminoAcidList.get(i).getFormuleBrute();

			}
			doublon = false;
		}
		return aAComposition;

	}

	@Override
	public String toString() {
		String msgWithoutTrpOrTyr = "";
		String msgExtCoefWithoutCys = "";
		String msgAbsWithoutCys = "";
		if(getNbTrp() == 0){
			msgWithoutTrpOrTyr = "\n\nThis protein does not contain any Trp residues. Experience shows that "
					+ "this could result in more than 10% error in the computed extinction coefficient.";
			if(getNbTyr() == 0){
				msgWithoutTrpOrTyr = "\n\nAs there are no Trp, Tyr or Cys in the region considered, your protein should not be visible by UV spectrophotometry.";
			}
		} 
		if(getNbCys() != 0){
			msgExtCoefWithoutCys = "\nExt. Coefficient (Without Cystein) :   " + this.getExtCoefWithoutCys();
			msgAbsWithoutCys = "\nAbs 0.1% (=1 g/l) (Without Cystein)     " + this.getAbs01PercWithoutCysRound();
		}
		return "-----------------------------------------------------------------------------------" +
				"\n\nSequence name: " + nomSeq + 
				"\n\nUser-provided Sequence: " + formateSeq(aminoAcidList) +
				"\n\nType of sequence: " + typeSeq + 
				"\n\nNumber of amino acids: " + nbMonomer +
				"\n\nMolecular weight (MW): " + mWRound + " g/mol " + 
				"\n\nTheoretical pI: " + pHIRound +
				"\n\nAmino Acid Composition: \n" + describeAminoAcidComposition(aminoAcidList) + "\n" +
				"\n\nTotal number of negatively charged residues (Asp + Glu):     " + this.getNbNegativeAA() +
				"\nTotal number of positively charged residues (Arg + Lys + His): " + this.getNbPositiveAA() +
				"\n\nAomic Composition: " +
				"\n\nCarbon       C        " + getNbCatom() +
				"\nHydrogen     H        " + getNbHatom() +
				"\nNitrogen     N        " + getNbNatom() +
				"\nOxygen       O        " + getNbOatom() +
				"\nSulfur       S        " + getNbSatom() +
				"\n\nFormula: " + getFormule() +
				"\nTotal number of atoms: " + getNbAtom() +
				"\n\nExtinction coefficients: " + msgWithoutTrpOrTyr 
				+ "\n\nExtinction coefficients are in units of  M-1 cm-1, at 280 nm measured in water." 
				+ "\n\nExt. Coefficient :                     " + this.getExtCoef() +
				msgExtCoefWithoutCys +
				"\n\nAbs 0.1% (=1 g/l)                       " + this.getAbs01PercRound()
				 + msgAbsWithoutCys +
				 "\n\nEstimated halph-life: " +
				 "\n\nThe N-terminal of the sequence considered is " + aminoAcidList.get(0).getSyn1L() + " (" + aminoAcidList.get(0).getSyn3L() + "). " + 
				 "\nThe estimated half-life is: " + getHalfLife(aminoAcidList)[0] + " (mammalian reticulocytes, in vitro)." +
				 "\n                            " + getHalfLife(aminoAcidList)[1] + " (yeast, in vivo)." +
				 "\n                            " + getHalfLife(aminoAcidList)[2] + " (Escherichia coli, in vivo)." +
				 "\n\nAliphatic index:  " + getAliphIndexRound() +
				"\n\n---------------------------------------------------------------------------------";
	}

	//Getters and Setters
	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getNomSeq() {
		return nomSeq;
	}

	public void setNomSeq(String nomSeq) {
		this.nomSeq = nomSeq;
	}

	public String getTypeSeq() {
		return typeSeq;
	}

	public void setTypeSeq(String typeSeq) {
		this.typeSeq = typeSeq;
	}

	public ArrayList<AminoAcid> getAminoAcidList() {
		return aminoAcidList;
	}

	public void setAminoAcidList(ArrayList<AminoAcid> aminoAcidList) {
		this.aminoAcidList = aminoAcidList;
	}

	public ArrayList<Nucleotid> getNucleotidList() {
		return nucleotidList;
	}

	public void setNucleotidList(ArrayList<Nucleotid> nucleotidList) {
		this.nucleotidList = nucleotidList;
	}

	public Double getmW() {
		return mW;
	}

	public void setmW(Double mW) {
		this.mW = mW;
	}

	public int getNbMonomer() {
		return nbMonomer;
	}

	public void setNbMonomer(int nbMonomer) {
		this.nbMonomer = nbMonomer;
	}

	public int getNbAla() {
		return nbAla;
	}

	public void setNbAla(int nbAla) {
		this.nbAla = nbAla;
	}

	public int getNbArg() {
		return nbArg;
	}

	public void setNbArg(int nbArg) {
		this.nbArg = nbArg;
	}

	public int getNbAsn() {
		return nbAsn;
	}

	public void setNbAsn(int nbAsn) {
		this.nbAsn = nbAsn;
	}

	public int getNbAsp() {
		return nbAsp;
	}

	public void setNbAsp(int nbAsp) {
		this.nbAsp = nbAsp;
	}

	public int getNbCys() {
		return nbCys;
	}

	public void setNbCys(int nbCys) {
		this.nbCys = nbCys;
	}

	public int getNbGlu() {
		return nbGlu;
	}

	public void setNbGlu(int nbGlu) {
		this.nbGlu = nbGlu;
	}

	public int getNbGln() {
		return nbGln;
	}

	public void setNbGln(int nbGln) {
		this.nbGln = nbGln;
	}

	public int getNbGly() {
		return nbGly;
	}

	public void setNbGly(int nbGly) {
		this.nbGly = nbGly;
	}

	public int getNbHis() {
		return nbHis;
	}

	public void setNbHis(int nbHis) {
		this.nbHis = nbHis;
	}

	public int getNbIso() {
		return nbIso;
	}

	public void setNbIso(int nbIso) {
		this.nbIso = nbIso;
	}

	public int getNbLeu() {
		return nbLeu;
	}

	public void setNbLeu(int nbLeu) {
		this.nbLeu = nbLeu;
	}

	public int getNbLys() {
		return nbLys;
	}

	public void setNbLys(int nbLys) {
		this.nbLys = nbLys;
	}

	public int getNbMet() {
		return nbMet;
	}

	public void setNbMet(int nbMet) {
		this.nbMet = nbMet;
	}

	public int getNbPhe() {
		return nbPhe;
	}

	public void setNbPhe(int nbPhe) {
		this.nbPhe = nbPhe;
	}

	public int getNbPro() {
		return nbPro;
	}

	public void setNbPro(int nbPro) {
		this.nbPro = nbPro;
	}

	public int getNbSec() {
		return nbSec;
	}

	public void setNbSec(int nbSec) {
		this.nbSec = nbSec;
	}

	public int getNbSer() {
		return nbSer;
	}

	public void setNbSer(int nbSer) {
		this.nbSer = nbSer;
	}

	public int getNbThr() {
		return nbThr;
	}

	public void setNbThr(int nbThr) {
		this.nbThr = nbThr;
	}

	public int getNbTrp() {
		return nbTrp;
	}

	public void setNbTrp(int nbTrp) {
		this.nbTrp = nbTrp;
	}

	public int getNbTyr() {
		return nbTyr;
	}

	public void setNbTyr(int nbTyr) {
		this.nbTyr = nbTyr;
	}

	public int getNbVal() {
		return nbVal;
	}

	public void setNbVal(int nbVal) {
		this.nbVal = nbVal;
	}


	public Double getpHI() {
		return pHI;
	}


	public void setpHI(Double pHI) {
		this.pHI = pHI;
	}


	public BigDecimal getmWRound() {
		return mWRound;
	}


	public void setmWRound(BigDecimal mWRound) {
		this.mWRound = mWRound;
	}


	public BigDecimal getpHIRound() {
		return pHIRound;
	}


	public void setpHIRound(BigDecimal pHIRound) {
		this.pHIRound = pHIRound;
	}


	public int getNbNegativeAA() {
		return nbNegativeAA;
	}


	public void setNbNegativeAA(int nbNegativeAA) {
		this.nbNegativeAA = nbNegativeAA;
	}


	public int getNbPositiveAA() {
		return nbPositiveAA;
	}


	public void setNbPositiveAA(int nbPositiveAA) {
		this.nbPositiveAA = nbPositiveAA;
	}


	public int getNbCatom() {
		return nbCatom;
	}


	public void setNbCatom(int nbCatom) {
		this.nbCatom = nbCatom;
	}


	public int getNbSatom() {
		return nbSatom;
	}


	public void setNbSatom(int nbSatom) {
		this.nbSatom = nbSatom;
	}


	public int getNbNatom() {
		return nbNatom;
	}


	public void setNbNatom(int nbNatom) {
		this.nbNatom = nbNatom;
	}


	public int getNbSeAtom() {
		return nbSeAtom;
	}


	public void setNbSeAtom(int nbSeAtom) {
		this.nbSeAtom = nbSeAtom;
	}


	public int getNbOatom() {
		return nbOatom;
	}


	public void setNbOatom(int nbOatom) {
		this.nbOatom = nbOatom;
	}


	public int getNbHatom() {
		return nbHatom;
	}


	public void setNbHatom(int nbHatom) {
		this.nbHatom = nbHatom;
	}


	public int getNbAtom() {
		return nbAtom;
	}


	public void setNbAtom(int nbAtom) {
		this.nbAtom = nbAtom;
	}


	public String getFormule() {
		formule = "C"+ getNbCatom() +
				  "H"+ getNbHatom() +
				  "N" + getNbNatom() +
				  "O"+ getNbOatom() +
				  "S"+ getNbSatom();
				
		return formule;
	}


	public void setFormule(String formule) {
		this.formule = formule;
	}


	public int getExtCoefWithoutCys() {
		return extCoefWithoutCys;
	}


	public void setExtCoefWithoutCys(int extCoefWithoutCys) {
		this.extCoefWithoutCys = extCoefWithoutCys;
	}


	public int getExtCoef() {
		return extCoef;
	}


	public void setExtCoef(int extCoef) {
		this.extCoef = extCoef;
	}


	public Double getAbs01Perc() {
		return abs01Perc;
	}


	public void setAbs01Perc(Double abs01Perc) {
		this.abs01Perc = abs01Perc;
	}


	public BigDecimal getAbs01PercRound() {
		return abs01PercRound;
	}


	public void setAbs01PercRound(BigDecimal abs01PercRound) {
		this.abs01PercRound = abs01PercRound;
	}


	public Double getAbs01PercWithoutCys() {
		return abs01PercWithoutCys;
	}


	public void setAbs01PercWithoutCys(Double abs01PercWithoutCys) {
		this.abs01PercWithoutCys = abs01PercWithoutCys;
	}


	public BigDecimal getAbs01PercWithoutCysRound() {
		return abs01PercWithoutCysRound;
	}


	public void setAbs01PercWithoutCysRound(BigDecimal abs01PercWithoutCysRound) {
		this.abs01PercWithoutCysRound = abs01PercWithoutCysRound;
	}


	public Double getAliphIndex() {
		return aliphIndex;
	}


	public void setAliphIndex(Double aliphIndex) {
		this.aliphIndex = aliphIndex;
	}


	public BigDecimal getAliphIndexRound() {
		return aliphIndexRound;
	}


	public void setAliphIndexRound(BigDecimal aliphIndexRound) {
		this.aliphIndexRound = aliphIndexRound;
	}
	
	public void setHalfLife(String[] halfLife) {
		this.halfLife = halfLife;
	}
}

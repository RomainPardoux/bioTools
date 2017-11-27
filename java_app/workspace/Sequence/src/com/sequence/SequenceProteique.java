package com.sequence;
import java.math.BigDecimal;
import java.util.ArrayList;
import com.aminoAcid.*;

public final class SequenceProteique{

	/* Declaration des variables d'instance */
	private String sequence = "", nomSeq = "", typeSeq = "protein", formule = "";
	private String [] halfLife = {"","",""};
	private int nbMonomer = 0, extCoef, extCoefWithoutCys;
	private Double mW = 0.0, pHI = 0.0, abs01Perc, abs01PercWithoutCys, aliphIndex, gravy; 
	private BigDecimal mWRound, pHIRound, abs01PercRound, abs01PercWithoutCysRound, aliphIndexRound, gravyRound;
	private ArrayList<AminoAcid> aminoAcidList;
	/* Variable Amino Acid */
	private int nbAla, nbArg, nbAsn, nbAsp, nbCys, nbGlu, nbGln, nbGly, nbHis,
	nbIso, nbLeu, nbLys, nbMet, nbPhe, nbPro, nbSec, nbSer, nbThr, nbTrp, nbTyr, nbVal, 
	nbPositiveAA, nbNegativeAA, nbCatom, nbNatom, nbOatom, nbSatom, nbSeAtom, nbHatom, nbAtom;

	/* Constructeurs */
	public SequenceProteique() {	}

	public SequenceProteique(String seq, String nom) {
		this.sequence = seq;
		this.nomSeq = nom;
		initConstructeur();
	}

	public SequenceProteique(String seq) {
		this.sequence = seq;
		initConstructeur();
	}

	//Init Constructeur
	private void initConstructeur(){
		addMonomer(sequence);
		this.nbMonomer = countMonomer(aminoAcidList);
		this.countAminoAcid(aminoAcidList);
		this.countChargedAminoAcid(aminoAcidList);
		this.countAtom(aminoAcidList);
		this.mW = computeMW(aminoAcidList);
		this.mWRound = (new BigDecimal(this.mW)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.pHI = computePHI(aminoAcidList);
		this.pHIRound = (new BigDecimal(this.pHI)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.extCoef = computeExtinctionCoef(aminoAcidList);
		this.extCoefWithoutCys = computeExtinctionCoefWithoutCys(aminoAcidList);
		this.abs01Perc = computeAbs01Perc(aminoAcidList);
		this.abs01PercRound = (new BigDecimal(this.abs01Perc)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.abs01PercWithoutCys = computeAbs01PercWithoutCys(aminoAcidList);
		this.abs01PercWithoutCysRound = (new BigDecimal(this.abs01PercWithoutCys)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.aliphIndex = computeAliphaticIndex(aminoAcidList);
		this.aliphIndexRound = (new BigDecimal(this.aliphIndex)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.halfLife = getHalfLife(aminoAcidList);
		this.gravy = computeGravyIndex(aminoAcidList);
		this.gravyRound = (new BigDecimal(this.gravy)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	//Fonctions de classe
	//1. Fonctions generiques
	//1.1 Alimente la liste aminoAcidList ou nucleotidList
	public void addMonomer(String seq){
		seq = seq.toLowerCase();
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
	}

	//1.2 Compte le nbre de monomere dans la sequence
	public int countMonomer(ArrayList<AminoAcid> aminoAcidList){
		nbMonomer = aminoAcidList.size();
		return nbMonomer;
	}

	//2. Fonctions propre a l analyse proteique
	//2.1 Compte le nbre d acide amine dans la sequence
	private void countAminoAcid(ArrayList<AminoAcid> aminoAcidList){
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
	private void countChargedAminoAcid(ArrayList<AminoAcid> aminoAcidList){
		for (int i = 0; i <aminoAcidList.size(); i++) {
			if (aminoAcidList.get(i).sideChainProperty.equals(SideChaineProperties.POSITIVE_CHARGED)) {
				this.nbPositiveAA ++;
			}else if (aminoAcidList.get(i).sideChainProperty.equals(SideChaineProperties.NEGATIVE_CHARGED)) {
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
		this.nbAtom = totAtomBuffer;
		this.nbCatom = cAtomBuffer;
		this.nbNatom = nAtomBuffer;
		this.nbOatom = oAtomBuffer;
		this.nbHatom = hAtomBuffer;
		this.nbSatom = sAtomBuffer;
		this.nbSeAtom = seAtomBuffer;
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
	private Double computePHI(ArrayList<AminoAcid> aminoAcidList){
		Double pHI = 0.0;
		ArrayList<Double> listPKa = new ArrayList<Double>();
		int cptrPositiveCharge = 0; 
		Double pKaBas = 0.0;
		Double pKaHaut = 0.0;
		// alimente une liste en pKa dans l'ordre croissant
		listPKa.add(aminoAcidList.get(0).getpKaNH3());
		listPKa.add(aminoAcidList.get(aminoAcidList.size()-1).getpKaCOOH());
		for (int i = 0; i < aminoAcidList.size(); i++) {
			if (aminoAcidList.get(i).sideChainProperty.equals(SideChaineProperties.POSITIVE_CHARGED)) {
				listPKa.add(aminoAcidList.get(i).getpKaR());
				cptrPositiveCharge++;
			}
			if (aminoAcidList.get(i).sideChainProperty.equals(SideChaineProperties.NEGATIVE_CHARGED)) {
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
	private int computeExtinctionCoef(ArrayList<AminoAcid> aminoAcidList){
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
	private int computeExtinctionCoefWithoutCys(ArrayList<AminoAcid> aminoAcidList){
		int cem = (getNbTyr() * 1280) + (getNbTrp() * 5690);
		return cem;
	}

	//2.8 Calcul l'aborbance � 0.1 pourcent de proteine
	private Double computeAbs01Perc(ArrayList<AminoAcid> aminoAcidList){
		int cem = computeExtinctionCoef(aminoAcidList);
		Double mw = computeMW(aminoAcidList);
		Double abs01Perc = (double)cem / mw;
		return abs01Perc;
	}

	//2.9 Calcul l'aborbance � 0.1 pourcent de proteine sans prendre en compte les cysteines
	private Double computeAbs01PercWithoutCys(ArrayList<AminoAcid> aminoAcidList){
		int cem = computeExtinctionCoefWithoutCys(aminoAcidList);
		Double mw = computeMW(aminoAcidList);
		Double abs01Perc = (double)cem / mw;
		return abs01Perc;
	}

	//2.10 Calcul l'index aliphatique de la proteine
	/*Detail du calcul: p(ala) + 2.9 * p(val) + 3.9 * ( p(ile) + p(leu) ) */
	private Double computeAliphaticIndex(ArrayList<AminoAcid> aminoAcidList){
		Double alpihIndex = ((double)(this.getNbAla() * 100) / (double)this.getNbMonomer()) 
				+ 2.9 * ((double)(this.getNbVal() * 100) / (double)this.getNbMonomer()) 
				+ 3.9 * ((double)((this.getNbIso() * 100) / (double)this.getNbMonomer()) 
						+ ((double)(this.getNbLeu() * 100) / (double)this.getNbMonomer()));
		return alpihIndex;
	}

	//2.11 Determine le In vivo half life de la proteine
	private String [] getHalfLife(ArrayList<AminoAcid> aminoAcidList) {
		this.halfLife = aminoAcidList.get(0).getHalfLife();
		return halfLife;
	}

	//Calcul l'index GRAVY de la proteine
	//2.12 The GRAVY value for a peptide or protein is calculated as the sum of hydropathy values of all the amino acids, divided by the number of residues in the sequence.
	private Double computeGravyIndex(ArrayList<AminoAcid> aminoAcidList){
		Double iI = 0.00;
		for (int i = 0; i < aminoAcidList.size(); i++) {
			iI += aminoAcidList.get(i).getHydropathie();
		}
		iI /= aminoAcidList.size();
		return iI;
	}

	//2.13 Renvoie le nombre d'acide amin� rens�gn� en parametre
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

	//2.14 Renvoi la seq proteique reformater
	public String formateSeq(ArrayList<AminoAcid> aminoAcidList){
		String formatedSeq = "";
		for (int i = 0; i < aminoAcidList.size(); i++) {
			formatedSeq += aminoAcidList.get(i).getSyn1L();
		}
		return formatedSeq;
	}

	//2.15 Renvoi une description de la composition de la seq en acide amine
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
		"\n\nAtomic Composition: " +
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
		"\n\nGRAVY Index: " + getGravyRound() +
		"\n\n---------------------------------------------------------------------------------";
	}

	//Getters and Setters
	public String getSequence() {
		return sequence;
	}

	public String getNomSeq() {
		return nomSeq;
	}

	public String getTypeSeq() {
		return typeSeq;
	}

	public ArrayList<AminoAcid> getAminoAcidList() {
		return aminoAcidList;
	}

	public Double getmW() {
		return mW;
	}

	public int getNbMonomer() {
		return nbMonomer;
	}

	public int getNbAla() {
		return nbAla;
	}

	public int getNbArg() {
		return nbArg;
	}

	public int getNbAsn() {
		return nbAsn;
	}

	public int getNbAsp() {
		return nbAsp;
	}

	public int getNbCys() {
		return nbCys;
	}

	public int getNbGlu() {
		return nbGlu;
	}

	public int getNbGln() {
		return nbGln;
	}

	public int getNbGly() {
		return nbGly;
	}

	public int getNbHis() {
		return nbHis;
	}

	public int getNbIso() {
		return nbIso;
	}

	public int getNbLeu() {
		return nbLeu;
	}

	public int getNbLys() {
		return nbLys;
	}

	public int getNbMet() {
		return nbMet;
	}

	public int getNbPhe() {
		return nbPhe;
	}

	public int getNbPro() {
		return nbPro;
	}

	public int getNbSec() {
		return nbSec;
	}

	public int getNbSer() {
		return nbSer;
	}

	public int getNbThr() {
		return nbThr;
	}

	public int getNbTrp() {
		return nbTrp;
	}

	public int getNbTyr() {
		return nbTyr;
	}

	public int getNbVal() {
		return nbVal;
	}

	public Double getpHI() {
		return pHI;
	}

	public BigDecimal getmWRound() {
		return mWRound;
	}

	public BigDecimal getpHIRound() {
		return pHIRound;
	}

	public int getNbNegativeAA() {
		return nbNegativeAA;
	}

	public int getNbPositiveAA() {
		return nbPositiveAA;
	}

	public int getNbCatom() {
		return nbCatom;
	}

	public int getNbSatom() {
		return nbSatom;
	}

	public int getNbNatom() {
		return nbNatom;
	}

	public int getNbSeAtom() {
		return nbSeAtom;
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

	public String getFormule() {
		formule = "C"+ getNbCatom() +
				"H"+ getNbHatom() +
				"N" + getNbNatom() +
				"O"+ getNbOatom() +
				"S"+ getNbSatom();

		return formule;
	}

	public int getExtCoefWithoutCys() {
		return extCoefWithoutCys;
	}

	public int getExtCoef() {
		return extCoef;
	}

	public Double getAbs01Perc() {
		return abs01Perc;
	}

	public BigDecimal getAbs01PercRound() {
		return abs01PercRound;
	}

	public Double getAbs01PercWithoutCys() {
		return abs01PercWithoutCys;
	}

	public BigDecimal getAbs01PercWithoutCysRound() {
		return abs01PercWithoutCysRound;
	}

	public Double getAliphIndex() {
		return aliphIndex;
	}

	public BigDecimal getAliphIndexRound() {
		return aliphIndexRound;
	}

	public Double getGravy() {
		return gravy;
	}

	public BigDecimal getGravyRound() {
		return gravyRound;
	}

}

package com.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.sequence.SequenceProteique;

public class PanProt extends JPanel{

	//Declaration variable
	//panels
	private cardProtInfo cardProtInfo;
	private cardProtCompo cardProtCompo;
	private cardProtAbs cardProtAbs;

	//Constructeur
	public PanProt(JTextArea jtaEcran) {
		super();
	}

	public PanProt() {
	}

	//Methode
	public void initPanelCardProt(JTextArea jtaEcran) {

		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		cardProtInfo = new cardProtInfo();
		cardProtCompo = new cardProtCompo(jtaEcran);
		cardProtAbs = new cardProtAbs(jtaEcran);
		add(cardProtAbs, BorderLayout.EAST);
		add(cardProtCompo, BorderLayout.SOUTH);
		add(cardProtInfo, BorderLayout.WEST);
		
	}

	public void majIfPanelProt(SequenceProteique seqProt) {
		//MAJ panel prot abs
		//coef ext mol
		cardProtAbs.getJtfExtCoef().setText(seqProt.getExtCoef() + "");
		if(seqProt.getExtCoef() == 0){
			cardProtAbs.getJtfAbs280().setEnabled(false);
			cardProtAbs.getJtfConcProt().setEnabled(false);
			cardProtAbs.getJcbUnite().setEnabled(false);
			cardProtAbs.getJtfAbs280().setEditable(false);
			cardProtAbs.getJtfConcProt().setEditable(false);
			cardProtAbs.getJcbUnite().setEditable(false);
		}else {
			cardProtAbs.getJtfAbs280().setEnabled(true);
			cardProtAbs.getJtfConcProt().setEnabled(true);
			cardProtAbs.getJcbUnite().setEnabled(true);
			cardProtAbs.getJtfAbs280().setEditable(true);
			cardProtAbs.getJcbUnite().setEditable(true);
		}
		cardProtAbs.getJtfAbs01perc().setText(seqProt.getAbs01PercRound() + "");
		cardProtAbs.getJtfAbs280().setText("");
		cardProtAbs.getJtfConcProt().setText("");
		//msg personalisé
		String msgWithoutTrpOrTyr = "Protein Concentration = Abs (280 nm) / Epsilon";
		if(seqProt.getNbTrp() == 0){
			msgWithoutTrpOrTyr = "This protein does not contain any Trp residues. Experience shows that "
					+ "this could result in more than 10% error in the computed extinction coefficient.";
			if(seqProt.getNbTyr() == 0){
				msgWithoutTrpOrTyr = "As there are no Trp, Tyr or Cys in the region considered, your protein should not be visible by UV spectrophotometry.";
			}
		} 
		cardProtAbs.getJtaCardProtAbsWarning().setText(msgWithoutTrpOrTyr);

		//MAJ panel prot compo
		cardProtCompo.getJtfNbOfAA().setText(seqProt.getNbMonomer() + "");
		cardProtCompo.getJtfNbMoinsAa().setText(seqProt.getNbNegativeAA() + "");
		cardProtCompo.getJtfNbPlusAa().setText(seqProt.getNbPositiveAA() + "");
		cardProtCompo.getJtfNbOfAtom().setText(seqProt.getNbAtom() + "");
		cardProtCompo.getJtfFormula().setText(seqProt.getFormule() + "");
		cardProtCompo.getJtfResultAACompo().setText("");
		cardProtCompo.getJtfAACompo().setText("");
		cardProtCompo.getJtfAtomicCompo().setText("");

		//MAJ panel prot info
		cardProtInfo.getJtfMw().setText(seqProt.getmWRound() + "");
		cardProtInfo.getJtfGravy().setText(seqProt.getGravyRound() + "");
		cardProtInfo.getJtfAliphIndex().setText(seqProt.getAliphIndexRound() + "");
		cardProtInfo.getJtfPI().setText(seqProt.getpHIRound() + "");
	}

	//getters and setters
	public cardProtInfo getCardProtInfo() {
		return cardProtInfo;
	}

	public void setCardProtInfo(cardProtInfo cardProtInfo) {
		this.cardProtInfo = cardProtInfo;
	}

	public cardProtCompo getCardProtCompo() {
		return cardProtCompo;
	}

	public void setCardProtCompo(cardProtCompo cardProtCompo) {
		this.cardProtCompo = cardProtCompo;
	}

	public cardProtAbs getCardProtAbs() {
		return cardProtAbs;
	}

	public void setCardProtAbs(cardProtAbs cardProtAbs) {
		this.cardProtAbs = cardProtAbs;
	}
	
//	//class interne
//	class ResetListener implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			// TODO Auto-generated method stub
//			cl.show(content, listContent[2]);
//			jbutSend.setEnabled(true);
//			jtaEcran.setText("");
//		}
//	}
		
};

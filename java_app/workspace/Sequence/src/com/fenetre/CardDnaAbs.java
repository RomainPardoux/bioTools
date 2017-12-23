package com.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sequence.SequenceNucleique;
import com.sequence.SequenceProteique;
import com.sequence.Unite;

public class CardDnaAbs extends JPanel{

	private CardDnaAbs cardDnaAbs;

	//ComboBox
	private JComboBox<Unite> jcbUnite;
	//jta
	private JTextArea jtaCardAbsWarning;
	//tab
	Unite[] tabJcbUnite = {Unite.M, Unite.mM, Unite.uM, Unite.nM, Unite.pM,};

	//Label Dna
	private JLabel labelExtCoef, labelAbs260,
	labelConc; 

	//JTextField Dna
	private JTextField jtfExtCoef, jtfAbs260,
	jtfConc;
	//seqNuc
	private String seq = "";

	public CardDnaAbs(String seq, SequenceNucleique seqNuc) {
		super();
		this.seq = seq;
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(320, 140));
		setBorder(BorderFactory.createTitledBorder("DNA Absorbance Properties"));
		JPanel cardDnaAbs1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardDnaAbs1.setPreferredSize(new Dimension(155, 100));
		JPanel cardDnaAbs2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardDnaAbs2.setPreferredSize(new Dimension(160, 100));
		JPanel cardDnaAbs3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cardDnaAbs3.setPreferredSize(new Dimension(320, 60));
		labelExtCoef = new JLabel("Ext. Coefficient : ");
		labelExtCoef.setPreferredSize(new Dimension(150, 20));
		jtfExtCoef = new JTextField();
		jtfExtCoef.setPreferredSize(new Dimension(100, 20));
		jtfExtCoef.setEditable(false);
		labelAbs260 = new JLabel("Absorbance at 280 nm ");
		labelAbs260.setPreferredSize(new Dimension(150, 20));
		jtfAbs260 = new JTextField();
		jtfAbs260.setToolTipText("Add absorbance value at 280 nm like 0.5");
		jtfAbs260.setPreferredSize(new Dimension(100, 20));
		jtfAbs260.addActionListener(new abs280listener());
		labelConc = new JLabel("Dna Concentration ");
		labelConc.setPreferredSize(new Dimension(150, 20));
		jtfConc = new JTextField();
		jtfConc.setPreferredSize(new Dimension(100, 20));
		jtfConc.setEditable(false);
		jcbUnite = new JComboBox<Unite>(tabJcbUnite);
		jcbUnite.setSelectedItem(tabJcbUnite[2]);
		jcbUnite.addActionListener(new UniteListener());
		jtaCardAbsWarning = new JTextArea();
		jtaCardAbsWarning.setEditable(false);
		jtaCardAbsWarning.setLineWrap(true);
		jtaCardAbsWarning.setWrapStyleWord(true);
		jtaCardAbsWarning.setBackground(Color.lightGray);
		jtaCardAbsWarning.setPreferredSize(new Dimension(310, 50));
		cardDnaAbs1.add(labelExtCoef);
		cardDnaAbs2.add(jtfExtCoef);
		cardDnaAbs1.add(labelAbs260);
		cardDnaAbs2.add(jtfAbs260);
		cardDnaAbs1.add(labelConc);
		cardDnaAbs2.add(jtfConc);
		cardDnaAbs2.add(jcbUnite);
		cardDnaAbs3.add(jtaCardAbsWarning);
		add(cardDnaAbs1, BorderLayout.WEST);
		add(cardDnaAbs2, BorderLayout.EAST);
		add(cardDnaAbs3, BorderLayout.SOUTH);
		
		//MAJ card abs
		if(seqNuc.isDna()){
			jtfExtCoef.setText(seqNuc.getExtCoefDna() + "");
			labelConc.setText("DNA Concentration ");
			setBorder(BorderFactory.createTitledBorder("DNA Absorbance Properties"));
		}else if(seqNuc.isRna()){
			jtfExtCoef.setText(seqNuc.getExtCoefRna() + "");
			labelConc.setText("RNA Concentration ");
			setBorder(BorderFactory.createTitledBorder("RNA Absorbance Properties"));
		}
		jtaCardAbsWarning.setText("Concentration = Abs (280 nm) / Epsilon");
	}

	//class interne (listeners)
	class abs280listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SequenceNucleique seqNuc = new SequenceNucleique(seq);
			String sAbs280 = jtfAbs260.getText();
			Double dAbs280 = Double.valueOf(sAbs280);
			if(seqNuc.isDna()){
				Double dDnaConc = seqNuc.ComputeDNAOrRnaConcentration(dAbs280, (Unite) jcbUnite.getSelectedItem(), "dna");
				BigDecimal bdDnaConc = (new BigDecimal(dDnaConc)).setScale(5, BigDecimal.ROUND_HALF_UP);
				String sDnaConc = String.valueOf(bdDnaConc);
				jtfConc.setText(sDnaConc);	
			}else if(seqNuc.isRna()){
				Double dRnaConc = seqNuc.ComputeDNAOrRnaConcentration(dAbs280, (Unite) jcbUnite.getSelectedItem(), "rna");
				BigDecimal bdRnaConc = (new BigDecimal(dRnaConc)).setScale(5, BigDecimal.ROUND_HALF_UP);
				String sRnaConc = String.valueOf(bdRnaConc);
				jtfConc.setText(sRnaConc);
			}
		}

	}

	class UniteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SequenceNucleique seqNuc = new SequenceNucleique(seq);
			String sAbs280 = jtfAbs260.getText();
			Double dAbs280 = Double.valueOf(sAbs280);
			if(seqNuc.isDna()){
				Double dDnaConc = seqNuc.ComputeDNAOrRnaConcentration(dAbs280, (Unite) jcbUnite.getSelectedItem(), "dna");
				BigDecimal bdDnaConc = (new BigDecimal(dDnaConc)).setScale(5, BigDecimal.ROUND_HALF_UP);
				String sDnaConc = String.valueOf(bdDnaConc);
				jtfConc.setText(sDnaConc);	
			}else if(seqNuc.isRna()){
				Double dRnaConc = seqNuc.ComputeDNAOrRnaConcentration(dAbs280, (Unite) jcbUnite.getSelectedItem(), "rna");
				BigDecimal bdRnaConc = (new BigDecimal(dRnaConc)).setScale(5, BigDecimal.ROUND_HALF_UP);
				String sRnaConc = String.valueOf(bdRnaConc);
				jtfConc.setText(sRnaConc);
			}
		}
	}


	//getters and setters
	public CardDnaAbs getCardDnaAbs() {
		return cardDnaAbs;
	}


	public void setCardDnaAbs(CardDnaAbs cardDnaAbs) {
		this.cardDnaAbs = cardDnaAbs;
	}


	public JComboBox<Unite> getJcbUnite() {
		return jcbUnite;
	}


	public void setJcbUnite(JComboBox<Unite> jcbUnite) {
		this.jcbUnite = jcbUnite;
	}


	public JTextArea getJtaCardAbsWarning() {
		return jtaCardAbsWarning;
	}


	public void setJtaCardAbsWarning(JTextArea jtaCardAbsWarning) {
		this.jtaCardAbsWarning = jtaCardAbsWarning;
	}


	public Unite[] getTabJcbUnite() {
		return tabJcbUnite;
	}


	public void setTabJcbUnite(Unite[] tabJcbUnite) {
		this.tabJcbUnite = tabJcbUnite;
	}


	public JLabel getLabelExtCoef() {
		return labelExtCoef;
	}


	public void setLabelExtCoef(JLabel labelExtCoef) {
		this.labelExtCoef = labelExtCoef;
	}


	public JLabel getLabelAbs260() {
		return labelAbs260;
	}


	public void setLabelAbs260(JLabel labelAbs260) {
		this.labelAbs260 = labelAbs260;
	}


	public JLabel getLabelConc() {
		return labelConc;
	}


	public void setLabelConc(JLabel labelConc) {
		this.labelConc = labelConc;
	}


	public JTextField getJtfExtCoef() {
		return jtfExtCoef;
	}


	public void setJtfExtCoef(JTextField jtfExtCoef) {
		this.jtfExtCoef = jtfExtCoef;
	}


	public JTextField getJtfAbs260() {
		return jtfAbs260;
	}


	public void setJtfAbs260(JTextField jtfAbs260) {
		this.jtfAbs260 = jtfAbs260;
	}


	public JTextField getJtfConc() {
		return jtfConc;
	}


	public void setJtfConc(JTextField jtfConc) {
		this.jtfConc = jtfConc;
	}


	public String getSeq() {
		return seq;
	}


	public void setSeq(String seq) {
		this.seq = seq;
	}

	
}

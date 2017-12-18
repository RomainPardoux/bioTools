package com.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sequence.SequenceNucleique;
import com.sequence.Unite;

public class CardDnaAbs extends JPanel{

	private CardDnaAbs cardDnaAbs;
	
	//ComboBox
	private JComboBox<Unite> jcbUniteDna;
	//jta
	private JTextArea jtaCardDnaAbsWarning;
	//tab
	Unite[] tabJcbUnite = {Unite.M, Unite.mM, Unite.µM, Unite.nM, Unite.pM,};
	
	//Label Dna
	private JLabel labelExtCoefDna, labelAbs01percDna, labelAbs280Dna,
	labelConcDna; 

	//JTextField Dna
	private JTextField jtfExtCoefDna, jtfAbs01percDna, jtfAbs280Dna,
	jtfConcDna;
	
	
	public CardDnaAbs() {
		super();
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(320, 140));
		setBorder(BorderFactory.createTitledBorder("DNA Absorbance Properties"));
		JPanel cardDnaAbs1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardDnaAbs1.setPreferredSize(new Dimension(155, 100));
		JPanel cardDnaAbs2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardDnaAbs2.setPreferredSize(new Dimension(160, 100));
		JPanel cardDnaAbs3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cardDnaAbs3.setPreferredSize(new Dimension(320, 30));
		labelExtCoefDna = new JLabel("Ext. Coefficient : ");
		labelExtCoefDna.setPreferredSize(new Dimension(150, 20));
		jtfExtCoefDna = new JTextField();
		jtfExtCoefDna.setPreferredSize(new Dimension(100, 20));
		jtfExtCoefDna.setEditable(false);
		labelAbs01percDna = new JLabel("Abs 0.1% (=1 g/l) : ");
		labelAbs01percDna.setPreferredSize(new Dimension(150, 20));
		jtfAbs01percDna = new JTextField();
		jtfAbs01percDna.setPreferredSize(new Dimension(100, 20));
		jtfAbs01percDna.setEditable(false);
		labelAbs280Dna = new JLabel("Absorbance at 280 nm ");
		labelAbs280Dna.setPreferredSize(new Dimension(150, 20));
		jtfAbs280Dna = new JTextField();
		jtfAbs280Dna.setToolTipText("Add absorbance value at 280 nm like 0.5");
		jtfAbs280Dna.setPreferredSize(new Dimension(100, 20));
		//			jtfAbs280Dna.addActionListener(new abs280listener());
		labelConcDna = new JLabel("Dna Concentration ");
		labelConcDna.setPreferredSize(new Dimension(150, 20));
		jtfConcDna = new JTextField();
		jtfConcDna.setPreferredSize(new Dimension(100, 20));
		jtfConcDna.setEditable(false);
		jcbUniteDna = new JComboBox<Unite>(tabJcbUnite);
		jcbUniteDna.setSelectedItem(tabJcbUnite[2]);
		//			jcbUniteDna.addActionListener(new UniteListener());
		jtaCardDnaAbsWarning = new JTextArea();
		jtaCardDnaAbsWarning.setEditable(false);
		jtaCardDnaAbsWarning.setLineWrap(true);
		jtaCardDnaAbsWarning.setWrapStyleWord(true);
		jtaCardDnaAbsWarning.setBackground(Color.lightGray);
		jtaCardDnaAbsWarning.setPreferredSize(new Dimension(310, 30));
		cardDnaAbs1.add(labelExtCoefDna);
		cardDnaAbs2.add(jtfExtCoefDna);
		cardDnaAbs1.add(labelAbs01percDna);
		cardDnaAbs2.add(jtfAbs01percDna);
		cardDnaAbs1.add(labelAbs280Dna);
		cardDnaAbs2.add(jtfAbs280Dna);
		cardDnaAbs1.add(labelConcDna);
		cardDnaAbs2.add(jtfConcDna);
		cardDnaAbs2.add(jcbUniteDna);
		cardDnaAbs3.add(jtaCardDnaAbsWarning);
		add(cardDnaAbs1, BorderLayout.WEST);
		add(cardDnaAbs2, BorderLayout.EAST);
		add(cardDnaAbs3, BorderLayout.SOUTH);
	}


	public CardDnaAbs getCardDnaAbs() {
		return cardDnaAbs;
	}


	public void setCardDnaAbs(CardDnaAbs cardDnaAbs) {
		this.cardDnaAbs = cardDnaAbs;
	}


	public JComboBox<Unite> getJcbUniteDna() {
		return jcbUniteDna;
	}


	public void setJcbUniteDna(JComboBox<Unite> jcbUniteDna) {
		this.jcbUniteDna = jcbUniteDna;
	}


	public JTextArea getJtaCardDnaAbsWarning() {
		return jtaCardDnaAbsWarning;
	}


	public void setJtaCardDnaAbsWarning(JTextArea jtaCardDnaAbsWarning) {
		this.jtaCardDnaAbsWarning = jtaCardDnaAbsWarning;
	}


	public Unite[] getTabJcbUnite() {
		return tabJcbUnite;
	}


	public void setTabJcbUnite(Unite[] tabJcbUnite) {
		this.tabJcbUnite = tabJcbUnite;
	}


	public JLabel getLabelExtCoefDna() {
		return labelExtCoefDna;
	}


	public void setLabelExtCoefDna(JLabel labelExtCoefDna) {
		this.labelExtCoefDna = labelExtCoefDna;
	}


	public JLabel getLabelAbs01percDna() {
		return labelAbs01percDna;
	}


	public void setLabelAbs01percDna(JLabel labelAbs01percDna) {
		this.labelAbs01percDna = labelAbs01percDna;
	}


	public JLabel getLabelAbs280Dna() {
		return labelAbs280Dna;
	}


	public void setLabelAbs280Dna(JLabel labelAbs280Dna) {
		this.labelAbs280Dna = labelAbs280Dna;
	}


	public JLabel getLabelConcDna() {
		return labelConcDna;
	}


	public void setLabelConcDna(JLabel labelConcDna) {
		this.labelConcDna = labelConcDna;
	}


	public JTextField getJtfExtCoefDna() {
		return jtfExtCoefDna;
	}


	public void setJtfExtCoefDna(JTextField jtfExtCoefDna) {
		this.jtfExtCoefDna = jtfExtCoefDna;
	}


	public JTextField getJtfAbs01percDna() {
		return jtfAbs01percDna;
	}


	public void setJtfAbs01percDna(JTextField jtfAbs01percDna) {
		this.jtfAbs01percDna = jtfAbs01percDna;
	}


	public JTextField getJtfAbs280Dna() {
		return jtfAbs280Dna;
	}


	public void setJtfAbs280Dna(JTextField jtfAbs280Dna) {
		this.jtfAbs280Dna = jtfAbs280Dna;
	}


	public JTextField getJtfConcDna() {
		return jtfConcDna;
	}


	public void setJtfConcDna(JTextField jtfConcDna) {
		this.jtfConcDna = jtfConcDna;
	}

	
	
}

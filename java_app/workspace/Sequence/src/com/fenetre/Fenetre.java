package com.fenetre;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.sequence.SequenceNucleique;
import com.sequence.SequenceProteique;
import com.sequence.Unite;

public class Fenetre extends JFrame{

	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	JPanel panEcran = new JPanel();
	JPanel cardProt = new JPanel();
	JPanel cardProtInfo = new JPanel();
	JPanel cardProtCompo = new JPanel();
	JPanel cardProtAbs = new JPanel();
	String[] listContent = {"PROT", "DNA", "DEFAULT"};

	SequenceProteique seqProt;

	JComboBox<Unite> jcbUnite;
	Unite[] tabJcbUnite = {Unite.M, Unite.mM, Unite.µM, Unite.nM, Unite.pM};
	JTextArea jtaEcran = new JTextArea();
	JTextField jtfAbs280, jtfConcProt;
	JButton jbutSend, jbutReset;
	//Label Prot
	JLabel labelTypeOfSeq, labelNbOfAA, labelMw, labelPI, labelNbPlusAa, labelNbMoinsAa, labelFormula, 
	labelNbOfAtom, labelAliphIndex, labelGravy, labelAACompo, labelExtCoef, labelAbs01perc, labelAbs280,
	labelConcProt;
	//font
	Font font = new Font("Arial", Font.PLAIN, 14);

	public Fenetre() throws HeadlessException {
		super();
		this.setSize(600, 650);
		this.setTitle("Your DNA and Protein assistant");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		initComposant();
		this.setVisible(true);
	}

	private void initComposant() {

		initPanelEcran();
		initPanelCardProt();

		//Panel CardDna
		JPanel cardDna = new JPanel();
		cardDna.setBackground(Color.WHITE);

		//Panel CardDefault
		JPanel cardDefautlt = new JPanel();
		cardDefautlt.setBackground(Color.green);

		//Panel Content
		content.setPreferredSize(new Dimension(600, 410));
		content.setLayout(cl);
		content.add(cardProt, listContent[0]);
		content.add(cardDna, listContent[1]);
		content.add(cardDefautlt, listContent[2]);

		//Panel ContentPane
		this.getContentPane().add(panEcran, BorderLayout.NORTH);
		this.getContentPane().add(content, BorderLayout.CENTER);
	}

	private void initPanelCardProt() {
		// TODO Auto-generated method stub
		//Panel CardProt
		cardProt.setLayout(new BorderLayout());
		cardProt.setBackground(Color.WHITE);
		initCardProtInfo();
		initCardProtCompo();
		initCardProtAbs();
		cardProt.add(cardProtAbs, BorderLayout.EAST);
		cardProt.add(cardProtCompo, BorderLayout.SOUTH);
		cardProt.add(cardProtInfo, BorderLayout.WEST);
	}

	private void initCardProtAbs() {
		// TODO Auto-generated method stub
		cardProtAbs.setLayout(new FlowLayout(FlowLayout.LEFT));
		cardProtAbs.setPreferredSize(new Dimension(320, 150));
		cardProtAbs.setBorder(BorderFactory.createTitledBorder("Protein Absorbance Properties"));
		labelExtCoef = new JLabel();
		labelAbs01perc = new JLabel();
		labelAbs280 = new JLabel();
		jtfAbs280 = new JTextField();
		jtfAbs280.setPreferredSize(new Dimension(40, 20));
		jtfAbs280.addActionListener(new abs280listener());
		labelConcProt = new JLabel("Protein Concentration ");
		jtfConcProt = new JTextField();
		jtfConcProt.setPreferredSize(new Dimension(80, 20));
		jtfConcProt.setEditable(false);
		jcbUnite = new JComboBox<Unite>(tabJcbUnite);
		jcbUnite.setSelectedItem(tabJcbUnite[2]);
		jcbUnite.addActionListener(new UniteListener());
		cardProtAbs.add(labelExtCoef);
		cardProtAbs.add(labelAbs01perc);
		cardProtAbs.add(labelAbs280);
		cardProtAbs.add(jtfAbs280);
		cardProtAbs.add(labelConcProt);
		cardProtAbs.add(jtfConcProt);
		cardProtAbs.add(jcbUnite);
	}

	private void initCardProtCompo() {
		// TODO Auto-generated method stub
		cardProtCompo.setLayout(new FlowLayout(FlowLayout.LEFT));
		cardProtCompo.setPreferredSize(new Dimension(220, 150));
		cardProtCompo.setBorder(BorderFactory.createTitledBorder("Protein Composition"));
		labelNbOfAA = new JLabel();
		labelNbPlusAa = new JLabel();
		labelNbMoinsAa = new JLabel();
		labelFormula = new JLabel();
		labelNbOfAtom = new JLabel();
		labelAACompo = new JLabel();
		cardProtCompo.add(labelNbOfAA);
		cardProtCompo.add(labelNbMoinsAa);
		cardProtCompo.add(labelNbPlusAa);
		cardProtCompo.add(labelNbOfAtom);
		cardProtCompo.add(labelFormula);
		cardProtCompo.add(labelAACompo);
	}

	private void initCardProtInfo() {
		// TODO Auto-generated method stub
		cardProtInfo.setLayout(new FlowLayout(FlowLayout.LEFT));
		cardProtInfo.setPreferredSize(new Dimension(280, 200));
		cardProtInfo.setBorder(BorderFactory.createTitledBorder("Protein identity"));
		labelMw = new JLabel();
		labelPI = new JLabel();
		labelAliphIndex = new JLabel();
		labelGravy = new JLabel();
		cardProtInfo.add(labelMw);
		cardProtInfo.add(labelPI);
		cardProtInfo.add(labelAliphIndex);
		cardProtInfo.add(labelGravy);
	}

	private void initPanelEcran() {
		// TODO Auto-generated method stub
		//Panel Ecran
		panEcran.setPreferredSize(new Dimension(600, 270));
		panEcran.setBackground(Color.DARK_GRAY);
		JPanel panEcranInfo = new JPanel();
		panEcranInfo.setPreferredSize(new Dimension(600, 20));
		panEcranInfo.setBackground(Color.DARK_GRAY);
		labelTypeOfSeq = new JLabel();
		labelTypeOfSeq.setForeground(Color.WHITE);
		panEcranInfo.add(labelTypeOfSeq);
		jtaEcran.setAutoscrolls(true);
		jtaEcran.setLineWrap(true);
		jtaEcran.setPreferredSize(new Dimension(600, 200));
		jtaEcran.setFont(font);
		jtaEcran.setToolTipText("Copy your sequence here ...");
		JScrollPane jsp = new JScrollPane(jtaEcran);
		jsp.setPreferredSize(new Dimension(590, 200));
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jbutSend = new JButton("Send");
		jbutSend.addActionListener(new SendListener());
		jbutReset = new JButton("Reset");
		jbutReset.setEnabled(false);
		jbutReset.addActionListener(new ResetListener());
		panEcran.add(panEcranInfo);
		panEcran.add(jsp);
		panEcran.add(jbutReset);
		panEcran.add(jbutSend);
	}

	class SendListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			content.repaint();
			jbutSend.setEnabled(false);
			jbutReset.setEnabled(true);
			String regexSeqProt = "^([ ]*)?[mM][ .,;-RrHhKkDdEeSsTtNnQqCcUuGgPpAaVvIiLlMmFfYyWw]*$";
			String regexSeqDna = "^[ .,;-aAtTcCgG]*$";
			String regexSeqRna = "^[ .,;-aAcCgGuU]*$";
			String seq = jtaEcran.getText();
			if ( seq.matches(regexSeqProt)){
				seqProt = new SequenceProteique(seq);
				System.out.println(seqProt.toString());
				cl.show(content, listContent[0]);
				initPanelProt(seqProt);
			}
			else if ( seq.matches(regexSeqDna) || seq.matches(regexSeqRna)){
				SequenceNucleique seqNuc= new SequenceNucleique(seq);
				System.out.println(seqNuc.toString());
				cl.show(content, listContent[1]);
				//				initPanelDna();
			} else {
				System.out.println("sequence undefinied");
				cl.show(content, listContent[2]);
				//				initPanelDefault();
			}
		}

		private void initPanelProt(SequenceProteique seqProt) {
			// TODO Auto-generated method stub
			String typeOfSeq = "Auto-Detect type of sequence: "	+ seqProt.getTypeSeq();
			String mW = "Molecular weight (MW): " + seqProt.getmWRound();
			String pI = "Theoretical pI: " + seqProt.getpHIRound() + "                             ";
			String aliphIndex = "Aliphatic index: " + seqProt.getAliphIndexRound() + "                     ";
			String gravy = "GRAVY index: " + seqProt.getGravyRound() + "                    ";
			String nbOfplusAa = "Total number of positively charged residues (Arg + Lys + His): " + seqProt.getNbPositiveAA();
			String nbOgMoinsAa = "Total number of negatively charged residues (Asp + Glu): " + seqProt.getNbNegativeAA() + "            ";
			String nbOfAtom = "Total number of atoms: " + seqProt.getNbAtom() + "                                                       ";
			String formula = "Formula: " + seqProt.getFormule() + "                                                                                                      ";
			String nbOfAA = "Number of amino acids: "+ seqProt.getNbMonomer() + "                                                       ";
			String aACompo = "Amino Acid Composition: ";
			String coefExt = "Ext. Coefficient : " + seqProt.getExtCoef() + "                 ";
			String abs01perc = "Abs 0.1% (=1 g/l) : " + seqProt.getAbs01PercRound() + "                 ";
			String abs280 = "Absorbance at 280 nm ";
			labelTypeOfSeq.setText(typeOfSeq);
			labelNbOfAA.setText(nbOfAA);
			labelNbMoinsAa.setText(nbOgMoinsAa);
			labelNbPlusAa.setText(nbOfplusAa);
			labelNbOfAtom.setText(nbOfAtom);
			labelFormula.setText(formula);
			labelGravy.setText(gravy);
			labelAliphIndex.setText(aliphIndex);
			labelMw.setText(mW);
			labelPI.setText(pI);
			labelAACompo.setText(aACompo);
			labelExtCoef.setText(coefExt);
			labelAbs01perc.setText(abs01perc);
			labelAbs280.setText(abs280);

		}
	};

	class ResetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			jbutSend.setEnabled(true);
			jtaEcran.setText("");
		}}

	class abs280listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SequenceProteique seqProt2 = new SequenceProteique(jtaEcran.getText());
			String sAbs280 = jtfAbs280.getText();
			Double dAbs280 = Double.valueOf(sAbs280);
			Double dProtConc = seqProt2.ComputeProtConcentration(dAbs280, (Unite) jcbUnite.getSelectedItem());
			BigDecimal bdProtConc = (new BigDecimal(dProtConc)).setScale(5, BigDecimal.ROUND_HALF_UP);
			String sProtConc = String.valueOf(bdProtConc);
			jtfConcProt.setText(sProtConc);
		}
	}

	class UniteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SequenceProteique seqProt3 = new SequenceProteique(jtaEcran.getText());
			String sAbs280 = jtfAbs280.getText();
			Double dAbs280 = Double.valueOf(sAbs280);
			Double dProtConc = seqProt3.ComputeProtConcentration(dAbs280, (Unite) jcbUnite.getSelectedItem());
			BigDecimal bdProtConc = (new BigDecimal(dProtConc)).setScale(5, BigDecimal.ROUND_HALF_UP);
			String sProtConc = String.valueOf(bdProtConc);
			jtfConcProt.setText(sProtConc);
		}

	}
}





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
import java.nio.ByteOrder;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.sequence.AminoAcid;
import com.sequence.SequenceNucleique;
import com.sequence.SequenceProteique;
import com.sequence.Unite;

public class Fenetre extends JFrame{

	//panel
	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	JPanel panEcran = new JPanel();
	JPanel cardDna = new JPanel();
	JPanel cardDnaInfo = new JPanel();
	JPanel cardDnaTranslate = new JPanel();
	JPanel cardDnaAbs = new JPanel();
	JPanel cardDefautlt = new JPanel();
	JPanel cardProt = new JPanel();
	JPanel cardProtInfo = new JPanel();
	JPanel cardProtCompo = new JPanel();
	JPanel cardProtAbs = new JPanel();
	String[] listContent = {"PROT", "DNA", "DEFAULT"};

	private ArrayList<AminoAcid> aminoAcidList;

	//seq
	SequenceProteique seqProt;
	SequenceNucleique seqNuc;

	//ComboBox
	JComboBox<Unite> jcbUnite;
	JComboBox<String> jcbAtomicCompo;
	JComboBox<Unite> jcbUniteDna;
	JComboBox<String> jcbAtomicCompoDna;

	//Tab
	Unite[] tabJcbUnite = {Unite.M, Unite.mM, Unite.µM, Unite.nM, Unite.pM};
	String[] tabJcbAtom = {"", "Carbon", "Hydrogen", "Oxygen", "Nitrogen", "Sulfur"};
	String[] tabJcobDnaOrientation = {"3'5' Frame 1", "3'5' Frame 2", "3'5' Frame 3", "5'3' Frame 1", "5'3' Frame 2", "5'3' Frame 3"};

	//jta
	JTextArea jtaEcran = new JTextArea();
	JTextArea jtaCardProtAbsWarning, jtaCardProtInfoNote, jtaCardDnaAbsWarning, jtaCardDnaInfoNote, jtaDnaTranslate;

	//Jbutton
	JButton jbutSend, jbutReset, jbutSendProt;

	//JComboBox
	JCheckBox jcobDnaOrientation;

	//Label
	//Label Prot
	JLabel labelTypeOfSeq, labelNbOfAA, labelMw, labelPI, labelNbPlusAa, labelNbMoinsAa, labelFormula, 
	labelNbOfAtom, labelAliphIndex, labelGravy, labelAACompo, labelExtCoef, labelAbs01perc, labelAbs280,
	labelConcProt, labelAtomicCompo;
	//Label Dna
	JLabel labelMwDnaOrRna, labelTypeOfSeqDna, labelFormulaDna, 
	labelNbOfAtomDna, labelExtCoefDna, labelAbs01percDna, labelAbs280Dna,
	labelConcDna, labelAtomicCompoDna; 

	//jtf
	//JTextField Prot
	JTextField jtfTypeOfSeq, jtfNbOfAA, jtfMw, jtfPI, jtfNbPlusAa, jtfNbMoinsAa, jtfFormula, 
	jtfNbOfAtom, jtfAliphIndex, jtfGravy, jtfAACompo, jtfExtCoef, jtfAbs01perc, jtfAbs280,
	jtfConcProt, jtfAtomicCompo, jtfResultAACompo;
	//JTextField Dna
	JTextField jtfMwDnaOrRna, jtfTypeOfSeqDna, jtfFormulaDna, 
	jtfNbOfAtomDna, jtfExtCoefDna, jtfAbs01percDna, jtfAbs280Dna,
	jtfConcDna, jtfAtomicCompoDna;

	//font
	Font font = new Font("Arial", Font.PLAIN, 14);

	public Fenetre() throws HeadlessException {
		super();
		this.setSize(600, 700);
		this.setTitle("Your DNA and Protein assistant");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		initComposant();
		this.setVisible(true);
	}

	private void initComposant() {

		initPanelEcran();

		//Panel CardDefault
		cardDefautlt.setBackground(Color.gray);

		//Panel Content
		content.setPreferredSize(new Dimension(600, 410));
		content.setLayout(cl);
		content.add(cardProt, listContent[0]);
		content.add(cardDna, listContent[1]);
		content.add(cardDefautlt, listContent[2]);
		cl.show(content, listContent[2]);

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
		cardProtAbs.setLayout(new BorderLayout());
		cardProtAbs.setPreferredSize(new Dimension(320, 170));
		cardProtAbs.setBorder(BorderFactory.createTitledBorder("Protein Absorbance Properties"));
		JPanel cardProtAbs1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardProtAbs1.setPreferredSize(new Dimension(155, 110));
		JPanel cardProtAbs2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardProtAbs2.setPreferredSize(new Dimension(160, 110));
		JPanel cardProtAbs3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cardProtAbs3.setPreferredSize(new Dimension(320, 60));
		labelExtCoef = new JLabel("Ext. Coefficient : ");
		labelExtCoef.setPreferredSize(new Dimension(150, 20));
		jtfExtCoef = new JTextField();
		jtfExtCoef.setPreferredSize(new Dimension(100, 20));
		jtfExtCoef.setEditable(false);
		labelAbs01perc = new JLabel("Abs 0.1% (=1 g/l) : ");
		labelAbs01perc.setPreferredSize(new Dimension(150, 20));
		jtfAbs01perc = new JTextField();
		jtfAbs01perc.setPreferredSize(new Dimension(100, 20));
		jtfAbs01perc.setEditable(false);
		labelAbs280 = new JLabel("Absorbance at 280 nm ");
		labelAbs280.setPreferredSize(new Dimension(150, 20));
		jtfAbs280 = new JTextField();
		jtfAbs280.setToolTipText("Add absorbance value at 280 nm like 0.5");
		jtfAbs280.setPreferredSize(new Dimension(100, 20));
		jtfAbs280.addActionListener(new abs280listener());
		labelConcProt = new JLabel("Protein Concentration ");
		labelConcProt.setPreferredSize(new Dimension(150, 20));
		jtfConcProt = new JTextField();
		jtfConcProt.setPreferredSize(new Dimension(100, 20));
		jtfConcProt.setEditable(false);
		jcbUnite = new JComboBox<Unite>(tabJcbUnite);
		jcbUnite.setSelectedItem(tabJcbUnite[2]);
		jcbUnite.addActionListener(new UniteListener());
		jtaCardProtAbsWarning = new JTextArea();
		jtaCardProtAbsWarning.setEditable(false);
		jtaCardProtAbsWarning.setLineWrap(true);
		jtaCardProtAbsWarning.setWrapStyleWord(true);
		jtaCardProtAbsWarning.setBackground(Color.lightGray);
		jtaCardProtAbsWarning.setPreferredSize(new Dimension(310, 50));
		cardProtAbs1.add(labelExtCoef);
		cardProtAbs2.add(jtfExtCoef);
		cardProtAbs1.add(labelAbs01perc);
		cardProtAbs2.add(jtfAbs01perc);
		cardProtAbs1.add(labelAbs280);
		cardProtAbs2.add(jtfAbs280);
		cardProtAbs1.add(labelConcProt);
		cardProtAbs2.add(jtfConcProt);
		cardProtAbs2.add(jcbUnite);
		cardProtAbs3.add(jtaCardProtAbsWarning);
		cardProtAbs.add(cardProtAbs1, BorderLayout.WEST);
		cardProtAbs.add(cardProtAbs2, BorderLayout.EAST);
		cardProtAbs.add(cardProtAbs3, BorderLayout.SOUTH);
	}

	private void initCardProtCompo() {
		// TODO Auto-generated method stub
		cardProtCompo.setLayout(new BorderLayout());
		cardProtCompo.setPreferredSize(new Dimension(600, 210));
		cardProtCompo.setBorder(BorderFactory.createTitledBorder("Protein Composition"));
		JPanel cardProtCompo1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardProtCompo1.setPreferredSize(new Dimension(400, 150));
		JPanel cardProtCompo2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardProtCompo2.setPreferredSize(new Dimension(200, 150));
		JPanel cardProtCompo3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardProtCompo3.setPreferredSize(new Dimension(600, 60));
		labelNbOfAA = new JLabel("Number of amino acids: ");
		labelNbOfAA.setPreferredSize(new Dimension(380, 20));
		jtfNbOfAA = new JTextField();
		jtfNbOfAA.setPreferredSize(new Dimension(150, 20));
		jtfNbOfAA.setEditable(false);
		labelNbPlusAa = new JLabel("Total number of positively charged residues (Arg + Lys + His): ");
		labelNbPlusAa.setPreferredSize(new Dimension(380, 20));
		jtfNbPlusAa = new JTextField();
		jtfNbPlusAa.setPreferredSize(new Dimension(150, 20));
		jtfNbPlusAa.setEditable(false);
		labelNbMoinsAa = new JLabel("Total number of negatively charged residues (Asp + Glu): ");
		labelNbMoinsAa.setPreferredSize(new Dimension(380, 20));
		jtfNbMoinsAa = new JTextField();
		jtfNbMoinsAa.setPreferredSize(new Dimension(150, 20));
		jtfNbMoinsAa.setEditable(false);
		labelFormula = new JLabel("Formula:                                                     ");
		labelFormula.setPreferredSize(new Dimension(380, 20));
		jtfFormula = new JTextField();
		jtfFormula.setPreferredSize(new Dimension(150, 20));
		jtfFormula.setEditable(false);
		labelNbOfAtom = new JLabel("Total number of atoms:                                         ");
		labelNbOfAtom.setPreferredSize(new Dimension(380, 20));
		jtfNbOfAtom = new JTextField();
		jtfNbOfAtom.setPreferredSize(new Dimension(150, 20));
		jtfNbOfAtom.setEditable(false);
		labelAtomicCompo = new JLabel("Atomic Composition: ");
		labelAtomicCompo.setPreferredSize(new Dimension(380, 20));
		jtfAtomicCompo = new JTextField();
		jtfAtomicCompo.setPreferredSize(new Dimension(62, 20));
		jtfAtomicCompo.setEditable(false);
		jcbAtomicCompo = new JComboBox<String>(tabJcbAtom);
		jcbAtomicCompo.setSelectedItem(tabJcbAtom[0]);
		jcbAtomicCompo.addActionListener(new AtomicCompoListener());
		labelAACompo = new JLabel("Amino Acid Composition: ");
		labelAACompo.setPreferredSize(new Dimension(150, 20));
		jtfAACompo = new JTextField();
		jtfAACompo.setPreferredSize(new Dimension(40, 20));
		jtfAACompo.setToolTipText("Add 3 first letters of your amino acid");
		jtfAACompo.addActionListener(new AACompoListener());
		jtfResultAACompo = new JTextField();
		jtfResultAACompo.setPreferredSize(new Dimension(335, 20));
		jtfResultAACompo.setEditable(false);
		cardProtCompo1.add(labelNbOfAA);
		cardProtCompo2.add(jtfNbOfAA);
		cardProtCompo1.add(labelNbMoinsAa);
		cardProtCompo2.add(jtfNbMoinsAa);
		cardProtCompo1.add(labelNbPlusAa);
		cardProtCompo2.add(jtfNbPlusAa);
		cardProtCompo1.add(labelNbOfAtom);
		cardProtCompo2.add(jtfNbOfAtom);
		cardProtCompo1.add(labelFormula);
		cardProtCompo2.add(jtfFormula);
		cardProtCompo3.add(labelAtomicCompo);
		cardProtCompo3.add(jcbAtomicCompo);
		cardProtCompo3.add(jtfAtomicCompo);
		cardProtCompo3.add(labelAACompo);
		cardProtCompo3.add(jtfAACompo);
		cardProtCompo3.add(jtfResultAACompo);
		cardProtCompo.add(cardProtCompo1, BorderLayout.WEST);
		cardProtCompo.add(cardProtCompo2, BorderLayout.EAST);
		cardProtCompo.add(cardProtCompo3, BorderLayout.SOUTH);
	}

	private void initCardProtInfo() {
		// TODO Auto-generated method stub
		cardProtInfo.setLayout(new BorderLayout());
		cardProtInfo.setPreferredSize(new Dimension(280, 170));
		cardProtInfo.setBorder(BorderFactory.createTitledBorder("Protein identity"));
		JPanel cardProtInfo1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardProtInfo1.setPreferredSize(new Dimension(150, 110));
		JPanel cardProtInfo2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardProtInfo2.setPreferredSize(new Dimension(130, 110));
		JPanel cardProtInfo3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cardProtInfo3.setPreferredSize(new Dimension(280, 60));
		labelMw = new JLabel("Molecular weight (MW): ");
		labelMw.setPreferredSize(new Dimension(140, 20));
		jtfMw = new JTextField();
		jtfMw.setPreferredSize(new Dimension(90, 20));
		jtfMw.setEditable(false);
		labelPI = new JLabel("Theoretical pI: ");
		labelPI.setPreferredSize(new Dimension(130, 20));
		jtfPI = new JTextField();
		jtfPI.setPreferredSize(new Dimension(90, 20));
		jtfPI.setEditable(false);
		labelAliphIndex = new JLabel("Aliphatic index: ");
		labelAliphIndex.setPreferredSize(new Dimension(130, 20));
		jtfAliphIndex = new JTextField();
		jtfAliphIndex.setPreferredSize(new Dimension(90, 20));
		jtfAliphIndex.setEditable(false);
		labelGravy = new JLabel("GRAVY index: ");
		labelGravy.setPreferredSize(new Dimension(130, 20));
		jtfGravy = new JTextField();
		jtfGravy.setPreferredSize(new Dimension(90, 20));
		jtfGravy.setEditable(false);
		jtaCardProtInfoNote = new JTextArea("Notes: ");
		jtaCardProtInfoNote.setEditable(true);
		jtaCardProtInfoNote.setLineWrap(true);
		jtaCardProtInfoNote.setWrapStyleWord(true);
		jtaCardProtInfoNote.setAutoscrolls(true);
		jtaCardProtInfoNote.setBackground(Color.lightGray);
		jtaCardProtInfoNote.setPreferredSize(new Dimension(270, 50));
		cardProtInfo1.add(labelMw);
		cardProtInfo2.add(jtfMw);
		cardProtInfo1.add(labelPI);
		cardProtInfo2.add(jtfPI);
		cardProtInfo1.add(labelAliphIndex);
		cardProtInfo2.add(jtfAliphIndex);
		cardProtInfo1.add(labelGravy);
		cardProtInfo2.add(jtfGravy);
		cardProtInfo3.add(jtaCardProtInfoNote);
		cardProtInfo.add(cardProtInfo1, BorderLayout.WEST);
		cardProtInfo.add(cardProtInfo2, BorderLayout.EAST);
		cardProtInfo.add(cardProtInfo3, BorderLayout.SOUTH);
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
		jtaEcran.setFont(font);
		jtaEcran.setToolTipText("Copy your sequence here ...");
		JScrollPane jsp = new JScrollPane(jtaEcran);
		jsp.setPreferredSize(new Dimension(590, 200));
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
				initPanelCardProt();
				seqProt = new SequenceProteique(seq);
				System.out.println(seqProt.toString());
				cl.show(content, listContent[0]);
				initPanelProt(seqProt);
			}
			else if ( seq.matches(regexSeqDna) || seq.matches(regexSeqRna)){
				initPanelCardDNA();
				seqNuc= new SequenceNucleique(seq);
				System.out.println(seqNuc.toString());
				cl.show(content, listContent[1]);
				initPanelDna(seqNuc);
			} else {
				System.out.println("sequence undefinied");
				cl.show(content, listContent[2]);
				initPanelDefault();
			}
		}

		private void initPanelCardDNA() {
			// TODO Auto-generated method stub
			//Panel CardProt
			cardDna.setLayout(new BorderLayout());
			cardDna.setBackground(Color.WHITE);
			initCardDnaInfo();
			initCardDnaTranslate();
			initCardDnaAbs();
			cardDna.add(cardDnaAbs, BorderLayout.EAST);
			cardDna.add(cardDnaTranslate, BorderLayout.SOUTH);
			cardDna.add(cardDnaInfo, BorderLayout.WEST);
		}

		private void initCardDnaAbs() {
			// TODO Auto-generated method stub
			cardDnaAbs.setLayout(new BorderLayout());
			cardDnaAbs.setPreferredSize(new Dimension(320, 140));
			cardDnaAbs.setBorder(BorderFactory.createTitledBorder("DNA Absorbance Properties"));
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
			cardDnaAbs.add(cardDnaAbs1, BorderLayout.WEST);
			cardDnaAbs.add(cardDnaAbs2, BorderLayout.EAST);
			cardDnaAbs.add(cardDnaAbs3, BorderLayout.SOUTH);
		}

		private void initCardDnaTranslate() {
			// TODO Auto-generated method stub
			cardDnaTranslate.setLayout(new BorderLayout());
			cardDnaTranslate.setPreferredSize(new Dimension(595, 235));
			cardDnaTranslate.setBorder(BorderFactory.createTitledBorder("DNA Translate"));
			JPanel cardDnaTranslate1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			cardDnaTranslate1.setPreferredSize(new Dimension(120, 235));
			JPanel cardDnaTranslate2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			cardDnaTranslate2.setPreferredSize(new Dimension(460, 210));

			jtaDnaTranslate = new JTextArea();
			jtaDnaTranslate.setLineWrap(true);
			jtaDnaTranslate.setWrapStyleWord(true);
			jtaDnaTranslate.setAutoscrolls(true);

			for (int i = 0; i < tabJcobDnaOrientation.length; i++) {
				jcobDnaOrientation = new JCheckBox(tabJcobDnaOrientation[i]);
				cardDnaTranslate1.add(jcobDnaOrientation);
				
				jcobDnaOrientation.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
							
					}
				});

			}

			jcobDnaOrientation.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (((JCheckBox)arg0.getSource()).isSelected()) {
						if(((JCheckBox)arg0.getSource()).getText().equals("3'5' Frame 1")){
							aminoAcidList = seqNuc.getSeqTranslate35F1();
							String msg = "";
							for (AminoAcid aminoAcid : aminoAcidList) {
								msg += aminoAcid.getSyn1L();
							}
							msg += "\n";
							jtaDnaTranslate.setText(msg);
						}
						else if(((JCheckBox)arg0.getSource()).getText().equals("3'5' Frame 2")){
							aminoAcidList = seqNuc.getSeqTranslate35F2();
							String msg = "";
							for (AminoAcid aminoAcid : aminoAcidList) {
								msg += aminoAcid.getSyn1L();
							}
							msg += "\n";
							jtaDnaTranslate.setText(msg);
						}
						//							
						//							, , "3'5' Frame 3", "5'3' Frame 1", "5'3' Frame 2", "5'3' Frame 3"};

					}
				}
			});


			jbutSendProt = new JButton("Send");

			JScrollPane jsp = new JScrollPane(jtaDnaTranslate);
			jsp.setPreferredSize(new Dimension(450, 200));
			cardDnaTranslate1.add(jbutSendProt);
			cardDnaTranslate2.add(jsp);
			cardDnaTranslate.add(cardDnaTranslate1, BorderLayout.WEST);
			cardDnaTranslate.add(cardDnaTranslate2, BorderLayout.EAST);
		}

		private void initCardDnaInfo() {
			// TODO Auto-generated method stub
			cardDnaInfo.setLayout(new BorderLayout());
			cardDnaInfo.setPreferredSize(new Dimension(280, 140));
			cardDnaInfo.setBorder(BorderFactory.createTitledBorder("DNA identity"));
			JPanel cardDnaInfo1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			cardDnaInfo1.setPreferredSize(new Dimension(150, 70));
			JPanel cardDnaInfo2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			cardDnaInfo2.setPreferredSize(new Dimension(130, 70));
			JPanel cardDnaInfo3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			cardDnaInfo3.setPreferredSize(new Dimension(280, 60));
			labelMwDnaOrRna = new JLabel("Molecular weight (MW): ");
			labelMwDnaOrRna.setPreferredSize(new Dimension(140, 20));
			jtfMwDnaOrRna = new JTextField();
			jtfMwDnaOrRna.setPreferredSize(new Dimension(90, 20));
			jtfMwDnaOrRna.setEditable(false);
			jtaCardDnaInfoNote = new JTextArea("Notes: ");
			jtaCardDnaInfoNote.setEditable(true);
			jtaCardDnaInfoNote.setLineWrap(true);
			jtaCardDnaInfoNote.setWrapStyleWord(true);
			jtaCardDnaInfoNote.setAutoscrolls(true);
			jtaCardDnaInfoNote.setBackground(Color.lightGray);
			jtaCardDnaInfoNote.setPreferredSize(new Dimension(270, 50));
			cardDnaInfo1.add(labelMwDnaOrRna);
			cardDnaInfo2.add(jtfMwDnaOrRna);
			cardDnaInfo3.add(jtaCardDnaInfoNote);
			cardDnaInfo.add(cardDnaInfo1, BorderLayout.WEST);
			cardDnaInfo.add(cardDnaInfo2, BorderLayout.EAST);
			cardDnaInfo.add(cardDnaInfo3, BorderLayout.SOUTH);

		}

		private void initPanelDefault() {
			// TODO Auto-generated method stub

		}

		private void initPanelDna(SequenceNucleique seqNuc) {
			// TODO Auto-generated method stub

		}

		private void initPanelProt(SequenceProteique seqProt) {
			// TODO Auto-generated method stub
			String typeOfSeq = "Auto-Detect type of sequence: "	+ seqProt.getTypeSeq();
			labelTypeOfSeq.setText(typeOfSeq);

			jtfExtCoef.setText(seqProt.getExtCoef() + "");
			if(seqProt.getExtCoef() == 0){
				jtfAbs280.setEnabled(false);
				jtfConcProt.setEnabled(false);
				jcbUnite.setEnabled(false);
				jtfAbs280.setEditable(false);
				jtfConcProt.setEditable(false);
				jcbUnite.setEditable(false);
			}else {
				jtfAbs280.setEnabled(true);
				jtfConcProt.setEnabled(true);
				jcbUnite.setEnabled(true);
				jtfAbs280.setEditable(true);
				jcbUnite.setEditable(true);
			}
			jtfAbs01perc.setText(seqProt.getAbs01PercRound() + "");
			jtfAbs280.setText("");
			jtfConcProt.setText("");
			String msgWithoutTrpOrTyr = "Protein Concentration = Abs (280 nm) / Epsilon";
			if(seqProt.getNbTrp() == 0){
				msgWithoutTrpOrTyr = "This protein does not contain any Trp residues. Experience shows that "
						+ "this could result in more than 10% error in the computed extinction coefficient.";
				if(seqProt.getNbTyr() == 0){
					msgWithoutTrpOrTyr = "As there are no Trp, Tyr or Cys in the region considered, your protein should not be visible by UV spectrophotometry.";
				}
			} 
			jtaCardProtAbsWarning.setText(msgWithoutTrpOrTyr);

			jtfNbOfAA.setText(seqProt.getNbMonomer() + "");
			jtfNbMoinsAa.setText(seqProt.getNbNegativeAA() + "");
			jtfNbPlusAa.setText(seqProt.getNbPositiveAA() + "");
			jtfNbOfAtom.setText(seqProt.getNbAtom() + "");
			jtfFormula.setText(seqProt.getFormule() + "");
			jtfResultAACompo.setText("");
			jtfAACompo.setText("");
			jtfAtomicCompo.setText("");

			jtfMw.setText(seqProt.getmWRound() + "");
			jtfGravy.setText(seqProt.getGravyRound() + "");
			jtfAliphIndex.setText(seqProt.getAliphIndexRound() + "");
			jtfPI.setText(seqProt.getpHIRound() + "");
		}
	};

	class ResetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			cl.show(content, listContent[2]);
			jbutSend.setEnabled(true);
			jtaEcran.setText("");
		}
	}

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

	class AtomicCompoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			cardProtCompo.repaint();
			SequenceProteique seqProt4 = new SequenceProteique(jtaEcran.getText());
			if(jcbAtomicCompo.getSelectedItem().equals("Carbon")){
				jtfAtomicCompo.setText(seqProt4.getNbCatom() + "");
			}else if(jcbAtomicCompo.getSelectedItem().equals("Oxygen")){
				jtfAtomicCompo.setText(seqProt4.getNbOatom() + "");
			}else if(jcbAtomicCompo.getSelectedItem().equals("Sulfur")){
				jtfAtomicCompo.setText(seqProt4.getNbSatom() + "");
			}else if(jcbAtomicCompo.getSelectedItem().equals("Nitrogen")){
				jtfAtomicCompo.setText(seqProt4.getNbNatom() + "");
			}else if(jcbAtomicCompo.getSelectedItem().equals("Hydrogen")){
				jtfAtomicCompo.setText(seqProt4.getNbHatom() + "");
			}
		}
	}

	class AACompoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String syn3l = jtfAACompo.getText().toUpperCase();
			if(syn3l.matches("^[aA-zZ]{3}$")){
				SequenceProteique seqProt4 = new SequenceProteique(jtaEcran.getText());
				jtfResultAACompo.setText(seqProt4.describeAminoAcidComposition(seqProt4.getAminoAcidList(), syn3l));	
			}else{
				jtfResultAACompo.setText(syn3l + " is not an amino acid.");
			}
		}	

	}
}





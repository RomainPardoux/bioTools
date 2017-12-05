package com.fenetre;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import com.sequence.SequenceNucleique;
import com.sequence.SequenceProteique;

public class Fenetre extends JFrame{

	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	String[] listContent = {"PROT", "DNA", "DEFAULT"};

	JTextArea jtaEcran = new JTextArea("Copy your sequence here ...");
	//Label Prot
	JLabel labelTypeOfSeq, labelNbOfAA, labelMw, labelPI, labelNbPlusAa, labelNbMoinsAa, labelFormula, 
	labelNbOfAtom, labelAliphIndex, labelGravy, labelAACompo;



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
		// TODO Auto-generated method stub

		//Panel Ecran
		JPanel panEcran = new JPanel();
		panEcran.setPreferredSize(new Dimension(600, 240));
		jtaEcran.setAutoscrolls(true);
		jtaEcran.setLineWrap(true);
		jtaEcran.setPreferredSize(new Dimension(600, 200));
		Font font = new Font("Arial", Font.PLAIN, 14);
		jtaEcran.setFont(font);
		JScrollPane jsp = new JScrollPane(jtaEcran);
		jsp.setPreferredSize(new Dimension(550, 200));
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JButton jbutSend = new JButton("Send");
		jbutSend.addActionListener(new SendListener());
		panEcran.add(jsp);
		panEcran.add(jbutSend);

		//Panel CardProt
		labelTypeOfSeq = new JLabel();
		labelNbOfAA = new JLabel();
		labelMw = new JLabel();
		labelPI = new JLabel();
		labelNbPlusAa = new JLabel();
		labelNbMoinsAa = new JLabel();
		labelFormula = new JLabel();
		labelNbOfAtom = new JLabel();
		labelAliphIndex = new JLabel();
		labelGravy = new JLabel();
		labelAACompo = new JLabel();
		JPanel cardProt = new JPanel();
		cardProt.setLayout(new BorderLayout());
		cardProt.setBackground(Color.WHITE);
		JPanel cardProtInfo = new JPanel();
		cardProtInfo.setLayout(new FlowLayout(FlowLayout.LEFT));
		cardProtInfo.setPreferredSize(new Dimension(220, 200));
		cardProtInfo.setBorder(BorderFactory.createTitledBorder("Protein identity"));
		cardProtInfo.add(labelTypeOfSeq);
		cardProtInfo.add(labelMw);
		cardProtInfo.add(labelPI);
		cardProtInfo.add(labelAliphIndex);
		cardProtInfo.add(labelGravy);
		JPanel cardProtCompo = new JPanel();
		cardProtCompo.setLayout(new FlowLayout(FlowLayout.LEFT));
		cardProtCompo.setPreferredSize(new Dimension(220, 150));
		cardProtCompo.setBorder(BorderFactory.createTitledBorder("Protein Composition"));
		cardProtCompo.add(labelNbOfAA);
		cardProtCompo.add(labelNbMoinsAa);
		cardProtCompo.add(labelNbPlusAa);
		cardProtCompo.add(labelNbOfAtom);
		cardProtCompo.add(labelFormula);
		cardProtCompo.add(labelAACompo);
		cardProt.add(cardProtCompo, BorderLayout.SOUTH);
		cardProt.add(cardProtInfo, BorderLayout.WEST);
		
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

	class SendListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			content.repaint();
			String regexSeqProt = "^([ ]*)?[mM][ .,;-RrHhKkDdEeSsTtNnQqCcUuGgPpAaVvIiLlMmFfYyWw]*$";
			String regexSeqDna = "^[ .,;-aAtTcCgG]*$";
			String regexSeqRna = "^[ .,;-aAcCgGuU]*$";
			String seq = jtaEcran.getText();
			if ( seq.matches(regexSeqProt)){
				SequenceProteique seqProt = new SequenceProteique(seq);
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

		//		private void initPanelDefault() {
		//			// TODO Auto-generated method stub
		//			content.removeAll();
		//			content.setBackground(Color.GREEN);
		//			content.repaint();
		//		}
		//
		//		private void initPanelDna() {
		//			// TODO Auto-generated method stub
		//			content.removeAll();
		//			content.setBackground(Color.YELLOW);
		//			content.repaint();
		//		}

		private void initPanelProt(SequenceProteique seqProt) {
			// TODO Auto-generated method stub
			String typeOfSeq = "Type of sequence: "	+ seqProt.getTypeSeq();
			String nbOfAA = "Number of amino acids: "+ seqProt.getNbMonomer() + "                                                       ";
			String mW = "Molecular weight (MW): " + seqProt.getmWRound();
			String pI = "Theoretical pI: " + seqProt.getpHIRound();
			String nbOfplusAa = "Total number of positively charged residues (Arg + Lys + His): " + seqProt.getNbPositiveAA();
			String nbOgMoinsAa = "Total number of negatively charged residues (Asp + Glu): " + seqProt.getNbNegativeAA() + "            ";
			String nbOfAtom = "Total number of atoms: " + seqProt.getNbAtom() + "                                                       ";
			String formula = "Formula: " + seqProt.getFormule() + "                                                          ";
			String aliphIndex = "Aliphatic index: " + seqProt.getAliphIndexRound();
			String gravy = "GRAVY index " + seqProt.getGravyRound();
			String aACompo = "Amino Acid Composition: ";
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

		}
	};
}



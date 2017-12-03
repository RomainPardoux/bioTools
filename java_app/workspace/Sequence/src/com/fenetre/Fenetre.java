package com.fenetre;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.sequence.SequenceNucleique;
import com.sequence.SequenceProteique;

public class Fenetre extends JFrame{

	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	String[] listContent = {"PROT", "DNA", "DEFAULT"};

	JTextArea jtaEcran = new JTextArea("Copy your sequence here ...");
	//Label Prot
	JLabel labelTypeOfSeq = new JLabel();
	JLabel labelNbOfAA = new JLabel();


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

		//Panel Info
		JPanel cardProt = new JPanel();
		cardProt.setBackground(Color.ORANGE);
		cardProt.add(labelTypeOfSeq, BorderLayout.SOUTH);
		cardProt.add(labelNbOfAA, BorderLayout.WEST);
		JPanel cardDna = new JPanel();
		cardDna.setBackground(Color.MAGENTA);		
		JPanel cardDefautlt = new JPanel();
		cardDefautlt.setBackground(Color.green);
		content.setPreferredSize(new Dimension(600, 410));

		content.setLayout(cl);
		content.add(cardProt, listContent[0]);
		content.add(cardDna, listContent[1]);
		content.add(cardDefautlt, listContent[2]);

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
			String typeOfSeq = "Type of sequence: "	+ seqProt.getTypeSeq() + "                                                      ";
			String nbOfAA = "Number of amino acids: "+ seqProt.getNbMonomer() + "\n";
			labelTypeOfSeq.setText(typeOfSeq);
			labelNbOfAA.setText(nbOfAA);

		}
	};
}



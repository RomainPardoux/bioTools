package com.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sequence.SequenceNucleique;

public class CardDnaInfo extends JPanel{

	//Declaration variable

	//jta
	private JTextArea jtaCardDnaInfoNote;

	//Label Prot
	private JLabel labelMw;

	//JTextField Prot
	private JTextField jtfMw;

	//Constructeur
	public CardDnaInfo( SequenceNucleique seqNuc) {
		super();
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(280, 170));
		setBorder(BorderFactory.createTitledBorder("DNA identity"));
		JPanel cardDnaInfo1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardDnaInfo1.setPreferredSize(new Dimension(150, 70));
		JPanel cardDnaInfo2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardDnaInfo2.setPreferredSize(new Dimension(130, 70));
		JPanel cardDnaInfo3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cardDnaInfo3.setPreferredSize(new Dimension(280, 100));
		labelMw = new JLabel("Molecular weight (MW): ");
		labelMw.setPreferredSize(new Dimension(140, 20));
		jtfMw = new JTextField();
		jtfMw.setPreferredSize(new Dimension(90, 20));
		jtfMw.setEditable(false);
		jtaCardDnaInfoNote = new JTextArea("Notes: ");
		jtaCardDnaInfoNote.setEditable(true);
		jtaCardDnaInfoNote.setLineWrap(true);
		jtaCardDnaInfoNote.setWrapStyleWord(true);
		jtaCardDnaInfoNote.setAutoscrolls(true);
		jtaCardDnaInfoNote.setBackground(Color.lightGray);
		jtaCardDnaInfoNote.setPreferredSize(new Dimension(270, 90));
		cardDnaInfo1.add(labelMw);
		cardDnaInfo2.add(jtfMw);
		cardDnaInfo3.add(jtaCardDnaInfoNote);
		add(cardDnaInfo1, BorderLayout.WEST);
		add(cardDnaInfo2, BorderLayout.EAST);
		add(cardDnaInfo3, BorderLayout.SOUTH);
		
		//MAJ panel info
		if(seqNuc.isDna()){
			jtfMw.setText(seqNuc.getMwDsDnaRound() + "");
		}else if(seqNuc.isRna()){
			jtfMw.setText(seqNuc.getMwSsRnaRound() + "");
			setBorder(BorderFactory.createTitledBorder("RNA identity"));
		}
	}


}

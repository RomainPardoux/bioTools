package com.fenetre;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.sequence.SequenceNucleique;

public class PanDna extends JPanel{

	//Declaration des variables
	//panels
	private CardDnaInfo cardDnaInfo;
	private CardDnaTranslate cardDnaTranslate;
	private CardDnaAbs cardDnaAbs;
	
	//Constructeur
	public PanDna() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Constructeur
	public void initPanelCardDNA(PanProt cardProt, CardLayout cl, JPanel content, String[] listContent, String seq, SequenceNucleique seqNuc, JLabel labelTypeOfSeq, JTextArea jtaEcran) {
		// TODO Auto-generated method stub
		//Panel CardProt
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		cardDnaInfo = new CardDnaInfo(seqNuc);
		cardDnaTranslate = new CardDnaTranslate(cardProt, cl, content, listContent, seqNuc, labelTypeOfSeq, jtaEcran);
		cardDnaAbs = new CardDnaAbs(seq, seqNuc);
		add(cardDnaAbs, BorderLayout.EAST);
		add(cardDnaTranslate, BorderLayout.SOUTH);
		add(cardDnaInfo, BorderLayout.WEST);
	}

	//getters and setters
	public CardDnaInfo getCardDnaInfo() {
		return cardDnaInfo;
	}

	public void setCardDnaInfo(CardDnaInfo cardDnaInfo) {
		this.cardDnaInfo = cardDnaInfo;
	}

	public CardDnaTranslate getCardDnaTranslate() {
		return cardDnaTranslate;
	}

	public void setCardDnaTranslate(CardDnaTranslate cardDnaTranslate) {
		this.cardDnaTranslate = cardDnaTranslate;
	}

	public CardDnaAbs getCardDnaAbs() {
		return cardDnaAbs;
	}

	public void setCardDnaAbs(CardDnaAbs cardDnaAbs) {
		this.cardDnaAbs = cardDnaAbs;
	}
	
}

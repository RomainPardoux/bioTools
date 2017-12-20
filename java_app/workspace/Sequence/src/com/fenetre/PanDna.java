package com.fenetre;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
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
	public void initPanelCardDNA(PanProt cardProt, CardLayout cl, JPanel content, String[] listContent, SequenceNucleique seqNuc) {
		// TODO Auto-generated method stub
		//Panel CardProt
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		cardDnaInfo = new CardDnaInfo();
		cardDnaTranslate = new CardDnaTranslate(cardProt, cl, content, listContent, seqNuc);
		cardDnaAbs = new CardDnaAbs();
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

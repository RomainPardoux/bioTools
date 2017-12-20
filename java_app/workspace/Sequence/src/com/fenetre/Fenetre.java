package com.fenetre;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{

	//Init Variable
	//panel
	private CardLayout cl = new CardLayout();
	private JPanel content = new JPanel();
	private PanEcran panEcran = new PanEcran();
	private PanDna cardDna = new PanDna();
	private PanDefault cardDefautlt = new PanDefault();
	private PanProt cardProt = new PanProt();
	//tab
	private String[] listContent = {"PROT", "DNA", "DEFAULT"};

	//Constructeur
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

	//Methode
	private void initComposant() {
		//On instencie l'ecran
		panEcran = new PanEcran(cardProt, cardDna, cardDefautlt, cl, content, listContent);

		//On initialise le Panel Content
		content.setPreferredSize(new Dimension(600, 410));
		content.setLayout(cl);
		content.add(cardProt, listContent[0]);
		content.add(cardDna, listContent[1]);
		content.add(cardDefautlt, listContent[2]);

		//Gestion des panels card
		cl.show(content, listContent[2]);

		//On ajoute l'ecran et le content au Panel ContentPane
		this.getContentPane().add(panEcran, BorderLayout.NORTH);
		this.getContentPane().add(content, BorderLayout.CENTER);
	}
}





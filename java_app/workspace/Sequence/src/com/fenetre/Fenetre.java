package com.fenetre;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{

	//panel
	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	PanEcran panEcran = new PanEcran();
	PanDna cardDna = new PanDna();
	PanDefault cardDefautlt = new PanDefault();
	PanProt cardProt = new PanProt();
	//tab
	String[] listContent = {"PROT", "DNA", "DEFAULT"};
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

		panEcran = new PanEcran(cardProt, cardDna, cardDefautlt, cl, content, listContent);

		//Panel Content
		content.setPreferredSize(new Dimension(600, 410));
		content.setLayout(cl);
		content.add(cardProt, listContent[0]);
		content.add(cardDna, listContent[1]);
		content.add(cardDefautlt, listContent[2]);

		//gestion des panels card
		cl.show(content, listContent[2]);


		//Panel ContentPane
		this.getContentPane().add(panEcran, BorderLayout.NORTH);
		this.getContentPane().add(content, BorderLayout.CENTER);
	}
}





package com.fenetre;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
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
	private ImageIcon imageIcon = new ImageIcon("image/adnIcone.jpeg");
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
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("adnIcone.jpg")));
		initComposant();
		this.setVisible(true);		
	}

	//Methode
	private void initComposant() {
		//On instencie l'ecran
		panEcran = new PanEcran(cardProt, cardDna, cardDefautlt, cl, content, listContent);
		cardDefautlt.initPanelDefault();
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





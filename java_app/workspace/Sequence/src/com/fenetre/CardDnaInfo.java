package com.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sequence.SequenceNucleique;
import com.sequence.Unite;

public class CardDnaInfo extends JPanel{

	//Declaration variable

	//jta
	private JTextArea jtaCardDnaInfoNote;

	//Label Prot
	private JLabel labelMw;

	//JTextField Prot
	private JTextField jtfMw;

	//Constructeur
	public CardDnaInfo() {
		super();
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(280, 170));
		setBorder(BorderFactory.createTitledBorder("Protein identity"));
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
		cardProtInfo1.add(labelMw);
		cardProtInfo2.add(jtfMw);
		add(cardProtInfo1, BorderLayout.WEST);
		add(cardProtInfo2, BorderLayout.EAST);
		add(cardProtInfo3, BorderLayout.SOUTH);
	}


}

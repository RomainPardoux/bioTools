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

import com.sequence.SequenceProteique;

public class cardProtInfo extends JPanel{

	//Declaration variable

	//jta
	private JTextArea jtaCardProtInfoNote;

	//Label Prot
	private JLabel labelMw, labelPI, labelAliphIndex, labelGravy;

	//JTextField Prot
	private JTextField jtfMw, jtfPI, jtfAliphIndex, jtfGravy;

	//Constructeur
	public cardProtInfo( SequenceProteique seqProt ) {
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
		add(cardProtInfo1, BorderLayout.WEST);
		add(cardProtInfo2, BorderLayout.EAST);
		add(cardProtInfo3, BorderLayout.SOUTH);

		//MAJ panel prot info
		jtfMw.setText(seqProt.getmWRound() + "");
		jtfGravy.setText(seqProt.getGravyRound() + "");
		jtfAliphIndex.setText(seqProt.getAliphIndexRound() + "");
		jtfPI.setText(seqProt.getpHIRound() + "");
	}

	//getters and setters
	public JTextArea getJtaCardProtInfoNote() {
		return jtaCardProtInfoNote;
	}

	public void setJtaCardProtInfoNote(JTextArea jtaCardProtInfoNote) {
		this.jtaCardProtInfoNote = jtaCardProtInfoNote;
	}

	public JLabel getLabelMw() {
		return labelMw;
	}

	public void setLabelMw(JLabel labelMw) {
		this.labelMw = labelMw;
	}

	public JLabel getLabelPI() {
		return labelPI;
	}

	public void setLabelPI(JLabel labelPI) {
		this.labelPI = labelPI;
	}

	public JLabel getLabelAliphIndex() {
		return labelAliphIndex;
	}

	public void setLabelAliphIndex(JLabel labelAliphIndex) {
		this.labelAliphIndex = labelAliphIndex;
	}

	public JLabel getLabelGravy() {
		return labelGravy;
	}

	public void setLabelGravy(JLabel labelGravy) {
		this.labelGravy = labelGravy;
	}

	public JTextField getJtfMw() {
		return jtfMw;
	}

	public void setJtfMw(JTextField jtfMw) {
		this.jtfMw = jtfMw;
	}

	public JTextField getJtfPI() {
		return jtfPI;
	}

	public void setJtfPI(JTextField jtfPI) {
		this.jtfPI = jtfPI;
	}

	public JTextField getJtfAliphIndex() {
		return jtfAliphIndex;
	}

	public void setJtfAliphIndex(JTextField jtfAliphIndex) {
		this.jtfAliphIndex = jtfAliphIndex;
	}

	public JTextField getJtfGravy() {
		return jtfGravy;
	}

	public void setJtfGravy(JTextField jtfGravy) {
		this.jtfGravy = jtfGravy;
	}	
}

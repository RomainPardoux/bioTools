package com.fenetre;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.sequence.SequenceNucleique;
import com.sequence.SequenceProteique;

public class PanEcran extends JPanel{

	//Declaration des variables
	//jta
	private JTextArea jtaEcran = new JTextArea();
	//jsp
	private JScrollPane jsp = new JScrollPane(jtaEcran);
	//panel
	private JPanel panEcranInfo = new JPanel();
	//Label Prot
	private JLabel labelTypeOfSeq;
	//font
	private Font font = new Font("Arial", Font.PLAIN, 14);
	//Jbutton
	private JButton jbutSend, jbutReset;
	//sequence
	private SequenceProteique seqProt;
	private SequenceNucleique seqNuc;
	//regex
	private String regexSeqProt = "";
	private String regexSeqDna = "";
	private String regexSeqRna = "";
	//seq
	String seq = "";
	//panel
	PanProt cardProt; 
	PanDna cardDna; 
	PanDefault cardDefautlt;
	CardLayout cl;
	JPanel content;
	String[] listContent;
	
	//Constructeur
	public PanEcran(PanProt cardProt, PanDna cardDna, PanDefault cardDefautlt, CardLayout cl, JPanel content, String[] listContent) {
		super();
		this.cardProt = cardProt;
		this.cardDna = cardDna;
		this.cardDefautlt = cardDefautlt;
		this.cl = cl;
		this.content = content;
		this.listContent = listContent;
		initPanelEcran();
	}

	public PanEcran() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Methodes
	public void initPanelEcran() {
		// TODO Auto-generated method stub
		//Panel Ecran
		this.setPreferredSize(new Dimension(600, 270));
		this.setBackground(Color.DARK_GRAY);
		//panEcranInfo
		panEcranInfo.setPreferredSize(new Dimension(600, 20));
		panEcranInfo.setBackground(Color.DARK_GRAY);
		labelTypeOfSeq = new JLabel();
		labelTypeOfSeq.setForeground(Color.WHITE);
		panEcranInfo.add(labelTypeOfSeq);
		//jtaEcran
		jtaEcran.setAutoscrolls(true);
		jtaEcran.setLineWrap(true);
		jtaEcran.setFont(font);
		jtaEcran.setToolTipText("Copy your sequence here ...");
		//jsp
		jsp.setPreferredSize(new Dimension(590, 200));
		//button
		jbutSend = new JButton("Send");
		jbutSend.addActionListener(new SendListener());
		jbutReset = new JButton("Reset");
		jbutReset.setEnabled(false);
		jbutReset.addActionListener(new ResetListener());
		//cablage au panel Ecran
		this.add(panEcranInfo);
		this.add(jsp);
		this.add(jbutReset);
		this.add(jbutSend);
	}
	
	//class interne
	public class SendListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			content.repaint();
			jbutSend.setEnabled(false);
			jbutReset.setEnabled(true);
			regexSeqProt = "^([ ]*)?[mM][ .,;-RrHhKkDdEeSsTtNnQqCcUuGgPpAaVvIiLlMmFfYyWw]*$";
			regexSeqDna = "^[ .,;-aAtTcCgG]*$";
			regexSeqRna = "^[ .,;-aAcCgGuU]*$";
			//On recupere la sequence
			seq = jtaEcran.getText();
			//Si seq prot :
			if ( seq.matches(regexSeqProt)){
//				cardProt = new PanProt(jtaEcran);
				cardProt.initPanelCardProt(jtaEcran);
				seqProt = new SequenceProteique(seq);
				System.out.println(seqProt.toString());
				cl.show(content, listContent[0]);
				//MAJ panel ecran
				String typeOfSeq = "Auto-Detect type of sequence: "	+ seqProt.getTypeSeq();
				labelTypeOfSeq.setText(typeOfSeq);
				cardProt.majIfPanelProt(seqProt);
			}
			//Sinon si seq nuc
			else if ( seq.matches(regexSeqDna) || seq.matches(regexSeqRna)){
//				cardDna = new PanDna();
				cardDna.initPanelCardDNA();
				seqNuc = new SequenceNucleique(seq);
				System.out.println(seqNuc.toString());
				cl.show(content, listContent[1]);
				cardDna.majIfPanelDna(seqNuc);
			//Sinon
			} else {
				cardDefautlt = new PanDefault();
				cardDefautlt.initPanelDefault();
				System.out.println("sequence undefinied");
				cl.show(content, listContent[2]);
				cardDefautlt.initPanelDefault();
			}
		}
	}
	
	public class ResetListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
//			content.removeAll();
			cardProt.removeAll();
			cardDefautlt.removeAll();
			cardDna.removeAll();
			cl.show(content, listContent[2]);
			jbutSend.setEnabled(true);
			jtaEcran.setText("");
		}
	}

	//getters and setters
	public JTextArea getJtaEcran() {
		return jtaEcran;
	}

	public void setJtaEcran(JTextArea jtaEcran) {
		this.jtaEcran = jtaEcran;
	}

	public JScrollPane getJsp() {
		return jsp;
	}

	public void setJsp(JScrollPane jsp) {
		this.jsp = jsp;
	}

	public JPanel getPanEcranInfo() {
		return panEcranInfo;
	}

	public void setPanEcranInfo(JPanel panEcranInfo) {
		this.panEcranInfo = panEcranInfo;
	}

	public JLabel getLabelTypeOfSeq() {
		return labelTypeOfSeq;
	}

	public void setLabelTypeOfSeq(JLabel labelTypeOfSeq) {
		this.labelTypeOfSeq = labelTypeOfSeq;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public JButton getJbutSend() {
		return jbutSend;
	}

	public void setJbutSend(JButton jbutSend) {
		this.jbutSend = jbutSend;
	}

	public JButton getJbutReset() {
		return jbutReset;
	}

	public void setJbutReset(JButton jbutReset) {
		this.jbutReset = jbutReset;
	}

	public SequenceProteique getSeqProt() {
		return seqProt;
	}

	public void setSeqProt(SequenceProteique seqProt) {
		this.seqProt = seqProt;
	}

	public SequenceNucleique getSeqNuc() {
		return seqNuc;
	}

	public void setSeqNuc(SequenceNucleique seqNuc) {
		this.seqNuc = seqNuc;
	}

	public String getRegexSeqProt() {
		return regexSeqProt;
	}

	public void setRegexSeqProt(String regexSeqProt) {
		this.regexSeqProt = regexSeqProt;
	}

	public String getRegexSeqDna() {
		return regexSeqDna;
	}

	public void setRegexSeqDna(String regexSeqDna) {
		this.regexSeqDna = regexSeqDna;
	}

	public String getRegexSeqRna() {
		return regexSeqRna;
	}

	public void setRegexSeqRna(String regexSeqRna) {
		this.regexSeqRna = regexSeqRna;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}	
}

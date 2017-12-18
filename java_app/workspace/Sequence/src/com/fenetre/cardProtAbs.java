package com.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sequence.SequenceProteique;
import com.sequence.Unite;

public class cardProtAbs extends JPanel{

	//ComboBox
	private JComboBox<Unite> jcbUnite;
	//Tab
	private Unite[] tabJcbUnite = {Unite.M, Unite.mM, Unite.µM, Unite.nM, Unite.pM};
	//jta
	private JTextArea jtaCardProtAbsWarning;

	//Label Prot
	private JLabel labelExtCoef, labelAbs01perc, labelAbs280,
	labelConcProt;

	//JTextField Prot
	private JTextField jtfExtCoef, jtfAbs01perc, jtfAbs280,
	jtfConcProt;

	private String seq = "";

	//Constructeur
	public cardProtAbs(JTextArea jtaEcran, SequenceProteique seqProt) {
		super();
		// TODO Auto-generated method stub
		seq = jtaEcran.getText();
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(320, 170));
		setBorder(BorderFactory.createTitledBorder("Protein Absorbance Properties"));
		JPanel cardProtAbs1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardProtAbs1.setPreferredSize(new Dimension(155, 110));
		JPanel cardProtAbs2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardProtAbs2.setPreferredSize(new Dimension(160, 110));
		JPanel cardProtAbs3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cardProtAbs3.setPreferredSize(new Dimension(320, 60));
		labelExtCoef = new JLabel("Ext. Coefficient : ");
		labelExtCoef.setPreferredSize(new Dimension(150, 20));
		jtfExtCoef = new JTextField();
		jtfExtCoef.setPreferredSize(new Dimension(100, 20));
		jtfExtCoef.setEditable(false);
		labelAbs01perc = new JLabel("Abs 0.1% (=1 g/l) : ");
		labelAbs01perc.setPreferredSize(new Dimension(150, 20));
		jtfAbs01perc = new JTextField();
		jtfAbs01perc.setPreferredSize(new Dimension(100, 20));
		jtfAbs01perc.setEditable(false);
		labelAbs280 = new JLabel("Absorbance at 280 nm ");
		labelAbs280.setPreferredSize(new Dimension(150, 20));
		jtfAbs280 = new JTextField();
		jtfAbs280.setToolTipText("Add absorbance value at 280 nm like 0.5");
		jtfAbs280.setPreferredSize(new Dimension(100, 20));
		jtfAbs280.addActionListener(new abs280listener());
		labelConcProt = new JLabel("Protein Concentration ");
		labelConcProt.setPreferredSize(new Dimension(150, 20));
		jtfConcProt = new JTextField();
		jtfConcProt.setPreferredSize(new Dimension(100, 20));
		jtfConcProt.setEditable(false);
		jcbUnite = new JComboBox<Unite>(tabJcbUnite);
		jcbUnite.setSelectedItem(tabJcbUnite[2]);
		jcbUnite.addActionListener(new UniteListener());
		jtaCardProtAbsWarning = new JTextArea();
		jtaCardProtAbsWarning.setEditable(false);
		jtaCardProtAbsWarning.setLineWrap(true);
		jtaCardProtAbsWarning.setWrapStyleWord(true);
		jtaCardProtAbsWarning.setBackground(Color.lightGray);
		jtaCardProtAbsWarning.setPreferredSize(new Dimension(310, 50));
		cardProtAbs1.add(labelExtCoef);
		cardProtAbs2.add(jtfExtCoef);
		cardProtAbs1.add(labelAbs01perc);
		cardProtAbs2.add(jtfAbs01perc);
		cardProtAbs1.add(labelAbs280);
		cardProtAbs2.add(jtfAbs280);
		cardProtAbs1.add(labelConcProt);
		cardProtAbs2.add(jtfConcProt);
		cardProtAbs2.add(jcbUnite);
		cardProtAbs3.add(jtaCardProtAbsWarning);
		add(cardProtAbs1, BorderLayout.WEST);
		add(cardProtAbs2, BorderLayout.EAST);
		add(cardProtAbs3, BorderLayout.SOUTH);
		
		//coef ext mol
		jtfExtCoef.setText(seqProt.getExtCoef() + "");
		if(seqProt.getExtCoef() == 0){
			jtfAbs280.setEnabled(false);
			jtfConcProt.setEnabled(false);
			jcbUnite.setEnabled(false);
			jtfAbs280.setEditable(false);
			jtfConcProt.setEditable(false);
			jcbUnite.setEditable(false);
		}else {
			jtfAbs280.setEnabled(true);
			jtfConcProt.setEnabled(true);
			jcbUnite.setEnabled(true);
			jtfAbs280.setEditable(true);
			jcbUnite.setEditable(true);
		}
		jtfAbs01perc.setText(seqProt.getAbs01PercRound() + "");
		jtfAbs280.setText("");
		jtfConcProt.setText("");
		//msg personalis√©
		String msgWithoutTrpOrTyr = "Protein Concentration = Abs (280 nm) / Epsilon";
		if(seqProt.getNbTrp() == 0){
			msgWithoutTrpOrTyr = "This protein does not contain any Trp residues. Experience shows that "
					+ "this could result in more than 10% error in the computed extinction coefficient.";
			if(seqProt.getNbTyr() == 0){
				msgWithoutTrpOrTyr = "As there are no Trp, Tyr or Cys in the region considered, your protein should not be visible by UV spectrophotometry.";
			}
		} 
		jtaCardProtAbsWarning.setText(msgWithoutTrpOrTyr);
	}

	//class interne (listeners)
	class abs280listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SequenceProteique seqProt2 = new SequenceProteique(seq);

			String sAbs280 = jtfAbs280.getText();
			Double dAbs280 = Double.valueOf(sAbs280);
			Double dProtConc = seqProt2.ComputeProtConcentration(dAbs280, (Unite) jcbUnite.getSelectedItem());
			BigDecimal bdProtConc = (new BigDecimal(dProtConc)).setScale(5, BigDecimal.ROUND_HALF_UP);
			String sProtConc = String.valueOf(bdProtConc);
			jtfConcProt.setText(sProtConc);
		}

	}

	class UniteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SequenceProteique seqProt3 = new SequenceProteique(seq);
			String sAbs280 = jtfAbs280.getText();
			Double dAbs280 = Double.valueOf(sAbs280);
			Double dProtConc = seqProt3.ComputeProtConcentration(dAbs280, (Unite) jcbUnite.getSelectedItem());
			BigDecimal bdProtConc = (new BigDecimal(dProtConc)).setScale(5, BigDecimal.ROUND_HALF_UP);
			String sProtConc = String.valueOf(bdProtConc);
			jtfConcProt.setText(sProtConc);
		}

	}

	// getters and setters
	public JComboBox<Unite> getJcbUnite() {
		return jcbUnite;
	}

	public void setJcbUnite(JComboBox<Unite> jcbUnite) {
		this.jcbUnite = jcbUnite;
	}

	public Unite[] getTabJcbUnite() {
		return tabJcbUnite;
	}

	public void setTabJcbUnite(Unite[] tabJcbUnite) {
		this.tabJcbUnite = tabJcbUnite;
	}

	public JTextArea getJtaCardProtAbsWarning() {
		return jtaCardProtAbsWarning;
	}

	public void setJtaCardProtAbsWarning(JTextArea jtaCardProtAbsWarning) {
		this.jtaCardProtAbsWarning = jtaCardProtAbsWarning;
	}

	public JLabel getLabelExtCoef() {
		return labelExtCoef;
	}

	public void setLabelExtCoef(JLabel labelExtCoef) {
		this.labelExtCoef = labelExtCoef;
	}

	public JLabel getLabelAbs01perc() {
		return labelAbs01perc;
	}

	public void setLabelAbs01perc(JLabel labelAbs01perc) {
		this.labelAbs01perc = labelAbs01perc;
	}

	public JLabel getLabelAbs280() {
		return labelAbs280;
	}

	public void setLabelAbs280(JLabel labelAbs280) {
		this.labelAbs280 = labelAbs280;
	}

	public JLabel getLabelConcProt() {
		return labelConcProt;
	}

	public void setLabelConcProt(JLabel labelConcProt) {
		this.labelConcProt = labelConcProt;
	}

	public JTextField getJtfExtCoef() {
		return jtfExtCoef;
	}

	public void setJtfExtCoef(JTextField jtfExtCoef) {
		this.jtfExtCoef = jtfExtCoef;
	}

	public JTextField getJtfAbs01perc() {
		return jtfAbs01perc;
	}

	public void setJtfAbs01perc(JTextField jtfAbs01perc) {
		this.jtfAbs01perc = jtfAbs01perc;
	}

	public JTextField getJtfAbs280() {
		return jtfAbs280;
	}

	public void setJtfAbs280(JTextField jtfAbs280) {
		this.jtfAbs280 = jtfAbs280;
	}

	public JTextField getJtfConcProt() {
		return jtfConcProt;
	}

	public void setJtfConcProt(JTextField jtfConcProt) {
		this.jtfConcProt = jtfConcProt;
	}	
}

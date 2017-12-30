package com.fenetre;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sequence.SequenceProteique;

public class cardProtCompo extends JPanel{

	//Declaration variable
	private JComboBox<String> jcbAtomicCompo;
	private String[] tabJcbAtom = {"", "Carbon", "Hydrogen", "Oxygen", "Nitrogen", "Sulfur"};

	//Label Prot
	private JLabel labelNbOfAA, labelNbPlusAa, labelNbMoinsAa, labelFormula, 
	labelNbOfAtom, labelAACompo, labelAtomicCompo;

	//JTextField Prot
	private JTextField jtfNbOfAA, jtfNbPlusAa, jtfNbMoinsAa, jtfFormula, 
	jtfNbOfAtom, jtfAACompo, jtfAtomicCompo, jtfResultAACompo;

	//Sequence
	private String seq = "";

	//Constructeur
	public cardProtCompo(String seq, SequenceProteique seqProt) {
		super();
		this.seq = seq;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 210));
		setBorder(BorderFactory.createTitledBorder("Protein Composition"));
		JPanel cardProtCompo1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardProtCompo1.setPreferredSize(new Dimension(400, 150));
		JPanel cardProtCompo2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardProtCompo2.setPreferredSize(new Dimension(180, 150));
		JPanel cardProtCompo3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardProtCompo3.setPreferredSize(new Dimension(600, 60));
		labelNbOfAA = new JLabel("Number of amino acids: ");
		labelNbOfAA.setPreferredSize(new Dimension(380, 20));
		jtfNbOfAA = new JTextField();
		jtfNbOfAA.setPreferredSize(new Dimension(150, 20));
		jtfNbOfAA.setEditable(false);
		labelNbPlusAa = new JLabel("Total number of positively charged residues (Arg + Lys + His): ");
		labelNbPlusAa.setPreferredSize(new Dimension(380, 20));
		jtfNbPlusAa = new JTextField();
		jtfNbPlusAa.setPreferredSize(new Dimension(150, 20));
		jtfNbPlusAa.setEditable(false);
		labelNbMoinsAa = new JLabel("Total number of negatively charged residues (Asp + Glu): ");
		labelNbMoinsAa.setPreferredSize(new Dimension(380, 20));
		jtfNbMoinsAa = new JTextField();
		jtfNbMoinsAa.setPreferredSize(new Dimension(150, 20));
		jtfNbMoinsAa.setEditable(false);
		labelFormula = new JLabel("Formula:");
		labelFormula.setPreferredSize(new Dimension(380, 20));
		jtfFormula = new JTextField();
		jtfFormula.setPreferredSize(new Dimension(150, 20));
		jtfFormula.setEditable(false);
		labelNbOfAtom = new JLabel("Total number of atoms:");
		labelNbOfAtom.setPreferredSize(new Dimension(380, 20));
		jtfNbOfAtom = new JTextField();
		jtfNbOfAtom.setPreferredSize(new Dimension(150, 20));
		jtfNbOfAtom.setEditable(false);
		labelAtomicCompo = new JLabel("Atomic Composition: ");
		labelAtomicCompo.setPreferredSize(new Dimension(400, 20));
		jtfAtomicCompo = new JTextField();
		jtfAtomicCompo.setPreferredSize(new Dimension(62, 20));
		jtfAtomicCompo.setEditable(false);
		jcbAtomicCompo = new JComboBox<String>(tabJcbAtom);
		jcbAtomicCompo.setSelectedItem(tabJcbAtom[0]);
		jcbAtomicCompo.addActionListener(new AtomicCompoListener());
		labelAACompo = new JLabel("Amino Acid Composition: ");
		labelAACompo.setPreferredSize(new Dimension(150, 20));
		jtfAACompo = new JTextField();
		jtfAACompo.setPreferredSize(new Dimension(40, 20));
		jtfAACompo.setToolTipText("Add 3 first letters of your amino acid");
		jtfAACompo.addActionListener(new AACompoListener());
		jtfResultAACompo = new JTextField();
		jtfResultAACompo.setPreferredSize(new Dimension(355, 20));
		jtfResultAACompo.setEditable(false);
		cardProtCompo1.add(labelNbOfAA);
		cardProtCompo2.add(jtfNbOfAA);
		cardProtCompo1.add(labelNbMoinsAa);
		cardProtCompo2.add(jtfNbMoinsAa);
		cardProtCompo1.add(labelNbPlusAa);
		cardProtCompo2.add(jtfNbPlusAa);
		cardProtCompo1.add(labelNbOfAtom);
		cardProtCompo2.add(jtfNbOfAtom);
		cardProtCompo1.add(labelFormula);
		cardProtCompo2.add(jtfFormula);
		cardProtCompo3.add(labelAtomicCompo);
		cardProtCompo3.add(jcbAtomicCompo);
		cardProtCompo3.add(jtfAtomicCompo);
		cardProtCompo3.add(labelAACompo);
		cardProtCompo3.add(jtfAACompo);
		cardProtCompo3.add(jtfResultAACompo);
		add(cardProtCompo1, BorderLayout.WEST);
		add(cardProtCompo2, BorderLayout.EAST);
		add(cardProtCompo3, BorderLayout.SOUTH);

		//MAJ panel prot compo
		jtfNbOfAA.setText(seqProt.getNbMonomer() + "");
		jtfNbMoinsAa.setText(seqProt.getNbNegativeAA() + "");
		jtfNbPlusAa.setText(seqProt.getNbPositiveAA() + "");
		jtfNbOfAtom.setText(seqProt.getNbAtom() + "");
		jtfFormula.setText(seqProt.getFormule() + "");
		jtfResultAACompo.setText("");
		jtfAACompo.setText("");
		jtfAtomicCompo.setText("");
	}

	//class interne (listeners)
	class AtomicCompoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SequenceProteique seqProt4 = new SequenceProteique(seq);
			if(jcbAtomicCompo.getSelectedItem().equals("Carbon")){
				jtfAtomicCompo.setText(seqProt4.getNbCatom() + "");
			}else if(jcbAtomicCompo.getSelectedItem().equals("Oxygen")){
				jtfAtomicCompo.setText(seqProt4.getNbOatom() + "");
			}else if(jcbAtomicCompo.getSelectedItem().equals("Sulfur")){
				jtfAtomicCompo.setText(seqProt4.getNbSatom() + "");
			}else if(jcbAtomicCompo.getSelectedItem().equals("Nitrogen")){
				jtfAtomicCompo.setText(seqProt4.getNbNatom() + "");
			}else if(jcbAtomicCompo.getSelectedItem().equals("Hydrogen")){
				jtfAtomicCompo.setText(seqProt4.getNbHatom() + "");
			}
		}
	}

	class AACompoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String syn3l = jtfAACompo.getText().toUpperCase();
			if(syn3l.matches("^[aA-zZ]{3}$")){
				SequenceProteique seqProt4 = new SequenceProteique(seq);
				jtfResultAACompo.setText(seqProt4.describeAminoAcidComposition(seqProt4.getAminoAcidList(), syn3l));	
			}else{
				jtfResultAACompo.setText(syn3l + " is not an amino acid.");
			}
		}	

	}

	//getters and setters
	public JComboBox<String> getJcbAtomicCompo() {
		return jcbAtomicCompo;
	}

	public void setJcbAtomicCompo(JComboBox<String> jcbAtomicCompo) {
		this.jcbAtomicCompo = jcbAtomicCompo;
	}

	public String[] getTabJcbAtom() {
		return tabJcbAtom;
	}

	public void setTabJcbAtom(String[] tabJcbAtom) {
		this.tabJcbAtom = tabJcbAtom;
	}

	public JLabel getLabelNbOfAA() {
		return labelNbOfAA;
	}

	public void setLabelNbOfAA(JLabel labelNbOfAA) {
		this.labelNbOfAA = labelNbOfAA;
	}

	public JLabel getLabelNbPlusAa() {
		return labelNbPlusAa;
	}

	public void setLabelNbPlusAa(JLabel labelNbPlusAa) {
		this.labelNbPlusAa = labelNbPlusAa;
	}

	public JLabel getLabelNbMoinsAa() {
		return labelNbMoinsAa;
	}

	public void setLabelNbMoinsAa(JLabel labelNbMoinsAa) {
		this.labelNbMoinsAa = labelNbMoinsAa;
	}

	public JLabel getLabelFormula() {
		return labelFormula;
	}

	public void setLabelFormula(JLabel labelFormula) {
		this.labelFormula = labelFormula;
	}

	public JLabel getLabelNbOfAtom() {
		return labelNbOfAtom;
	}

	public void setLabelNbOfAtom(JLabel labelNbOfAtom) {
		this.labelNbOfAtom = labelNbOfAtom;
	}

	public JLabel getLabelAACompo() {
		return labelAACompo;
	}

	public void setLabelAACompo(JLabel labelAACompo) {
		this.labelAACompo = labelAACompo;
	}

	public JLabel getLabelAtomicCompo() {
		return labelAtomicCompo;
	}

	public void setLabelAtomicCompo(JLabel labelAtomicCompo) {
		this.labelAtomicCompo = labelAtomicCompo;
	}

	public JTextField getJtfNbOfAA() {
		return jtfNbOfAA;
	}

	public void setJtfNbOfAA(JTextField jtfNbOfAA) {
		this.jtfNbOfAA = jtfNbOfAA;
	}

	public JTextField getJtfNbPlusAa() {
		return jtfNbPlusAa;
	}

	public void setJtfNbPlusAa(JTextField jtfNbPlusAa) {
		this.jtfNbPlusAa = jtfNbPlusAa;
	}

	public JTextField getJtfNbMoinsAa() {
		return jtfNbMoinsAa;
	}

	public void setJtfNbMoinsAa(JTextField jtfNbMoinsAa) {
		this.jtfNbMoinsAa = jtfNbMoinsAa;
	}

	public JTextField getJtfFormula() {
		return jtfFormula;
	}

	public void setJtfFormula(JTextField jtfFormula) {
		this.jtfFormula = jtfFormula;
	}

	public JTextField getJtfNbOfAtom() {
		return jtfNbOfAtom;
	}

	public void setJtfNbOfAtom(JTextField jtfNbOfAtom) {
		this.jtfNbOfAtom = jtfNbOfAtom;
	}

	public JTextField getJtfAACompo() {
		return jtfAACompo;
	}

	public void setJtfAACompo(JTextField jtfAACompo) {
		this.jtfAACompo = jtfAACompo;
	}

	public JTextField getJtfAtomicCompo() {
		return jtfAtomicCompo;
	}

	public void setJtfAtomicCompo(JTextField jtfAtomicCompo) {
		this.jtfAtomicCompo = jtfAtomicCompo;
	}

	public JTextField getJtfResultAACompo() {
		return jtfResultAACompo;
	}

	public void setJtfResultAACompo(JTextField jtfResultAACompo) {
		this.jtfResultAACompo = jtfResultAACompo;
	}


}

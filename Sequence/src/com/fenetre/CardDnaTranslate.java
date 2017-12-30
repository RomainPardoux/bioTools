package com.fenetre;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.sequence.AminoAcid;
import com.sequence.SequenceNucleique;
import com.sequence.SequenceProteique;

public class CardDnaTranslate extends JPanel{

	private CardDnaTranslate cardDnaTranslate;
	//seq
	private SequenceNucleique seqNuc;
	//list
	private ArrayList<AminoAcid> aminoAcidList35F1 = new ArrayList<AminoAcid>();
	private ArrayList<AminoAcid> aminoAcidList35F2 = new ArrayList<AminoAcid>();
	private ArrayList<AminoAcid> aminoAcidList35F3 = new ArrayList<AminoAcid>();
	private ArrayList<AminoAcid> aminoAcidList53F1 = new ArrayList<AminoAcid>();
	private ArrayList<AminoAcid> aminoAcidList53F2 = new ArrayList<AminoAcid>();
	private ArrayList<AminoAcid> aminoAcidList53F3 = new ArrayList<AminoAcid>();

	//seq string
	private String seq35F1, seq35F2, seq35F3, seq53F1, seq53F2, seq53F3;
	private String seq35F1plus, seq35F2plus, seq35F3plus, seq53F1plus, seq53F2plus, seq53F3plus;
	private String orf35F1, orf35F2, orf35F3, orf53F1, orf53F2, orf53F3;
	private String seqTranslate = "";
	//Tab
	private String[] tabJcobDnaOrientation = {"3'5' Frame 1", "3'5' Frame 2", "3'5' Frame 3", "5'3' Frame 1", "5'3' Frame 2", "5'3' Frame 3"};
	//Seq prot
	private SequenceProteique seqProt;
	//jta
	private JTextArea jtaDnaTranslate;
	//Jbutton
	private JButton jbutSendProt;
	//JComboBox
	private JCheckBox jcob35F1, jcob35F2, jcob35F3, jcob53F1, jcob53F2, jcob53F3;

	public CardDnaTranslate(PanProt cardProt, CardLayout cl, JPanel content, String[] listContent, SequenceNucleique seqNuc, JLabel labelTypeOfSeq, JTextArea jtaEcran) {
		super();
		this.seqNuc = seqNuc;
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(595, 235));
		setBorder(BorderFactory.createTitledBorder("DNA Translate"));
		JPanel cardDnaTranslate1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardDnaTranslate1.setPreferredSize(new Dimension(120, 235));
		JPanel cardDnaTranslate2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cardDnaTranslate2.setPreferredSize(new Dimension(460, 210));

		if (seqNuc.isDna()) {
			setBorder(BorderFactory.createTitledBorder("DNA Translate"));
		}else{
			setBorder(BorderFactory.createTitledBorder("RNA Translate"));
		}
		
		//jtaDnaTranslate
		jtaDnaTranslate = new JTextArea();
		jtaDnaTranslate.setLineWrap(true);
		jtaDnaTranslate.setWrapStyleWord(true);
		jtaDnaTranslate.setAutoscrolls(true);

		//init list amino acid
		aminoAcidList35F1 = seqNuc.getSeqTranslate35F1();
		aminoAcidList35F2 = seqNuc.getSeqTranslate35F2();
		aminoAcidList35F3 = seqNuc.getSeqTranslate35F3();
		aminoAcidList53F1 = seqNuc.getSeqTranslate53F1();
		aminoAcidList53F2 = seqNuc.getSeqTranslate53F2();
		aminoAcidList53F3 = seqNuc.getSeqTranslate53F3();
		//init seq prot translate
		seq35F1plus = "3'5' Frame 1\n";
		seq35F2plus = "3'5' Frame 2\n";
		seq35F3plus = "3'5' Frame 3\n";
		seq53F1plus = "5'3' Frame 1\n";
		seq53F2plus = "5'3' Frame 2\n";
		seq53F3plus = "5'3' Frame 3\n";
		seq35F1 = "";
		seq35F2 = "";
		seq35F3 = "";
		seq53F1 = "";
		seq53F2 = "";
		seq53F3 = "";

		for (AminoAcid aminoAcid : aminoAcidList35F1) {
			seq35F1plus += String.valueOf(aminoAcid.getSyn1L());
			seq35F1 += String.valueOf(aminoAcid.getSyn1L());
		}

		for (AminoAcid aminoAcid : aminoAcidList35F2) {
			seq35F2plus += String.valueOf(aminoAcid.getSyn1L());
			seq35F2 += String.valueOf(aminoAcid.getSyn1L());
		}

		for (AminoAcid aminoAcid : aminoAcidList35F3) {
			seq35F3plus += String.valueOf(aminoAcid.getSyn1L());
			seq35F3 += String.valueOf(aminoAcid.getSyn1L());
		}

		for (AminoAcid aminoAcid : aminoAcidList53F1) {
			seq53F1plus += String.valueOf(aminoAcid.getSyn1L());
			seq53F1 += String.valueOf(aminoAcid.getSyn1L());
		}

		for (AminoAcid aminoAcid : aminoAcidList53F2) {
			seq53F2plus += String.valueOf(aminoAcid.getSyn1L());
			seq53F2 += String.valueOf(aminoAcid.getSyn1L());
		}

		for (AminoAcid aminoAcid : aminoAcidList53F3) {
			seq53F3plus += String.valueOf(aminoAcid.getSyn1L());
			seq53F3 += String.valueOf(aminoAcid.getSyn1L());
		}

		//init orf
		orf35F1 = modifyBeforeSendSeqProt(seq35F1);
		orf35F2 = modifyBeforeSendSeqProt(seq35F2);
		orf35F3 = modifyBeforeSendSeqProt(seq35F3);
		orf53F1 = modifyBeforeSendSeqProt(seq53F1);
		orf53F2 = modifyBeforeSendSeqProt(seq53F2);
		orf53F3 = modifyBeforeSendSeqProt(seq53F3);

		//checkBox
		jcob53F1 = new JCheckBox(tabJcobDnaOrientation[3]);
		cardDnaTranslate1.add(jcob53F1);
		jcob53F2 = new JCheckBox(tabJcobDnaOrientation[4]);
		cardDnaTranslate1.add(jcob53F2);
		jcob53F3 = new JCheckBox(tabJcobDnaOrientation[5]);
		cardDnaTranslate1.add(jcob53F3);
		jcob35F1 = new JCheckBox(tabJcobDnaOrientation[0]);
		cardDnaTranslate1.add(jcob35F1);
		jcob35F2 = new JCheckBox(tabJcobDnaOrientation[1]);
		cardDnaTranslate1.add(jcob35F2);
		jcob35F3 = new JCheckBox(tabJcobDnaOrientation[2]);
		cardDnaTranslate1.add(jcob35F3);

		autoSelectGoodSeq();

		jcob53F1.addActionListener(new PrepareForTranslateListener());
		jcob53F2.addActionListener(new PrepareForTranslateListener());
		jcob53F3.addActionListener(new PrepareForTranslateListener());
		jcob35F1.addActionListener(new PrepareForTranslateListener());
		jcob35F2.addActionListener(new PrepareForTranslateListener());
		jcob35F3.addActionListener(new PrepareForTranslateListener());
		jbutSendProt = new JButton("Analyse");
		jbutSendProt.setToolTipText("Analysis the selected translated ORF");
		onlyOneSelected();
		jbutSendProt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String seq = "";
				cardProt.removeAll();
				cardProt.repaint();
				if(jcob35F1.isSelected()){
					seq = modifyBeforeSendSeqProt(seq35F1);
					seqProt = new SequenceProteique(seq);
					cardProt.initPanelCardProt(seq, seqProt);
					jtaEcran.setText(orf35F1);
				}if(jcob35F2.isSelected()){
					seq = modifyBeforeSendSeqProt(seq35F2);
					seqProt = new SequenceProteique(seq);
					cardProt.initPanelCardProt(seq, seqProt);
					jtaEcran.setText(orf35F2);
				}if(jcob35F3.isSelected()){
					seq = modifyBeforeSendSeqProt(seq35F3);
					seqProt = new SequenceProteique(seq);
					cardProt.initPanelCardProt(seq, seqProt);
					jtaEcran.setText(orf35F3);
				}if(jcob53F1.isSelected()){
					seq = modifyBeforeSendSeqProt(seq53F1);
					seqProt = new SequenceProteique(seq);
					cardProt.initPanelCardProt(seq, seqProt);
					jtaEcran.setText(orf53F1);
				}if(jcob53F2.isSelected()){
					seq = modifyBeforeSendSeqProt(seq53F2);
					seqProt = new SequenceProteique(seq);
					cardProt.initPanelCardProt(seq, seqProt);
					jtaEcran.setText(orf53F2);
				}if(jcob53F3.isSelected()){
					seq = modifyBeforeSendSeqProt(seq53F3);
					seqProt = new SequenceProteique(seq);
					cardProt.initPanelCardProt(seq, seqProt);
					jtaEcran.setText(orf53F3);
				}
				labelTypeOfSeq.setText("Auto-Detect type of sequence: translate amino-acid sequence ");
				cl.show(content, listContent[0]);
			}
		});
		initSeqTranslate();
		jtaDnaTranslate.setText(seqTranslate);
		JScrollPane jsp = new JScrollPane(jtaDnaTranslate);
		jsp.setPreferredSize(new Dimension(450, 200));
		cardDnaTranslate1.add(jbutSendProt);
		cardDnaTranslate2.add(jsp);
		add(cardDnaTranslate1, BorderLayout.WEST);
		add(cardDnaTranslate2, BorderLayout.EAST);
	}


	//Methodes
	private void initSeqTranslate() {
		seqTranslate = "";
		if(jcob53F1.isSelected()){
			seqTranslate += seq53F1plus;
			seqTranslate += "\n\n";
		}
		if(jcob53F2.isSelected()){
			seqTranslate += seq53F2plus;
			seqTranslate += "\n\n";
		}
		if(jcob53F3.isSelected()){
			seqTranslate += seq53F3plus;
			seqTranslate += "\n\n";
		}
		if(jcob35F1.isSelected()){
			seqTranslate += seq35F1plus;
			seqTranslate += "\n\n";
		}
		if(jcob35F2.isSelected()){
			seqTranslate += seq35F2plus;
			seqTranslate += "\n\n";
		}
		if(jcob35F3.isSelected()){
			seqTranslate += seq35F3plus;
			seqTranslate += "\n\n";
		}
		jtaDnaTranslate.setText(seqTranslate);
	}


	private void onlyOneSelected(){
		int cptr = 0;
		if(jcob53F1.isSelected()){
			cptr ++;
		}
		if(jcob53F2.isSelected()){
			cptr ++;
		}
		if(jcob53F3.isSelected()){
			cptr ++;
		}
		if(jcob35F1.isSelected()){
			cptr ++;
		}
		if(jcob35F2.isSelected()){
			cptr ++;
		}
		if(jcob35F3.isSelected()){
			cptr ++;
		}
		if(cptr == 1){
			jbutSendProt.setEnabled(true);
		}else{
			jbutSendProt.setEnabled(false);
		}
	}

	private String modifyBeforeSendSeqProt(String seqProt){
		String seqProt2 = seqProt;
		if(seqProt.contains("*")){
			if(seqProt.contains("M")) {
				int index1 = seqProt.indexOf("M");
				int index2 = seqProt.indexOf("*", seqProt.indexOf("M"));
				if(index2 != -1)
					seqProt2 = seqProt.substring(index1, index2);
				else
					seqProt2 = seqProt.substring(0, seqProt.indexOf('*'));
			}else {
				seqProt2 = seqProt.substring(0, seqProt.indexOf('*'));
			}
		}
		return seqProt2;
	}

	private void autoSelectGoodSeq(){
		//recupere la plus longue seq entre 
		ArrayList<Integer> orfList = new ArrayList<Integer>();
		orfList.add(orf35F1.length());
		orfList.add(orf35F2.length());
		orfList.add(orf35F3.length());
		orfList.add(orf53F1.length());
		orfList.add(orf53F2.length());
		orfList.add(orf53F3.length());
		int value = 0;
		String orfSelected = "";
		for (int i = 0; i < orfList.size(); i++) {
			if(orfList.get(i) > value){
				
				if(i == 0 && orf35F1.startsWith("M")){
					orfSelected = "orf35F1";
					value = orfList.get(i);
				}
				if(i == 1 && orf35F2.startsWith("M")){
					orfSelected = "orf35F2";
					value = orfList.get(i);
				}
				if(i == 2 && orf35F3.startsWith("M")){
					orfSelected = "orf35F3";
					value = orfList.get(i);
				}
				if(i == 3 && orf53F1.startsWith("M")){
					orfSelected = "orf53F1";
					value = orfList.get(i);
				}
				if(i == 4 && orf53F2.startsWith("M")){
					orfSelected = "orf53F2";
					value = orfList.get(i);
				}
				if(i == 5 && orf53F3.startsWith("M")){
					orfSelected = "orf53F3";
					value = orfList.get(i);
				}
			}
		}
		if(orfSelected == "orf35F1"){
			jcob35F1.setSelected(true);
		}if(orfSelected == "orf35F2"){
			jcob35F2.setSelected(true);
		}if(orfSelected == "orf35F3"){
			jcob35F3.setSelected(true);
		}if(orfSelected == "orf53F1"){
			jcob53F1.setSelected(true);
		}if(orfSelected == "orf53F2"){
			jcob53F2.setSelected(true);
		}if(orfSelected == "orf53F3"){
			jcob53F3.setSelected(true);
		}
	}

	//Listener
	private class PrepareForTranslateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			initSeqTranslate();
			onlyOneSelected();
		}

	}
}

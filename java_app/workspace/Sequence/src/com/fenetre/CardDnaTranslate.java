package com.fenetre;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.sequence.AminoAcid;
import com.sequence.SequenceNucleique;

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
	private String seqTranslate = "";
	private String sendTranslate;
	//Tab
	private String[] tabJcobDnaOrientation = {"3'5' Frame 1", "3'5' Frame 2", "3'5' Frame 3", "5'3' Frame 1", "5'3' Frame 2", "5'3' Frame 3"};

	//jta
	private JTextArea jtaDnaTranslate;

	//Jbutton
	private JButton jbutSendProt;

	//JComboBox
	private JCheckBox jcob35F1, jcob35F2, jcob35F3, jcob53F1, jcob53F2, jcob53F3;

	public CardDnaTranslate(SequenceNucleique seqNuc) {
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

		//checkBox
		jcob53F1 = new JCheckBox(tabJcobDnaOrientation[3]);
		cardDnaTranslate1.add(jcob53F1);
		jcob53F1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initSeqTranslate();

				onlyOneSelected();
			}
		});

		jcob53F2 = new JCheckBox(tabJcobDnaOrientation[4]);
		cardDnaTranslate1.add(jcob53F2);
		jcob53F2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initSeqTranslate();

				onlyOneSelected();
			}
		});


		jcob53F3 = new JCheckBox(tabJcobDnaOrientation[5]);
		cardDnaTranslate1.add(jcob53F3);
		jcob53F3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initSeqTranslate();

				onlyOneSelected();
			}
		});
		jcob35F1 = new JCheckBox(tabJcobDnaOrientation[0]);
		cardDnaTranslate1.add(jcob35F1);
		jcob35F1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				initSeqTranslate();

				onlyOneSelected();


			}
		});
		jcob35F2 = new JCheckBox(tabJcobDnaOrientation[1]);
		cardDnaTranslate1.add(jcob35F2);
		jcob35F2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initSeqTranslate();

				onlyOneSelected();
			}
		});
		jcob35F3 = new JCheckBox(tabJcobDnaOrientation[2]);
		cardDnaTranslate1.add(jcob35F3);
		jcob35F3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initSeqTranslate();

				onlyOneSelected();
			}
		});


		jbutSendProt = new JButton("Send");
		onlyOneSelected();
		jbutSendProt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String seq = "";
				if(sendTranslate == "35F1"){
					seq = modifyBeforeSendSeqProt(seq35F1);
				}if(sendTranslate == "35F2"){
					seq = modifyBeforeSendSeqProt(seq35F2);
				}if(sendTranslate == "35F3"){
					seq = modifyBeforeSendSeqProt(seq35F3);
				}if(sendTranslate == "53F1"){
					seq = modifyBeforeSendSeqProt(seq53F1);
				}if(sendTranslate == "53F2"){
					seq = modifyBeforeSendSeqProt(seq53F2);
				}if(sendTranslate == "53F3"){
					seq = modifyBeforeSendSeqProt(seq53F3);
				}
			}
		});
		jtaDnaTranslate.setText(seqTranslate);
		JScrollPane jsp = new JScrollPane(jtaDnaTranslate);
		jsp.setPreferredSize(new Dimension(450, 200));
		cardDnaTranslate1.add(jbutSendProt);
		cardDnaTranslate2.add(jsp);
		add(cardDnaTranslate1, BorderLayout.WEST);
		add(cardDnaTranslate2, BorderLayout.EAST);
	}


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
			if(jcob53F1.isSelected()){
				jbutSendProt.setEnabled(true);
				sendTranslate = "53F1";
			}
			if(jcob53F2.isSelected()){
				jbutSendProt.setEnabled(true);
				sendTranslate = "53F2";
			}
			if(jcob53F3.isSelected()){
				jbutSendProt.setEnabled(true);
				sendTranslate = "53F3";
			}
			if(jcob35F1.isSelected()){
				jbutSendProt.setEnabled(true);
				sendTranslate = "35F1";
			}
			if(jcob35F2.isSelected()){
				jbutSendProt.setEnabled(true);
				sendTranslate = "35F2";
			}
			if(jcob35F3.isSelected()){
				jbutSendProt.setEnabled(true);
				sendTranslate = "35F3";
			}	
		}else{
			jbutSendProt.setEnabled(false);
		}
		
	}
	
	private String modifyBeforeSendSeqProt(String seqProt){
		if(seqProt.contains("*")){
			seqProt.split("*");
		}
		return seqProt;
	}
	
	private void autoSelectGoodSeq(){
		//recupere la plus longue seq entre 
	}
}

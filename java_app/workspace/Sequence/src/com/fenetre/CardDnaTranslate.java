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
	private ArrayList<AminoAcid> aminoAcidList;
	//Tab
	private String[] tabJcobDnaOrientation = {"3'5' Frame 1", "3'5' Frame 2", "3'5' Frame 3", "5'3' Frame 1", "5'3' Frame 2", "5'3' Frame 3"};

	//jta
	private JTextArea jtaDnaTranslate;

	//Jbutton
	private JButton jbutSendProt;

	//JComboBox
	private JCheckBox jcobDnaOrientation;

	public CardDnaTranslate() {
		super();
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(595, 235));
		setBorder(BorderFactory.createTitledBorder("DNA Translate"));
		JPanel cardDnaTranslate1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardDnaTranslate1.setPreferredSize(new Dimension(120, 235));
		JPanel cardDnaTranslate2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cardDnaTranslate2.setPreferredSize(new Dimension(460, 210));

		jtaDnaTranslate = new JTextArea();
		jtaDnaTranslate.setLineWrap(true);
		jtaDnaTranslate.setWrapStyleWord(true);
		jtaDnaTranslate.setAutoscrolls(true);

		for (int i = 0; i < tabJcobDnaOrientation.length; i++) {
			jcobDnaOrientation = new JCheckBox(tabJcobDnaOrientation[i]);
			cardDnaTranslate1.add(jcobDnaOrientation);

			jcobDnaOrientation.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});

		}

		jcobDnaOrientation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (((JCheckBox)arg0.getSource()).isSelected()) {
					if(((JCheckBox)arg0.getSource()).getText().equals("3'5' Frame 1")){
						aminoAcidList = seqNuc.getSeqTranslate35F1();
						String msg = "";
						for (AminoAcid aminoAcid : aminoAcidList) {
							msg += aminoAcid.getSyn1L();
						}
						msg += "\n";
						jtaDnaTranslate.setText(msg);
					}
					else if(((JCheckBox)arg0.getSource()).getText().equals("3'5' Frame 2")){
						aminoAcidList = seqNuc.getSeqTranslate35F2();
						String msg = "";
						for (AminoAcid aminoAcid : aminoAcidList) {
							msg += aminoAcid.getSyn1L();
						}
						msg += "\n";
						jtaDnaTranslate.setText(msg);
					}
					//							
					//							, , "3'5' Frame 3", "5'3' Frame 1", "5'3' Frame 2", "5'3' Frame 3"};

				}
			}
		});


		jbutSendProt = new JButton("Send");

		JScrollPane jsp = new JScrollPane(jtaDnaTranslate);
		jsp.setPreferredSize(new Dimension(450, 200));
		cardDnaTranslate1.add(jbutSendProt);
		cardDnaTranslate2.add(jsp);
		add(cardDnaTranslate1, BorderLayout.WEST);
		add(cardDnaTranslate2, BorderLayout.EAST);
	}



}

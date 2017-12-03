package com.fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sequence.SequenceNucleique;
import com.sequence.SequenceProteique;

public class Fenetre extends JFrame{

	private JPanel container = new JPanel();
	private JTextField jtfEcran = new JTextField("Copy your sequence here ...");
	private JTextField jtfMw = new JTextField();
	private int typePanel = 1;
	JPanel panProt;
	JPanel panSeq;
	JPanel panDefault;


	public Fenetre() throws HeadlessException {
		super();
		this.setSize(600, 650);
		this.setTitle("Your DNA and Protein assistant");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		initComposant();
		this.setContentPane(container);
		this.setVisible(true);
	}

	private void initComposant() {
		// TODO Auto-generated method stub
		JPanel panEcran = new JPanel();
		panEcran.setPreferredSize(new Dimension(600, 240));
		jtfEcran.setPreferredSize(new Dimension(600, 200));
		Font font = new Font("Arial", Font.PLAIN, 14);
		jtfEcran.setFont(font);
		
		JPanel panConteneur = new JPanel();
		panConteneur.setPreferredSize(new Dimension(600, 410));
		panConteneur.setBackground(Color.BLACK);
		JButton jbutSend = new JButton("Send");
		jbutSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String regexSeqProt = "^([ ]*)?[mM][ .,;-RrHhKkDdEeSsTtNnQqCcUuGgPpAaVvIiLlMmFfYyWw]*$";
				String regexSeqDna = "^[ .,;-aAtTcCgG]*$";
				String regexSeqRna = "^[ .,;-aAcCgGuU]*$";
				String seq = jtfEcran.getText();
				if ( seq.matches(regexSeqProt)){
					SequenceProteique seqProt = new SequenceProteique(seq);
					System.out.println(seqProt.toString());
					typePanel = 2;
				}
				else if ( seq.matches(regexSeqDna) || seq.matches(regexSeqRna)){
					SequenceNucleique seqNuc= new SequenceNucleique(seq);
					System.out.println(seqNuc.toString());
					typePanel = 3;
				} else {
					System.out.println("sequence undefinied");
					typePanel = 1;
				}
			}
		});
		panEcran.add(jtfEcran);
		panEcran.add(jbutSend);

//		JPanel panInfo = new JPanel();
//		panInfo.setPreferredSize(new Dimension(600, 300));
//		JLabel jlMw = new JLabel("MW (g/mol) ");
//		String sMsgSeq = "MW (g/mol) : ";
//		jlMw.setText(sMsgSeq);
//		panInfo.add(jlMw);
		
		container.add(panEcran);
		
		if ( typePanel == 2){
			this.repaint();
			panProt = new JPanel();
			panProt.setPreferredSize(new Dimension(600, 300));
			panProt.setBackground(Color.YELLOW);
			panConteneur.add(panProt);
			container.add(panProt);
		}
		else if ( typePanel == 3){
			this.repaint();
			panSeq = new JPanel();
			panSeq.setPreferredSize(new Dimension(600, 300));
			panSeq.setBackground(Color.GREEN);
			panConteneur.add(panSeq);
			container.add(panSeq);
		} else {
			this.repaint();
			panDefault = new JPanel();
			panDefault.setPreferredSize(new Dimension(600, 300));
			panDefault.setBackground(Color.ORANGE);
			panConteneur.add(panDefault);
			container.add(panDefault);
		}
	}
	
}

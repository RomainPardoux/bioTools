package com.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanDefault extends JPanel{


	//Declaration des variables
	private JComboBox<String> jcobMenuHelp;
	private String[] menuHelp = {"Extinction coefficients", "In vivo half-life", "Instability index (II)", "Aliphatic index", "GRAVY (Grand Average of Hydropathy)"};
	private JTextArea jtaHelp = new JTextArea("");
	private JTextArea jtaContent = new JTextArea("");
	private JPanel panDefaultHelp = new JPanel();
	
	public PanDefault() {
		super();
	}

	public void initPanelDefault() {
		// TODO Auto-generated method stub
		//Panel CardProt
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		JPanel panDefaultContent = new JPanel();
		panDefaultContent.setPreferredSize(new Dimension(580, 400));
		panDefaultContent.setBorder(BorderFactory.createTitledBorder("Menu"));
		panDefaultContent.setLayout(new BorderLayout());
		
		jtaContent.setText("This tools computes various physico-chemical properties that can be deduced from a protein, dna or rna sequence. No additional information is required about the protein, dna or rna under consideration. The sequence can be specified as a raw sequence. White space and numbers are ignored.");
		jtaContent.setWrapStyleWord(true);
		jtaContent.setLineWrap(true);
		jtaContent.setEditable(false);
		panDefaultContent.add(jtaContent);
		initCardDefaultHelp();
		
		add(panDefaultContent, BorderLayout.NORTH);
		panDefaultContent.add(panDefaultHelp, BorderLayout.SOUTH);
	}

	private void initCardDefaultHelp() {
		// TODO Auto-generated method stub
		panDefaultHelp.setLayout(new BorderLayout());
		panDefaultHelp.setBorder(BorderFactory.createTitledBorder("Calculated parameters"));
		panDefaultHelp.setPreferredSize(new Dimension(560, 320));
		jcobMenuHelp = new JComboBox<String>(menuHelp);
		jcobMenuHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String msg = "";
				if(((JComboBox<String>)e.getSource()).getSelectedItem().equals(menuHelp[0])) {
					msg = "The extinction coefficient indicates how much light a protein absorbs at a certain wavelength. It is useful to have an estimation of this coefficient for following a protein which a spectrophotometer when purifying it.\n\n" + 
							"It has been shown that it is possible to estimate the molar extinction coefficient of a protein from knowledge of its amino acid composition. From the molar extinction coefficient of tyrosine, tryptophan and cystine (cysteine does not absorb appreciably at wavelengths >260 nm, while cystine does) at a given wavelength, the extinction coefficient of the native protein in water can be computed using the following equation:\n\n" + 
							"E(Prot) = Numb(Tyr)*Ext(Tyr) + Numb(Trp)*Ext(Trp) + Numb(Cystine)*Ext(Cystine)\n\n" + 
							"where (for proteins in water measured at 280 nm): Ext(Tyr) = 1490, Ext(Trp) = 5500, Ext(Cystine) = 125;\n\n" + 
							"The absorbance (optical density) can be calculated using the following formula:\n\n" + 
							"Absorb(Prot) = E(Prot) / Molecular_weight)\n\n" +
							"Two values are produced by ProtParam based on the above equations, both for proteins measured in water at 280 nm. The first one shows the computed value based on the assumption that all cysteine residues appear as half cystines (i.e. all pairs of Cys residues form cystines), and the second one assuming that no cysteine appears as half cystine (i.e. assuming all Cys residues are reduced). Experience shows that the computation is quite reliable for proteins containing Trp residues, however there may be more than 10% error for proteins without Trp residues.";
				}
				else if(((JComboBox<String>)e.getSource()).getSelectedItem().equals(menuHelp[1])) {
					msg = "The half-life is a prediction of the time it takes for half of the amount of protein in a cell to disappear after its synthesis in the cell.\n\n ProtParam relies on the N-end rule, which relates the half-life of a protein to the identity of its N-terminal residue; the prediction is given for 3 model organisms (human, yeast and E.coli). The N-end rule originated from the observations that the identity of the N-terminal residue of a protein plays an important role in determining its stability in vivo ([2],[3],[4]).\n\n The rule was established from experiments that explored the metabolic fate of artificial beta-galactosidase proteins with different N-terminal amino acids engineered by site-directed mutagenesis. The beta-gal proteins thus designed have strikingly different half-lives in vivo, from more than 100 hours to less than 2 minutes, depending on the nature of the amino acid at the amino terminus and on the experimental model (yeast in vivo; mammalian reticulocytes in vitro, Escherichia coli in vivo). In addition, it has been shown that in eukaryotes, the association of a destabilizing N-terminal residue and of an internal lysine targets the protein to ubiquitin-mediated proteolytic degradation [6]. Note that the program gives an estimation of the protein half-life and is not applicable for N-terminally modified proteins.";

				}
				else if(((JComboBox<String>)e.getSource()).getSelectedItem().equals(menuHelp[2])) {
					msg = "The instability index provides an estimate of the stability of your protein in a test tube. Statistical analysis of 12 unstable and 32 stable proteins has revealed [7] that there are certain dipeptides, the occurence of which is significantly different in the unstable proteins compared with those in the stable ones. The authors of this method have assigned a weight value of instability to each of the 400 different dipeptides (DIWV). Using these weight values it is possible to compute an instability index (II) which is defined as:\n\n" +  
							"                   i=L-1\r" + 
							"\n\n" + 
							"II = (10/L) * Sum     DIWV(x[i]x[i+1])" + 
							"\n\n" + 
							"                   i=1" + 
							"\n\n" + 
							"     where: L is the length of sequence" + 
							"\n\n" + 
							"            DIWV(x[i]x[i+1]) is the instability weight value for the dipeptide starting in position i." + 
							"\n\n" + 
							"A protein whose instability index is smaller than 40 is predicted as stable, a value above 40 predicts that the protein may be unstable.jtaHelp.setText(msg)";
				}
				else if(((JComboBox<String>)e.getSource()).getSelectedItem().equals(menuHelp[3])) {
					msg = "The aliphatic index of a protein is defined as the relative volume occupied by aliphatic side chains (alanine, valine, isoleucine, and leucine). It may be regarded as a positive factor for the increase of thermostability of globular proteins. The aliphatic index of a protein is calculated according to the following formula [8]:\n\n" + 
							"Aliphatic index = X(Ala) + a * X(Val) + b * ( X(Ile) + X(Leu) )  \n\n" + 
							"where X(Ala), X(Val), X(Ile), and X(Leu) are mole percent (100 X mole fraction) \n\n" + 
							"of alanine, valine, isoleucine, and leucine. \n\n" + 
							"The coefficients a and b are the relative volume of valine side chain (a = 2.9) \n\n" + 
							"and of Leu/Ile side chains (b = 3.9) to the side chain of alanine. ";
				}
				else if(((JComboBox<String>)e.getSource()).getSelectedItem().equals(menuHelp[4])) {
					msg = "The GRAVY value for a peptide or protein is calculated as the sum of hydropathy values [9] of all the amino acids, divided by the number of residues in the sequence. ";
				}
				jtaHelp.setText(msg);
			}
		});
		jcobMenuHelp.setSelectedItem(menuHelp[0]);
		jtaHelp.setEditable(false);
		jtaHelp.setWrapStyleWord(true);
		jtaHelp.setLineWrap(true);
		JScrollPane jspHelp = new JScrollPane(jtaHelp);
		jspHelp.setPreferredSize(new Dimension(550, 270));
		panDefaultHelp.add(jcobMenuHelp, BorderLayout.NORTH);
		panDefaultHelp.add(jspHelp, BorderLayout.SOUTH);
	}
	
}

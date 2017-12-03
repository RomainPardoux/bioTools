package com.main;
import java.util.Scanner;

import com.fenetre.Fenetre;
import com.sequence.SequenceNucleique;
import com.sequence.SequenceProteique;

public class Main {

	private static Scanner sc1;
	private static Scanner sc2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fenetre fenetre = new Fenetre();
//		System.out.println("Veuillez saisir le nom de votre sequence : \n");
//		sc1 = new Scanner(System.in);
//		String nomSeq = sc1.nextLine();
//		System.out.println("Veuillez saisir une sequence d'ADN ou PROTEINE : \n");
//		sc2 = new Scanner(System.in);
//		String sequence = sc2.nextLine();
//
//		// ctrl regex
//		String regexSeqProt = "^([ ]*)?[mM][ .,;-RrHhKkDdEeSsTtNnQqCcUuGgPpAaVvIiLlMmFfYyWw]*$";
//		String regexSeqDna = "^[ .,;-aAtTcCgG]*$";
//		String regexSeqRna = "^[ .,;-aAcCgGuU]*$";
//		if ( sequence.matches(regexSeqProt)){
//			SequenceProteique seqProt = new SequenceProteique(sequence, nomSeq);
//			System.out.println(seqProt.toString());
//			System.out.println("\nVeuillez saisir l'Abs à 280nm : \n");
//			sc2 = new Scanner(System.in);
//			double abs = sc2.nextDouble();
//			double protConc = seqProt.ComputeProtConcentration(abs);
//			System.out.println("\nProt Concentration: " + protConc + " mol/l");
//		}
//		else if ( sequence.matches(regexSeqDna) || sequence.matches(regexSeqRna)){
//			SequenceNucleique seqNuc= new SequenceNucleique(sequence, nomSeq);
//			System.out.println(seqNuc.toString());
//		} else {
//			System.out.println("sequence undefinied");
//		}
	}
}

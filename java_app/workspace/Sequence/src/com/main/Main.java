package com.main;

import java.util.Scanner;
import com.sequence.Sequence;
import com.sequence.SequenceProteique;

public class Main {

	private static Scanner sc1;
	private static Scanner sc2;
	private static Scanner sc3;

	public static void main(String[] args) {
		Sequence seq;
		// TODO Auto-generated method stub
		System.out.println("Veuillez saisir le nom de votre sequence : \n");
		sc1 = new Scanner(System.in);
		String nomSeq = sc1.nextLine();
		System.out.println("Veuillez saisir une sequence d'ADN ou PROTEINE : \n");
		sc2 = new Scanner(System.in);
		String sequence = sc2.nextLine();

		// ctrl regex a exporter ailleurs ensuite
		String regexSeqProt = "^([ ]*)?[mM][RrHhKkDdEeSsTtNnQqCcUuGgPpAaVvIiLlMmFfYyWw]*$";
		String regexSeqDna = "^[aAtTcCgGuU]*$";
		if ( sequence.matches(regexSeqProt)){
			seq = new SequenceProteique(sequence, nomSeq);
			System.out.println(seq.toString());
		}
		else if ( sequence.matches(regexSeqDna)){
			System.out.println("Pouvez-vous confirmer que votre sequence est une sequence nucleique (y or n) :");
			sc3 = new Scanner(System.in);
			String confirm = sc3.nextLine();
			if(confirm.equals("n")) {
				seq = new SequenceProteique(sequence, nomSeq);
				System.out.println(seq.toString());
			}else {
				System.out.println("sequence nucleique");
			}
		} else {
			System.out.println("sequence undefinied");
		}
	}
}

package com.sequence;
import java.util.Scanner;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

public class Main {

	private static Scanner sc1;
	private static Scanner sc2;
	private String typeSeq = "";





	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Veuillez saisir le nom de votre sequence : \n");
		sc1 = new Scanner(System.in);
		String nomSeq = sc1.nextLine();
		System.out.println("Veuillez saisir une sequence d'ADN ou PROTEINE : \n");
		sc2 = new Scanner(System.in);
		String sequence = sc2.nextLine();
		 
		// ctrl regex
		String regexSeqProt = "^([ ]*)?[mM][RrHhKkDdEeSsTtNnQqCcUuGgPpAaVvIiLlMmFfYyWw]*$";
		String regexSeqDna = "^[aAtTcCgGuU]*$";
		if ( sequence.matches(regexSeqProt)){
			SequenceProteique seqProt = new SequenceProteique(sequence, nomSeq);
			System.out.println(seqProt.toString());
		}
		else if ( sequence.matches(regexSeqDna)){
			
		} else {
			
		}
		
	}
	}

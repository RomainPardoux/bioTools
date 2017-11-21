package com.sequence;
import java.util.Scanner;

public class Main {

	private static Scanner sc1;
	private static Scanner sc2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Veuillez saisir le nom de votre sequence : \n");
		sc1 = new Scanner(System.in);
		String nomSeq = sc1.nextLine();
		System.out.println("Veuillez saisir une sequence d'ADN ou PROTEINE : \n");
		sc2 = new Scanner(System.in);
		String sequence = sc2.nextLine();
		Sequence seq = new Sequence(sequence, nomSeq);
		System.out.println(seq.toString());
	}
}

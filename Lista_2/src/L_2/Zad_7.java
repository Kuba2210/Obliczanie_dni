package L_2;

import java.util.Scanner;

public class Zad_7 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		
		System.out.print("Podaj liczbe: ");	
		int liczba = scanner.nextInt(); 
		int pozycja = 2; 										// okreslamy ktory bit negujemy
		int maska = 1 << pozycja; 								// maska bitowa z bitem (1) na zadanej pozycji (0100)
		int wynik = liczba ^ maska; 							// negujemy bit wykonujac operacje xor na masce

		scanner.close();

		System.out.println("Liczba " + liczba + " binarnie: " + Integer.toBinaryString(liczba));
		System.out.println("Maska binarnie: " + Integer.toBinaryString(maska));
		System.out.println("Liczba po zamianie: " + wynik);
		System.out.println("Liczba " + wynik + " binarnie: " + Integer.toBinaryString(wynik));

	}

}

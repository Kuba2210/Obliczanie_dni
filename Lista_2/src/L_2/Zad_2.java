package L_2;

import java.util.Scanner;

public class Zad_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean wyjscie = true;

		System.out.println("Podaj liczbê a: ");
		int a = scanner.nextInt();

		System.out.println("Podaj liczbê b: ");
		int b = scanner.nextInt();

		while (wyjscie) {
			System.out.println("1. Dodawanie");
			System.out.println("2. Odejmowanie");
			System.out.println("3. Mno¿enie");
			System.out.println("4. Dzielnie");
			System.out.println("5. Wyjœcie");
			System.out.print("Wybierz opcje: ");

			int choose = scanner.nextInt();

			switch (choose) {
			case 1 -> System.out.println("a + b = " + (a + b));
			case 2 -> System.out.println("a - b = " + (a - b));
			case 3 -> System.out.println("a * b = " + (a * b));
			case 4 -> System.out.println("a / b = " + (a / b));
			case 5 -> wyjscie = false;

			}

		}
		scanner.close();
	}

}
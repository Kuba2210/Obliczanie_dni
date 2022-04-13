package L_2;

import java.util.Scanner;

public class Zad_4 {
	
	public static int dni_p, miesiac_p, rok_p, dni_k, miesiac_k, rok_k, rok, przestepny, liczba_dni, licznik,
			 sprawdzenie1, sprawdzenie2;
	
	// Deklaracja dni
	public static int styczen = 31, luty_p = 29, luty_np = 28, kwiecien = 30;

	static void czy_przestepny(int rok) {									//Funkcja sprawdzaj¹ca czy rok jest przestêpny
		if ((rok % 4 == 0) && (rok % 100 != 0) || (rok % 400 == 0)) {
			przestepny = 1;
		} else {
			przestepny = 0;
		}

		//System.out.println(rok + " Czy przestepny: " + przestepny);
	}

	static void ile_dni_w_miesiacu(int miesiac) {							//Funkcja obliczaj¹ca ile jest dni w poszczególnym miesi¹cu
		if (miesiac == 1 || miesiac == 3 || miesiac == 5 || miesiac == 7 || miesiac == 8 || miesiac == 10
				|| miesiac == 12) {
			licznik = 31;
		}

		else if (miesiac == 4 || miesiac == 6 || miesiac == 9 || miesiac == 11) {
			licznik = 30;
		}

		else if (miesiac == 2) {											//Definiowanie lutego w zale¿noœci czy rok jest przestêpny
			if (przestepny == 0) {											// 1 - przestepny, 0 - nie
				licznik = 28;
			} else if (przestepny == 1) {
				licznik = 29;
			}

		}
	}

	static void caly_rok() {												//Oblicza ile dni jest w roku, uwzglêdniaj¹c lata przestêpne
		if ((miesiac_k < miesiac_p) || (miesiac_p == miesiac_k && dni_k < dni_p)) {		//Jeœli jest np rok i 4 miesi¹ce to liczymy osobno rok i osobno 4 msc
			while (rok_p < rok_k - 1) {													//dlatego (rok_k - 1)
				czy_przestepny(rok_p);
				sprawdzenie1 = przestepny;

				czy_przestepny(rok_p + 1);
				sprawdzenie2 = przestepny;									//Sprawdzenie warunku na obliczenie dni ca³ego roku przestêpnego.

				if (sprawdzenie1 == 0 && sprawdzenie2 == 0) {
					liczba_dni = liczba_dni + 365;
					rok_p++;
				} else if (sprawdzenie1 == 1 && sprawdzenie2 == 0 && miesiac_p < 3) {
					liczba_dni = liczba_dni + 366;
					rok_p++;
				} else if (sprawdzenie1 == 1 && sprawdzenie2 == 0 && miesiac_p >= 3) {
					liczba_dni = liczba_dni + 365;
					rok_p++;
				} else if (sprawdzenie1 == 0 && sprawdzenie2 == 1 && miesiac_p >= 3) {

					liczba_dni = liczba_dni + 366;
					rok_p++;

				} else if (sprawdzenie1 == 0 && sprawdzenie2 == 1 && miesiac_p <= 3) {

					liczba_dni = liczba_dni + 365;
					rok_p++;

				}
			}
		}

		else {
			while (rok_p < rok_k) {														//tutaj ju¿ po prostu rok_p < rok_k bo miesi¹c_p jest wiekszy od koncowego
				czy_przestepny(rok_p);													// i jesli msc ten sam to dzien_k jest wiekszy od poczatkowego
				sprawdzenie1 = przestepny;												// dlatego mozemy brac pod uwage caly rok

				czy_przestepny(rok_p + 1);
				sprawdzenie2 = przestepny;

				if (sprawdzenie1 == 0 && sprawdzenie2 == 0) {
					liczba_dni = liczba_dni + 365;
					rok_p++;
				} else if (sprawdzenie1 == 1 && sprawdzenie2 == 0 && miesiac_p < 3) {
					liczba_dni = liczba_dni + 366;
					rok_p++;
				} else if (sprawdzenie1 == 1 && sprawdzenie2 == 0 && miesiac_p >= 3) {
					liczba_dni = liczba_dni + 365;
					rok_p++;
				} else if (sprawdzenie1 == 0 && sprawdzenie2 == 1 && miesiac_p >= 3) {

					liczba_dni = liczba_dni + 366;
					rok_p++;

				} else if (sprawdzenie1 == 0 && sprawdzenie2 == 1 && miesiac_p <= 3) {

					liczba_dni = liczba_dni + 365;
					rok_p++;
				}

			}
		}

	}

	public static void main(String[] args) {

		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Podaj datê pocz¹tkow¹... ");
		System.out.println("****************************************");

		while(rok_p<=0)
		{
		System.out.println("Rok: ");
		rok_p = scanner.nextInt();
		}
		
		while(miesiac_p<=0 || miesiac_p>12)
		{
		System.out.println("Miesi¹c: ");
		miesiac_p = scanner.nextInt();
		}

		while(dni_p<=0 || dni_p>31)
		{
			
		System.out.println("Dzieñ: ");
		dni_p = scanner.nextInt();
		}
		
		System.out.println("Podaj datê koñcow¹... ");
		System.out.println("****************************************");

		while(rok_k<=0 || rok_k<rok_p)
		{
			
		System.out.println("Rok: ");
		rok_k = scanner.nextInt();
		}
		
		while(miesiac_k<=0 || miesiac_k>12)
		{
		System.out.println("Miesi¹c: ");
		miesiac_k = scanner.nextInt();
		}
		
		while(dni_k<=0 || dni_k>31)
		{
			
		System.out.println("Dzieñ: ");
		dni_k = scanner.nextInt();
		}
		scanner.close();

		czy_przestepny(rok_p);

		if (rok_p == rok_k) {							//Rozwa¿amy ró¿ne przypadki
			if (miesiac_p == miesiac_k) {
				liczba_dni = dni_k - dni_p;				//Obliczamy same dni
			}
		}

		if (rok_p == rok_k) {

			if (miesiac_p != miesiac_k) {				//Obliczamy dni w miesi¹cach

				ile_dni_w_miesiacu(miesiac_p); // Sprawdzamy ile dni w miesi¹cu
				liczba_dni = licznik - dni_p; // Obliczamy dni do koñca tego miesi¹ca
				miesiac_p++; // Zwiêkszamy miesi¹c

				while (miesiac_p <= miesiac_k) {
					if (miesiac_p == miesiac_k) {
						liczba_dni = liczba_dni + dni_k;
					} else {
						ile_dni_w_miesiacu(miesiac_p);
						liczba_dni = liczba_dni + licznik;
					}
					miesiac_p++;
				}
			}

		}

		if (rok_p != rok_k) {							//Obliczamy ca³y rok
			if (miesiac_p == miesiac_k) {
				if (dni_p == dni_k) {
					caly_rok();
				}
			}




			if (((miesiac_k < miesiac_p) || (miesiac_p == miesiac_k && dni_k < dni_p)) && (rok_p != rok_k)) {			
				caly_rok();																			// Obliczamy gdy dla daty koncowej miesi¹ce mniejsze ni¿ dla pocz¹tkowej
				czy_przestepny(rok_p);																// albo dni mniejsze
				if (miesiac_k < miesiac_p) {
					ile_dni_w_miesiacu(miesiac_p); // Sprawdzamy ile dni w miesi¹cu

					liczba_dni = liczba_dni + (licznik - dni_p); // Obliczamy dni do koñca tego miesi¹ca
					miesiac_p++; // Zwiêkszamy miesi¹c
					
					

					while (miesiac_p <= 12) // Liczymy dni do konca roku
					{
								
						ile_dni_w_miesiacu(miesiac_p);

						liczba_dni = licznik + liczba_dni;

						miesiac_p++;
					}
					
					if (miesiac_p == 13) {				//Liczymy dni w kolejnych miesiacach po grudniu 
						miesiac_p = 1;
						rok_p++;
						czy_przestepny(rok_p);

						while (miesiac_p <= miesiac_k) // Liczymy dni do konca roku
						{
							
							if (miesiac_p == miesiac_k) {
								
								liczba_dni = liczba_dni + dni_k;
							} else {
								ile_dni_w_miesiacu(miesiac_p);
								liczba_dni = licznik + liczba_dni;

								

							}
							miesiac_p++;
						}

					}

				}
			} else if (rok_p != rok_k) {							//Przypadek jeœli miesi¹c daty koncowej jest wiêkszy lub równy pocz¹tkowej
				caly_rok();
				czy_przestepny(rok_p);
				ile_dni_w_miesiacu(miesiac_p); // Sprawdzamy ile dni w miesi¹cu
				liczba_dni = liczba_dni + (licznik - dni_p); // Obliczamy dni do koñca tego miesi¹ca
				miesiac_p++;
				if (miesiac_k >= miesiac_p) {
					caly_rok();
					czy_przestepny(rok_p);
							
					while (miesiac_k >= miesiac_p) {
						if (miesiac_p == miesiac_k) {

							liczba_dni = liczba_dni + dni_k;
						} else {
							ile_dni_w_miesiacu(miesiac_p);
							liczba_dni = licznik + liczba_dni;
						}

						miesiac_p++;
					}
								}
				}
			}		

		System.out.println("Liczba dni: " + liczba_dni);
	
		
	}

}



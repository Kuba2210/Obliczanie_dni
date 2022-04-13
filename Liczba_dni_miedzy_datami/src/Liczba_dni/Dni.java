package Liczba_dni;

import java.util.Scanner;

public class Dni {

	public static int dni_p, miesiac_p, rok_p, dni_k, miesiac_k, rok_k, rok, przestepny, liczba_dni, licznik,
	 sprawdzenie1, sprawdzenie2;

// Deklaracja dni
public static int styczen = 31, luty_p = 29, luty_np = 28, kwiecien = 30;

static void czy_przestepny(int rok) {									//Funkcja sprawdzająca czy rok jest przestępny
if ((rok % 4 == 0) && (rok % 100 != 0) || (rok % 400 == 0)) {
	przestepny = 1;
} else {
	przestepny = 0;
}


}

static void ile_dni_w_miesiacu(int miesiac) {							//Funkcja obliczająca ile jest dni w poszczególnym miesiącu
if (miesiac == 1 || miesiac == 3 || miesiac == 5 || miesiac == 7 || miesiac == 8 || miesiac == 10
		|| miesiac == 12) {
	licznik = 31;
}

else if (miesiac == 4 || miesiac == 6 || miesiac == 9 || miesiac == 11) {
	licznik = 30;
}

else if (miesiac == 2) {											//Definiowanie lutego w zależności czy rok jest przestępny
	if (przestepny == 0) {											// 1 - przestepny, 0 - nie
		licznik = 28;
	} else if (przestepny == 1) {
		licznik = 29;
	}

}
}

static void caly_rok() {												//Oblicza ile dni jest w roku, uwzględniając lata przestępne
if ((miesiac_k < miesiac_p) || (miesiac_p == miesiac_k && dni_k < dni_p)) {		//Jeśli jest np rok i 4 miesiące to liczymy osobno rok i osobno 4 msc
	while (rok_p < rok_k - 1) {													//dlatego (rok_k - 1)
		czy_przestepny(rok_p);
		sprawdzenie1 = przestepny;

		czy_przestepny(rok_p + 1);
		sprawdzenie2 = przestepny;									//Sprawdzenie warunku na obliczenie dni całego roku przestępnego.

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
	while (rok_p < rok_k) {														//tutaj już po prostu rok_p < rok_k bo miesiąc_p jest wiekszy od koncowego
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

System.out.println("Podaj datę początkową... ");
System.out.println("****************************************");

while(rok_p<=0)
{
System.out.println("Rok: ");
rok_p = scanner.nextInt();
}

while(miesiac_p<=0 || miesiac_p>12)
{
System.out.println("Miesiąc: ");
miesiac_p = scanner.nextInt();
}

while(dni_p<=0 || dni_p>31)
{
	
System.out.println("Dzień: ");
dni_p = scanner.nextInt();
}

System.out.println("Podaj datę końcową... ");
System.out.println("****************************************");

while(rok_k<=0 || rok_k<rok_p)
{
	
System.out.println("Rok: ");
rok_k = scanner.nextInt();
}

while(miesiac_k<=0 || miesiac_k>12)
{
System.out.println("Miesiąc: ");
miesiac_k = scanner.nextInt();
}

while(dni_k<=0 || dni_k>31)
{
	
System.out.println("Dzień: ");
dni_k = scanner.nextInt();
}
scanner.close();

czy_przestepny(rok_p);

if (rok_p == rok_k) {							//Rozważamy różne przypadki
	if (miesiac_p == miesiac_k) {
		liczba_dni = dni_k - dni_p;				//Obliczamy same dni
	}
}

if (rok_p == rok_k) {

	if (miesiac_p != miesiac_k) {				//Obliczamy dni w miesiącach

		ile_dni_w_miesiacu(miesiac_p); // Sprawdzamy ile dni w miesiącu
		liczba_dni = licznik - dni_p; // Obliczamy dni do końca tego miesiąca
		miesiac_p++; // Zwiększamy miesiąc

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

if (rok_p != rok_k) {							//Obliczamy cały rok
	if (miesiac_p == miesiac_k) {
		if (dni_p == dni_k) {
			caly_rok();
		}
	}




	if (((miesiac_k < miesiac_p) || (miesiac_p == miesiac_k && dni_k < dni_p)) && (rok_p != rok_k)) {			
		caly_rok();																			// Obliczamy gdy dla daty koncowej miesiące mniejsze niż dla początkowej
		czy_przestepny(rok_p);																// albo dni mniejsze
		if (miesiac_k < miesiac_p) {
			ile_dni_w_miesiacu(miesiac_p); // Sprawdzamy ile dni w miesiącu

			liczba_dni = liczba_dni + (licznik - dni_p); // Obliczamy dni do końca tego miesiąca
			miesiac_p++; // Zwiększamy miesiąc
			
			

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
	} else if (rok_p != rok_k) {							//Przypadek jeśli miesiąc daty koncowej jest większy lub równy początkowej
		caly_rok();
		czy_przestepny(rok_p);
		ile_dni_w_miesiacu(miesiac_p); // Sprawdzamy ile dni w miesiącu
		liczba_dni = liczba_dni + (licznik - dni_p); // Obliczamy dni do końca tego miesiąca
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



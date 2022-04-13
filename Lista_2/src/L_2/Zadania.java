package L_2;

import java.util.Scanner;

public class Zadania {

	public static int minuty, lminut, lgodzin, dni, pomocnicza;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Podaj liczbê minut: ");
		 minuty = scanner.nextInt();
		
		scanner.close();

		if(minuty>=480)
		{
		 dni = minuty/480;
		 pomocnicza = dni* 480;
		minuty = minuty - pomocnicza;
		}
		
		
		if(minuty>=60)
		{
			 lgodzin = minuty/60;
			 pomocnicza = lgodzin * 60;
			 minuty = minuty - pomocnicza;
		}
		
		
		
		
		
		System.out.println(dni + " dzieñ, " + lgodzin + " godzin i " + minuty + " minut");
	}

}

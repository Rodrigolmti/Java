package Lista2;

import java.util.Scanner;

public class exerc2 {

	public static void main(String[] args) {

		String placa;
		Scanner input = new Scanner(System.in);

		do {
			System.out
					.println("Favor informar a placa Maiuscula e como no exemplo :");
			System.out.println("             AAA-1234             ");

			placa = input.nextLine();
		} while (!ValidaPlaca(placa));

	}

	public static boolean ValidaPlaca(String placa) {
		if (placa.matches("[A-Z]{3}-\\d{4}")) 
		{
			return true;
		}

		return false;
	}
}

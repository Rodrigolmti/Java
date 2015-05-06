package Lista2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class exerc7 {

	public static void main(String[] args) {

		String data1;
		String data2;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Favor informar a data 1 como abaixo :");
			System.out.println("DD/MM/YYYY");

			data1 = input.nextLine();
		} while (!validaData(data1));
		do {
			System.out.println("\nFavor informar a data 2 como abaixo :");
			System.out.println("DD/MM/YYYY");

			data2 = input.nextLine();
		} while (!validaData(data2));

		int dias = SubDias(data1, data2);
		System.out.println(dias);
	}

	public static boolean validaData(String data) {

		if (data.matches("^(\\d{2}\\/\\d{2}\\/\\d{4})$")) 
		{
			return true;
		}
		return false;
	}

	public static int SubDias(String data1, String data2) {
		int retornaDias = 0;
		Date dt1 = null;
		Date dt2 = null;
		SimpleDateFormat sdfEntrada = new SimpleDateFormat("dd/mm/yyyy");

		try {
			dt1 = sdfEntrada.parse(data1);
			dt2 = sdfEntrada.parse(data2);
		} catch (Exception e) {

		}

		GregorianCalendar gdt1 = new GregorianCalendar();
		GregorianCalendar gdt2 = new GregorianCalendar();

		gdt1.setTime(dt1);
		gdt2.setTime(dt2);

		retornaDias = (int) ((gdt1.get(GregorianCalendar.DAY_OF_MONTH) - gdt2
				.get(GregorianCalendar.DAY_OF_MONTH)));

		if (retornaDias < 0) 
		{
			retornaDias = retornaDias * -1;

		}
		return retornaDias;

	}

}
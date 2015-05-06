package Lista2;

import java.util.Scanner;

public class exerc4 {

	public static void main(String[] args) {

		String texto;
		Scanner input = new Scanner(System.in);

		System.out.println("Informe a palavra :");
		texto = input.nextLine();

		System.out.println(corrigEspaco(texto));

	}

	public static String corrigEspaco(String x) {
/*		for (int i = 0; i < x.length(); i++) {

			if (x.charAt(i) != 'b') {
			

				r += x.charAt(i);
			} else {

				for (int j = 0; j < x.length(); j++) 
				{

					if ((x.charAt(i) == 'b') && (x.charAt(i + 1) == 'b')) 
					{


					}

				}

			}

		}*/

		x = x.replaceAll("b+", " ");
		return x;
	}

}

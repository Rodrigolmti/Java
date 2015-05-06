import java.util.*;
public class Parte5_Exercicio1 {
	public static void main(String[] args) {
		String texto;
		Scanner leia = new Scanner(System.in);
		
		System.out.print("Digite o texto em minúsculo: ");
		texto = leia.nextLine();
		
		texto = Character.toUpperCase( texto.charAt(0) ) + texto.substring(1);
		
		for (int x = 1; x < texto.length() ; x++) {
			if (texto.charAt(x) == ' ') {
				texto = texto.substring(0 , x+1) + Character.toUpperCase( texto.charAt(x+1) ) +
						texto.substring(x+2);
			}
		}
		
		System.out.println(texto);
	}

}

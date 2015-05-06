import java.util.*;
public class Parte3_Exercicio2 {
	public static void main(String[] args) {
		// 1 - declara��o de vari�veis
		String codigo;
		boolean valido;
		int soma = 0;
		int digito1;
		int digito2;
		int mult = 1;
		String multString;
		
		Scanner leia = new Scanner(System.in);
		// 2 - entrada de dados
		do {
			System.out.print("Digite o c�digo: ");
			codigo = leia.next();
			valido = true;
			if (codigo.length() != 11) {
				System.out.println("C�digo inv�lido ! digite 11 d�gitos");
				valido = false;
			} else {
				for (byte x = 0 ; x<=10; x++) {
					if (codigo.charAt(x) < '0' || codigo.charAt(x) > '9') {
						System.out.println("C�digo inv�lido ! digite apenas d�gitos");	
						valido = false;
						break;
					}					
				}
			}
		} while (! valido);
		
		// 3 - c�lculos
		for (byte x = 0; x <= 8 ; x++) {
			soma = soma + Character.digit(codigo.charAt(x) , 10 );
			mult = mult * Character.digit(codigo.charAt(x) , 10 );
		}
		digito1 = soma / 10; // divis�o entre inteiros o resulta � inteiro !
			
		multString = String.valueOf(mult); 
		
		// int posicaoCaracter = multString.length() -1;
		//char caracter = multString.charAt( multString.length() -1 );
		// digito2 = Character.digit (caracter,10);
		digito2 = Character.digit( multString.charAt( multString.length() -1 ) , 10);
		
		if (Character.forDigit(digito1,10) == codigo.charAt(9) && 
				Character.forDigit(digito2,10) == codigo.charAt(10)) {
			System.out.println("Digitos verificadores CORRETOS !");
		} else {
			System.out.println("Digitos verificadores INCORRETOS ! Corretos s�o: " +
					digito1 + "" + digito2);
		}
		
	}

}

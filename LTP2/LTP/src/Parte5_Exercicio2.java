import java.util.*;
public class Parte5_Exercicio2 {
	public static void main (String []args) {
		String nome;
		Scanner leia = new Scanner(System.in);
		boolean erro;
		String login;
		String senha;
		
		for (byte cont = 1 ; cont <= 30 ; cont++) {
			
			do {
				System.out.print("Digite o nome (FIM para encerrar): ");
				nome = leia.nextLine().toUpperCase();
				
				if (nome.equals("FIM")) {
					break;
				}
				erro = false;
				if (nome.length() < 15) {
					System.out.println("Nome inválido! Digite 15 ou mais caracteres");
					erro = true;
				} else if (nome.charAt(0) == ' ' || nome.charAt( nome.length() - 1) == ' ') {
					System.out.println("Nome inválido! Não pode existir espaço antes ou depois do nome");					
					erro = true;
				} else if ( ! nome.contains(" ") ) {
					System.out.println("Nome inválido! Deve conter pelo menos nome e sobrenome");
					erro = true;
				} else if ( nome.contains("  ")) {
					System.out.println("Nome inválido! Deve existir apenas 1 espaço entre nomes");
					erro = true;
				} else {
					for (int x = 0; x < nome.length() ; x++) {
						if ( (nome.charAt(x) < 'A' || nome.charAt(x) > 'Z') && nome.charAt(x) != ' ') {
							System.out.println("Nome inválido! Deve conter apenas letras");
							erro = true;
							break;
						}
					}
				}
			} while( erro );
			
			if (nome.equals("FIM")) {
				break;
			}
			// cálculos
			login = nome.substring(0,1);
			for (int x = 1 ; x < nome.length() ; x++) {
				if (nome.charAt(x) == ' ') {
					login = login + nome.charAt(x+1);
				}
			}
			System.out.println("Login: " + login);
			senha = "";
			for (int x = 0 ; x < login.length() ; x++) {
				senha = senha + ( (int) login.charAt(x) ) / 10;
			}
			System.out.println("Senha: " + senha);
		}
	}
}

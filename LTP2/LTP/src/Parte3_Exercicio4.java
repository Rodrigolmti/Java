import java.util.*;
public class Parte3_Exercicio4 {
	public static void main(String[] args) {
		// 1 - declaração de variáveis
		String placa;
		String dataMulta;
		float vlrMulta = 0;
		float somaVlrMulta = 0;
		float vlrMenorMulta = 99999;
		int cont = 0;
		boolean erro;
		int dia;
		int mes;
		int ano;
		Scanner leia = new Scanner (System.in);
		
		do {
			// 2 - Entrada de dados
			do {
				System.out.print("Digite a placa do veículo (SAIR para finalizar): ");
				placa = leia.next();
				
				if (placa.equals("SAIR")) {
					break;
				}
				
				erro = false;
				if (placa.length() != 7) {
					System.out.println("Placa Inválida ! Digite 7 caracteres");
					erro = true;
				} else {
					for (byte x = 0; x <= 6; x++) {
						if (x <= 2) {
							if ( placa.charAt(x) < 'A' || placa.charAt(x) > 'Z') {
								System.out.println("Placa Inválida ! Digite letras nos 3 primeiros caracteres");
								erro = true;
								break;
							}
						} else {
							if ( placa.charAt(x) < '0' || placa.charAt(x) > '9') {
								System.out.println("Placa Inválida ! Digite dígitos nos 4 ultimos caracteres");
								erro = true;
								break;
							}							
						}
					}
				}
			}while (erro);
			
			if (placa.equals("SAIR")) {
				break;
			}
			
			do {
				System.out.print("Digite a data da multa: ");
				dataMulta = leia.next();
				erro = false;
				if (dataMulta.length() != 10) {
					System.out.println("Data inválida, digite 10 caracteres no formato " +
							"DD/MM/AAAA");
					erro = true;
				} else {
					try {
						dia = Integer.parseInt( dataMulta.substring(0,2) );
						mes = Integer.parseInt( dataMulta.substring(3,5) );
						ano = Integer.parseInt( dataMulta.substring(6) );		
						if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 1980 || 
								ano > 2013) {
							System.out.println("Data Inválida! Digite dia entre 1 e 31, " +
									"mês entre 1 e 12, ano entre 1980 e 2013");
							erro = true;
						}
					} catch (NumberFormatException e) { 
						System.out.println("Data Inválida! Digite somente números para dia, " +
								"mes e ano");
						erro = true;
					}				
				}
			} while ( erro );  // mesmo que : erro == true
			
			do {
				System.out.print("Digite o valor da multa: ");
				try {
					vlrMulta = leia.nextFloat();
					if (vlrMulta <= 0) {
						System.out.println("Valor Inválido ! Digite valor acima de zero");
					}
				} catch (InputMismatchException e) {
					System.out.println("ERRO ! digite somente números !");
					leia.nextLine();
				}		
			}while(vlrMulta <= 0);
			
			// 3 - cálculos
			somaVlrMulta = somaVlrMulta + vlrMulta;
			cont ++;
			if (vlrMulta < vlrMenorMulta) {
				vlrMenorMulta = vlrMulta;
			}
		
		} while ( ! placa.equals("SAIR"));
		
		// 4- saída de dados
		System.out.println("Soma dos valores das multas: " + somaVlrMulta);
		if (cont > 0){
			System.out.println("Valor médio das multas: " + somaVlrMulta / cont);		
		}
		System.out.println("Valor da menor multa: " + vlrMenorMulta);
	}

}

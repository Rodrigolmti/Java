import java.util.*;
public class Parte6_Exercicio3 {
	public static void main(String[] args) {
		String nomeHospede[] = new String[100];
		String dataEntrada;
		String dataSaida;
		String tipoQuarto;
		float vlrConta[] = new float[100];
		boolean valido;
		int diaEntrada;
		int diaSaida;
		float vlrDiaria;
		float somaVlrContas= 0;
		float mediaVlrContas;
		
		Scanner leia = new Scanner(System.in);
		
		byte cont;
		for (cont = 0 ; cont <= 99 ; cont++) {
			System.out.print("Digite o nome do Hóspede (SAIR para encerrar): ");
			nomeHospede[cont] = leia.nextLine();
			
			if (nomeHospede[cont].equalsIgnoreCase("SAIR")){
				break;
			}
			
			do{
				do{
					System.out.print("Digite a data de entrada: ");
					dataEntrada = leia.next();
				}while( ! validarData(dataEntrada) );
				
				do{
					System.out.print("Digite a data de saída: ");
					dataSaida = leia.next();
				}while( ! validarData(dataSaida) );
				
				valido = true;
				diaEntrada = Integer.parseInt(dataEntrada.substring(0,2));
				diaSaida = Integer.parseInt(dataSaida.substring(0,2));
				if ( ! dataEntrada.substring(3).equals(dataSaida.substring(3))) {
					System.out.println("Erro, mes/ano Entrada deve ser igual mes Saída");
					valido = false;
				} else if (diaEntrada >= diaSaida) {
					System.out.println("Erro, data Saída deve ser maior que data Entrada");
					valido = false;
				}
			}while( ! valido );
			
			
			do{
				System.out.print("Digite o tipo de quarto: ");
				tipoQuarto = leia.next();
				if( ! tipoQuarto.equals("LUXO") && ! tipoQuarto.equals("SUPER-LUXO") &&  
						! tipoQuarto.equals("STANDARD") ) {
					System.out.println("Erro, digite LUXO, STANDARD ou SUPER-LUXO");
				}
			}while(! tipoQuarto.equals("LUXO") && ! tipoQuarto.equals("SUPER-LUXO") &&  
					! tipoQuarto.equals("STANDARD"));
			
			// cálculos
			if (tipoQuarto.equals("STANDARD")) {
				vlrDiaria = 120;
			} else if (tipoQuarto.equals("LUXO")) {
				vlrDiaria = 150;
			} else { //if (tipoQuarto.equals("SUPER-LUXO")) 
				vlrDiaria = 180;
			}
			vlrConta[cont] = (diaSaida - diaEntrada) * vlrDiaria;
		
			
			leia.nextLine();
		} // fim do for
	} // fim do método main
	
	public static boolean validarData (String data) {
		if (data.length() != 10) {
			System.out.println("Data inválida! digite 10 caracteres no formato DD/MM/AAAA");
			return false;
		}
		if (data.charAt(2) != '/' || data.charAt(5) != '/') {
			System.out.println("Data inválida! digite / no 3o. e 6o caracteres");
			return false;			
		}
		int dia,mes,ano;
		try {
			dia = Integer.parseInt( data.substring(0,2) );
			mes = Integer.parseInt( data.substring(3,5) );
			ano = Integer.parseInt( data.substring(6) );
			if (ano > 2014) {
				System.out.println("Data inválida! digite ano menor ou igual 2014");
				return false;			
			} else if (mes < 1 || mes > 12) {
				System.out.println("Data inválida! digite mes entre 01 e 12");
				return false;			
			} else if (mes == 2 && (dia < 1 || dia > 28) ) {
				System.out.println("Data inválida! em Fev. digite dia de 01 a 28");
				return false;			
			} else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia < 1 || dia > 30) ) {
				System.out.println("Data inválida! Abr,Jun,Set e Nov, dia entre 01 e 30");
				return false;			
			} else if (dia < 1 || dia > 31) {
				System.out.println("Data inválida! digite dia entre 01 e 31");
				return false;			
			}		
		} catch(NumberFormatException e) {
			System.out.println("Data inválida! digite apenas dígitos para dia,mes e ano");
			return false;						
		}
		return true;
	}
	
}


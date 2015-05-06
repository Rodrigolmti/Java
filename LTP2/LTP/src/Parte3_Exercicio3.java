import java.util.*;
public class Parte3_Exercicio3 {
	public static void main(String[] args) {
		// 1 - Declara��o de vari�veis
		String horarioInicial;
		String horarioFinal;
		byte HI = 0;  // hora do hor�rio inicial
		byte MI = 0;  // minuto do hor�rio inicial
		byte HF = 0;  // hora do hor�rio final
		byte MF = 0;  // minuto do hor�rio final
		float vlrMinuto;
		int duracao;
		float custoChamada;
		float custoTotal = 0;
		Scanner leia = new Scanner (System.in);
		
		do{
			// 2 - Entrada de dados
			do {
				System.out.print("Digite o hor�rio inicial (FIM para encerrar):");
				horarioInicial = leia.next();
				if (horarioInicial.equals("FIM")) {
					break;
				}
				System.out.print("Digite o hor�rio final:");
				horarioFinal = leia.next();
				
				try {
					HI = Byte.parseByte( horarioInicial.substring(0,2) );
					MI = Byte.parseByte( horarioInicial.substring(3,5) );
					HF = Byte.parseByte( horarioFinal.substring(0,2) );
					MF = Byte.parseByte( horarioFinal.substring(3,5) );	
					if ( (HF < HI) || (HF == HI && MF <= MI) ) {
						System.out.println("Hor�rio inv�lido! Final deve ser maior que inicial");
					}
				} catch (NumberFormatException e) {
					System.out.println("Hor�rio inv�lido! digite formato HH:MM");
				}
			}while ((HF < HI) || (HF == HI && MF <= MI));
			
			if (horarioInicial.equals("FIM")) {
				break;
			}

			// 3 - c�lculos
			if (HI < 6) {
				vlrMinuto = (float) 0.10;
			} else if (HI < 8) {
				vlrMinuto = (float) 0.15;
			} else if (HI < 18) {
				vlrMinuto = (float) 0.20;
			} else {
				vlrMinuto = (float) 0.15;
			}
			
			duracao = (HF - HI)*60 + MF - MI;
			custoChamada = vlrMinuto * duracao;
			System.out.println("Custo chamada: " + custoChamada);
			custoTotal = custoTotal + custoChamada;
			
		}while ( ! horarioInicial.equals("FIM"));
		
		System.out.println("Custo total da Conta: " + custoTotal);
	}

}

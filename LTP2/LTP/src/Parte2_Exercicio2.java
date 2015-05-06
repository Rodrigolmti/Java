import java.util.*;
public class Parte2_Exercicio2 {
	public static void main (String[] args) {
		// 1 - variáveis
		float altura;
		char sexo;
		float maiorAltura = 0;
		float menorAltura = 3;
		int numAtletasFem = 0;
		int numAtletasMasc = 0;
		float somaAlturaMasc = 0;
		float somaAlturas = 0;
		
		Scanner leia = new Scanner(System.in);
		
		do {
			// 2 - Entrada de dados
			do {
				System.out.print("Digite a altura (0 para ecerrar): ");
				altura = leia.nextFloat();
				if (altura < 0 || altura > 2.5) {
					System.out.println("Altura inválida ! Digite entre 0 e 2,5");
				}
			}while(altura < 0 || altura > 2.5);
			
			if (altura == 0) {
				break;
			}
			
			do {
				System.out.print("Digite o sexo: ");
				sexo = leia.next().charAt(0);
				if (sexo != 'M' && sexo != 'F') {
					System.out.println("Sexo inválido ! digite M ou F");
				}
			} while (sexo != 'M' && sexo != 'F');
			
			// 3 - cálculos
			if (altura > maiorAltura) {
				maiorAltura = altura;
			}
			
			if (altura < menorAltura) {
				menorAltura = altura;
			}
			
			if (sexo == 'F') {
				numAtletasFem ++;
			} else {
				numAtletasMasc ++;
				somaAlturaMasc = somaAlturaMasc + altura;
			}
				
			somaAlturas = somaAlturas + altura;
			
		} while (altura != 0);
		
		// 4 - saída de dados
		System.out.println("Maior altura: " + maiorAltura);
		System.out.println("Menor altura: " + menorAltura);
		System.out.println("Num. atletas Feminino: " + numAtletasFem);
		if (numAtletasMasc > 0) {
			System.out.println("Média altura masculina: " + somaAlturaMasc / numAtletasMasc);
		}
		if (numAtletasFem + numAtletasMasc > 0) {
			System.out.println("Média geral das alturas: " + 
					somaAlturas / (numAtletasFem + numAtletasMasc));
		}
			
				
	}
}
